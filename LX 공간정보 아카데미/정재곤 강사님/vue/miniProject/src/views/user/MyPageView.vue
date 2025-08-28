
<template>
  <div>
    <div class="p-3">
      <div class="d-flex flex-row justify-content-center border-black border-bottom border-1 rounded-1 mt-4">
        <span class="fs-2x fw-bold mb-2">{{user_Id}} 님의 마이페이지</span>
      </div>
      <div class="d-flex flex-row justify-content-center gap-6 mt-4">
        <button class="btn btn-secondary border border-dark border-2 px-3" @click="logOut()">로그아웃</button>
        <button class="btn btn-secondary border border-dark border-2 px-3" @click="goToUserModify()">회원정보 수정</button>
      </div>
    </div>
    <div class="p-3">
      <div class="d-flex flex-row justify-content-center border-black border-bottom border-1 rounded-1 mt-4">
        <span class="fs-2x fw-bold mb-2">내 글 보기</span>
      </div>
        <div class="p-4">
          <div v-for="(item, index) in post" :key="item.pkNumber" class="card postcard mb-4" @click="goToPostDetail(item.pkNumber)">
            <div class="card-body d-flex justify-content-between align-items-center h-40px">
              <span class="fs-2x fw-bold">{{ item.title }}</span>
              <span class="fw-bold">{{ item.year }}년 {{ item.grade }}학기 ({{ item.semester }}학년)</span>
            </div>
            <div class=" h-150px">
              <img :src=item.thumbnail class="w-100 h-100" style="object-fit: none;">
            </div>
            <div class="card-footer d-flex justify-content-between align-items-center h-30px">
              <span class="fw-bold">❤️ {{ item.likes }}</span>
              <span class="fw-bold">😎 {{ item.user_id }}</span>
            </div>
          </div>
        </div>
    </div>
  </div>

  <!-- ======== 페이지네이션 ======== -->
  <div>
    <Pagination :requestFunc="getPostList" :pagination="pagination1" />
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
const { loginCheck, user_Id, post_pkNumber, fullScreen, post, mode, selectIndex } = storeToRefs(userStore);

// ======== 페이지네이션 ========
import Pagination from '@/components/Pagination.vue'
import { usePagination } from '@/util/pagination'
const { makePagination } = usePagination()

const pagination1 = ref({})

// BaseURL 받기
import { requestConfig } from '../../../app.config'


const router = useRouter();

onMounted(() => {
 console.log(`MyPageView :: onMounted 실행됨`)

 mode.value = 'myPage-modify'
 getPostList(1, 5, user_Id.value)
})

// ======== onMounted post list 보여주기 ========
async function getPostList(page, perPage, user_Id) {
  
  try {
    const response = await axios({
      method: 'post',
      baseURL: requestConfig.baseUrl,
      url: 'post/myList',
      data: {
        page: page,
        perPage: perPage,
        user_id: user_Id
      },
      timeout: 5000,
      responseType: 'json'
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`)

    post.value = response.data.data.data

    pagination1.value = makePagination(response.data.data.header)

  } catch (err) {
    console.error(`에러 -> ${err}`);
  }
}

function logOut() {
  console.log(`logout 함수 실행됨`)

  loginCheck.value = false
  user_Id.value = false

  alert('로그아웃 되었습니다.')

  goToHome()
}

function goToUserModify() {
  console.log(`goToUserModify 함수 실행됨`)

  router.push('/user-modify')
}

function goToHome() {
  console.log(`goToHome 함수 실행됨`)

  router.push('/')
}

function goToPostDetail(pkNumber) {
  console.log(`goToPostDetail 함수 실행됨`)

  post_pkNumber.value = pkNumber

  router.push('/post-detail')
}

</script>


<style scoped>

</style>