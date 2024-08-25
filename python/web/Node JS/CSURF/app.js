const express = require('express');
const hbs = require('express-handlebars');
const cookieParser = require('cookie-parser');
const session = require('express-session');
const csurf = require('csurf');


const app = express()


app.use(cookieParser('cookiesign'))
app.use(session({
    secret: "cookiesign",
    resave: true,
    saveUninitialized: true
}))


app.engine('handlebars', hbs.engine({
    defaultLayout: 'main',               
}))
app.set('view engine', 'handlebars')

app.use(express.json());
app.use(express.urlencoded({extended: false}));

// CSRF
app.use(csurf());
app.use((req, res, next) => {
    res.locals._csrfToken = req.csrfToken();
    next();
})

app.get('/login', (req, res) => {
    res.render('login') 
})

app.post('/login', (req, res) => {
    console.log('CSRF token (from hidden form field): ' + req.body._csrf)
    console.log('Username (from visible form field): ' + req.body.username)
    console.log('Password (from visible form field): ' + req.body.password)

    res.render('login', {message: "Login Success. See console for detail"})
})

app.listen(8080)