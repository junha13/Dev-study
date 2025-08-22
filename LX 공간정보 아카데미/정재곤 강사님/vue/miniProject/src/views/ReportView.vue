<template>
<div>
    <div class="w-100">
        <div class="p-3">
            <img src="/src/assets/images/grass.jpg" class="w-100 rounded-3 border border-success border-3"></img>
        </div>
    </div>

    <div class="d-flex flex-row justify-content-between mt-7">
        <div class="w-50 h-200px">  <!-- 왠지는 모르겠는데 이러니까 4:4:2로 나눠가지네-->
            <div class="d-flex flex-column justify-content-between h-200px ms-1">
                <div class="h-50 p-2">
                    <div class="border border-3 rounded-3 border-dark-subtle h-100 shadow-sm">
                        <div class="d-flex flex-column align-items-center justify-content-center h-100"> <!--align-items-center 가로 가운데, justify-content-center 세로 가운데-->
                            <span class="menu-icon ">
                                <i class="ki-duotone ki-document fs-2x ">
                                    <span class="path1"></span>
                                    <span class="path2"></span>
                                </i>
                            </span>
                            <span class="menu-title m-2 ">문서</span>
                        </div>

                    </div>
                </div>
                <div class="h-50 p-2">
                    <div class="border border-3 rounded-3 border-dark-subtle h-100 shadow-sm">
                        <div class="d-flex flex-column align-items-center justify-content-center h-100"> <!--align-items-center 가로 가운데, justify-content-center 세로 가운데-->
                            <span class="menu-icon ">
                                <i class="ki-duotone ki-document fs-2x ">
                                    <span class="path1"></span>
                                    <span class="path2"></span>
                                </i>
                            </span>
                            <span class="menu-title m-2 ">문서</span>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <div class="w-50 h-200px">  <!-- 왠지는 모르겠는데 이러니까 4:4:2로 나눠가지네-->
            <div class="d-flex flex-column justify-content-between h-200px">
                <div class="h-50 p-2">
                    <div class="border border-3 rounded-3 border-dark-subtle h-100 shadow-sm">
                        <div class="d-flex flex-column align-items-center justify-content-center h-100"> <!--align-items-center 가로 가운데, justify-content-center 세로 가운데-->
                            <span class="menu-icon ">
                                <i class="ki-duotone ki-document fs-2x ">
                                    <span class="path1"></span>
                                    <span class="path2"></span>
                                </i>
                            </span>
                            <span class="menu-title m-2 ">문서</span>
                        </div>
                    </div>
                </div>
                <div class="h-50 p-2">
                    <div class="border border-3 rounded-3 border-dark-subtle h-100 shadow-sm">
                        <div class="d-flex flex-column align-items-center justify-content-center h-100"> <!--align-items-center 가로 가운데, justify-content-center 세로 가운데-->
                            <span class="menu-icon ">
                                <i class="ki-duotone ki-document fs-2x ">
                                    <span class="path1"></span>
                                    <span class="path2"></span>
                                </i>
                            </span>
                            <span class="menu-title m-2 ">문서</span>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <div class="w-25 h-200px">
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
                            <span class="menu-title m-2 ">문서</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div>
        <div class="d-flex flex-row justify-content-between p-2">
            <div class="ms-2">
                <span>전체 농장</span>
            </div>
            <div class="me-2">
                <span>더보기</span>
            </div>
        </div>

            <div class="d-flex flex-row justify-content-between">
                <div class="w-50 h-150px">
                    <div class="d-flex flex-column align-items-center justify-content-center">
                        <div class="">
                            <img src="/src/assets/images/bong.jpg" class="w-100 h-100">
                        </div>
                        <div class="">
                            <span class="menu-title m-2 h-25">버섯</span>
                        </div>
                        <div class="">
                            <span class="menu-title m-2 h-25">문서</span>
                        </div>
                    </div>
                </div>
                <div class="w-50 h-150px">
                    <div class="d-flex flex-column align-items-center justify-content-center h-100">
                        <div>
                            <span class="menu-title m-2 ">문서</span>
                        </div>
                    </div>
                </div>
                <div class="w-50 h-150px">
                    <div class="d-flex flex-column align-items-center justify-content-center h-100">
                        <div>
                            <span class="menu-title m-2 ">문서</span>
                        </div>
                    </div>
                </div>


        </div>
    </div>

    <div class="d-flex flex-row justify-content-between h-100px mb-10">
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
