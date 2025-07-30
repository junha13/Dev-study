<template>
  <div>
    <div>
      <h1>정보 화면</h1>


    </div>
    <div>
      <p>전달받은 이름 : {{ name }}</p>
      <p>전달받은 나이 : {{ age }}</p>
    </div>

    <div>
      <button @click="goToHome()">돌아가기</button>

    </div>



  </div>

</template>


<script setup>
import {ref, onMounted} from 'vue'
import { useRouter, useRoute } from 'vue-router'
const router = useRouter();
const route = useRoute();
const name = ref('');
const age = ref('');

onMounted(() => {
  console.log(`호출`)
  name.value = route.query.name;
  age.value = route.query.age;

})


function goToHome() {
  router.push('/')
}
</script>

<style scoped>



</style>