// 웹서버 만들기

// 1. 다른 개발자가 만든 http라는 모듈을 불러오기
const http = require(`http`);
const express = require(`express`);
const mariadb = require(`mariadb`);

const pool= mariadb.createPool({ //pool로 값 빈환가능
    host : 'localhost',
    port : 4406,
    user: 'root',
    password: `rootroot`
})

const app = express();

app.set(`views`,  __dirname + `/views`);
app.set(`view engine`, `ejs`);






const router = express.Router();
app.use('/', router);


router.route(`/page/menu`).get(async(req, res) => {
    console.log(`menu 요청됨`)

    const context = {

    }

    req.app.render(`menu`, context, (err, html) => {
            if (err) { 
                console.log(`뷰 처리 중 에러 -> ${err}`);
            }

            res.writeHead(200, {'Content-Type':'text/html;charset-utf8'});
            res.end(html);
    })
})

router.route(`/page/update`).get(async(req, res) => {
    console.log(`update 요청됨`);

    const context = {

    }
    req.app.render(`updete`, context, (err, html) => {
        if (err) {
            console.log(`뷰 처리 중 에러 -> ${err}`);
        };
        res. writeHead(200, {'Content-Type':'text/html;charset-utf8'});
        res.end(html);
    });
});
router.route(`/page/insert`).get(async(req, res) => {
    console.log(`insert 요청됨`);

    conn = await pool.getConnection();


    const context = {

    }
    req.app.render(`insert`, context, (err, html) => {
        if (err) {
            console.log(`뷰 처리 중 에러 -> ${err}`);
        };
        res. writeHead(200, {'Content-Type':'text/html;charset-utf8'});
        res.end(html);
    });
});
router.route(`/page/select`).get(async(req, res) => {
    console.log(`select 요청됨`);

    const params = req.query;
    conn = await pool.getConnection();
    const sql = `select id, name, age, mobile from test.person`;
    const rows = await conn.query(sql, []); // 빈 배열 넣기

    const id= Number(params.id) -1; 

    const context = {  // 순차적으로 이루어지는게 아님 타입변환 해줄거면 밖에서 해주고 들어와야됨
        id: id,
        username: rows[id].name,
        age: rows[id].age,
        mobile: rows[id].mobile
    }
    req.app.render(`select`, context, (err, html) => {
        if (err) {
            console.log(`뷰 처리 중 에러 -> ${err}`);
        };
        res. writeHead(200, {'Content-Type':'text/html;charset-utf8'});
        res.end(html);
    });
});



router.route(`/page/delete`).get(async(req, res) => {
    console.log(`/page/delete 요청됨`)

    let conn;
    try {
        // 데이터베이스로 SQL문 실행 요청하기
        
        conn = await pool.getConnection();  // pool을 다 쓰고 나면 반환해줘야 함


        const sql = `select id, name, age, mobile from test.person`;
        const rows = await conn.query(sql, []); // 빈 배열 넣기


        const context = {
            username: rows[0].name
        }

        req.app.render(`delete`, context, (err, html) => {
            if (err) { 
                console.log(`뷰 처리 중 에러 -> ${err}`);
            }

            res.writeHead(200, {'Content-Type':'text/html;charset-utf8'});
            res.end(html);
        })

    } catch(err) {
        console.error(`요청 처리 중 에러 -> ${err}`);
    } finally {
        if (conn) {conn.end();}
    }

})

const port = 7002;
http.createServer(app).listen(port, () => {
    console.log(`웹서버 실행됨 -> port: ${port}`);
})


