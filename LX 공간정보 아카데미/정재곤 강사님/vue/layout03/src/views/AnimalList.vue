
<template>

<div>

  <div>
    <h1>홈 화면</h1>
  </div>

  <div>
    <div v-if="nameVisible">
      <label>이름</label>
      <span>{{ name }}</span>
    </div>
    <div v-else>
      <label>나이</label>
      <span>21</span>
    </div>

    <div>
      <label>이름 입력 : </label>
      <input type="text" v-model="nameInput">
    </div>

    <div>
      <button @click="show()">확인</button>
    </div>
  </div>

  <div>
    <div style="margin-top: 2em; margin-bottom: 2em;">
      <span>동물들</span>
      <button @click="addAnimal()">추가</button>

      <button class="btn btn-sm btn-primary ms-4" @click="showDialog()">대화상자 띄우기</button>
    </div>

    <div v-for="(item, index) in animals" :key="item.id" :class="(item.type == 'dog') ? 'dog-style' : 'cat-style'">

      <div style="margin-bottom: 1em;">
        <label>구분 : </label>
        <span>{{ (item.type == 'dog') ? '강아지' : (item.type == 'cat') ? '고양이' : '모름' }}</span>
      
        <button @click="modifyAnimal(index)">수정</button>
        <button @click="removeAnimal(index)">삭제</button>
      </div>

      <div style="margin-bottom: 1em;">
        <label>이름 : </label>
        <span>{{ item.name }}</span>
      </div>

      <div style="margin-bottom: 1em;">
        <label>나이 : </label>
        <span>{{ item.age }}</span>
      </div>

      <div style="margin-bottom: 1em;">
        <label>전화번호 : </label>
        <span>{{ item.mobile }}</span>
      </div>

      <div>
        <label>이미지 : </label>
        <img :src="item.path" width="50%">
      </div>

    </div>

    <div style="margin-top: 1em;">

      <Pagination :requestFunc="requestAnimalList" :pagination="pagination1" />

    </div>


  </div>

</div>

<!--====== begin :: 대화상자  =======-->
<div class="modal fade" id="myDialog">  <!--modal은 보이지 않음-->

  <div class="modal-dialog modal-dialog-centered">

    <div class="modal-content rounded">

      <div class="modal-header">
        <span class="fs-1 fw-bold">파일 업로드</span>
      </div>

      <div class="modal-body p-10">

        <div>
          <label>이름 : </label>
          <input type="text" class="form-control form-control-solid"></input>
        </div>

        <div class="mt-4">
          <!-- 입력값이 바뀔 때마다 함수 실행 -->
          <input type="file" id="uploadImage" hidden @change="getFilename($event.target.files)"></input>
          <label for="uploadImage" class="d-flex justify-content-center">
            <img src="/assets/media/avatars/300-20.jpg" id="preview" width="50%"></img>
          </label>
        </div>

        <div class="mt-10">
          <button class="btn btn-primary" @click="uploadFile()">업로드</button>
        </div>

      </div>

    </div>

  </div>

</div>
<!--====== end :: 대화상자  =======-->

</template>

<script setup>

import { ref, onMounted } from 'vue'

// 라우터
import { useRouter } from 'vue-router'
const router = useRouter()

// 스토어 (공통저장소에 있는 것 사용하기)
import { storeToRefs } from 'pinia'

import { useAnimalStore } from '@/stores/animal'
const animalStore = useAnimalStore()
const { animals, mode, selectedIndex } = storeToRefs(animalStore)

// 웹서버로 요청하기 위한 모듈
import axios from 'axios'


// 페이지네이션
import Pagination from '@/components/Pagination.vue'
import { usePagination } from '@/util/pagination'
const { makePagination } = usePagination()

const pagination1 = ref({})

// 부트스트랩
import { Modal } from 'bootstrap'

// 업로드
import { useUpload } from '@/util/upload.js'
const { upload } = useUpload()

// 대화상자 객체를 담아둘 변수상자
let myDialog;
// 선택된 파일
const selectedFile = ref('')

// 감시할 수 있는 변수상자, ref 함수를 이용해서 만든다, 봉지를 씌운 것과 같다.
// 자바스크립트 코드에서는 변수상자의 값을 바꿀 때 name.value를 사용해야 한다.
// <template> 안에 있는 태그에서 값을 감시할 때는 name을 사용해야 한다.
// 반응형 변수라고 부른다. (Reactive variable)
const name = ref('홍길동1')

const nameInput = ref('')

const nameVisible = ref(true)


// 화면이 보이기 전에 한 번 실행됨
// 목적 : 화면이 보이기 전에 초기화하거나 또는 실행해야 하는 것들을 실행해줌
onMounted(() => {
  console.log(`HomeView::onMounted 호출됨`)

  requestAnimalList(1, 2)

})


async function requestAnimalList(page, perPage) {

  try {
  
    const response = await axios({
      method: 'post',
      baseURL: 'http://localhost:8001',
      url: '/animal/v1/list',
      data: {
        page: page,
        perPage: perPage,
      },
      timeout: 5000,
      responseType: 'json'
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`)
 
    animals.value = response.data.data.data

    pagination1.value = makePagination(response.data.data.header)

  } catch(err) {
    console.error(`에러 -> ${err}`)
  }

}


function showDialog() {
  console.log(`showDialog 함수 호출됨`)

  const elem = document.querySelector('#myDialog')
  myDialog = new Modal(elem);
  myDialog.show() // 보여주거나 안보여주거나 정할 수 있음
}


async function getFilename(files) {
  selectedFile.value = files[0] // 파일 중 첫번재 파일만 저장
  await base64()

}

function base64() {
  return new Promise((resolve, reject) => {
    let reader = new FileReader()
    // 파일을 다 로딩하고 previewImage.src에 저장
    reader.onload = e => {
      resolve(e.target.result)

      const previewImage = document.querySelector('#preview')
      previewImage.src = e.target.result
    }

    reader.readAsDataURL(selectedFile.value)
    // 선택한 파일 읽기 이게 먼저 실행되고 위 함수가 실행됨
  })
}

async function uploadFile() {
  console.log(`uploadFile 함수 호출됨 -> ${selectedFile.value.name}`)

  try{
  await upload(selectedFile.value, (progress) => {
    console.log(`업로드 진행률 : ${progress}`)
  })

  console.log(`업로드 응답 -> ${JSON.stringify(response)}`)
  } catch (err) {
    console.error(`업로드 중 에러 -> ${err}`)
  }
}

function show() {
  console.log(`show 함수 호출됨`)

  name.value = nameInput.value

  nameVisible.value = false

  //name.value = '홍길동2'

}

function addAnimal() {
  console.log(`addAnimal 함수 호출됨`)

  mode.value = 'add'
  router.replace('/animal-add', {})

}

function modifyAnimal(index) {
  console.log(`modifyAnimal 함수 호출됨 -> ${index}`)

  mode.value = 'modify'
  selectedIndex.value = index

  router.replace('/animal-add', {})


}

function removeAnimal(index) {
  console.log(`removeAnimal 함수 호출됨 -> ${index}`)

  const item = {
    id: animals.value[index].id
  }

  requestAnimalRemove(item)

}


async function requestAnimalRemove(item) {

  try {
  
    const response = await axios({
      method: 'post',
      baseURL: 'http://localhost:8001',
      url: '/animal/v1/remove',
      data: item,
      timeout: 5000,
      responseType: 'json'
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`)
  
    requestAnimalList(1, 10)

  } catch(err) {
    console.error(`에러 -> ${err}`)
  }

}



</script>

<style scoped>

.dog-style {
  background-color: aqua;
  margin-bottom: 1em;
}

.cat-style {
  background-color: darkcyan;
  margin-bottom: 1em;
}


</style>
