const http = require('http');
const express = require('express');
const mariadb = require('mariadb');
const cors = require('cors')

const pool = mariadb.createPool({
    host:'localhost',
    port:4406,
    user:'root',
    password:'rootroot',
    supportBigNumbers: true // BigInt로 가면 숫자로 나옴
    
})

/*
BigInt.prototype.toJSON = () => {
    return this.toString();
}
*/

const app = express();
app.use(cors());


const router = express.Router();
app.use('/', router);


router.route('/person/page/list').get(async(req, res) => {
    console.log(`list 라우터 접속`)

    let conn;
    try {
        conn =  await pool.getConnection();
        let sql = `select * from test.person`
        let rows =  await conn.query(sql, [])

        const output = {
            output:rows
        }

        res.writeHead(200, {'Contend-Type':'text/html;Charset=utf8'})
        res.end(JSON.stringify(output))
    } catch (err) {
        console.error(`에러 발생 -> err: ${err}`);
    } finally {
        if (conn) conn.end()
    }
})

router.route('/person/page/update').get(async(req, res) => {
    console.log(`update 라우터 접속`)

    const params = req.query;
    let conn;
    try {
        conn =  await pool.getConnection();
        let sql = `UPDATE test.person SET name = '${params.name}', age = ${params.age}, mobile = '${params.mobile}' WHERE id = ${params.id}`
        let rows =  await conn.query(sql, [])

        sql = `select * from test.person`
        rows =  await conn.query(sql, [])

        const output = {
            output:rows
        }

        res.writeHead(200, {'Contend-Type':'text/html;Charset=utf8'})
        res.end(JSON.stringify(output))
    } catch (err) {
        console.error(`에러 발생 -> err: ${err}`);
    } finally {
        if (conn) conn.end()
    }
})
router.route('/person/page/list').get(async(req, res) => {
    console.log(`list 라우터 접속`)

    let conn;
    try {
        conn =  await pool.getConnection();
        let sql = `select * from test.person`
        let rows =  await conn.query(sql, [])

        const output = {
            output:rows
        }

        res.writeHead(200, {'Contend-Type':'text/html;Charset=utf8'})
        res.end(JSON.stringify(output))
    } catch (err) {
        console.error(`에러 발생 -> err: ${err}`);
    } finally {
        if (conn) conn.end()
    }
})

const port = 7003;
http.createServer(app).listen(port, ()=> {
    console.log(`웹서버 실행된 ->${port}`)
})