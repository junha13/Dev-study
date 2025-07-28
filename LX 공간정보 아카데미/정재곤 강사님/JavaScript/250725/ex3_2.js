// 웹서버 만들기

// 1. 다른 개발자가 만든 모듈(라이브러리) 불러오기  = require();
// 요청, 응답에 대한 방법을 http라는 약속으로 정해둔 거임
const http = require('http');

// http만 쓰려다 보니까 코드가 너무 많아서 간단하게 쓰려고 가져오는거 = 변수상자 안에 함수상자가 있음
const express = require('express');

// 2. 익스프레스를 이용해서 웹서버를 위한 객체 만들기
const app = express();


// 6. 뷰 사용하기
app.set('views', './views');
app.set('view engine', 'ejs');
// ejs, ./views라는 엔진을 사용하는거임 


// 4. 미들웨어 추가하기
// 미들웨어 => 중간에 가로챈다, 원하는 만큼 등록가능
// 그래서 use라는 변수로 res.end로 

// 5. 라우터 추가하기
const router = express.Router();
app.use('/', router);

router.route('/page/login').get((req, res) => {
    console.log(`/page/login 요청됨`);


    const params = req.query;
    console.log(`요청 파라미터 -> ${JSON.stringify(params)}`);

    const context = {
        name: params.name
    }

    req.app.render(`login`, context, (err, html) => {
        if (err) {
            console.error(`뷰 처리 중 에러 -> ${err}`);
            return;
        }
        res.writeHead(200, {'Content-Type':'text/html;charset-utf8'});
        res.end(html);
    });

})

router.route('/page/first').get((req, res) => {
    console.log(`/page/first 요청됨`);

    const params = req.query;
    console.log(`요청 파라미터 -> ${JSON.stringify(params)}`);

    const context = {  //context에서 찍은 붕어빵을 html에서 그대로 사용할 수 있음
        username:"홍길동1"
    }

    //render를 실행하면
    req.app.render('first', context, (err, html) => { 
        if (err) {
            console.error(`뷰 처리 중 에러 -> ${err}`);
            return;
        }
        res.writeHead(200, {'Content-Type':'text/html;charset-utf8'});
        res.end(html);
    });
})

router.route('/page/second').get((req, res) => {
    console.log(`/page/second 요청됨`);

    const params = req.query;
    const context = { // 이름이 어디서 오는지
        name: params.name

    }

    req.app.render('second', context, (err, html) => {
        if (err) {
            console.error(`뷰 처리 중 에러 -> ${err}`);
            return;
        }
        res.writeHead(200, {'Content-Type':'text/html;charset-utf8'});
        res.end(html);
    });

})




// 3. 웹서버 실행하기
// 7001번 포트로 웹서버가 대기하게 됨 => 포트는 
http.createServer(app).listen(7001, () => {
    console.log(`웹서버 실행됨`);
})

// 요청경로에 따라 다른 웹페이가 보일 수 있도록 할 수 있음
