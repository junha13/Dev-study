
<template>
  <div>
    <button @click="logOut()">로그아웃</button>
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

const router = useRouter();

onMounted(() => {
 console.log(`MyPageView :: onMounted 실행됨`)

})

function logOut() {
  console.log(`logout 함수 실행됨`)

  loginCheck.value = false
  userName.value = false
  pkNumber.value = false

  goToHome()
}

function goToHome() {
  console.log(`goToHome 함수 실행됨`)

  router.push('/')
}

</script>


<style scoped>

</style>