
<template>
  <div class="">
    <div class="d-flex flex-column align-items-center">

      <div class="mt-10">
        <div class="d-flex flex-column align-items-center">
          <input class="form-control form-control-solid bg-white border-black" type="text" placeholder="id" v-model="userId"></input>
          <input class="form-control form-control-solid bg-white border-black mt-5" type="password" placeholder="password" v-model="userPassword"></input>
        </div>
      </div>

      <div class=" mt-10">
        <button class="btn btn-primary px-20" @click="login()">로그인</button>
      </div>

      <div class="mt-3">
        <span class="cursor-pointer" @click="goToJoin()">회원가입</span>
      </div>  

    </div>
  </div>
  <div class="h-350px">
  </div>

</template>

<script setup>

import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router';
import axios from 'axios'

// BaseURL 받기
import { requestConfig } from '../../../app.config'

// user name 저장
import { storeToRefs } from 'pinia';

import { useUserStore } from '@/stores/user';
const userStore =  useUserStore();
const { loginCheck, user_Id, post_pkNumber, fullScreen } = storeToRefs(userStore);

const userId = ref('')
const userPassword = ref('')

const router = useRouter();

onMounted(() => {
 console.log(`homeView :: onMounted 실행됨`)

 fullScreen.value = false

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
      baseURL: requestConfig.baseUrl,
      url: '/user/login',
      data: params,
      timeout: 5000,
      response: 'json'
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`)

    let loginCnt = response.data.data.data[0]['cnt'];
    user_Id.value = response.data.data.data[0]['id'];

    if (loginCnt === 1) {
      alert(`로그인 성공 ${user_Id.value}님`)
      loginCheck.value = true;

      fullScreen.value = true
      router.push('/')

    } else {
      alert(`아이디와 비밀번호가 맞지 않습니다. 로그인을 다시 시도해주세요`)
      userId.value = ''
      userPassword.value = ''
      return;
    }

  } catch (err) {
    console.log(`에러 발생 -> ${err}`)
  }
}

function goToJoin() {

  router.replace('/join', {})
}


</script>


<style scoped>

</style>