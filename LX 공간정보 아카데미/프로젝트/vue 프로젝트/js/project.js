const http = require('http');
const express = require('express');
const mariadb = require('mariadb');
const cors = require('cors');

const pool = mariadb.createPool({
    host:'localhost',
    port:3307,
    user:'root',
    password:'rootroot',
    supportBigNumbers:true
})

const app = express();
app.use(cors());

const router = express.Router();
app.use('/',router);

router.route('/Uban-Archive/Main').get(async(req, res) => {
    console.log(`Main 라우터 접속`)

    const params = req.query;
    let conn;
    try{
        conn = await pool.getConnection();
        let sql = '';
        let rows = await conn.query(sql, []);

        const output = {

        }

        res.writeHead(200, {'Content-Type':'text/html;charset=utf8'});
        res.end(output);
    } catch (err) {
        console.log(`Main 오류 -> ${err}`);
    } finally {
        if (conn) conn.end();
    }
})



const port = 7004;
http.createServer(app).listen(port, ()=> {
    console.log(`서버 실행 완료~`)
})