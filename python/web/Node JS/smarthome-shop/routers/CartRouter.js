const express = require('express');
const db = require("../db");
const Router = express.Router();

Router.get("/", (req, res) => {
    if (!req.session.username || req.session.username === "admin")
        return res.redirect("/account/login");

    let cartId = req.session.cartId;
    let sql = `select id, image, name, pc.quantity, price*pc.quantity as price
            from product p, productcart pc
            where id = product_id and cart_id = ?
            `;

    db.query(sql, cartId, (error, results, fields) => {
        if (error)
            throw new Error(error.sqlMessage);

        db.query("select address from customer where username = ?", req.session.username, (error, results2, fields) => {
            if (error)
                throw new Error(error.sqlMessage);

            res.render("cart", { username: req.session.username, products: results, address: results2[0].address })
        })
    })
})


Router.post("/add", (req, res) => {
    let cartId = req.session.cartId;
    let productId = req.body.productId;

    let sql = "select * from productcart where product_id = ? and cart_id = ?";
    let params = [productId, cartId];

    db.query(sql, params, (error, results, fields) => {
        if (error)
            throw new Error(error.sqlMessage);

        if (results.length > 0)
            sql = "update productcart set quantity = quantity + 1 where product_id = ? and cart_id = ?";

        else
            sql = "insert into productcart values(?,?,1)";

        db.query(sql, params, (error, results, fields) => {
            if (error)
                throw new Error(error.sqlMessage);

            res.json({ code: 0, message: "Thêm sản phẩm vào giỏ hàng thành công." })
        })
    })
})
module.exports = Router;