<template>
  <div>
    <div>
      <h1>홈 화면</h1>

    </div>
    <div>
      <span>이름 : </span><input type="text" v-model="nameInput"> <!---->
    </div>
    <div>
      <span>나이 : </span><input type="text" v-model="ageInput"></input>
    </div>
    <div>
      <span>전화번호 : </span><input type="text" v-model="mobileInput"></input>
    </div>
    <div>
      <button @click="show()">확인</button>
    </div>
    <div>
      <p>결과 : {{ name }}</p>
    </div>

    <div>
      <button @click="requestPersonList()">웹서버에서 조회하기</button> 
      <!-- 버튼을 누르면 요청을 하는거임 이름은 거의 다 request를 붙힘 -->
    </div>





    <table>
      <thead>
        <tr>
          <th>이름</th>
          <th>나이</th>
          <th>전화번호</th>
        </tr>
      </thead>
      <tbody>
        <!-- persons에 value를 붙히지 않으면 객체 하나씩 나오면서 소괄호 하나에 들어감, 이때 key 설정을 id로 한다 -->
        <tr v-for="(item, index) in persons" :key ="item.id">    <!--tr이 한 행임 행 데이터가 바뀌면 어떻게 표시할 거냐 => 배열 만들기 => 하나의 행만 남기기 <tr v-for="() in persons"> 입력   --> 
          <td>{{ item.name }}</td>
          <td>{{ item.age }}</td>
          <td>{{ item.mobile }}</td>
        </tr>

      </tbody>
    </table>


  </div>

  <div>
    <button @click="goToAbout()">넘어가기</button>
    <button @click="goToMenu()">메뉴화면으로 </button>
  </div>

</template>


<script setup>
import { ref, onMounted } from 'vue';
import {useRouter } from 'vue-router'

const router = useRouter(); 
import axios from 'axios';

const nameInput = ref('') // ref로 감싸줌 => nameInput이라는 변수 상자가 있는데 ref로 한번 감싼 느낌 일단 빈 글자를 넣고 감시하고, 그 값의 이름은 value가 됨
// 감싼것이 nameInput이고, 그 값은 value임 그래서 여기 값을 뽑을 땐 nameInput.value임

const name = ref('');
const persons = ref([]);

/*
const persons = ref([
  {
    id:1,
    name:'홍길동1',
    age:21,
    mobile:'292-3232-3222'
  },
  {
    id: 2,
    name: '홍길동3',
    age: 33,
    mobile:'dddd-dddd-ddd'
  },
  {
    id: 3,
    name: '홍길fg동3',
    age: 334,
    mobile:'ddddfg-dddd-ddd'
  }
])
*/

// 페이지가 로딩되면 호출되는 콜백함수를 등록함
onMounted(() => {
  console.log(`onMounted 함수 호출됨`)
  requestPersonList();
})
function show() {
  console.log(`show함수 호출됨`);
  name.value = nameInput.value;
}
async function requestPersonList() {  // 이 함수가 실행되면 url로 데이터를 요청하고 콘솔창에 출력함
  console.log(`requestPersonList 함수 호출됨`)
  // axios가 promise로 되어 있어서 async, await 해야 함

  try {
    const response = await axios({  // axios가 언제 응답을 줄지 모르기때문에 콜백을 줄인거임
      method: 'get',  // get 방식으로 가져온다
      url: 'http://localhost:7001/person/list-data',
      data: {}
    });

    console.log(`응답 -> ${JSON.stringify(response.data)}`)
    persons.value = response.data.data // 요청 데이터 안에 data에 객체가 저장되어 있으니까  persons와 컬럼이 똑같으니까 이렇게 저장이 됨
  } catch (err) {
    console.error(`에러 -> ${err}`)
  }


}

function goToAbout() {
  router.push({
    path: '/about',
    query: {name : '홍길동1', age : 21}
  });
    
}
function goToMenu() {
  router.push('/menu');
}
</script>

<style scoped>



</style>