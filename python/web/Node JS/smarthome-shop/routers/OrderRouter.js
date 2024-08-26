const express = require('express');
const db = require("../db");
const Router = express.Router();


Router.get("/checkout" , (req ,res) =>{
    let currentDate = new Date();
    let day = currentDate.getDate().toString().padStart(2, '0');
    let month = (currentDate.getMonth() + 1).toString().padStart(2, '0'); 
    let year = currentDate.getFullYear().toString();
    let hours = currentDate.getHours().toString().padStart(2, '0');
    let minutes = currentDate.getMinutes().toString().padStart(2, '0');
    let seconds = currentDate.getSeconds().toString().padStart(2, '0');

    let id = day + month + year + hours + minutes + seconds; // ddmmyyyyhhmmss
    let username = req.session.username;
    let totalPrice = req.body.totalPrice;
    let date = `${day}/${month}/${year} ${hours}:${minutes}:${seconds}`
    let status = "Chờ xác nhận";

    let sql = "insert into `order` values(?,?,?,?,?)";
    let params = [id, username, totalPrice, date, status];

    db.query(sql, params, async (error, results, fields) => {
        if(error) 
            return res.json({code: 1, message: "Thanh toán thất bại"});
                
        // Sau khi thanh toán thành công thì xóa hết sản phẩm trong giỏ hàng
        db.query("delete from productcart where cart_id = ?", req.session.cartId, (error, results, fields) => {
            if(error) 
                return res.json({code: 1, message: "Thanh toán thất bại"});

            res.json({code: 0, message: "Thanh toán thành công"});
        })
    }) 
})

Router.get("/", (req, res) => {
    if(!req.session.username || req.session.username === "admin")
        return res.redirect("/account/login");
    
    db.query("select * from `order` where username = ?", req.session.username, (error, results, fields) => {
        if(error)
            throw new Error(error.sqlMessage);
        
        res.render("order", {username: req.session.username, orders: results});
    })
})


Router.get("/", (req, res) => {
    if(!req.session.username || req.session.username === "admin")
        return res.redirect("/account/login");
    
    db.query("select * from `order` where username = ?", req.session.username, (error, results, fields) => {
        if(error)
            throw new Error(error.sqlMessage);
        
        res.render("order", {username: req.session.username, orders: results});
    })
})


module.exports = Router;