<template>
<h1>코스</h1>
<div>
    <div>
        <input placeholder="id" v-model="userId"></input>
    </div>
    <div>
        <input placeholder="password" v-model="userPassword"></input>
    </div>
    <div>
        <input placeholder="name" v-model="userName"></input>
    </div>
    <div>
        <input placeholder="email" v-model="userEmail"></input>
    </div>
    <div>
        <input placeholder="phone" v-model="userPhone"></input>
    </div>
    <div>
        <button @click="addUser">회원가입</button>
    </div>
</div>


</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'

const userId = ref('');
const userPassword = ref('');
const userName = ref('');
const userEmail = ref('');
const userPhone = ref('');

async function addUser() {

    try{

        const params = {
            id:userId.value,
            password:userPassword.value,
            name:userName.value,
            email:userEmail.value,
            phone:userPhone.value
        }

        const response = await axios({
            method: 'post',
            baseURL: 'http://localhost:8001',
            url: '/user/add',
            data: params,
            timeout: 5000,
            response: 'json'
        })

        console.log(`응답 => ${JSON.stringify(response.data)}`)
    } catch(err) {
        console.err(`에러 => ${err}`)

    }
}
</script>

<style scoped>

</style>
