<template>
    <HeaderView />
    <div class="d-flex flex-row-fluid align-items-center">
        <div class="loginPage">
            <div class="mt-lg-20 py-20"> <!--mt - 상단 여백 py - y축 여백 ms 왼쪽 여백 mb- 하단 여백-->
                <h1 class="fs-2hx fw-bold text-center ms-lg-15">Sign In</h1>
            </div>
            <div>
                <div class="fv-row mb-8 fv-plugins-icon-container ms-lg-20">
                <input type="text" placeholder="id" v-model="id" class="form-control bg-transparent"> 
            <!--placeholder = 회색 글씨 힌트, class =  -->
                </div>
                <div class="fv-row mb-12 fv-plugins-icon-containe ms-lg-20">    
                    <input type="password" placeholder="Password" v-model="password" class="form-control bg-transparent">
                </div>
                <div class="fv-row mb-12 fv-plugins-icon-containe ms-lg-20">
                    <a href="/signUp"><span>회원가입</span></a>
                </div>
                <div class="d-grid mb-10">
                    <div class="d-grid mb-10 ms-lg-20">
                    <button @click="login()" type="submit" id="kt_sign_in_submit" class="btn btn-primary">
                    <span class="indicator-label">Sign In</span>
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
import {useRouter} from 'vue-router'

const router = useRouter();
import axios from 'axios';

let id= ref('')
let password= ref('')

async function login() {
    const response = await axios({
        method:'get',
        url:'http://localhost:7004/login',
        data:[],
        params:{
            id:id.value,
            password:password.value
        }
    })
    const loginCnt = response.data.loginCnt
    if (loginCnt===1) {
        alert(`로그인에 성공하셨습니다. 반갑습니다 ${id.value}님.`)
        router.push({
        path: '/',
        query:{id:id.value}
  	    })
    } else if (loginCnt===0) {
        alert(`아이디 및 비밀번호가 일치하지 않습니다.`)
    }
}

</script>

<style>
</style>
