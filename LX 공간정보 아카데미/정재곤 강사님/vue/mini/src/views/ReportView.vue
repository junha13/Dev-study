<template>
<div>
    <div class="w-100">
        <div class="p-3">
            <img src="/src/assets/images/grass.jpg" class="w-100 rounded-3 border border-success border-3"></img>
        </div>
    </div>

    <div class="d-flex flex-row justify-content-between mt-3">
        <div class="w-50 h-300px">  <!-- 왠지는 모르겠는데 이러니까 4:4:2로 나눠가지네-->
            <div class="d-flex flex-column justify-content-between h-300px ms-1">
                <div v-for="(menu, index) in firstMenu" :key="menu.name" class="h-50 p-2">
                    <div class="border border-3 rounded-3 border-dark-subtle h-100 shadow-sm">
                        <div class="d-flex flex-column align-items-center justify-content-center h-100"> <!--align-items-center 가로 가운데, justify-content-center 세로 가운데-->
                            <span v-html="menu.icon" class="menu-icon">
                            </span>
                            <span class="m-2 fs-2x fw-bold">{{ menu.name }}</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="w-50 h-200px">  <!-- 왠지는 모르겠는데 이러니까 4:4:2로 나눠가지네-->
            <div class="d-flex flex-column justify-content-between h-300px">
                            <div class="d-flex flex-column justify-content-between h-300px ms-1">
                <div v-for="(menu, index) in secondMenu" :key="menu.name" class="h-50 p-2">
                    <div class="border border-3 rounded-3 border-dark-subtle h-100 shadow-sm">
                        <div class="d-flex flex-column align-items-center justify-content-center h-100"> <!--align-items-center 가로 가운데, justify-content-center 세로 가운데-->
                            <span v-html="menu.icon" class="menu-icon">
                            </span>
                            <span class="m-2 fs-2x fw-bold">{{ menu.name }}</span>
                        </div>
                    </div>
                </div>
            </div>
            </div>
        </div>
        <div class="w-25 h-300px">
            <div class="d-flex flex-column justify-content-between h-100 me-1">
                <div class="h-100 p-2">
                    <div class="border border-3 border-success rounded-3 h-100 shadow-sm bg-success-subtle">
                        <div class="d-flex flex-column align-items-center justify-content-center h-100"> <!--align-items-center 가로 가운데, justify-content-center 세로 가운데-->
                            <span class="menu-icon ">
                                <i class="ki-duotone ki-document fs-2x ">
                                    <span class="path1"></span>
                                    <span class="path2"></span>
                                </i>
                            </span>
                            <span class=" m-2 fs-2x fw-bold">내 주변</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div>
        <div class="d-flex flex-row justify-content-between align-items-center p-2 h-80px">
            <div class="ms-2">
                <span class="fs-2x fw-bold">전체 농장</span>
            </div>
            <div class="me-2">
                <span class="fs-1x fw-bold text-primary">더보기</span>
                <i class="ki-duotone ki-right fs-1x">
                </i>
            </div>
        </div>

        <div class="d-flex flex-row justify-content-between">
            <div v-for="(product, index) in products" :key="product.id"  class="w-50 h-150px">
                <div class="d-flex flex-column align-items-center justify-content-center p-2">
                        <img :src="product.image" class="w-100 h-100 rounded-4">
                    <div class="bg-success mt-5 rounded-4 p-1">
                        <span class="m-2 h-25 text-white">{{ product.name }}</span>
                    </div>
                    <div class="mt-2">
                        <span class="m-2 h-25">⭐ {{ product.star }}</span><br>
                    </div>
                    <div class="mt-2">
                        <span class="m-2 h-25">{{ product.seller }}</span><br>
                    </div>
                </div>
            </div>
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
const { fullScreen, activeTab } = storeToRefs(counterStore);

onMounted(() => {
    activeTab.value = 'homeHome'
})

const products = ref([
  {
    id : 1,
    name : "버섯",
    star : "3.5 (0)",
    seller : "전주 B",
    image : "/src/assets/images/m.jpg"
  },
  {
    id : 2,
    name : "감자",
    star : "2 (0)",
    seller : "창원",
    image : "/src/assets/images/p.jpg"
  },
  {
    id : 3,
    name : "토마토",
    star : "0 (0)",
    seller : "경기도",
    image : "/src/assets/images/t.jpg"
  }
])

const firstMenu = ref([
    {
        name : "땅 검색",
        icon : `<i class="ki-duotone ki-password-check fs-6x">
                    <span class="path1"></span>
                    <span class="path2"></span>
                    <span class="path3"></span>
                    <span class="path4"></span>
                    <span class="path5"></span>
                </i>`
    },
    {
        name : "거래내역",
        icon : `<i class="ki-duotone ki-document fs-2x fs-6x">
                    <span class="path1"></span>
                    <span class="path2"></span>
                </i>`
    }
])
const secondMenu = ref([
    {
        name : "건강수치 확인",
        icon : `<i class="ki-duotone ki-chart-simple-2 fs-6x">
                    <span class="path1"></span>
                    <span class="path2"></span>
                    <span class="path3"></span>
                    <span class="path4"></span>
                </i>`
    },
    {
        name : "내 땅 확인",
        icon : `<i class="ki-duotone ki-element-12 fs-6x">
                    <span class="path1"></span>
                    <span class="path2"></span>
                    <span class="path3"></span>
                </i>`
    }
])



const router = useRouter();

function goToHome() {
    fullScreen.value = false,
    router.push('/');
}



</script>

<style scoped>

</style>
