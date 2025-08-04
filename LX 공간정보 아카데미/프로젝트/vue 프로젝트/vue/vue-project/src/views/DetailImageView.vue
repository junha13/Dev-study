<template>
    <HeaderView />
    <div class="mt-lg-20">
        <div class="d-flex align-items-center justify-content-between mb-5">
            <h1 class="mt-lg-10">제목 : {{ title }}</h1>
            <div>
                <button v-if="id===arcID" class="btn btn-secondary mt-lg-10 ms-10 " @click="deleteArchive()" >삭제하기 </button>
                <button v-else class="btn btn-secondary mt-lg-10 ms-10 " @click="alertDelete()">삭제하기 </button>
                <button class="btn btn-secondary mt-lg-10 ms-5" @click="goToStuArchive()">이전으로 </button>
            </div>
        </div>
        <p><img :src="'http://localhost:7004' + image" class="img-fluid rounded-start" alt="이미지"></p>  <!--태그 안에 넣을때는 자동으로 언래핑되어서 value안써도 됨-->
    </div>
</template>

<script setup>
import HeaderView from '../views/HeaderView.vue' // Headerview import
import {ref, onMounted} from 'vue';
import {useRouter, useRoute} from 'vue-router'

const route = useRoute();
const router = useRouter();
import axios from 'axios';

let image = ref('')
let title = ref('')
let id = ref('')
let arcID = ref('')
let number = ref('')


onMounted (() => {
	image.value = route.query.image
    title.value = route.query.title
    id.value = route.query.id
    arcID.value = route.query.arcID
    number.value = route.query.number
})

async function goToStuArchive() { // 학부설계 페이지로
  	router.push({
        path: '/stuArchive',
        query:{
            id:id.value
        }
  	})
}

async function deleteArchive() { // 작품 지우기

    try {
        const response = await axios ({
            method:'get',
            url:'http://localhost:7004/stuArchiveDelete',
            data:{},
            params:{
                number:number.value
            }
        })

        } catch(err) {
            console.log(`오류 발생 --> ${err}`)
        }

  	router.push({
        path: '/stuArchive',
        query:{
            id:id.value
        }
  	})
}

function alertDelete() {
    alert('작품을 올린 본인만 삭제가 가능합니다.')
}


</script>

