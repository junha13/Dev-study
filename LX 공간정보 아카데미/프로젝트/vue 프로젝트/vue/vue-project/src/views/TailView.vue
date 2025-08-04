<template> 
  <div class="bg-primary text-white  ">
    <p>ddd</p>

  </div>
</template>

<script setup>
import HeaderView from '../views/HeaderView.vue' // Headerview import
import {ref, onMounted} from 'vue';
import {useRouter, useRoute} from 'vue-router'

const route = useRoute();
const router = useRouter();
import axios from 'axios';

</script>

<style scoped>
</style>


