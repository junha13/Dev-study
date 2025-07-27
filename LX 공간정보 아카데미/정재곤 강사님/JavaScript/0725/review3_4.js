// 하나의 변수상자 안에 여러 값을 넣기
const fishes = [ // const라서 배열 전체를 바꿀 수는 없지만 ,배열 안쪽을 바꿀 수는 있다 
    {
        name: '물고기1',
        age: 1
    },
    {
        name: '물고기2',
        age:2
    }
]

console.log(`물고기 마리수 : ${fishes.length}`)
fishes[0].name = '물고기3'

console.log(`첫 번째 물고기의 이름 : ${fishes[0].name}`)

// 변수상자 안에 들어있는 각각의 값을 알아보기
for (let fish of fishes) {
    console.log(`물고기의 이름 : ${fish.name}`);
}

// forEach 안에 콜백함수가 만들어짐
fishes.forEach((value, index) => {
    console.log(`물고기의 이름 : ${value.name}`);
})

// forEach 함수 직접 만들어보기
const forEach = (items, callback) => { // items에 fishes가 전달이 된다면
    let index = 0;
    for (let item of items) {
        callback(item, index);
        index += 1;
    }
}

forEach(fishes, (value, index) => {
    console.log(`물고기의 이름 : ${value.name}`);
})