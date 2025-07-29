// 웹서버 만들기 (Node.js + Express + MariaDB)

// ------------------------------------------------------
// 1. 모듈 불러오기 (require)
// ------------------------------------------------------
const http = require('http');       // Node.js 기본 웹서버 모듈
const express = require('express'); // 웹 애플리케이션 프레임워크
const mariadb = require('mariadb'); // MariaDB DB 연결 모듈

// ------------------------------------------------------
// 2. 데이터베이스 연결 풀 설정
// ------------------------------------------------------
const pool = mariadb.createPool({
    host: 'localhost', // DB 서버 주소
    port: 3307,        // DB 서버 포트
    user: 'root',      // 사용자 계정
    password: 'rootroot'// 비밀번호
    // database는 SQL문 실행 시 'test.person' 처럼 직접 지정
})

// ------------------------------------------------------
// 3. Express 앱 설정
// ------------------------------------------------------
const app = express();

// 뷰 파일이 있는 폴더 경로와 뷰 엔진(ejs) 설정
app.set('views', './views');
app.set('view engine', 'ejs');

// ------------------------------------------------------
// 4. 라우터 객체 생성 및 미들웨어 등록
// ------------------------------------------------------
const router = express.Router();
app.use('/', router); // 기본 경로("/")로 들어오면 router 사용

// ------------------------------------------------------
// 5. URL 라우팅
// ------------------------------------------------------

// (1) /page/list 요청 처리
router.route('/page/list').get(async (req, res) => {
    console.log('/page/list 요청됨');

    let conn;
    try {
        // 1) DB 연결 가져오기
        conn = await pool.getConnection();

        // 2) SQL문 실행
        const sql = `select id, name, age, mobile from test.person`;
        const rows = await conn.query(sql, []);

        // 3) ejs 템플릿에 전달할 데이터(context) 준비
        const context = {
            persons: rows // rows 배열을 템플릿에 넘김
        }

        // 4) ejs 파일 렌더링 → HTML로 변환
        req.app.render('list', context, (err, html) => {
            if (err) {
                console.error(`뷰 처리 중 에러 -> ${err}`);
            }

            // 5) HTTP 응답 보내기
            res.writeHead(200, {'Content-Type':'text/html;charset=utf8'});
            res.end(html);
        });

    } catch(err) {
        console.error(`요청 처리 중 에러 -> ${err}`);
    } finally {
        if (conn) { conn.end(); } // DB 연결 반환
    }
});


// (2) /page/add 요청 처리
router.route('/page/add').get(async (req, res) => {
    console.log('/page/add 요청됨');

    try {
        const context = {
            // add.ejs 파일은 입력 폼 화면만 보여줄 것이라 데이터 없음
        }

        req.app.render('add', context, (err, html) => {
            if (err) {
                console.error(`뷰 처리 중 에러 -> ${err}`);
            }

            res.writeHead(200, {'Content-Type':'text/html;charset=utf8'});
            res.end(html);
        });

    } catch(err) {
        console.error(`요청 처리 중 에러 -> ${err}`);
    }
});


// (3) /page/insert 요청 처리
router.route('/page/insert').get(async (req, res) => {
    console.log('/page/insert 요청됨');

    // GET 방식으로 전달된 파라미터 추출 (?name=...&age=...&mobile=...)
    const params = req.query;
    console.log(`요청 파라미터 -> ${JSON.stringify(params)}`);

    let conn;
    try {
        // 1) DB 연결 가져오기
        conn = await pool.getConnection();

        // 2) insert SQL 실행 (새로운 데이터 저장)
        let sql = `insert into test.person(name, age, mobile) 
                   values ('${params.name}', ${params.age}, '${params.mobile}')`;
        let rows = await conn.query(sql, []);

        // 3) 저장 후 다시 목록 조회
        sql = `select id, name, age, mobile from test.person`;
        rows = await conn.query(sql, []);

        // 4) 새 목록 데이터를 context에 담아서 list.ejs 렌더링
        const context = {
            persons: rows
        }

        req.app.render('list', context, (err, html) => {
            if (err) {
                console.error(`뷰 처리 중 에러 -> ${err}`);
            }

            res.writeHead(200, {'Content-Type':'text/html;charset=utf8'});
            res.end(html);
        });

    } catch(err) {
        console.error(`요청 처리 중 에러 -> ${err}`);
    } finally {
        if (conn) { conn.end(); } // DB 연결 반환
    }
});

router.route('/page/edit').get(async (req, res) => {
    console.log('/page/edit 요청됨');

    try {
        const context = {
            // add.ejs 파일은 입력 폼 화면만 보여줄 것이라 데이터 없음
        }

        req.app.render('edit', context, (err, html) => {
            if (err) {
                console.error(`뷰 처리 중 에러 -> ${err}`);
            }

            res.writeHead(200, {'Content-Type':'text/html;charset=utf8'});
            res.end(html);
        });

    } catch(err) {
        console.error(`요청 처리 중 에러 -> ${err}`);
    }
});



router.route('/page/update').get(async (req, res) => {
    console.log('/page/update 요청됨');

    const params = req.query;
    console.log(`요청 파라미터 -> ${JSON.stringify(params)}`);

    let conn;

    try {
        conn = await pool.getConnection();

        let sql = `update test.person(name, age, mobile)`;

        let rows = await conn.query(sql, []);

        sql = `select id, name, age, mobile from test.person`;
        rows = await conn.query(sql, []);

        const context = {
            persons: rows
        }

        req.app.render('list', context, (err, html) => {
            if (err) {
                console.error(`뷰 처리 중 에러 -> ${err}`);
            }
            res.writeHead(200, {'Content-Type':'text/html;charset=utf8'});
            res.end(html);
        });
    } catch (err) {
        console.error(`요청 처리 중 에러 -> ${err}`);
    } finally {
        if (conn) { conn.end(); }
    }

});



// ------------------------------------------------------
// 6. 서버 실행
// ------------------------------------------------------
const port = 7001;
http.createServer(app).listen(port, () => {
    console.log(`웹서버 실행됨 -> port: ${port}`);
});
