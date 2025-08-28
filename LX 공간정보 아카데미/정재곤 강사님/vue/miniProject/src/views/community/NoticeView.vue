
<template>
  <div class="h-750px">
    <div class="d-flex justify-content-center mt-10">
      <span class="fs-2x fw-bold">이 페이지는 공지사항 페이지입니다.</span>
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
const { } = storeToRefs(userStore);

const router = useRouter();

onMounted(() => {
 console.log(`NoticeView :: onMounted 실행됨`)

})


</script>


<style scoped>

</style>