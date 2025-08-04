<template>
  <div class="d-flex flex-column flex-root app-root" id="kt_app_root">
    <!--<HeaderView /> 이건 최초 1회만 onMounted가 되기 때문에 없앰-->
    <RouterView />
    <!--<TailView />  너무 시간이 촉박해서 지움 --> 
  </div>
</template>

<script setup>
import HeaderView from './views/HeaderView.vue'
import { RouterView } from 'vue-router'
import TailView from './views/TailView.vue';
</script>


<style scoped>

</style>
