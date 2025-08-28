<template>
<div class="d-flex flex-row justify-content-center mt-10">
    <div class="d-flex flex-column align-items-center gap-4 ms-20">
        <div>
            <span>
                <input class="form-control form-control-solid bg-white border-black" placeholder="id" v-model="userId"></input>
            </span>
        </div>
        <div>
            <input type="password" class="form-control form-control-solid bg-white border-black" placeholder="password" v-model="userPassword"></input>
        </div>
        <div>
            <input type="password" class="form-control form-control-solid bg-white border-black" placeholder="password check" v-model="userPasswordDoubleCheck"></input>
        </div>
        <div>
            <input class="form-control form-control-solid bg-white border-black" placeholder="name" v-model="userName"></input>
        </div>
        <div>
            <input class="form-control form-control-solid bg-white border-black" placeholder="email" v-model="userEmail"></input>
        </div>
        <div>
            <input class="form-control form-control-solid bg-white border-black" placeholder="mobile" v-model="userMobile"></input>
        </div>
        <div>
            <button class="btn btn-primary px-20" @click="addUser">회원가입</button>
        </div>
    </div>
    <div>
        <button class="btn btn-secondary border border-dark border-2 p-2 me-n5 mt-1 ms-3" @click="idOverlapCheck()">id 중복체크</button>
    </div>
</div>
<div class="h-200px">

</div>



</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'
import axios from 'axios'

// BaseURL 받기
import { requestConfig } from '../../../app.config'

const router = useRouter();

const userId = ref('');
const userPassword = ref('');
const userPasswordDoubleCheck = ref('');
const userName = ref('');
const userEmail = ref('');
const userMobile = ref('');

let idCheck;
let completeId;

onMounted(() => {
    console.log(`JoinView :: onMounted 실행됨`)
    idCheck = 0;
})

async function addUser() {
    console.log(`addUser 함수 실행됨`)

    try{

        if(!userId.value) {
            alert('id를 입력하세요')
            return;
        }

        if(idCheck === 0 || !(completeId === userId.value)) {  // 아이디 체크를 하고 아이디가 변경되면 감지
            alert('id check를 하세요')
            return;
        }

        if(!userPassword.value || !userPasswordDoubleCheck.value || !(userPassword.value == userPasswordDoubleCheck.value)) {
            alert('비밀번호가 서로 맞지 않습니다.')
            return;
        }

        if(!userName.value) {
            alert('name을 입력하세요')
            return;
        }

        if(!userEmail.value) {
            alert('email을 입력하세요')
            return;
        }

        if(!userMobile.value) {
            alert('Mobile을 입력하세요')
            return;
        }

        const params = {
            id:userId.value,
            password:userPassword.value,
            name:userName.value,
            email:userEmail.value,
            mobile:userMobile.value
        }

        const response = await axios({
            method: 'post',
            baseURL: requestConfig.baseUrl,
            url: '/user/add',
            data: params,
            timeout: 5000,
            response: 'json'
        })

        console.log(`응답 => ${JSON.stringify(response.data)}`)

        alert('회원가입 완료~~ 다시 로그인해주세요')

        router.push('/login');
    } catch(err) {
        console.error(`에러 => ${err}`)

    }
}

function idOverlapCheck() {
    idOverlapCheckByDB()
}


async function idOverlapCheckByDB() {

    try{

        const params = {
            id:userId.value,
        }

        const response = await axios({
            method: 'post',
            baseURL: requestConfig.baseUrl,
            url: '/user/overlapCheck',
            data: params,
            timeout: 5000,
            response: 'json'
        })

        console.log(`응답 => ${JSON.stringify(response.data.data.data[0]['cnt'])}`)

        // id overlapCheck
        if (response.data.data.data[0]['cnt'] === 0 && userId.value) {  // 이게 최선일까
            alert('사용하세요')
            completeId = userId.value;
            idCheck = 1;
        } else {
            alert('되겠냐')
        }

    } catch(err) {
        console.error(`에러 => ${err}`)

    }
}
</script>

<style scoped>

</style>
