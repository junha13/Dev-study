<template>
<div>
    <div class="w-100">
        <div class="p-4">
            <img src="/src/assets/images/grass.jpg" class="w-100 rounded-3 border border-success border-3"></img>
        </div>
    </div>

    <div class="d-flex flex-row justify-content-between">
        <div class="w-50">  <!-- 왠지는 모르겠는데 이러니까 4:4:2로 나눠가지네-->
            <div class="d-flex flex-column justify-content-between h-250px">
                <div class="h-50 p-1">
                    <div class="border dorder-3 bg-primary">


                    </div>
                </div>
                <div class="h-50">
                    dd
                </div>
            </div>
        </div>
        <div class="w-50">  <!-- 왠지는 모르겠는데 이러니까 4:4:2로 나눠가지네-->
            <div class="d-flex flex-column justify-content-between h-250px">
                <div class="h-50">
                    dd
                </div>
                <div class="h-50">
                    dd
                </div>
            </div>
        </div>
        <div class="w-25">
            <div class="bg-primary">
                <div>
                    dd
                </div>
            </div>
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
