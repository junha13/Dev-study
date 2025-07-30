<template>
  <div>
    <div>
      <h1>정보 화면</h1>

    </div>

    <div>
      <button @click="goToHome()">홈 화면</button>
    </div>



  </div>

</template>


<script setup>
import { useRouter } from 'vue-router'
const router = useRouter();

function goToHome() {
  router.push('/')
}
</script>

<style scoped>



</style>