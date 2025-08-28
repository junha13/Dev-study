
<template>

<div>

  <div>
    <h1>추가 화면</h1>
  </div>

  <div>
    <div>
      <label>구분</label>
      <input type="text" v-model="typeInput">
    </div>

    <div>
      <label>이름</label>
      <input type="text" v-model="nameInput">
    </div>

    <div>
      <label>나이</label>
      <input type="text" v-model="ageInput">
    </div>

    <div>
      <label>전화번호</label>
      <input type="text" v-model="mobileInput">
    </div>

    <div>
      <label>이미지 경로</label>
      <input type="text" v-model="pathInput">
    </div>

      <div class="mt-4">
    <!-- 입력값이 바뀔 때마다 함수 실행 -->
    <input type="file" id="uploadImage" hidden @change="getFilename($event.target.files)"></input>
    <label for="uploadImage" class="d-flex justify-content-center">
      <img src="/assets/media/avatars/300-20.jpg" id="preview" width="50%"></img>
    </label>
  </div>

  </div>

  <div style="margin-top: 2em;">
    <button @click="save()">저장</button>
    <button @click="cancel()">취소</button>
  </div>

</div>

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

import axios from 'axios'




const typeInput = ref('')
const nameInput = ref('')
const ageInput = ref('')
const mobileInput = ref('')
const pathInput = ref('')

// 업로드
import { useUpload } from '@/util/upload.js'
const { upload } = useUpload()

import { requestConfig } from '../../app.config'

// 선택된 파일
const selectedFile = ref('')


onMounted(() => {
  console.log(`AnimalAdd::onMounted 호출됨`)

  // 수정 모드인 경우, 입력상자에 선택된 아이템의 값을 넣어주기
  if (mode.value == 'modify') {
    const selected = animals.value[selectedIndex.value]

    typeInput.value = selected.type
    nameInput.value = selected.name
    ageInput.value = selected.age
    mobileInput.value = selected.mobile
    pathInput.value = selected.path

  }

})


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



function save() {
  console.log(`save 함수 호출됨`)

  const type = typeInput.value
  const name = nameInput.value
  const age = ageInput.value
  const mobile = mobileInput.value
  const path = pathInput.value

  const item = {
    //id: String(animals.length + 1),
    type: type,
    name: name,
    age: age,
    mobile: mobile,
    path: path
  }

  if (mode.value == 'add') {
    
    requestAnimalAdd(item)

  } else if (mode.value == 'modify') {
    
    item.id = animals.value[selectedIndex.value].id

    requestAnimalModify(item)

  }
 
}


async function requestAnimalAdd(item) {

  try {

    let response = await upload(selectedFile.value, (progress) => {
        console.log(`업로드 진행률 : ${progress}`)
      })

      console.log(`업로드 응답 -> ${JSON.stringify(response)}`)

      item.path = `${requestConfig.baseUrl}${response.data.filename}` // item의 path 정보를 filename으로 바꿈
  
      // 이게 왜 이렇게 하면 되는거임??  => 웹서버쪽 전체주소를 db에 넣어야됨 ex)  http://localhost:8001//images/CB3E7290-EFFC-4951-9986-7D6DD1001FD51756174075185.png



    response = await axios({
      method: 'post',
      baseURL: 'http://localhost:8001',
      url: '/animal/v1/add',
      data: item,
      timeout: 5000,
      responseType: 'json'
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`)
 
    goToList()

  } catch(err) {
    console.error(`에러 -> ${err}`)
  }

}


async function requestAnimalModify(item) {

  try {
  
    const response = await axios({
      method: 'post',
      baseURL: 'http://localhost:8001',
      url: '/animal/v1/modify',
      data: item,
      timeout: 5000,
      responseType: 'json'
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`)
 
    goToList()

  } catch(err) {
    console.error(`에러 -> ${err}`)
  }

}


function goToList() {
  router.replace('/', {})
}


function cancel() {
  console.log(`cancel 함수 호출됨`)

  router.replace('/', {})
}


</script>

<style scoped>


</style>
