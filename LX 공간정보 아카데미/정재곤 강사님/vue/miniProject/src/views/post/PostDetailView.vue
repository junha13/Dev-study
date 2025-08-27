
<template>
<div class="p-2">
  <div class="cursor-pointer" @click="goToArchive()">
    <i class="ki-duotone ki-arrow-left">
      <span class="path1"></span>
      <span class="path2"></span>
    </i>
    <span class="fw-bold"> 뒤로가기</span>
  </div>
  <div class="d-flex flex-row justify-content-between mt-10 border-top border-bottom border-2">
    <div class="d-flex align-items-center gap-4">
      <span class="fs-2x fw-bold">{{ title }}</span>
      <span class="fw-bold">{{ likes }}</span>
    </div>
    <div class="d-flex align-items-center gap-4" >
      <span class="fw-bold">{{ year }}년 {{ semester }}학기 ({{ grade }}학년)</span>
    </div>
  </div>
  <div>
    <div>
      <span>{{ content }}</span>
    </div>
  </div>

  <div class="mb-3 border border-black border-2">
    <img :src="thumbnail" class="w-100"></img>
  </div>

  <div class="mt-10">

  </div>


</div>

</template>

<script setup>

import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router';
import axios from 'axios'

let postDetail;

const title = ref('')
const content = ref('')
const thumbnail = ref('')
const likes = ref('')
const userId = ref('')
const year = ref('')
const grade = ref('')
const semester = ref('')

// BaseURL 받기
import { requestConfig } from '../../../app.config'

// ======== stores ========
import { storeToRefs } from 'pinia';
import { useUserStore } from '@/stores/user';
const userStore =  useUserStore();
const { loginCheck, user_id, post_pkNumber } = storeToRefs(userStore);

const router = useRouter();

onMounted(() => {
  console.log(`PostDetailView :: onMounted 실행됨`)

   getPostDetail(post_pkNumber.value)
})

// ======== onMounted post detail 보여주기 ========
async function getPostDetail(post_pkNumber) {
  console.log(`getPostDetail 함수 실행됨`)
  
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

    console.log(`응답 -> ${JSON.stringify(response.data.data.data[0])}`)

    postDetail = response.data.data.data[0]

    title.value = postDetail.title
    content.value = postDetail.content
    thumbnail.value = postDetail.thumbnail
    likes.value = postDetail.likes
    userId.value = postDetail.userId
    year.value = postDetail.year
    grade.value = postDetail.grade
    semester.value = postDetail.semester


  } catch (err) {
    console.error(`에러 -> ${err}`);
  }
}

function goToArchive() {
  console.log(`goToArchive 실행됨`)

  router.push('/archive')
}

</script>


<style scoped>

</style>