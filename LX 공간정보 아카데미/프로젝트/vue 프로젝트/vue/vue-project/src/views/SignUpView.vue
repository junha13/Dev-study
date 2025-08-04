<template>
    <HeaderView />
    <div class="d-flex flex-row-fluid align-items-center">
        <div class="loginPage">
            <div class="mt-lg-20 py-20"> <!--mt - 상단 여백 py - y축 여백 ms 왼쪽 여백 mb- 하단 여백-->
                <h1 class="fs-2hx fw-bold text-center ms-lg-15">Sign Up</h1>
            </div>
            <div>
                <div class="fv-row mb-7 fv-plugins-icon-container ms-lg-20">
                <input type="text" placeholder="id" v-model="id" class="form-control bg-transparent">
                <button @click="idCheck()" class="btn btn-primary mt-2 w-20">
                    <span class="indicator-label fs-8">id 중복검사</span></button>
                <!--placeholder = 회색 글씨 힌트, class =  -->
                </div>
                <div class="fv-row mb-8 fv-plugins-icon-containe ms-lg-20">    
                    <input type="password" placeholder="Password" v-model="password" class="form-control bg-transparent">
                </div>
                <div class="fv-row mb-10 fv-plugins-icon-containe ms-lg-20">    
                    <input type="password" placeholder="Password Check" v-model="passwordCheck" class="form-control bg-transparent">
                </div>
                <div class="d-grid mb-10">
                    <div class="d-grid mb-10 ms-lg-20">
                        <button @click="signUp()" type="submit" id="kt_sign_in_submit" class="btn btn-primary">
                        <span class="indicator-label">Sign Up</span>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import HeaderView from '../views/HeaderView.vue'  // Headerview import
import {ref, onMounted} from 'vue';
import {useRouter} from 'vue-router'
const router = useRouter();
import axios from 'axios';

let id= ref('')
let password= ref('')
let passwordCheck= ref('')
let idCheckNum;

async function goToHome() { // 로그인 페이지로
  	router.push({
    path: '/'
  	})
}
onMounted(() => {
    idCheckNum = 0;
})

async function idCheck() {  // 아이디 중복 검사 sql로 id 보내고 count 추출 후 비교 
    if (id.value) {
        try{
            const response = await axios({
                method:'get',
                url:'http://localhost:7004/idCheck',
                data:[],
                params:{
                    id:id.value
                }
            })

            const idCnt = response.data.idCnt

            if(idCnt===0) {   // 아이디 중복 검사
                idCheckNum=1
                alert(`아이디가 중복되지 않았습니다. 그대로 진행해주세요.`)
            } else {
                alert(`중복된 아이디가 존재합니다. 다시 입력해주세요.`)
            }
        } catch (err) {
            console.log(`오류 발생 --> ${err}`)
        }
    } else {
        alert('아이디를 입력해주세요')
    }
}

async function signUp() {
    if(password.value===passwordCheck.value && idCheckNum===1 &&password.value && id.value) {
        alert(`회원가입이 완료되었습니다. 로그인을 진행해주세요.`)  
            try{
                const response = await axios({  // 테이블에 추가한거임 
                method:'get',
                url:'http://localhost:7004/signUp',
                data:[],
                params:{
                    id:id.value,
                    password:password.value
                }
                })
            } catch(err) {
                console.log(`오류 발생 --> ${err}`)
            }
            router.push({
                path:'/signIn'
            })
        } else if (!id.value) {
            alert('아이디를 입력해주세요')
        } else if (idCheckNum===0) {
            alert(`아이디 중복검사를 먼저 진행해주세요.`)
        } else if (!(password.value===passwordCheck.value)) {
            alert(`입력하신 비밀번호가 서로 다릅니다.`)
        } else if (!password.value) {
            alert('비밀번호를 입력해주세요')
        } 
}
</script>

<style>
</style>
