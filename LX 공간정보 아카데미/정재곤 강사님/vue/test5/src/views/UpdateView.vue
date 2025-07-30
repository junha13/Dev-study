<template>
    <div>
        <h1>수정화면</h1>
    </div>
    <div>
        <input type="text" v-model="name"><p></p>
        <input type="text" v-model="age"><p></p>
        <input type="text" v-model="mobile"><p></p>
        <button @click="accept()">적용</button>
        <button @click="goTohome()">취소</button>
    </div>


</template>

<script setup>
import {ref, onMounted} from 'vue';
import { useRouter, useRoute } from 'vue-router'
import axios from 'axios'

const router = useRouter();
const route = useRoute();
const id = ref('');
const name = ref('');
const age = ref('');
const mobile = ref('');

onMounted(() => {
    console.log(`insert onmounted 호출`);

    id.value= Number(route.query.id);
    name.value= route.query.name;
    age.value= Number(route.query.age);
    mobile.value= route.query.mobile;
})

async function accept() {
    console.log(`accept 호출`);
    try{
        const response = await axios({
            method:'get',
            url:'http://localhost:7003/person/page/update',
            params: {
                id:id.value,
                name:name.value,
                age:age.value,
                mobile:mobile.value,
            }
        })
        

        router.push({
            path:`/`
        })
    } catch(err) {

    }

}

function goTohome() {
    router.push({
        path:'/'
    })
}

</script>

<style>

</style>