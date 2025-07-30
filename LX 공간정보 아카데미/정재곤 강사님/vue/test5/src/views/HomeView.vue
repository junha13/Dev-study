<template>

  <div>
    <h1>고객 목록 화면</h1>
  </div>

  <div> 
    <p></p>
  </div>

  <div>
    <table>
      <thead>
        <tr>
          <th>이름</th>
          <th>나이</th>
          <th>전화번호</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(item, index) in persons" :key ="item.id">
          <td>{{ item.name }}</td>
          <td>{{ item.age }}</td>
          <td>{{ item.mobile }}</td>
          <td><button @click="requestUpdateUserIfo(index)">수정</button></td>
          <td><button @click="requestDeleteUserIfo(index)">삭제</button></td>
          <td></td>
        </tr>
      </tbody>
    </table>
    <div>
      <button @click="requestInsertUserIfo()">추가</button>
    </div>


  </div>


</template>

<script setup>
import {ref, onMounted} from 'vue';
import {useRouter} from 'vue-router'

const router = useRouter();
import axios from 'axios';

const persons = ref([]);

onMounted(() => {
  requestPersonList();
})
async function requestPersonList() {

  try{
    const response = await axios({
      method: 'get',
      url: 'http://localhost:7003/person/page/list',
      data : {}

    })

    persons.value = response.data.output

  } catch (err) {
    console.profileEnd(`에러남`)
  }
}


async function requestInsertUserIfo(index) {
  router.push({
    path: '/insert'
  })

}



function requestUpdateUserIfo(index) { 
  router.push({
  path: `/update`,
  query: {id:persons.value[index].id,name:persons.value[index].name,age:persons.value[index].age,mobile:persons.value[index].mobile}
  // query에는 배열 자체를 넣으면안됨 그리고 ref니까 value로 넣어야됨
  })
}

async function requestDeleteUserIfo(index) {

  try {
  const response = await axios({
    method:'get',
    url:'http://localhost:7003/person/page/delete',
    data:{},
    params:{
      id:persons.value[index].id
    }
  })
  persons.value = response.data.output  // 객체 = 객체
  } catch (err) { 
    console.log(`에러남`)
  }
}



</script>

