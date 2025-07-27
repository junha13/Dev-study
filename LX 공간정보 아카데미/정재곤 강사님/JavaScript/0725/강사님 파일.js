// 웹서버 만들기

// 1. 다른 개발자가 만든 모듈(라이브러리) 불러오기
const http = require('http');
const express = require('express');

// 2. 익스프레스를 이용해서 웹서버를 위한 객체 만들기
const app = express();

// 6. 뷰 사용을 위해 설정하기
app.set('views', './views');
app.set('view engine', 'ejs');


// 4. 미들웨어 추가하기


// 5. 라우터 추가하기
const router = express.Router();
app.use('/', router);

router.route('/page/first').get((req, res) => {
    console.log(`/page/first 요청됨`);

    const context = {

    }

    req.app.render('first', context, (err, html) => {
        if (err) {
            console.error(`뷰 처리 중 에러 -> ${err}`);
            return;
        }

        res.writeHead(200, {'Content-Type':'text/html;charset=utf8'});
        res.end(html);
    })
 
})

router.route('/page/second').get((req, res) => {
    console.log(`/page/second 요청됨`);

    const context = {

    }

    req.app.render('second', context, (err, html) => {
        if (err) {
            console.error(`뷰 처리 중 에러 -> ${err}`);
            return;
        }

        res.writeHead(200, {'Content-Type':'text/html;charset=utf8'});
        res.end(html);
    })

})



// 3. 웹서버 실행하기
// 7001번 포트로 웹서버가 대기하게 됨
http.createServer(app).listen(7001, () => {
    console.log(`웹서버 실행됨`);
})

