
<template>
<div class="d-flex justify-content-end me-4 gap-7 mt-4">
  <button @click="showDialog()" class="btn btn-secondary border border-dark border-2 fw-bold p-2 px-5">검색</button>
  <button v-if="loginCheck" @click="goToAddPost()" class="btn btn-secondary border border-dark border-2 fw-bold p-2 px-5">추가</button>
</div>
<!-- ======== 카드 List ======== -->
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


<!-- ======== 페이지네이션 ======== -->
<!-- ======== 근데 이거 검색할때는 안나와야되는거 아닌가? ======== -->
<div>
  <Pagination :requestFunc="getPostList" :pagination="pagination1" />
</div>


<!-- ======== 검색 modal ======== -->
<div class="modal fade" id="myDialog">
  <div class="modal-dialog modal-dialog-centered">

    <div class="modal-content rounded">

      <div class="modal-header">
        <span class="fs-2x fw-bold">검색 화면</span>
      </div>

      <div class="modal-body">
        <div>
          <label>제목 : </label>
          <input type="text" class="form-control form-control-solid" v-model="searchTitle"></input>
        </div>
        <div>
          <label>유저 아이디 : </label>
          <input type="text" class="form-control form-control-solid" v-model="searchUserId"></input>
        </div>
        <div>
          <label>연도 : </label>
          <input type="text" class="form-control form-control-solid" v-model="searchYear"></input>
        </div>
        <div>
          <label>학년 : </label>
          <input type="text" class="form-control form-control-solid" v-model="searchGrade"></input>
        </div>
        <div>
          <label>학기 : </label>
          <input type="text" class="form-control form-control-solid" v-model="searchSemester"></input>
        </div>
      </div>

      <div class="modal-footer d-flex justify-content-center gap-10">
        <button class="btn btn-secondary border border-dark border-2 fw-bold" @click="getPostListBySearchCondition(1, 5)">검색</button>
        <button class="btn btn-secondary border border-dark border-2 fw-bold" @click="myDialog.hide()">취소</button>
      </div>

    </div>

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
const { loginCheck, post_pkNumber, mode, post } = storeToRefs(userStore);

const router = useRouter();

onMounted(() => {
  console.log(`homeView :: onMounted 실행됨`)

  mode.value = 'archive-add'

  getPostList(1, 5)
})

// ======== 페이지네이션 ========
import Pagination from '@/components/Pagination.vue'
import { usePagination } from '@/util/pagination'
const { makePagination } = usePagination()

const pagination1 = ref({})

// ======== 부트스트랩 modal ========
import { Modal } from 'bootstrap'
let myDialog;

function showDialog() {
  console.log(`showDialog 함수 호출됨`)

  const elem = document.querySelector('#myDialog')
  myDialog = new Modal(elem);
  myDialog.show()
}



// ======== onMounted post list 보여주기 ========
async function getPostList(page, perPage) {
  
  try {
    const response = await axios({
      method: 'post',
      baseURL: requestConfig.baseUrl,
      url: 'post/list',
      data: {
        page: page,
        perPage: perPage
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

// ======== 검색기능 변수 정리 ========
const searchTitle = ref('')
const searchUserId = ref('')
const searchYear = ref('')
const searchGrade = ref('')
const searchSemester = ref('')

// ======== 검색따라 post list 보여주기 ========
async function getPostListBySearchCondition(page, perPage) {

  // ======== 빈값 검사 돌리기 위해 객체 생성 {}, ref value 뽑아서 넣은거니까 modal 다시 열었을 때도 값이 저장되어 있음  ========
  const searchCondition = {
    title: searchTitle.value,
    user_id : searchUserId.value,
    year : searchYear.value,
    grade : searchGrade.value,
    semester : searchSemester.value
  }

  // 검색 빈값 검사 / 값이 비어있으면 sql like문이 안되니까 %로 할당 / LIKE '%' 와일드카드 사용
  for (const key in searchCondition) {
    if (searchCondition[key] == null ||String(searchCondition[key]).trim() == '') {
      searchCondition[key] = '%'
    } else {
      searchCondition[key] = '%' + searchCondition[key] + '%'
    }
  }

  // sql에 넣기 전 확인
  console.log(`title : ${searchCondition.title}, user_id : ${searchCondition.user_id}, year : ${searchCondition.year}, grade : ${searchCondition.grade}, semester : ${searchCondition.semester}`)

  try {
    const response = await axios({
      method: 'post',
      baseURL: requestConfig.baseUrl,
      url: 'post/search',
      data: {
        page: page,
        perPage: perPage,
        // params 대신 여기에 검색조건 입력
        title: searchCondition.title,
        user_id: searchCondition.user_id,
        year: searchCondition.year,
        grade: searchCondition.grade,
        semester: searchCondition.semester
      },
      timeout: 5000,
      responseType: 'json'
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`)

    post.value = response.data.data.data

    pagination1.value = makePagination(response.data.data.header)

    myDialog.hide()

  } catch (err) {
    console.error(`에러 -> ${err}`);
  }
}


// ======== post-add 이동 / 로그인해야 이동 가능 ========
function goToAddPost() {
  console.log(`goToAddPost 함수 실행됨`)

  router.push('/post-add')
}

function goToPostDetail(pkNumber) {
  console.log(`goToPostDetail 함수 실행됨`)

  post_pkNumber.value = pkNumber

  router.push('/post-detail')
}

</script>


<style scoped>

</style>