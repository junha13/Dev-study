// 웹서버 만들기

// 다른 개발자가 만들어둔 모듈 불러오기
const http = require('http')
const express = require('express')
const cors = require('cors');
const mariadb = require('mariadb')

const pool = mariadb.createPool({
    host:'localhost',
    port:4406,
    user:'root',
    password:'rootroot'
})


BigInt.prototype.toJSON = () => {
    return this.toString();
}

// 웹서비스를 위한 객체 만들기
const app = express();
app.use(cors());

// 웹페이지 파일을 저장해두고 불러와서 사용하기 위해 사용되는 모듈에 대한 설정
app.set('views', __dirname +'/views');
app.set('view engine', 'ejs');  // 나중에 자바로 웹서버 만들땐 jsp 사용 / 지금은 자바스크립트 사용중
 

// 라우터 설정하기
// 클라이언트(요청을 하는 쪽, 웹브라우저)에서 요청 경로로 요청하는 것을 
// 어떤 함수로 실행시켜서 응답을 보내줄 지를 결정해주는 것
// 요청 경로 -> 함수 매칭
const router = express.Router();
app.use('/', router);

// /person/list 요청경로로 요청이 들어오면 설정한 콜백함수를 실행함
router.route('/person/list-data').get(async(req, res)=> {
    console.log(`/person/list-data 요청경로로 요청됨`);


    let conn; // const 쓰면 안됨

    try {
        // 데이터베이스에서 데이터 조회하기
        const sql = `select id, name, age, mobile from test.person`;
        conn = await pool.getConnection();
        
        let rows = await conn.query(sql, [])


        const output = {
            code:200,
            message :'ok',
            data: rows
        }


  
        // 클라이언트(요청한 쪽, 웹브라우저) 쪽으로 응답을 보내줌
        res.writeHead(200, {'Content-Type':'text/html;charset=utf8'});
        res.end(JSON.stringify(output));
 
    } catch (err) {
        console.error(`에러 발생 -> err: ${err}`);
    } finally {
        if (conn) conn.end();
    }
})



router.route('/person/modify').get(async(req, res)=> {
    console.log(`/person/modify 요청경로로 요청됨`);

    // 클라이언트로부터 전달받은 요청 파라미터 확인하기
    const params = req.query;
    console.log(`요청 파라ㅣ미터 -> params ${JSON.stringify(params)}`)

    let conn; // const 쓰면 안됨

    try {
        // 데이터베이스에서 데이터 조회하기
        // 클라이언트(웹브라우저)가 보내준 요청 파라미터를 SQL문과 합쳐서 업데이트 실행
        let sql = `update test.person set name = '${params.name}', age = ${params.age}, mobile = '${params.mobile}'
                        where id = ${params.id}`;
        conn = await pool.getConnection();
        let rows = await conn.query(sql, [])
        
        // 업데이트 한 결과로 고객 목록을 볼 수 있도록 list.ejs 웹페이지 파일을 불러온 후 DB의 데이터와 결합시켜 응답 보내기
        sql = `select id, name, age, mobile from test.person`;
        rows = await conn.query(sql, [])
        const context = {
            persons: rows
        }


        // view 폴더 안에 있는 list.ejs 웹페이지 파일을 읽어오고
        // context 객체(붕어빵) 안에 있는 속성들을 웹페이지와 결합해서
        // 콜백함수의 두번째 구멍으로 전달해줌
        req.app.render(`list`, context, (err, html) => {  // 만약 데이터가 있다면 콜백함수로 넘어감 - 오류있으면 if걸림
            // 만약 첫번째 구멍으로 에러가 전달된다면
            if (err) {
                console.error(`view 처리 중 에러 -> ${err}`)
            }

            // 정상적으로 두번째 구멍으로 웹페이지가 전달된다면
            // 클라이언트(요청한 쪽, 웹브라우저) 쪽으로 응답을 보내줌
            res.writeHead(200, {'Content-Type':'text/html;charset=utf8'});
            res.end(html);
        })
    } catch (err) {
        console.error(`에러 발생 -> err: ${err}`);
    } finally {
        if (conn) conn.end();
    }
})


router.route('/person/update').get(async(req, res)=> {
    console.log(`/person/update 요청경로로 요청됨`);

    // 클라이언트로부터 전달받은 요청 파라미터 확인하기
    const params = req.query;

    const context = {
        params:params // ? 
    }


    // view 폴더 안에 있는 list.ejs 웹페이지 파일을 읽어와서 요청 파라미터로 전달받은 데이터를 결합한 후 
    // 콜백함수의 두번째로 전달해줌
    req.app.render(`update`, context, (err, html) => {  // 만약 데이터가 있다면 콜백함수로 넘어감 - 오류있으면 if걸림
        // 만약 첫번째 구멍으로 에러가 전달된다면
        if (err) {
            console.error(`view 처리 중 에러 -> ${err}`)
        }

        // 정상적으로 두번째 구멍으로 웹페이지가 전달된다면
        // 클라이언트(요청한 쪽, 웹브라우저) 쪽으로 응답을 보내줌
        res.writeHead(200, {'Content-Type':'text/html;charset=utf8'});
        res.end(html);
    })
})



router.route('/person/delete').get(async(req, res)=> {
    console.log(`/person/delete 요청경로로 요청됨`);

    try {
        // 클라이언트로부터 전달받은 요청 파라미터 확인하기
        const params = req.query;

        let sql = `DELETE FROM test.person WHERE id = ${params.id}`
        let conn = await pool.getConnection();
        let rows = await conn.query(sql,[]);

        sql = 'select * from test.person'
        rows = await conn.query(sql,[]);

        const context = {
            persons: rows 
        }


        // view 폴더 안에 있는 list.ejs 웹페이지 파일을 읽어와서 요청 파라미터로 전달받은 데이터를 결합한 후 
        // 콜백함수의 두번째로 전달해줌
        req.app.render(`list`, context, (err, html) => {  // 만약 데이터가 있다면 콜백함수로 넘어감 - 오류있으면 if걸림
            // 만약 첫번째 구멍으로 에러가 전달된다면
            if (err) {
                console.error(`view 처리 중 에러 -> ${err}`)
            }

            // 정상적으로 두번째 구멍으로 웹페이지가 전달된다면
            // 클라이언트(요청한 쪽, 웹브라우저) 쪽으로 응답을 보내줌
            res.writeHead(200, {'Content-Type':'text/html;charset=utf8'});
            res.end(html);
        })
    } catch(err) {
        console.error(`에러 발생 -> err: ${err}`);
    } finally {
        if (conn) conn.end();
    }
})

router.route('/page/insert').get(async(req, res) => {

    const context = {

    }

    req.app.render('insert', context, (err, html) => {
        if (err) {
            console.error(`view 처리 중 에러 -> ${err}`)
        }

        res.writeHead(200, {'Content-Type':'text/html;charset=uft8'});
        res.end(html);
    })
})

router.route('/page/add').get(async(req, res) => {

    try {
        const params = req.query;
        let sql = `insert into test.person(name, age, mobile) values ('${params.name}', ${params.age}, '${params.mobile}')`
        let conn = await pool.getConnection();
        let rows = await conn.query(sql, []);

        sql = `select * from test.person`
        rows = await conn.query(sql, []);



        const context = {
            persons:rows
        }

        req.app.render('list', context, (err, html) => {
            if (err) {
                console.error(`view 처리 중 에러 -> ${err}`)
            }

            res.writeHead(200, {'Content-Type':'text/html;charset=uft8'});
            res.end(html);
        })
    } catch (err) {
        console.error(`에러 발생 -> err: ${err}`);
    } finally {
        if (conn) conn.end(); 
    }
})


//웹서버 실행하기
const port = 7001;


http.createServer(app).listen(port, () => {
    console.log (`웹서버 실행됨 : ${port}`);
})