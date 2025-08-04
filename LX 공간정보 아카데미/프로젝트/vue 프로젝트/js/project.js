const http = require('http');
const express = require('express');
const mariadb = require('mariadb');
const cors = require('cors');
const multer = require('multer');

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

// js 파일의 public/uploads 폴더를 vue 파일의  /uploads 로 접근 가능하게 설정 ★★★★★★  (js/public/uploads, vue/public/assets 폴더 열어서 설명)
// 왜 이미지를 이렇게 이상하게 받냐
// 이 사진들은 <image>에서 src로 public-assets으로 받는 것과 달리
// 웹이 실행중인 도중에 사진 파일이 생성되는 것으로 Vue 빌드 시점에는 존재하지 않으므로 단순히 src로 알 수 없음
// 때문에 <image :src "">로 js파일의 public/uploads 폴더에 직접 요청해야 하며 이걸 express에서 미들웨어로 직접 열어줘야 함 (다른방법도 있긴 함)
app.use('/uploads', express.static('public/uploads'));

router.route('/header').get(async(req, res) => {
    console.log(`header 라우터 접속`)

    const params = req.query;

        const output = {
            id:params.id
        }

        res.writeHead(200, {'Content-Type':'text/html;charset=utf8'});
        res.end(JSON.stringify(output));
})

router.route('/login').get(async(req, res) => {
    console.log(`login 라우터 접속`)

    const params = req.query;
    let conn;
    try{
        conn = await pool.getConnection();
        let sql = `SELECT COUNT(*) cnt FROM test.idpassword WHERE id = '${params.id}' and password = '${params.password}'`
        let rows = await conn.query(sql, []);

        const output = {
            loginCnt:rows[0].cnt
        }

        res.writeHead(200, {'Content-Type':'text/html;charset=utf8'});
        res.end(JSON.stringify(output));
    } catch (err) {
        console.log(`Main 오류 -> ${err}`);
    } finally {
        if (conn) conn.end();
    }
})


router.route('/idCheck').get(async(req, res) => {
    console.log(`idCheck 라우터 접속`)

    const params = req.query;
    let conn;
    try{
        conn = await pool.getConnection();
        let sql = `SELECT COUNT(*) cnt FROM test.idpassword WHERE id = '${params.id}'`
        let rows = await conn.query(sql, []);

        const output = {
            idCnt:rows[0].cnt
        }

        res.writeHead(200, {'Content-Type':'text/html;charset=utf8'});
        res.end(JSON.stringify(output));
    } catch (err) {
        console.log(`Main 오류 -> ${err}`);
    } finally {
        if (conn) conn.end();
    }
})

router.route('/signUp').get(async(req, res) => {
    console.log(`signUp 라우터 접속`)

    const params = req.query;
    let conn;
    try{
        conn = await pool.getConnection();
        let sql = `insert into test.idpassword(id,password) values ('${params.id}','${params.password}')`
        let rows = await conn.query(sql, []);

        const output = {
        }

        res.writeHead(200, {'Content-Type':'text/html;charset=utf8'});
        res.end(JSON.stringify(output));
    } catch (err) {
        console.log(`Main 오류 -> ${err}`);
    } finally {
        if (conn) conn.end();
    }
})



const upload = multer({ dest : 'public/uploads/' }) // 사용자가 업로드한 파일을 js 폴더 저 경로에 자동저장 하는 함수를 저장, 경로를 변수로 저장해야 됨

router.post('/submit', upload.single('image'), async (req, res) => {  // image를 하나만(single) 서버의 이미지파일에 자동 업로드 해줌
    console.log(`submit 라우터 접속`)

    const params = req.body;  // query가 아닌 body로 받음  // 그리고 폼 데이터 안 텍스트는 req.body에 담기고 파일은 req.file에 담김
    let conn;

    try{
        const image = `/uploads/${req.file.filename}`  // 저장된 파일의 경로 저장 (DB저장용)


        conn = await pool.getConnection();
        let sql = `insert into test.stuarchive(id, title, explanation, image, year, grade, semester) 
                    values ('${params.id}','${params.title}', '${params.explanation}', '${image}', '${params.year}', '${params.grade}', '${params.semester}')`
                    // db에 저장할때는 파일 경로만 저장되게  하고 사진파일 자체는 /uploads/${req.file.filename}`에 저장
        let rows = await conn.query(sql, []);

        sql = `insert into test.stuarchiveSafeDelete(id, title, explanation, image, year, grade, semester) 
                    values ('${params.id}','${params.title}', '${params.explanation}', '${image}', '${params.year}', '${params.grade}', '${params.semester}')`
                    // 지워지지 않는 테이블에 저장 (영구 기록용)
        rows = await conn.query(sql, []);

        const output = {
        }

        res.writeHead(200, {'Content-Type':'text/html;charset=utf8'});
        res.end(JSON.stringify(output));
    } catch (err) {
        console.log(`Main 오류 -> ${err}`);
    } finally {
        if (conn) conn.end();
    }
})


router.route('/stuArchiveSelectAll').get(async(req, res) => { 
    console.log(`stuArchiveSelectAll 라우터 접속`)

    let conn;
    try{

        conn = await pool.getConnection();
        let sql = `select * from test.stuarchive`
        let rows = await conn.query(sql, []);

        const output = {
            output:rows
        }

        res.writeHead(200, {'Content-Type':'text/html;charset=utf8'});
        res.end(JSON.stringify(output));
    } catch (err) {
        console.log(`Main 오류 -> ${err}`);
    } finally {
        if (conn) conn.end();
    }
})

router.route('/stuArchiveSelectWhere').get(async(req, res) => { 
    console.log(`stuArchiveSelectWhere 라우터 접속`)

    const params = req.query
    let conn;
    try{

        conn = await pool.getConnection();
        let sql = `select * from test.stuarchive where year='${params.year}' and grade ='${params.grade}' and semester = '${params.semester}'`
        let rows = await conn.query(sql, []);

        const output = {
            output:rows
        }

        res.writeHead(200, {'Content-Type':'text/html;charset=utf8'});
        res.end(JSON.stringify(output));
    } catch (err) {
        console.log(`Main 오류 -> ${err}`);
    } finally {
        if (conn) conn.end();
    }
})


router.route('/stuArchiveDelete').get(async(req, res) => { 
    console.log(`stuArchiveDelete 라우터 접속`)

    const params = req.query
    let conn;
    try{

        conn = await pool.getConnection();
        let sql = `delete from test.stuarchive where number = ${params.number}`
        let rows = await conn.query(sql, []);

        const output = {
        }

        res.writeHead(200, {'Content-Type':'text/html;charset=utf8'});
        res.end(JSON.stringify(output));
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