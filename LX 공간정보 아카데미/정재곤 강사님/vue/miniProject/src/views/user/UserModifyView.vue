
<template>
<div class="d-flex flex-column align-items-center w-100 h-700px">
    <div class="d-flex flex-column align-items-center w-75 h-75 rounded rounded-4 border border-success-subtle border-1 bg-secondary shadow mt-10 gap-3">
      <div class="mt-10 mb-5">
        <span class="fs-2x fw-bold">계정 정보 수정</span>
      </div>

      <div style="width: 80%;">
        <input type="password" class="form-control form-control-solid bg-white border-black" v-model="password" placeholder="password"></input>
      </div>
      <div style="width: 80%;">
        <input type="password" class="form-control form-control-solid bg-white border-black" v-model="passwordDoubleCheck" placeholder="password check"></input>
      </div>

      <div class="" style="width: 80%;">
        <input class="form-control form-control-solid bg-white border-black" v-model="name" placeholder="name"></input>
      </div>
      <div class="" style="width: 80%;">
        <input class="form-control form-control-solid bg-white border-black" v-model="email" placeholder="email"></input>
      </div>
      <div class="" style="width: 80%;">
        <input class="form-control form-control-solid bg-white border-black" v-model="mobile" placeholder="mobile"></input>
      </div>
      
      <div>
        <button class="btn bg-success-subtle border border-black p-2 mt-10 fw-bold shadow" @click="userModify()">변경 완료</button>
      </div>
      <div>
        <button class="btn bg-danger-subtle border border-black p-2 mt-5 fw-bold shadow" @click="userRemove()">회원 탈퇴</button>
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
const { loginCheck, user_Id, post_pkNumber, mode, post } = storeToRefs(userStore);

const router = useRouter();
let user;

const password = ref('')
const passwordDoubleCheck = ref('')
const name = ref('')
const email = ref('')
const mobile = ref('')

onMounted(() => {
  console.log(`UserModifyView :: onMounted 실행됨`)

   getUserDetail()
})

// ======== onMounted post detail 보여주기 ========
async function getUserDetail() {
  
  try {
    const response = await axios({
      method: 'post',
      baseURL: requestConfig.baseUrl,
      url: 'user/read',
      data: {
        id:user_Id.value
      },
      timeout: 5000,
      responseType: 'json'
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`)

    user = response.data.data.data[0]

    password.value = user.password
    passwordDoubleCheck.value = user.password
    name.value = user.name
    email.value = user.email
    mobile.value = user.mobile

  } catch (err) {
    console.error(`에러 -> ${err}`);
  }
}

function userModify() {
  requsetUserModify()
}

async function requsetUserModify() {

  if(!password.value || !passwordDoubleCheck.value || !(password.value == passwordDoubleCheck.value)) {
      alert('비밀번호가 서로 맞지 않습니다.')
      return;
  }

  if(!name.value) {
      alert('name을 입력하세요')
      return;
  }

  if(!email.value) {
      alert('email을 입력하세요')
      return;
  }

  if(!mobile.value) {
      alert('Mobile을 입력하세요')
      return;
  }
  
  try {
    const response = await axios({
      method: 'post',
      baseURL: requestConfig.baseUrl,
      url: 'user/modify',
      data: {
        id:user_Id.value,
        password: password.value,
        name: name.value,
        email: email.value,
        mobile: mobile.value
      },
      timeout: 5000,
      responseType: 'json'
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`)

    user.value = response.data.data.data

    goToMyPage()

  } catch (err) {
    console.error(`에러 -> ${err}`);
  }
}

function userRemove() {
  if (confirm('진짜 삭제할거????')) {
    requsetUserRemove()
  } else {
    return;
  }
}

async function requsetUserRemove() {
  
  try {
    const response = await axios({
      method: 'post',
      baseURL: requestConfig.baseUrl,
      url: 'user/remove',
      data: {
        id:user_Id.value
      },
      timeout: 5000,
      responseType: 'json'
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`)

    user.value = response.data.data.data

    goTologin()

  } catch (err) {
    console.error(`에러 -> ${err}`);
  }
}

function goToMyPage() {
  console.log(`goToMyPage 실행됨`)

  router.push('/myPage')
}
function goTologin() {
  console.log(`goTologin 실행됨`)

  router.push('/login')
}

</script>


<style scoped>

</style>