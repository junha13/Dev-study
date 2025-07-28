// 변수상자 만들기
let name1 = "홍길동1"; // String
let age1 = 21; // number
let visible = true; // boolean

const nameType = typeof(name1);
console.log(`변수상자 타입 ${typeof(visible)}`);

let name2;
const name2Type = typeof(name2);
console.log(`변수상자 타입 ${name2Type}`);

const age2 = `21`;  // 숫자가 들어가 있어도 글자 형태임
const age3 = `22`;

const age2Int = Number(age2); // Int 변환
const age3Int = Number(age3);

const result1 = age2Int + age3Int;
console.log(result1);

const age4 = `21A`
const age4Int = Number(age4);
if (isNaN(age4Int)) {
    console.log(`첫 번째 글자는 숫자가 아닙니다.`)
}


