

<template>

  <div class="d-flex flex-column align-items-center w-100 h-700px">
    <div class="d-flex flex-column align-items-center w-75 h-75 rounded rounded-4 border border-success-subtle border-1 bg-secondary shadow mt-10 gap-3">
      <div class="mt-10 mb-5">
        <span class="fs-2x fw-bold">새 작품 등록</span>
      </div>

      <div style="width: 80%;">
        <input class="form-control form-control-solid bg-white border-black" v-model="title" placeholder="title"></input>
      </div>

      <div class="" style="width: 80%;">
        <textarea class="form-control form-control-solid bg-white border-black" v-model="content" placeholder="content" rows="5" style="resize: none;"></textarea>
      </div>

      <!-- ======== 드롭다운 ======== -->
      <div class="d-flex flex-row justify-content-between gap-4">
        <!-- ======== year ======== -->
        <div class="dropdown">
          <button type="button" class="dropdown-toggle btn bg-white btn border border-black p-2 px-4 " data-bs-toggle="dropdown" >{{ year ? year + '년': '연도' }}</button>
          <ul class="dropdown-menu h-100px w-100 overflow-auto">
            <li><a v-for="(year_select) in years" :key="year_select" class="dropdown-item" @click="setYear(year_select)">{{ year_select }}년</a></li>
          </ul>
        </div>
        <!-- ======== semester ======== -->
        <div class="dropdown">
          <button type="button" class="dropdown-toggle btn bg-white btn border border-black p-2 px-4 " data-bs-toggle="dropdown">{{ semester ? semester + '학기' : '학기' }}</button>
          <ul class="dropdown-menu h-85px w-100 overflow-auto">
            <li><a v-for="(semester_select) in semesters" :key="semester_select" class="dropdown-item" @click="setSemester(semester_select)">{{ semester_select }}학기</a></li>
          </ul>
        </div>
        <!-- ======== grade ======== -->
        <div class="dropdown">
          <button type="button" class="dropdown-toggle btn bg-white btn border border-black p-2 px-4 " data-bs-toggle="dropdown">{{ grade ? grade + '학년' : '학년' }}</button>
          <ul class="dropdown-menu h-100px w-100 overflow-auto">
            <li><a v-for="(grade_select) in grades" :key="grade_select" class="dropdown-item" @click="setGrade(grade_select)">{{ grade_select }}학년</a></li>
          </ul>
        </div>
      </div>

      <div>
        <input class="w-65px" type="file" id="uploadImage" hidden @change="getFileName($event.target.files)"></input>
        <label for="uploadImage" class="d-flex justify-content-center">
          <img src="/images/aaa.png" width="75%" ></img>
        </label>
      </div>
      <button @click="showDialog()" class="btn bg-white btn border border-black fw-bold p-2 px-5">파일 미리보기</button>
      <div>
        <button class="btn bg-success-subtle border border-black p-2 mt-10 fw-bold shadow" @click="addPost()">작성 완료</button>
      </div>
    </div>
  </div>
  <!-- ======== 파일 미리보기 modal ======== -->
  <div class="modal fade p-10" id="myDialog">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content rounded">
      <div class="modal-header">
        <span class="fs-2x fw-bold">미리보기 화면</span>
      </div>
      <div class="modal-body d-flex justify-content-center">
        <img :src="thumbnail" id="preview" width="60%" class="border border-black shadow"></img>
      </div>
      <div class="modal-footer d-flex justify-content-center gap-10">
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

// ======== 입력받을 변수 반응형으로 만들기 ========
const title = ref('')
const content = ref('')
const thumbnail = ref('')
const likes = ref('')
const year = ref('')
const grade = ref('')
const semester = ref('')
const user_id = ref('')

// user name 저장
import { storeToRefs } from 'pinia';

// ======== stores / user_id, post_pkNumber, mode 가져옴 ========
import { useUserStore } from '@/stores/user';
const userStore =  useUserStore();
const { user_Id, post_pkNumber, mode } = storeToRefs(userStore);

const router = useRouter();
let postDetail;

// ======== 부트스트랩 modal ========
import { Modal } from 'bootstrap'
let myDialog;

function showDialog() {
  console.log(`showDialog 함수 호출됨`)

  const elem = document.querySelector('#myDialog')
  myDialog = new Modal(elem);
  myDialog.show()
}


// 아니 왜 바로 addView 요청했을땐 드롭다운 되는데 왜 다른 vue에서 라우팅해서 들어가면 드롭다운 왜 안되는데 진짜 오류도 안뜨고 그냥 클릭만안돼
// 정신나갈거같애 진짜

// ======== onMounted / modify로 들어온 경우 기존 값이 뜨도록 mode 분류 ========
onMounted(async() => {
 console.log(`PostAddView :: onMounted 실행됨 유저 : ${user_Id.value}, mode : ${mode.value}`)


 // ======== 수정으로 들어올 때 ( 글 올린 본인만 수정되도록 해야 함, 마이페이지 ) =========
 if (mode.value == 'myPage-modify') {
  
   getPostDetail(post_pkNumber)
 }

})

// ======== 게시물 pkNumber를 매개로 게시물 정보 출력 ========
async function getPostDetail(post_pkNumber) {
  console.log(`getPostDetail 함수 실행됨`)
  
  try {
    const response = await axios({
      method: 'post',
      baseURL: requestConfig.baseUrl,
      url: 'post/read',
      data: {
        pkNumber: post_pkNumber.value
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
    user_id.value = postDetail.userId
    year.value = postDetail.year
    grade.value = postDetail.grade
    semester.value = postDetail.semester


  } catch (err) {
    console.error(`에러 -> ${err}`);
  }
}


// 이미지 저장 부분
import { useUpload } from '@/util/upload.js'
const { upload } = useUpload();

// BaseURL 받기
import { requestConfig } from '../../../app.config'

// 선택된 파일
const selectedFile = ref('')

async function getFileName(files) {
  selectedFile.value = files[0] // 파일 중 첫번째 파일만 저장
  await base64()
}

function base64() {
  return new Promise((resolve, reject) => {
    let reader = new FileReader()

    reader.onload = e => {
      resolve(e.target.result)

      const previewImage = document.querySelector('#preview')
      previewImage.src = e.target.result
    }

    reader.readAsDataURL(selectedFile.value)
  })
}

// ======== 글 작성 완료 버튼 함수 =========
function addPost() {

  // ======== 빈값 검사 =========
  if(!title.value || !content.value || !year.value || !grade.value || !semester.value) {
    alert('모든 항목을 입력하세요')
    return;
  }

  // ======== params 객체 생성 / 사진같은경우는 아직 안들어가는데 기존에 있었으면 들어감 =========
  let params = {
    title: title.value,
    content: content.value,
    thumbnail: thumbnail.value,  // 기존 사진 저장
    likes: likes.value ? likes.value : 0, // 기존 게시물이면 기존의 like 개수 적용, 아니면 0
    user_id: user_id.value ? user_id.value : user_Id.value, 
    // 기존 게시물이면 게시물에 잡혀있는 user_id, 아니면 store에 있는 user_Id 반영
    year: year.value,
    grade: grade.value,
    semester: semester.value
  }

  // ======== mode 분루 / goToBack 함수 때문에 진입점도 고려 =========
  if (mode.value == 'archive-add' ) {
    requestPostAdd(params)

  } else if (mode.value == 'myPage-modify') {
    params.pkNumber = post_pkNumber.value // 동일 행에 대해서 변경해야 하기 때문에 pkNumber 할당
    requestPostModify(params)
  }
}

// ======== 글 추가 함수 =========
async function requestPostAdd(params) {

  try{
    if (!selectedFile) {
      alert('이미지를 선택하세요')
      return;
    }
    let response = await upload(selectedFile.value, (progress) => {
      console.log(`업로드 진행률 : ${progress}`)
    })

    console.log(`업로드 응답 -> ${JSON.stringify(response)}`)

    params.thumbnail = `${requestConfig.baseUrl}${response.data.filename}`

    response = await axios ({
      method: 'post',
      baseURL: requestConfig.baseUrl,
      url: 'post/add',
      data: params,
      timeout: 5000,
      responseType: 'json'
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`)

    goToArchive()

  } catch (err) {
    console.error(`에러 -> ${err}`);
  }
}

// ======== 글 변경 함수 =========
async function requestPostModify(params) {

  try{
    let response;
    if (selectedFile.value) {
      response = await upload(selectedFile.value, (progress) => {
        console.log(`업로드 진행률 : ${progress}`)
      })

      console.log(`업로드 응답 -> ${JSON.stringify(response)}`)

      params.thumbnail = `${requestConfig.baseUrl}${response.data.filename}`
    }

    response = await axios ({
      method: 'post',
      baseURL: requestConfig.baseUrl,
      url: 'post/modify',
      data: params,
      timeout: 5000,
      responseType: 'json'
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`)

    goToMyPage()

  } catch (err) {
    console.error(`에러 -> ${err}`);
  }
}


function goToArchive() {
  console.log(`goToArchive 함수 실행됨`)

  router.push('/archive')
}

function goToMyPage() {
  console.log(`goToMyPage 함수 실행됨`)

  router.push('/myPage')
}


// ======== 드롭다운 배열 및 함수 =========
const years = [2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023, 2024, 2025]
const grades = [1, 2, 3, 4]
const semesters = [1, 2]

function setYear(year_select) {
  console.log(`year_select 함수 실행됨`)

  year.value = year_select
}
function setSemester(semester_select) {
  semester.value = semester_select
}
function setGrade(grade_select) {
  grade.value = grade_select
}

</script>


<style scoped>

</style>