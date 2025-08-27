
<template>
<!-- ======== 학과사진 carousel ======== -->
<div>
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
</div>

<div>

  
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