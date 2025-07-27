// 웹서버 만들기

// 1. 다른 개발자가 만든 모듈(라이브러리) 불러오기  = require();
// 요청, 응답에 대한 방법을 http라는 약속으로 정해둔 거임
const http = require('http');

// http만 쓰려다 보니까 코드가 너무 많아서 간단하게 쓰려고 가져오는거 = 변수상자 안에 함수상자가 있음
const express = require('express');

// 2. 익스프레스를 이용해서 웹서버를 위한 객체 만들기
const app = express();

// 4. 미들웨어 추가하기
// 미들웨어 => 중간에 가로챈다, 원하는 만큼 등록가능
// 그래서 use라는 변수로 res.end로 
app.use((req, res, next) => {
    console.log(`첫번째 미들웨어 호출됨`);

    next();    
})
app.use((req, res, next) => {
    console.log(`두번째 미들웨어 호출됨`)

    res.writeHead(200, {'Content-Type':'text/html;charset=utf8'});
    res.end(`<h1>웹서버에서 전달받은 페이지<h1>`);
})
// 왜 호출을 여러번 하는가? 한번 요청에 제대로 안될수도있기 때문에 여러번 요청함 

// 3. 웹서버 실행하기
// 7001번 포트로 웹서버가 대기하게 됨 => 포트는 
http.createServer(app).listen(7001, () => {
    console.log(`웹서버 실행됨`);
})

// 요청경로에 따라 다른 웹페이가 보일 수 있도록 할 수 있음
