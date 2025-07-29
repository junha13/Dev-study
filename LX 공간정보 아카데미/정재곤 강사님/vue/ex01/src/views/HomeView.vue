<template>

  <div>
    <h1>홈 화면</h1>

    <div>
      <p clas="group1">안녕!</p>
      <img src="@/assets/images/back2.jpg">
      <!--사진 파일은 assets파일에 넣는거임-->
    </div>
    
    <div>
      <label>이름 : </label><input type="text" v-model="name">
      <br>
      <label>나이 : </label><input type="text" v-model="age">
      <br>
      <label>전화번호 : </label><input type="text" v-model="mobile">
      <br>

      <button @click="show()">확인</button>
    </div>
    <div>
      <p>{{ name }}</p>
      <p>{{ output1 }}</p>

    </div>
    <div>
      <input type="text" v-model = "inputA">
      <input type="text" v-model = "inputB">
      <button @click="add()">더하기</button>
      <p>더하기 결과 : {{ result1 }}</p>
    </div>

  </div>

</template>

<script setup>

import {ref} from 'vue'; // require 랑 비슷한 역할을 함..
// gpt) 📦 ref는 Vue 3에서 **반응형 데이터를 만들기 위한 함수**예요
// gpt) 값이 변경되면 화면에 자동으로 반영되는 반응형 상태를 만들 수 있어요

const name = ref('');
// gpt) ✍️ 사용자가 입력한 이름을 저장하는 반응형 변수예요
// gpt) 문자열을 초기값으로 넣었기 때문에 name.value는 ''로 시작해요

const output1 = ref(`결과 : `);
// gpt) 🖨️ 버튼 클릭 시 보여줄 출력 메시지를 위한 변수예요
// gpt) 문자열 초기값으로 시작하며, {{ output1 }}처럼 화면에 표시할 수 있어요

const inputA = ref('');
const inputB = ref('');
// gpt) 🔢 사용자로부터 입력받은 숫자 문자열을 저장해요

const result1 = ref(0);
// gpt) ✅ 계산 결과를 저장하는 숫자 상태예요
// gpt) 숫자형 초기값 0을 주면 result1.value도 number 타입으로 동작해요

function add() {
  const a = Number(inputA.value);
  const b = Number(inputB.value);
  // gpt) 문자열로 입력된 값을 Number로 변환해 계산할 수 있게 해요

  result1.value = a + b;
  // gpt) result1.value에 값을 할당하면 화면에 자동 반영돼요 (반응형!)
}

function show() {
  console.log(`show 함수 호출됨`);
  output1.value = `결과 : 이름`;
  // gpt) 버튼을 눌렀을 때 output1에 새로운 메시지를 넣는 동작이에요
}

</script>

<style scoped>

</style>

