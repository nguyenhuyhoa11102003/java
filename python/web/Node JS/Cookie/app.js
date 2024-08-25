
let express = require('express');
let app = express();
let cookieParser = require('cookie-parser');
let credentials = require('./credentials');

app.use(cookieParser(credentials.cookieSign)); // hash chữ ký



app.get('/', (req, res) => {
    // tạo cookie bình thường: key-value
    res.cookie('name', 'Peter'); 
    // tạo cookie có chữ ký: key-value
    res.cookie('signedName', 'Signed Peter', {signed: true});

    // cookie này sẽ tự hết hạn sau 360000ms
    // res.cookie('timeCookie', 'value', {maxAge: 360000});

    res.send("Trang này tạo cookie")
})


app.get('/read-cookie', (req, res) => {
    // đọc dữ liệu từ cookie đã được tạo ở trang '/'
    let name = req.cookies.name; // đọc dữ liệu của cookie bình thường
    let signedName = req.signedCookies.signedName; // đọc dữ liệu của cookie có chữ ký

    // in dữ liệu đọc được ra màn hình console
    console.log('Name: ' + name)
    console.log('Signed Name: ' + signedName)

    res.send("Trang này đọc cookie. Xem trong console")
})

app.get('/delete-cookie', (req, res) => {
    // xóa cookie
    res.clearCookie('name')
    res.clearCookie('signedName')

    res.send("Trang này xóa cookie.")
})

app.listen(8080)