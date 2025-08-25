
<template>

  <div>
    <div>
      <span>
        <span>아이디</span>
        <input class="idInput" type="text" placeholder="id" v-model="userId"></input>
      </span>
    </div>
    <div>
      <span>
        <span>비번</span>
        <input class="passwordInput" type="password" placeholder="password" v-model="userPassword"></input>
      </span>
    </div>
    <div>
      <button @click="login()">로그인</button>
    </div>
  </div>

</template>

<script setup>

import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router';
import axios from 'axios'


// user name 저장
import { storeToRefs } from 'pinia';

import { useUserStore } from '@/stores/user';
const userStore =  useUserStore();
const { loginCheck, userName, pkNumber } = storeToRefs(userStore);

const userId = ref('')
const userPassword = ref('')

const router = useRouter();

onMounted(() => {
 console.log(`homeView :: onMounted 실행됨`)

})

async function login() {
  console.log(`login 함수 실행됨`)


  try {
    const params = {
      id:userId.value,
      password:userPassword.value
    }

    const response = await axios({
      method: 'post',
      baseURL: 'http://localhost:8001',
      url: '/user/login',
      data: params,
      timeout: 5000,
      response: 'json'
    })

    console.log(`응답 -> ${JSON.stringify(response.data.data.data[0]['cnt'])}`)

    let loginCnt = response.data.data.data[0]['cnt'];
    userName.value = response.data.data.data[0]['name'];
    pkNumber.value = response.data.data.data[0]['pkNumber'];

    if (loginCnt === 1) {
      alert(`로그인 성공 ${userName.value}님`)
      loginCheck.value = true;

      router.push('/')

    } else {
      alert(`아이디와 비밀번호가 맞지 않습니다. 로그인을 다시 시도해주세요`)
      $('input').val('');  // jquery가 기본으로 됨
      return;
    }

  } catch (err) {
    console.log(`에러 발생 -> ${err}`)
  }
}


</script>


<style scoped>

</style>