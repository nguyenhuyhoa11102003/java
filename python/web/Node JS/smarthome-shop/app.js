const express = require('express'); 
const cookieParser = require('cookie-parser');  
const session = require('express-session');
const hbs = require('express-handlebars');
const db = require('./db');

const app = express();  

const AccountRouter = require('./routers/AccountRouter');
const ProductRouter = require('./routers/ProductRouter');
const CartRouter = require('./routers/CartRouter');
const OrderRouter = require('./routers/OrderRouter');
const AdminRouter = require('./routers/AdminRouter');

app.use(cookieParser('abcdefghijklmnopqrstuvwxyz'))
app.use(session({
    secret: "abcdefghijklmnopqrstuvwxyz",
    resave: true,
    saveUninitialized: true
}))

app.engine('handlebars', hbs.engine({
    defaultLayout: 'main',
    helpers: {
        formatPrice: (price) => {
            return price.toLocaleString('vi-VN') + "đ"; 
        },

        totalPrice: (products) => {
            let total = 0;
            products.forEach(p => total += p.price);
            return total;
        },

        colorOrderStatus: (status) => {
            if(status === "Chờ xác nhận")
                return "danger";
            else if(status === "Đang vận chuyển")
                return "warning";
            else
                return "success";
        },
    }
}));
app.set('view engine', 'handlebars');


// Điều chỉnh lại kích thước của request
app.use(express.json({limit: '2mb'}));


app.use(express.json());   
app.use(express.urlencoded({ extended: true }));

app.use(express.static(__dirname + '/public'))

app.get("/", (req, res) => {
    res.redirect("/product")
})

app.use('/account', AccountRouter);
app.use('/product', ProductRouter);
app.use('/cart', CartRouter);
app.use('/order', OrderRouter);
app.use('/admin', AdminRouter);

app.use((req, res) => {
    res.status(404) 
    res.render('404', {layout: null})
})

app.use((err, req, res, next) => {
    res.status(500);
    res.render('500', {layout: null});
});

app.listen(8888, () => {
    db.connect((error) => {
        if(error)
            throw new Error(error.sqlMessage);

        console.log("Bạn có thể vào trang web tại địa chỉ http://localhost:8888");
    })
})