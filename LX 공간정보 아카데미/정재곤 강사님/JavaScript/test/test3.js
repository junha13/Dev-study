
// 1. 다른 개발자가 만든 모듈 불러오기 
// 기본 HTTP 기능을 준비하고 → Express 도구를 불러와서 → Express 웹 서버를 만든다
// import 느낌
const http = require('http');
const express = require('express');
const app = express();

// 5. 뷰 사용하기
// 폴더를 설정하고, 해석 방법을 설정하는거임
app.set(`views`, `./views`);
app.set(`view engine`, `ejs`);

// 3. 미들웨어 추가하기
// use로 사용 res.end

// 4. 라우터 추가하기
const router = express.Router();
app.use(`/`, router);

router.route(`/page/login`).get((req, res) => {
    console.log(`login 요청`);

    const params = req.query;
    
    const context = {
    }

    req.app.render(`login`, context, (err, html) => {
        if (err) {
            console.error(`뷰 처리 중 에러 -> ${err}`);
            return;
        }
        res.writeHead(200, {'Content-Type':'text/html;charset-utf-8'});
        res.end(html);
    })


})
router.route(`/page/menu`).get((req, res) => {
    console.log(`menu 요청`);

    const params = req.query;
    
    const context = {  // 이 페이지에서 사용하는 함수를 정의해야 함, 이 페이지로 보내는 쪽에서 정의된 함수를 이쪽에 정의하는거임
        name:params.username,
        lastName:params.lastname
    }

    req.app.render(`menu`, context, (err, html) => {
        if (err) {
            console.error(`뷰 처리 중 에러 -> ${err}`);
            return;
        }
        res.writeHead(200, {'Content-Type':'text/html;charset-utf-8'});
        res.end(html);
    })


})
router.route(`/page/customerManage`).get((req, res) => {
    console.log(`고객관리 요청`);

    const params = req.query;
    
    const context = {
        name:params.username,
    }
    

    req.app.render(`customerManage`, context, (err, html) => {
        if (err) {
            console.error(`뷰 처리 중 에러 -> ${err}`);
            return;
        }
        res.writeHead(200, {'Content-Type':'text/html;charset-utf-8'});
        res.end(html);
    })


})
router.route(`/page/productManage`).get((req, res) => {
    console.log(`물품관리`);

    const params = req.query;
    
    const context = {
        name:params.username,
    }

    req.app.render(`productManage`, context, (err, html) => {
        if (err) {
            console.error(`뷰 처리 중 에러 -> ${err}`);
            return;
        }
        res.writeHead(200, {'Content-Type':'text/html;charset-utf-8'});
        res.end(html);
    })


})
router.route(`/page/salesManage`).get((req, res) => {
    console.log(`매출관리`);

    const params = req.query;
    
    const context = {
        name:params.username,
    }
    

    req.app.render(`salesManage`, context, (err, html) => {
        if (err) {
            console.error(`뷰 처리 중 에러 -> ${err}`);
            return;
        }
        res.writeHead(200, {'Content-Type':'text/html;charset-utf-8'});
        res.end(html);
    })


})

// 2. 웹서버 실행하기
// 7001번 포트로 웹서버가 대기
http.createServer(app).listen(7001, () => {
    console.log(`웹서버 실행`);
})