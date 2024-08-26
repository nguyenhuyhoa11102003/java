const express = require('express');
const db = require("../db");
const Router = express.Router();


Router.get("/detail/:id", (req, res) => {
    let id = req.params.id;

    db.query("select * from product where id = ?", id, (error, results, fields) => {
        if (error)
            throw new Error(error.sqlMessage);

        if (results.length <= 0 || results[0].deleted === 1)
            return res.status(404).render("404", { layout: null });

        res.render("product-detail", { product: results[0], username: req.session.username });
    });
})

Router.get("/", (req, res) => {
    db.query('select * from product', (error, results, fields) => {
        if (error)
            throw new Error(error.sqlMessage);
        let products = [];
        results.forEach(product => {
            if (product.deleted === 0)
                products.push({
                    id: product.id,
                    name: product.name,
                    price: product.price,
                    image: product.image,
                })
        });
        res.render("products", { products, username: req.session.username });
    })
})


Router.get("/search", (req, res) => {
    let name = req.query.name;

    db.query("select * from product where name like ?", `%${name}%`, (error, results, fields) => {
        if (error)
            throw new Error(error.sqlMessage);

        let products = [];

        results.forEach(product => {
            if (product.deleted === 0)
                products.push({
                    id: product.id,
                    name: product.name,
                    price: product.price,
                    image: product.image,
                })
        })

        res.render("products", { products, username: req.session.username });
    })
})

Router.get("/:catalog", (req, res) => {
    let catalogs = ["Đèn thông minh", "Cảm biến", "Công tắc thông minh", "Bộ rèm cửa", "Phụ kiện", "Khác"];
    let catalog = req.params.catalog;

    if (catalogs.indexOf(catalog) === -1)
        return res.status(404).render("404", { layout: null });

    db.query("select * from product where catalog = ?", catalog, (error, results, fields) => {
        if (error)
            throw new Error(error.sqlMessage);

        let products = [];

        results.forEach(product => {
            if (product.deleted === 0)
                products.push({
                    id: product.id,
                    name: product.name,
                    price: product.price,
                    image: product.image,
                })
        })

        res.render("products", { products, username: req.session.username });
    })
})


module.exports = Router;    