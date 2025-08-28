
<template>
<div class="d-flex justify-content-end me-4 gap-7 mt-4">
  <button @click="showDialog()" class="btn btn-secondary border border-dark border-2 fw-bold p-2 px-5">검색</button>
  <button v-if="loginCheck" @click="goToAddPost()" class="btn btn-secondary border border-dark border-2 fw-bold p-2 px-5">추가</button>
</div>
<!-- ======== 카드 List ======== -->
<div class="p-4">
  <div v-for="(item, index) in post" :key="item.pkNumber" class="card postcard mb-6 shadow" @click="goToPostDetail(item.pkNumber)">
    <div class="card-body d-flex justify-content-between align-items-center h-40px">
      <span class="fs-2x fw-bold ms-n3">{{ item.title }}</span>
      <span class="fw-bold">{{ item.year }}년 {{ item.grade }}학기 ({{ item.semester }}학년)</span>
    </div>
    <div class=" h-150px overflow-hidden">
      <img :src=item.thumbnail class="w-100 h-100" style="object-fit: none;">
    </div>
    <div class="card-footer d-flex justify-content-between align-items-center h-30px">
      <span class="fw-bold" >❤️ {{ item.likes }}</span>
      <span class="fw-bold">😎 {{ item.user_id }}</span>
    </div>
  </div>
</div>


<!-- ======== 페이지네이션 ======== -->
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
      <!-- ======== 드롭다운 ======== -->
      <div class="d-flex flex-row justify-content-between w-100 mt-4">
        <!-- ======== year ======== -->
        <div class="dropdown w-25">
          <button type="button" class="w-100 dropdown-toggle btn bg-white btn border border-black p-2 px-4 " data-bs-toggle="dropdown" >{{ !searchYear ? '연도' : searchYear=='전체' ? '전체연도' : searchYear+'년' }}</button>
          <ul class="dropdown-menu h-100px w-100 overflow-auto">
            <li><a v-for="(year_select) in years" :key="year_select" class="dropdown-item" @click="setYear(year_select)">{{ year_select=='전체' ? '전체' : year_select+'년' }}</a></li>
          </ul>
        </div>
        <!-- ======== semester ======== -->
        <div class="dropdown w-25">
          <button type="button" class=" w-100 dropdown-toggle btn bg-white btn border border-black p-2 px-4 " data-bs-toggle="dropdown">{{ searchSemester ? searchSemester + '학기' : '학기' }}</button>
          <ul class="dropdown-menu h-85px w-100 overflow-auto">
            <li><a v-for="(semester_select) in semesters" :key="semester_select" class="dropdown-item" @click="setSemester(semester_select)">{{ semester_select=='전체' ? '전체' : semester_select+'학기'  }}</a></li>
          </ul>
        </div>
        <!-- ======== grade ======== -->
        <div class="dropdown w-25">
          <button type="button" class="w-100 dropdown-toggle btn bg-white btn border border-black p-2 px-4 " data-bs-toggle="dropdown">{{ searchGrade ? searchGrade + '학년' : '학년' }}</button>
          <ul class="dropdown-menu h-100px w-100 overflow-auto">
            <li><a v-for="(grade_select) in grades" :key="grade_select" class="dropdown-item" @click="setGrade(grade_select)">{{ grade_select=='전체' ? '전체' : grade_select+'학년' }}</a></li>
          </ul>
        </div>
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
      timeout: 50000,
      responseType: 'json'
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`)

    post.value = response.data.data.data

    pagination1.value = makePagination(response.data.data.header)

  } catch (err) {
    console.error(`에러 -> ${err}`);
  }
}

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
    if (searchCondition[key] == null ||String(searchCondition[key]).trim() == '' || String(searchCondition[key]).trim() == '전체') {
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
      timeout: 50000,
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


// ======== 드롭다운 배열 및 함수 =========

const years = ['전체', 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023, 2024, 2025]
const grades = ['전체', 1, 2, 3, 4]
const semesters = ['전체', 1, 2]

function setYear(year_select) {
  console.log(`year_select 함수 실행됨`)

  searchYear.value = year_select
}
function setSemester(semester_select) {
  searchSemester.value = semester_select
}
function setGrade(grade_select) {
  searchGrade.value = grade_select
}
</script>


<style scoped>

</style>