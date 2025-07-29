// 함수상자

// 콜백함수 잘 이해하기


// A 개발자 -> 더하기 함수 상자 만들기 : a, b라는 2개의 위쪽 구멍을 만들어둠
function add(a, b) {
    return a + b;
}

// B 개발자 -> A 개발자가 만든 더하기 함수상자의 위쪽 구멍은 2개라고 이미 정의되어 있음
// 이 부분에 대해선 B 개발자의 의지가 아님 정의된 대로 호출해야 함
const a = 10;
const b = 20;
const result1 = add(a, b);
console.log(`더하기 결과 : ${result1}`);

// 콜백함수
// 함수를 1급 객체로 다룬다 -> 함수를 변수에 할당할 수 있다 -> 함수상자를 변수상자에 넣을 수 있다.

const add2 = function (a, b) {  // 함수이름 생략 가능 -> 익명함수
    return a + b;
}

const add3 = (a, b) => {  // 화살표함수
    return a + b;
}


// 콜백함수
// A 개발자가 콜백함수를 사용하는 형태로 함수를 정의함
const add4 = (a, b, callback) => {
    callback(a + b);  // return으로 함수 아래로 떨어뜨리지 않겠디  // 이 값을 세번째 인자로 넘겨주겠다.
}

// B 개발자가 콜백함수를 사용함
// 위쪽 구멍으로 던져줄 값의 갯수는 A 개발자가 정의한 개수와 동일하게 맞춰줌
add4(a, b, (result) => {
    console.log(`콜백함수 안에서 더하기 결과 : ${result}`);
});
// console.log(`콜백함수 밖에서 더하기 결과 ${result}`); 이건 안됨 지역변수인가?

// 콜백함수를 여러 개 연속해서 사용하는 경우
// null 알아보기
let fish1 = {  // 객체의 주솟값을 fish1에 넣은거임, 이때 변수가 가리키는 객체가 없으면 null임
    name: `홍길동`,
    age : 1
}

let fish2 = null; // undifined는 아님 

const add5 = (a, b, callback) => {
    const result = a + b;
    callback(null, result);  // 에러가 있을 경우 null, 정상적으로 실행되면 result
}

add5(10, 10, (err, result) => {
    if (err) { // null인 경우에 들어오게 됨
        console.error(`에러 발생 -> ${err}`);
        return;
    } 
    console.log(`더하기 결과 ${result}`);
})

// 나누기 함수
const divide5 = (a, b, callback) => {
    if (b == 0) {
        callback(`두번째 값이 0입니다.`, null);
        return; // 함수 실행 끝내기
    }
    const result = a / b; // b가 0이면 안됨
    callback(null, result);
}

divide5(200, 10, (err, result) => {
    if (err) {
        console.log(`에러 발생 -> ${err}`);
    }

    console.log(`콜백함수 안에서 나누기 결과 : ${result}`);
})

// A개발자가 만들어 둔 더하기 함수와 나누기 함수가 있을 때,
// 나누기 함수를 실행한 결과값에 다른 값을 더하고 싶은 경우

divide5(200, 10, (err, result) => {
    if (err) {
        console.log(`에러 발생 -> ${err}`);
        return;
    }

    console.log(`나누기 결과 ${result}`);

    add5(result, 10, (err2, result2) => {
        if (err2) {
            console.log(`에러 발생 -> ${err2}`);
            return;
        }
        console.log(`더하기 결과 ${result2}`);
    })
})

const add6 = (a, b, callback) => {
    setTimeout (() => {
        const result = a + b;
        callback(null, result)
    }, 500 ) // 500밀리센컨드 이후에 callback 함수를 실행해라
    // DB에서 커넥션을 만드는 이유 => 
}

const divide6 = (a, b, callback) => {
    setTimeout(() => {
        if (b == 0) {
            callback(`두번째 값이 0입니다.`,null);
            return;
        }
        const result = a / b;
        callback(null, result); 
    }, 1000)
}

divide6(200, 10, (err, result) => {
    if (err) {
        console.error(`에러 발생 -> ${err}`);
        return;
    }
    console.log(`divide6 안에서 나누기 결과 : ${result}`)
})
add6(10, 10, (err, result) => {
    if (err) {
        console.error(`에러 발생 -> ${err}`);
        return;
    }
    console.log(`add6 안에서 더하기 결과 : ${result}`);
})

divide6(200, 10, (err, result) => {
    if (err) {
        console.log(`에러 발생 -> ${err}`);
        return;
    }

    console.log(`나누기 결과 : ${result}`);

    add6(result, 10, (err2, result2) => {
        if (err2) {
            console.log(`에러 발생 -> ${err2}`);
            return;
        }

        console.log(`더하기 결과 : ${result2}`);


    })

})


// async ~ await     // { return을 이렇게 한거임}
const add7 = (a, b) => new Promise((resolve, reject) => {
    add6(a, b, (err, result) => {
        if (err) {
            reject(err);  // err일 경우 reject 함수 실행
            return;
        }

        resolve(result);
    })
})

const divide7 = (a, b) => new Promise((resolve, reject) => {
    divide6(a, b, (err, result) => {
        if (err) {
            reject(err);
            return;
        }

        resolve(result);
    })
})

// 나누기를 먼저하고 그 결과를 이용해서 더하기 하기
const doCalc = async () => { // 얘만 순서대로 실행이 됨
    try {
    const result1 = await divide7(200, 10) // 콜백함수로 안던지고 promise ~~ 모르겠음 근야
    console.log(`doCalc 안에서 나누기 결과 : ${result1}`);

    const result2 = await add7(result1, 10); // promise로 변형한건 await을 붙혀서 
    console.log(`doCalc 안에서 더하기 결과 : ${result2}`);
    } catch(err) {
        console.error(`doCalc 안에서 에러 발생 : ${err}`);
    }
}
doCalc();

