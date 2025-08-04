<template>
    <HeaderView />
    <div class="d-flex flex-row-fluid align-items-center">
        <div class="loginPage mt-lg-20">
                <div class="mt-lg-20 py-20"> <!--mt - 상단 여백 py - y축 여백 ms 왼쪽 여백 mb- 하단 여백-->
                <h1 class="fs-2hx fw-bold text-center ms-lg-15">My Page</h1>
            </div>
            <div>
                <div class="d-grid mb-10">
                    <div class="d-grid mb-10 ms-lg-20">
                    <button @click="logOut()" type="submit" id="kt_sign_in_submit" class="btn btn-primary">
                    <span class="indicator-label">로그아웃</span>
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

onMounted (() => {
	console.log('쿼리값:', route.query.id)
	id.value = route.query.id
})

async function logOut() {
    alert(`로그아웃 되었습니다.`)
    router.push({
        path: '/',
    })
}

</script>

<style>
</style>
