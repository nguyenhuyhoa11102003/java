const express = require('express');
const fs = require('fs');
const path = require('path');
const archiver = require('archiver'); // use to compress folder to download
const hbs = require('express-handlebars')

const app = express();

app.engine('handlebars', hbs.engine({
    defaultLayout: 'main',
}))
app.set('view engine', 'handlebars')

app.use(express.static(__dirname + '/public'))

app.get('/', (req, res) => {
    res.render('index');
})

app.get('/download/:name', (req, res) => {
    let name = req.params.name;
    let itemPath = path.join(__dirname, `/public/${name}`);

    // Kiểm tra xem item có tồn tại không
    if (fs.existsSync(itemPath)) {
        // item là folder -> zip -> download
        if (fs.lstatSync(itemPath).isDirectory()) {
            let archive = archiver('zip', { zlib: { level: 9 } });

            // Tên file nén
            let zipFileName = 'archive.zip';

            // Thiết lập header để thông báo trình duyệt về loại dữ liệu của file
            res.setHeader('Content-Type', 'application/zip');
            // Thiết lập header để xác định tên của file khi được tải về
            res.setHeader('Content-Disposition', `attachment; filename=${zipFileName}`);

            // Pipe dữ liệu từ archiver đến response
            archive.pipe(res);

            // Thêm thư mục vào file nén
            archive.directory(itemPath, false);

            // Kết thúc quá trình nén và gửi về client
            archive.finalize();

            return res.json({ code: 1, message: 'Zip and download folder success!' });
        }

        // item là file -> just download
        let fileStream = fs.createReadStream(itemPath);

        // Thiết lập header để thông báo trình duyệt về loại dữ liệu của file
        res.setHeader('Content-Type', 'application/octet-stream');
        // Thiết lập header để xác định tên của file khi được tải về
        res.setHeader('Content-Disposition', `attachment; filename=${name}`);

        // Pipe dữ liệu từ fileStream đến response
        fileStream.pipe(res);

        return res.json({ code: 2, message: 'Download file success!' });
    }

    // item không tồn tại 
    res.json({ code: 0, message: 'Not found!!' });
});

app.listen(8080, () => {
    console.log('Visit: http://localhost:8080');
});