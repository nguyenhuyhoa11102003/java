# Smarthome Shop Website
This project is a website selling smarthome devices used at FPT Smart Home. With an intuitive and friendly UI, it can enhance the shopping experience for customers looking to purchase smarthome devices.

### Software Development Technologies
- Express framework: is a minimal and flexible Node.js web application framework that provides a robust set of features for web and mobile applications.
- Handlebars view engine: is a Javascript library used to create reusable webpage templates.
- MySQL: is the database.

### Features
**1. Customer role**
- Sign up
- Sign in
- View device list
- View device in detail
- View device by category (switches, lights, sensors, etc)
- Search device
- Add device to cart
- Buy device and create order
- View history purchase
  
**2. Administrator role**
- View device list
- Manage device: CRUD
- View order list

### How to run this website?
1. Download or clone this project from GitHub
2. Unzip this project
3. Import file **database.sql** into MySQL server
4. Open **cmd** and go to (cd) **src** folder 
5. Type `yarn install` to download modules in file `package.json`
6. Type `node app.js`
7. Open the browser and access `http://localhost:8888`

### Sample accounts to sign in
**1. Customer account 1**
- username: nguyenvana
- password: nguyenvana

**2. Customer account 2**
- username: nguyenvanb
- password: nguyenvanb
  
**3. Administrator account**
- username: admin
- password: admin