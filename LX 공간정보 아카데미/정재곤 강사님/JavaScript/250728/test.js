const http = require('http');
const express = require('express');
const mariadb = require('mariadb');

const pool = mariadb.createPool({
    host: 'localhost',
    port: 3307,
    user: 'root',
    password: 'rootroot'
})

const app = express();

app.set(`views`, './views');
app.set('view engine', 'ejs');

const router = express.Router();
app.use('/',router);

router.route('/page/list').get(async(req, res) => {

    conn = await pool.getConnection();

    const params = req.query;
    const context =  {

    }

    req.app.render('list',context, (err, html) => {
        if (err) console.log()
    })
    res.writeHead(200, {'Content-Type':'text/html;charset=utf8'})
    res.end(html);
})

const port = 7001;
http.createServer(app),listen(port, () => {
    
})