class Cat{
    constructor(name){
        this.name = name;
    }
}
class Dog{
    constructor(name){
        this.name = name;
    }
}

let person = {
    name: "홍길동",
    age: 21,
    mobile: "010-1111-1111"
}

let house = {
    dog: new Dog("멍멍이"),
    cat: new Cat("야옹이"),
    person: person,
    profile: function () {
        console.log(`현재 사는 사람의 이름 : ${this.person.name}, 나이 : ${this.person.age}, 전화번호 ${this.person.mobile}`);
        console.log(`현재 사는 강아지 이름 : ${this.dog.name}`);
        console.log(`현재 사는 고양이 이름 : ${this.cat.name}`);    
    }
}
let dog = "멍멍ㅎㅍ이";
house.profile();