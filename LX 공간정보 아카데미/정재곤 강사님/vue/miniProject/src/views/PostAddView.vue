
<template>
  <div>
    <div>
      <input v-model="title" placeholder="title"></input>
    </div>
    <div>
      <input v-model="content" placeholder="content"></input>
    </div>
    <div>
      <input v-model="thumbnail" placeholder="thumbnail"></input>
    </div>
    <div>
      <input v-model="likes" placeholder="likes"></input>
    </div>
    <div>
      <input v-model="user_id" placeholder="user_id"></input>
    </div>
    <div>
      <button @click="addPost()">새 글 작성</button>
    </div>
  </div>

</template>

<script setup>

import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router';
import axios from 'axios'

const title = ref('')
const content = ref('')
const thumbnail = ref('')
const likes = ref('')
const user_id = ref('')

// user name 저장
import { storeToRefs } from 'pinia';

import { useUserStore } from '@/stores/user';
const userStore =  useUserStore();
const { userName, pkNumber } = storeToRefs(userStore);

const router = useRouter();

onMounted(() => {
 console.log(`PostAddView :: onMounted 실행됨`)

})

async function addPost() {
  try{
    const params = {
      title: title.value,
      content: content.value,
      thumbnail: thumbnail.value,
      likes: likes.value,
      user_id: user_id.value
    }

    const response = await axios ({
      method: 'post',
      baseURL: 'http://localhost:8001',
      url: 'post/add',
      data: params,
      timeout: 5000,
      responseType: 'json'
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`)

  } catch (err) {
    console.error(`에러 -> ${err}`);
  }
}



function goToHome() {
  console.log(`goToHome 함수 실행됨`)

  router.push('/')
}

</script>


<style scoped>

</style>