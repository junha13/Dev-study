// sysoutprintln이랑 똑같음
console.log('안녕');

// 변수상자 만들기
// 자바스크립트는 변수상자의 크기를 명시하지 않음.
// 자바의 경우
// String name1;
// 모든 변수상자 앞에 let을 붙힘
let name1; // 어떤게 들어가는지 모름
name1 = '홍길동';
console.log(`name1 변수상자의 값은 : ` + name1);
console.log(`name1 변수상자의 값은 : ${name1}`); // 이걸 더 권장

let name2 = '홍길동2';
console.log(`name2 변수상자의 값 : ${name2}`);

let age1 = 21;
console.log(`age1 변수상자의 값 : ${age1}`);

// 여까지 만들고 문제가 생김 . 변수상자의 크기를 확인해야 할 때가 생김
console.log(`name1 변수상자의 크기 : ${typeof(name1)}`);
console.log(`name1 변수상자의 크기 : ${typeof(age1)}`);
// String이 아닌 string 임

let visible = true;
console.log(`visible 변수상자 크기 : ${typeof(visible)}`);
// js는 이렇게 세개가 끝임

let age2;
console.log(`age2변수상자크기 : ${typeof(age2)}`);
// 얘는 값이 없으니까 undefined 를 가짐, 값을 넣었을때 타입이 정해짐

if (typeof(age2) == `undefined`) {
    console.log(`age2 변수상자의 크기를 알 수 없습니다.`);
} else if (typeof(age2) == `string`) {
    console.log(`age2 변수상자의 크기는 string입니다`);
}

age2 = 22;

if (age2) { // undefined가 아닌 경우에 걸림 if(값)
    console.log(`age2 변수상자의 크기가 결정되어 있습ㄴ디ㅏ : ${typeof(age2)}`);
}