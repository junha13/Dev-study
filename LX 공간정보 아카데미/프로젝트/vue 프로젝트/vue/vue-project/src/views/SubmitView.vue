<template>  <!--각 데이터는 v-model과 ref로 받고 라우터로 post방식, formdata방식으로 보냄-->
  <HeaderView />
    <div class="d-flex flex-row-fluid align-items-center">
        <div class="loginPage">
            <div class="mt-lg-20 py-10"> <!--mt - 상단 여백 py - y축 여백 ms 왼쪽 여백 mb- 하단 여백-->
                <h1 class="fs-2hx fw-bold text-center ms-lg-15">작품 등록</h1>
            </div>
            <div>
              <div class="fv-row mb-8 fv-plugins-icon-container ms-lg-20">
                <button v-if="!year" class="btn btn-secondary dropdown-toggle w-100" data-bs-toggle="dropdown">연도</button>
          <button v-else class="btn btn-secondary dropdown-toggle w-100" data-bs-toggle="dropdown">{{ year }}년</button>
          <!--드롭다운 메뉴를 누르면 ref변수에 값이 들어가면서 v-else로 빠지고 화면에 값 표시-->

          <ul class="dropdown-menu">
            <li><a class="dropdown-item" @click="setYear(2017)">2017년</a></li>
            <li><a class="dropdown-item" @click="setYear(2018)">2018년</a></li>
            <li><a class="dropdown-item" @click="setYear(2019)">2019년</a></li>
            <li><a class="dropdown-item" @click="setYear(2020)">2020년</a></li>
            <li><a class="dropdown-item" @click="setYear(2021)">2021년</a></li>
            <li><a class="dropdown-item" @click="setYear(2022)">2022년</a></li>
            <li><a class="dropdown-item" @click="setYear(2023)">2023년</a></li>
            <li><a class="dropdown-item" @click="setYear(2024)">2024년</a></li>
            <li><a class="dropdown-item" @click="setYear(2025)">2025년</a></li>
          </ul>
              </div>
              <div class="fv-row mb-8 fv-plugins-icon-containe ms-lg-20">    
          <button v-if="!grade" class="btn btn-secondary dropdown-toggle w-100" data-bs-toggle="dropdown">학년</button>
          <button v-else class="btn btn-secondary dropdown-toggle w-100" data-bs-toggle="dropdown">{{ grade }}학년</button>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" @click="setGrade(1)">1학년</a></li>
            <li><a class="dropdown-item" @click="setGrade(2)">2학년</a></li>
            <li><a class="dropdown-item" @click="setGrade(3)">3학년</a></li>
            <li><a class="dropdown-item" @click="setGrade(4)">4학년</a></li>
          </ul>
              </div>
                <div class="dropdown flex-fill"> 
                    <div class="fv-row mb-8 fv-plugins-icon-containe ms-lg-20">
            <button v-if="!semester" class="btn btn-secondary dropdown-toggle w-100" data-bs-toggle="dropdown">학기</button>
            <button v-else class="btn btn-secondary dropdown-toggle w-100" data-bs-toggle="dropdown">{{ semester }}학기</button>
            <ul class="dropdown-menu">
            <li><a class="dropdown-item" @click="setSemester(1)">1학기</a></li>
            <li><a class="dropdown-item" @click="setSemester(2)">2학기</a></li>
             </ul>
            </div>
            </div>
              <div class="fv-row mb-8 fv-plugins-icon-containe ms-lg-20"> 
              <input type="text" placeholder="title" v-model="title" class="form-control bg-transparent">
              </div>
              <div class="fv-row mb-8 fv-plugins-icon-containe ms-lg-20"> 
              <input type="text" placeholder="explanation" v-model="explanation" class="form-control bg-transparent">
              </div>
              <div class="fv-row mb-8 fv-plugins-icon-containe ms-lg-20"> 
              <input type="file" placeholder="imageURL" @change="imageload" class="form-control bg-transparent">
              <!--file input에서는 파일을 선택해 넣을 수 있고, 객체, 이름, 리스트, 파일 크기 등이 담김 -->
              <!--@change는 파일 선택이 완료됐을 때 imageload 함수 실행, 때문에 @click은 안됨, 그리고 file은 v-model도 안먹음-->
              <!--함수의 매개변수 쪽에는 자동으로 event라는 매개변수가 들어가는데, event는 event object를 나타내고, 클릭, 선택, 키보드 입력 등의 이벤트 정보를 담는 객체임, 
                vue에서는 이런 @change로 받을 수 있음 이 객체를 FormData로 서버에 전송하면 실제 이미지 업로드 가능-->
              <!--때문에 스크립트 쪽에서 event.taget.files[0]으로 제일 처음 선택한 이미지를 다른 곳(image.value)에 담을 수 있음-->
              </div>
                <div class="d-grid mb-10">
                  <div class="d-grid mb-10 ms-lg-20">
                    <button @click="submitAccept()" type="submit" id="kt_sign_in_submit" class="btn btn-primary">
                      <span class="indicator-label">작품 등록</span>
                    </button>
                  </div>
                </div>
              </div>
          </div>
    </div>
</template>

<script setup>
import HeaderView from '../views/HeaderView.vue' // Headerview import
import {ref, onMounted} from 'vue';
import {useRouter, useRoute} from 'vue-router'

const route = useRoute();
const router = useRouter();
import axios from 'axios';

let id= ref('')
let year= ref('')
let grade= ref('')
let title = ref('')
let explanation = ref('')
let image = ref('')
let semester = ref('')

onMounted(() => {
    id.value = route.query.id
})

function setYear(input) {
    year.value = input;
};

function setGrade(input) {
    grade.value = input;
};

function setSemester(input) {
    semester.value = input;
};

function imageload(event) {
    image.value = event.target.files[0]
    console.log(`${image.value}`)
    // image.vaule에 event.target.files[0] 객체가 저장됨
}


async function submitAccept() {
    try {
        const formData = new FormData();   // 파일을 담아 라우터로 보내려면 form데이터로 감싸서 보내야 됨. 여기에 키, 밸류 값으로 넣어서 라우터로 전송
        formData.append('id', id.value);
        formData.append('year', year.value);
        formData.append('grade', grade.value);
        formData.append('title', title.value);
        formData.append('explanation', explanation.value);
        formData.append('image', image.value);
        formData.append('semester', semester.value);

        const response = await axios({  // get 방식이 아닌 post 방식으로 보내야 함
            method:'post',
            url:'http://localhost:7004/submit',
            data:formData
            })

        router.push({
            path:'/stuArchive',
            query:{
                id:id.value
            }
        })

    } catch (err) {
        console.log(`오류 발생 --> ${err}`)
    }
}



</script>

<style scoped>
</style>


