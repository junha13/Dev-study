
<template>
<div class="p-2">
  <div class="d-flex justify-content-between">
    <div class="cursor-pointer" @click="goToBack()">
      <i class="ki-duotone ki-arrow-left">
        <span class="path1"></span>
        <span class="path2"></span>
      </i>
      <span class="fw-bold"> 뒤로가기</span>
    </div>
    <!--======== 마이페이지에서 들어올때만 수정삭제 가능 ========-->
    <div>
      <button v-if="mode=='myPage-modify'" @click="goToModify(post_pkNumber)" class="btn bg-success-subtle btn border border-black fw-bold p-1 px-4 me-5">수정</button>
      <button v-if="mode=='myPage-modify'" @click="postRemove(post_pkNumber)" class="btn bg-primary-subtle btn border border-black fw-bold p-1 px-4">삭제</button>
    </div>
  </div>


  <div class="d-flex flex-row justify-content-between mt-5 border-top border-bottom border-2 ">
    <div class="d-flex align-items-center gap-4 ms-3">
      <span class="fs-2x fw-bold">{{ title }}</span>
      <span class="fw-bold"> || ❤️ {{ likes }}</span>
    </div>
    <div class="d-flex align-items-center gap-4 me-3" >
      <span class="fw-bold">{{ year }}년 {{ semester }}학기 ({{ grade }}학년)</span>
    </div>
  </div>
  <div>
    <div class="my-5 mx-5">
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
const { loginCheck, user_id, post_pkNumber, mode } = storeToRefs(userStore);

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

function goToModify() {
  console.log(`goToModify 실행됨`)

  router.push('/post-add')
}

function postRemove(post_pkNumber) {
  console.log(`postRemove 실행됨`)

  if (confirm('진짜 삭제하게???')) {
    requestPostRemove(post_pkNumber)
  } else {
    return
  }

  router.push('/post-add')
}

// ======== postDelete 요청 ========
async function requestPostRemove(post_pkNumber) {
  console.log(`requestPostRemove 함수 실행됨`)
  
  try {
    const response = await axios({
      method: 'post',
      baseURL: requestConfig.baseUrl,
      url: 'post/remove',
      data: {
        pkNumber: post_pkNumber
      },
      timeout: 5000,
      responseType: 'json'
    })

    console.log(`응답 -> ${JSON.stringify(response.data.data.data[0])}`)


  } catch (err) {
    console.error(`에러 -> ${err}`);
  }

  router.push('/myPage')
}


// ======== 뒤로가기 함수 / 아카이브에서 들어오면 아카이브로, 마이페이지에서 들어오면 마이페이지로 ========
function goToBack() {
  console.log(`goToBack 실행됨`)

  if (mode.value === 'archive-add') {
    router.push('/archive')
  } else if (mode.value === 'myPage-modify') {
    router.push('/myPage')
  }

}

</script>


<style scoped>

</style>