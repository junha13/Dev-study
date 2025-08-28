
<template>
<div>
  <!-- ======== 학과사진 carousel ======== -->
  <div id="carouselExampleCaptions" class="carousel slide">
    <div class="carousel-inner">
      <div class="carousel-item active">
        <img src="/images/mt.jpg" class="w-100">
        <div class="carousel-caption">
          <h5 class="text-light mb-n3">2024년 도시정보공학과 MT</h5>
        </div>
      </div>
      <div class="carousel-item">
        <img src="/images/baaa.jpg" class=" w-100">
        <div class="carousel-caption">
          <h5 class="text-light mb-n3">2024년 대학 연합 성과공유 전시회</h5>
        </div>
      </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Next</span>
    </button>
  </div>
  <!-- ======== 넣을거 없어서 레이아웃만 잡음 ======== -->
  <div class="d-flex flex-row h-350px">
    <div class="w-50 h-100 p-2">
      <div class="w-100 h-100 rounded-3 border border-primary border-3">
      </div>
    </div>
    <div class="w-50 h-100 p-2 d-flex flex-column">
      <div class="w-100 h-50 rounded-3 border border-danger-subtle border-3">

      </div>
      <div class="w-100 h-50 rounded-3 border border-success-subtle border-3 mt-4">

      </div>

    </div>
  </div>
</div>
</template>

<script setup>

import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router';
import axios from 'axios'

// user name 저장
import { storeToRefs } from 'pinia';

import { useUserStore } from '@/stores/user';
const userStore =  useUserStore();
const { loginCheck, userName, pkNumber } = storeToRefs(userStore);

const router = useRouter();

onMounted(() => {
  console.log(`HomeView :: onMounted 실행됨`)

})

</script>


<style scoped>

</style>