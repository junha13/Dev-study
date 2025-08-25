
<template>
<div v-if="!loginCheck">
  <div>
    <button @click="goToLogin()">로그인</button>
  </div>
  <div>
    <button @click="goToJoin()">회원가입</button>
  </div>
</div>
<div v-else-if="loginCheck">
  <button @click="goToMypage()">마이페이지</button>
</div>
<div>

  <span>{{ userName }}</span>
</div>
<div>
  <button @click="goToPostList()">글 리스트</button>
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
 console.log(`homeView :: onMounted 실행됨`)

})

function goToLogin() {
  console.log(`goToLogin 함수 실행됨`)

  router.push('/login')
}

function goToJoin() {
  console.log(`goToJoin 함수 실행됨`)

  router.push('/join')
}

function goToMypage() {
  console.log(`goToMypage 함수 실행됨`)

  router.push('/myPage')
}

function goToPostList() {
  console.log(`goToPostList 함수 실행됨`)

  router.push('/post-list')
}

</script>


<style scoped>

</style>