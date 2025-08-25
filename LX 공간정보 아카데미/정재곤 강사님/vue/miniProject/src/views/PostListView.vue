
<template>
  <div>
    <button @click="goToAddPost()">글 추가하기</button>
  </div>
<div>
  <div v-for="(item, index) in posts" :key="item.pkNumber" class="card postcard">
    <div class="card-header">
      <span>{{ item.user_id }}</span>
    </div>
    <div class="card-body">
      <img src="/images/cat1.jpg" class="w-25">
    </div>
    <div class="card-footer">
      <span>{{ item.title }}</span>
      <span>{{ item.likes }}</span>

    </div>
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
const { userName, pkNumber } = storeToRefs(userStore);

const router = useRouter();

const posts = ref([])

onMounted(() => {
  console.log(`homeView :: onMounted 실행됨`)

  getPostList()

})

async function getPostList() {
  
  try {
    const response = await axios({
      method: 'post',
      baseURL: 'http://localhost:8001',
      url: 'post/list',
      data: {},
      timeout: 5000,
      responseType: 'json'
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`)

    posts.value = response.data.data.data

  } catch (err) {
    console.error(`에러 -> ${err}`);
  }
}

function goToAddPost() {
  console.log(`goToAddPost 함수 실행됨`)

  router.push('/post-add')
}





function goToHome() {
  console.log(`goToHome 함수 실행됨`)

  router.push('/')
}

</script>


<style scoped>

</style>