
<template>

<div>

  <div>
    <h1>추가 화면</h1>
  </div>

  <div>
    <div>
      <label>구분</label>
      <input type="text" v-model="typeInput">
    </div>

    <div>
      <label>이름</label>
      <input type="text" v-model="nameInput">
    </div>

    <div>
      <label>나이</label>
      <input type="text" v-model="ageInput">
    </div>

    <div>
      <label>전화번호</label>
      <input type="text" v-model="mobileInput">
    </div>

    <div>
      <label>이미지 경로</label>
      <input type="text" v-model="pathInput">
    </div>

  </div>

  <div style="margin-top: 2em;">
    <button @click="save()">저장</button>
    <button @click="cancel()">취소</button>
  </div>

</div>

</template>

<script setup>

import { ref, onMounted } from 'vue'

// 라우터
import { useRouter } from 'vue-router'
const router = useRouter()

// 스토어 (공통저장소에 있는 것 사용하기)
import { storeToRefs } from 'pinia'

import { useAnimalStore } from '@/stores/animal'
const animalStore = useAnimalStore()
const { animals, mode, selectedIndex } = storeToRefs(animalStore)


const typeInput = ref('')
const nameInput = ref('')
const ageInput = ref('')
const mobileInput = ref('')
const pathInput = ref('')


onMounted(() => {
  console.log(`AnimalAdd::onMounted 호출됨`)

  // 수정 모드인 경우, 입력상자에 선택된 아이템의 값을 넣어주기
  if (mode.value == 'modify') {
    const selected = animals.value[selectedIndex.value]

    typeInput.value = selected.type
    nameInput.value = selected.name
    ageInput.value = selected.age
    mobileInput.value = selected.mobile
    pathInput.value = selected.path

  }

})


function save() {
  console.log(`save 함수 호출됨`)

  const type = typeInput.value
  const name = nameInput.value
  const age = ageInput.value
  const mobile = mobileInput.value
  const path = pathInput.value

  const item = {
    id: String(animals.length + 1),
    type: type,
    name: name,
    age: age,
    mobile: mobile,
    path: path
  }

  if (mode.value == 'add') {
    animals.value.push(item)
  } else if (mode.value == 'modify') {
    animals.value[selectedIndex.value] = item
  }


  router.replace('/', {})

}

function cancel() {
  console.log(`cancel 함수 호출됨`)

  router.replace('/', {})
}


</script>

<style scoped>


</style>
