// 붕어빵 만들기

const fish1 = {
    name: "물고기",
    age: 21
}

const fishes = [
    {
        name: "물고기",
        age: 12
    },
    {
        name: "물물고기",
        age: 11
    }
]
const fishes1 = []
fishes1.push({
    name:"물물물고기",
    age: 1
})
fishes1.push({
    name:"물물물물고기",
    age: 11
})

console.log(`fishes의 칸 개수 : ${fishes.length}`);
console.log(`첫번째 칸에 있는 물고기의 이름 : ${fishes[0].name}`);
console.log(`첫번째 칸에 있는 물고기의 이름 : ${fishes[0]['name']}`);

class Fish {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }

}

const fish3 = new Fish(`물물물물물고기`, 5);
const fish4 = new Fish(`물물물물물물고기`, 6);

