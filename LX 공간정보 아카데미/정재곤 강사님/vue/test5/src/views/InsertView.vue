<template>
    <div>
        <h1>고객 추가</h1>
    </div>

    <div>
        <span>이름 </span><input v-model="name"><p></p>
        <span>나이 </span><input v-model="age"><p></p>
        <span>전번 </span><input v-model="mobile"><p></p>
    </div>
    <div>
        <button @click="insert()">추가</button>
        <button @click="goToHome()">취소</button>
    </div>
</template>

<script setup>
import {ref, onMounted } from 'vue'
import axios from 'axios'
import {useRoute, useRouter} from 'vue-router'

const name = ref('');
const age = ref('');
const mobile = ref('');

const router = useRouter();
const route = useRoute();

async function insert() {

    try{
        const response = await axios({
            method:'get',
            url:'http://localhost:7003/person/page/insert',
            data:{},
            params:{
                name:name.value,
                age:age.value,
                mobile:mobile.value
            }

        })
        router.push({
            path:'/'
        })
    }catch (err) {
        console.log(`에러남`)
    }
}

function goToHome () {
    router.push({
        path:'/'
    })
}


</script>

<style>

</style>
