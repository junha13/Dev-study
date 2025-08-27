

<template>

  <div class="d-flex flex-column align-items-center w-100 h-700px">
    <div class="d-flex flex-column align-items-center w-75 h-75 rounded rounded-4 border border-success-subtle border-1 bg-secondary shadow mt-10 gap-3">
      <div class="mt-10 mb-5">
        <span class="fs-2x fw-bold">새 작품 등록</span>
      </div>
      <div>
        <input class="form-control form-control-solid bg-white border-black" v-model="title" placeholder="title"></input>
      </div>
      <div>
        <input class="form-control form-control-solid bg-white border-black" v-model="content" placeholder="content"></input>
      </div>
      <div class="d-flex flex-row justify-content-between gap-4">
        <div class="dropdown">
          <button type="button" class="dropdown-toggle btn bg-white btn border border-black p-2 px-4 " data-bs-toggle="dropdown">{{ year ? year + '년': '연도' }}</button>
          <ul class="dropdown-menu h-100px w-100 overflow-auto">
            <li v-for="(year_select) in years" :key="year_select" class="dropdown-item" @click="setYear(year_select)">{{ year_select }}년</li>
          </ul>
        </div>
        <div class="dropdown">
          <button type="button" class="dropdown-toggle btn bg-white btn border border-black p-2 px-4 " data-bs-toggle="dropdown">{{ semester ? semester + '학기' : '학기' }}</button>
          <ul class="dropdown-menu h-100px w-100 overflow-auto">
            <li v-for="(semester_select) in semesters" :key="semester_select" class="dropdown-item" @click="setSemester(semester_select)">{{ semester_select }}학기</li>
          </ul>
        </div>
        <div class="dropdown">
          <button type="button" class="dropdown-toggle btn bg-white btn border border-black p-2 px-4 " data-bs-toggle="dropdown">{{ grade ? grade + '학년' : '학년' }}</button>
          <ul class="dropdown-menu h-100px w-100 overflow-auto">
            <li v-for="(grade_select) in grades" :key="grade_select" class="dropdown-item" @click="setGrade(grade_select)">{{ grade_select }}학년</li>
          </ul>
        </div>
      </div>

      <div>
        <input class="w-65px" type="file" id="uploadImage" @change="getFileName($event.target.files)"></input>
        <label for="uploadImage" class="d-flex justify-content-center">
          <img src="" id="preview" width="50%"></img>
        </label>
      </div>
      <div>
        <button @click="addPost()">새 글 작성</button>
      </div>
    </div>
  </div>
</template>

<script setup>

import { ref, onMounted, nextTick } from 'vue'
import { useRouter } from 'vue-router';
import axios from 'axios'

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

import { useUserStore } from '@/stores/user';
const userStore =  useUserStore();
const { loginCheck, user_Id, post_pkNumber, fullScreen, post, mode, selectIndex } = storeToRefs(userStore);

const router = useRouter();


// 아니 왜 바로 addView 요청했을땐 드롭다운 되는데 왜 다른 vue에서 라우팅해서 들어가면 드롭다운 왜 안되는데 진짜 오류도 안뜨고 그냥 클릭만안돼
// 정신나갈거같애 진짜
onMounted(async() => {
 console.log(`PostAddView :: onMounted 실행됨 유저 : ${user_Id.value}`)

   await nextTick()
  document.querySelectorAll('[data-bs-toggle="dropdown"]').forEach(el => {
    new bootstrap.Dropdown(el)
  })
 

 // ======== 수정으로 들어올 때 ( 글 올린 본인만 수정되도록 해야 함 ) =========
 if (mode.value == 'modify') {
  const selected = post.value[selectedIndex.value]

  title.value = selected.title
  content.value = selected.content
  thumbnail.value = selected.thumbnail
  likes.value = selected.likes
  user_id.value = user_Id.value
  year.value = selected.year
  grade.value = selected.grade
  semester.value = selected.semester
 }

})



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

// ======== post-add =========
function addPost() {

  let params = {
    title: title.value,
    content: content.value,
    thumbnail: thumbnail.value,
    likes: likes.value ? likes.value : 0,
    user_id: user_id.value,
    year: year.value,
    grade: grade.value,
    semester: semester.value
  }

  if (mode.value == 'add' ) {
    requestPostAdd(params)

  } else if (mode.value == 'modify') {
    params.id = post.value[selectedIndex.value].id
    requestPostModify(params)
  }
}

async function requestPostAdd(params) {

  try{
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

async function requestPostModify(params) {

  try{
    let response = await upload(selectedFile.value, (progress) => {
      console.log(`업로드 진행률 : ${progress}`)
    })

    console.log(`업로드 응답 -> ${JSON.stringify(response)}`)

    params.thumbnail = `${requestConfig.baseURL}${response.data.filename}`

    response = await axios ({
      method: 'post',
      baseURL: requestConfig.baseUrl,
      url: 'post/modify',
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


function goToArchive() {
  console.log(`goToArchive 함수 실행됨`)

  router.push('/archive')
}

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