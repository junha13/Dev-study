// 붕어빵 만들기
// 붕어빵을 만드는 이유는 변수상자를 모아두는 것에 목적이 있음



let fish1 = {
    name: '홍길동1',
    age: 21
}

console.log(`fish1 변수상자에 들어있는 붕어빵의 이름은? : ${fish1.name}`);

let fish2 = { // 얘네를 그냥 변수라기보다는 **속성**이라고 부름
    name: '홍길도2',
    age: 22,
    swim: function () { // 화살표 함수가 아니라 익명함수로 해야 this를 사용할 수 있음
        console.log(`물고기가 헤엄칩니다 : ${this.name}`);
    }
}

fish2.swim(); // 화살표함수는 this를 못알아먹음

class Fish{ // 클래스 선언 let을 떼고 넣어야됨
    constructor(name, age) {
        this.name = name; // this는 붕어빵 자신을 말하는 것이 맞고, 만들어지면 변수는 자동으로 만들어짐
        this.age = age;

    }

    swim() {
        console.log(`붕어빵이 헤엄칩니다. ${this.name}`)
    }
}
let fish3 = new Fish(`붕어빵1` ,1);
console.log(`${fish3.name}`);
fish3.swim();

// js에서는 객체를 한번만 사용하는 경우가 많음 때문에 객체를 바로바로 생성해서 사용함
