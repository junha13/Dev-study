
<template>
<div>
  <div>
    <span ></span>
  </div>


</div>

</template>

<script setup>

import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router';
import axios from 'axios'

// BaseURL 받기
import { requestConfig } from '../../../app.config'

// ======== stores ========
import { storeToRefs } from 'pinia';
import { useUserStore } from '@/stores/user';
const userStore =  useUserStore();
const { loginCheck, user_id, post_pkNumber, mode, post } = storeToRefs(userStore);

const router = useRouter();

onMounted(() => {
  console.log(`PostDetailView :: onMounted 실행됨`)

   getPostDetail(post_pkNumber.value)
})

// ======== onMounted post detail 보여주기 ========
async function getPostDetail(post_pkNumber) {
  
  try {
    const response = await axios({
      method: 'post',
      baseURL: requestConfig.baseUrl,
      url: 'post/read',
      data: {
        pkNumber: post_pkNumber
      },
      timeout: 5000,
      responseType: 'json'
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`)

    post.value = response.data.data.data

  } catch (err) {
    console.error(`에러 -> ${err}`);
  }
}

</script>


<style scoped>

</style>