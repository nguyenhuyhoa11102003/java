const express = require('express');
const fs = require('fs');
const db = require("../db");
const Router = express.Router();


// Quản lý sản phẩm
Router.get("/", (req, res) => {
    if (!req.session.username || req.session.username !== "admin")
        return res.redirect("/account/login");

    db.query("select * from product where deleted = 0", (error, results, fields) => {
        if (error)
            throw new Error(error.sqlMessage);

        res.render("admin", { layout: "admin", products: results });
    })
})

Router.get("/product/add", (req, res) => {
    if (!req.session.username || req.session.username !== "admin")
        return res.redirect("/account/login");

    res.render("add-product", { layout: "admin" })
})

Router.post("/product/add", (req, res) => {
    let { name, description, price, catalog, base64, imageName } = req.body;

    base64 = base64.replace(/^data:image\/\w+;base64,/, '');
    let buffer = Buffer.from(base64, 'base64');

    fs.writeFile(`./public/uploads/${imageName}`, buffer, (error) => {
        if (error)
            return res.json({ code: 1, message: "Thêm sản phẩm thất bại" });
    })

    let sql = "insert into product(name, description, price, image, catalog, deleted) values(?,?,?,?,?,?)";
    let params = [name, description, price, imageName, catalog, 0];

    db.query(sql, params, (error, results, fields) => {
        if (error)
            return res.json({ code: 1, message: "Thêm sản phẩm thất bại" });

        res.json({ code: 0, message: "Thêm sản phẩm thành công" })
    })
})

Router.put("/product/update", (req, res) => {
    let { id, name, description, price, catalog, base64, imageName } = req.body;

    // Khi admin muốn cập nhật hình ảnh mới
    if (base64 !== "") {
        base64 = base64.replace(/^data:image\/\w+;base64,/, '');
        let buffer = Buffer.from(base64, 'base64');

        fs.writeFile(`./public/uploads/${imageName}`, buffer, (error) => {
            if (error)
                return res.json({ code: 1, message: "Cập nhật sản phẩm thất bại" });
        })
    }

    let sql = "update product set name = ?, description = ?, price = ?, catalog = ?, image = ? where id = ?";
    let params = [name, description, price, catalog, imageName, id];

    db.query(sql, params, (error, results, fields) => {
        if (error)
            return res.json({ code: 1, message: "Cập nhật sản phẩm thất bại" });

        res.json({ code: 0, message: "Cập nhật sản phẩm thành công" })
    })
})

Router.delete("/product/delete", (req, res) => {
    let id = req.body.id;

    db.query("update product set deleted = 1 where id = ?", id, (error, results, fields) => {
        if (error)
            res.json({ code: 1, message: "Xóa sản phẩm thất bại" });

        res.json({ code: 0, message: "Xóa sản phẩm thành công." });
    })
})

// Quản lý đơn hàng
Router.get("/order/", (req, res) => {
    if (!req.session.username || req.session.username !== "admin")
        return res.redirect("/account/login");

    db.query("select * from `order`", (error, results, fields) => {
        if (error)
            throw new Error(error.sqlMessage);

        res.render("manage-order", { layout: "admin", orders: results });
    })
})


Router.put("/order/update", (req, res) => {
    let id = req.body.id;
    let status = req.body.status;

    if (status === "Chờ xác nhận")
        status = "Đang vận chuyển";
    else if (status === "Đang vận chuyển")
        status = "Hoàn thành";
    else
        status = "Chờ xác nhận";

    let sql = "update `order` set status = ? where id = ?";
    let params = [status, id];

    db.query(sql, params, (error, results, fields) => {
        if (error)
            return res.json({ code: 1, message: "Cập nhật trạng thái đơn hàng thất bại" });

        res.json({ code: 0, message: "Cập nhật trạng thái đơn hàng thành công" })
    })
})

module.exports = Router;