<template>
<div>
    <div class="w-100">
        <div class="p-4">
            <img src="/src/assets/images/grass.jpg" class="w-100 rounded-3 border-2"></img>
        </div>
    </div>

    <div class="d-flex flex-row justify-content-between">
        <div class="m-auto">
            <button class="btn btn-primary p-3" @click="goToHome()">안전등산가기</button>
        </div>
    </div>


</div>
</template>

<script setup>

import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'

import { storeToRefs } from 'pinia';

import { useCounterStore } from '@/stores/counter';
const counterStore =  useCounterStore();
const { fullScreen } = storeToRefs(counterStore);


const router = useRouter();

function goToHome() {
    fullScreen.value = false,
    router.push('/');
}



</script>

<style scoped>

</style>
