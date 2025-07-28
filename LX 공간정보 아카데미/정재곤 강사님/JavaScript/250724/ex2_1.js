// 여러 개의 값을 하나의 변수 상자에 넣기 -> 배열

let names = ['홍길동1', '홍길동2', '홍길동3'];  // 칸이 3개 만들어지고 각각 값이 들어감
console.log(`names 배열 안에 있는 요소들의 개수 : ${names.length}`); // 칸 갯수 세서 출력
console.log(`names의 첫 번째 칸에 들어있는 값은? : ${names[0]}`); // 대괄호

let fishes = [
    { // 속성 2개를 묶은거임
        name: '물고기1',
        age: 1
    },
    {
        name: '물고기2',
        age: 2
    }
]
console.log(`fishes 변수상자에 들어있는 요소의 개수 : ${fishes.length}`);
console.log(`fishes의 첫 번째 칸에 들어있는 물고기의 이름은? : ${fishes[0].name}`);

console.log(`names 변수상자의 자료형은? ${typeof(names)}`); // 자료형이 object라고 뜸 
console.log(`names 변수상자의 첫번째 칸에 들어가 있는 값의 자료형은? : ${typeof(names[0])}`);

let fish1 = {
    name: '물고기1'
}
console.log(`fish1의 자료형은? : ${typeof(fish1)}`); // 이것도 object 

console.log(`names 변수상자는 배열인가요? : ${Array.isArray(names)}`); // 배열인지를 확인해주는 것 나중에 if문에서 사용하면 좋을듯
console.log(`fish1 변수상자는 배열인가요? : ${Array.isArray(fish1)}`);

let print = () => {
    console.log(`print 함수 실행됨.`);
}

console.log(`prnit 변수상자의 자료형은? ${typeof(print)}`);

// 값 추가하기
fishes.push({
    name: '물고기3',
    age: 25
})
console.log(`fishs 변수상자에 들어있는 칸의 개수 : ${fishes.length}`);

// 각 칸의 값을 하나씩 확인하기 - for문 대체 찾기
// 속도가 느림 C스타일 for문 가급적 안쓰는게
for (let i = 0; i<fishes.length; i++) {
    console.log(`fishes의 ${i+1}번째 물고기 : ${fishes[i].name}`);
}
// fishes에 fish를 하나씩 넣으면서 실행함 이런 형태를 권장함
let i =0;
for (let fish of fishes) {
    console.log(`fishes의 물고기 : ${fish.name}`);
    i +=1;
}

// callback 함수를 사용하기 (value, index는 고정으로 사용하셈)
fishes.forEach((value, index) => {
    console.log(`fishes의 ${index}번째 물고기 : ${value.name}`)
});


// 
let house = {
    name: '우리 집',
    children: [
        {
            name: '아이1',
            age: 11,
            fishes: [
                {
                    name: '물고기1',
                    age: 1
                }
            ]
        },
        {
            name: '아이2',
            age: 12
        }
    ]
}
console.log(`집 안에 있는 첫번째 아이가 가지고 있는 첫번째 물고기의 나이는? ${house.children[0].fishes[0].age}`);

console.log(`fish1 물고기의 이름 : ${fish1.name}`)
console.log(`fish1 물고기의 이름 : ${fish1[`name`]}`) // js만 됨 
// 이게 이름이 왜뜨지 => 만약 name이 아닌 age를 선택하는 경우에 안에 값을 넣어줄 수 있으니까 좋은거네


let attrName = 'name';
console.log(`fish1 물고기의 이름 : ${fish1[attrName]}`);

// 약간 주소값을 문자열로 넣을 수 있는 거 같은데 좀 어렵네
console.log(`집 안에 있는 첫 번째 아이가 가지고 있는 첫 번째 물고기의 나이는? : ${house[`children`][0][`fishes`][0][`age`]}`)


// 붕어빵 객체 안에 들어있는 속성들을 글자로 바꿔주기
// Json 포맷 (자바스크립트의 객체를 글자로 바뀐 것)☆
let houseInfo = JSON.stringify(house);
console.log(`house 정보 -> ${houseInfo}`);

let house2 = JSON.parse(houseInfo);
console.log(`house 이름 : ${house2[`name`]}`);

// 해시테이블 사용하기
// 1번 (이걸 권장)
let map = new Map();
map.set('강아지', {
    name: '강아지1',
    age: 1
});

map.set('고양이', {
    name: '고양이',
    age: 2
});

let dog = map.get('강아지')
console.log(`해시맵에서 꺼내온 강아지 이름 ${dog.name}`);

let map2 = {

}
// 2번
map2['강아지'] = {
    name: '강아지1',
    age: 1
}

map2['고양이'] = {
    name: '고양이1',
    age: 2
}

let dog2 = map2['강아지'];
console.log(`꺼내온 강아지의 이름 : ${dog2.name}`);