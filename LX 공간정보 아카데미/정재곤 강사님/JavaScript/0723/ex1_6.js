// 함수상자 만들기

// 자바에서
// int add(int a, int b) {
//  return a + b;
//}



function add(a, b) {
    return a+b;
}

let output1 = add(10, 10);
console.log(`더하기 결과 : ${output1}`);

function print(a) {
    console.log(`print 함수상자 안에서 a 상자의 값 : ${a}`);
}

print(10);



// 함수 상자를 변수 상자에 할당하기
let show = print;

show(20);

// 함수 상자를 만들면서 변수상자에 즉시 할당하기
// 변수 상자를 만들면서 함수상자로 초기화하기
let show2 = function () { // 익명함수, 이름이 없음 
    console.log(`print2 함수 실행됨.`);
}

// 이름없는 함수
show2();

let show3 = () => { // 화살표 함수
    console.log(`print2 함수 실행됨.`);
}

function add2 (a, b) {
    return a+b;
}

let output2 = add2(10,10);
console.log(`더하기 결과 : ${output2}`);


// 값이 통과하는 절차가 좀 달라짐
// 리턴함수, 콜백함수
function add3(a, b, c ) {
    c(a+b);
}

add3(10,10,output => { 
    console.log(`더하기 결과 : ${output}`);
});






