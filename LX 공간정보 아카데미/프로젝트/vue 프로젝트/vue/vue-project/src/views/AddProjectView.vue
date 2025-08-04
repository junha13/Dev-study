<template>
    <HeaderView />
    <div class="mt-lg-20">
        <div class="d-flex align-items-center justify-content-between">
            <h1 class="mt-lg-20 text-success p-3">1. 처음에 계획했던 페이지를 전부 구현하지 못한 것</h1>
        </div>
        <div class="ms-10">  
            <h3>원래는 페이지 기준 11개 이상의 페이지를 만들고, header가 있으니 footer 또한 만들었어야 했지만, 시간과 능력 부족,, 하지만 이번 프로젝트는 개인적으로라도 차근차근 완성시켜 볼 예정</h3>
        </div>
        <div class="d-flex align-items-center justify-content-between">
            <h1 class="mt-lg-20 text-success p-3">2. 처음에 너무 큰 그림만 잡고 개발에 들어간 것</h1>
        </div>
        <div class="ms-10">  
            <h3>처음 해보는 웹페이지 프로젝트여서 개발 속도가 느려질까봐 대충 머릿속으로만 구상하고 개발에 들어갔는데, 세부적인 사항에 대해 미리 스케치작업을 한 후에 개발에 들어갔다면 훨씬 더 빨리 끝났을 것 같다. 다음부터는 웹페이지 개발 전에 미리 웹페이지 구상을 하고 들어가야 할 것 같다.</h3>
        </div>
        <div class="d-flex align-items-center justify-content-between">
            <h1 class="mt-lg-20 text-success p-3">3. metronic 시스템에 대해 먼저 공부하지 않은 것</h1>
        </div>
        <div class="ms-10">  
            <h3>이건 진짜 metronic row, col (lg, xl, xxl) 때문에 머리 깨질뻔 했다. 추후에 더 공부하면서 프로젝트 완성해야 함</h3>
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


let id = ref('')


onMounted (() => {
    id.value = route.query.id
})




</script>

