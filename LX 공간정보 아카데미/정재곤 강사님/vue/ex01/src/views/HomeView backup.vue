<template>

  <div>
    <h1>홈 화면</h1>

    <div>
      <p clas="group1">안녕!</p>
      <img src="@/assets/images/back2.jpg">
      <!--사진 파일은 assets파일에 넣는거임-->
    </div>
    
    <div>
      <label>이름 : </label><input type="text" id="input1">
      <br>
      <label>나이 : </label><input type="text" id="input2">
      <br>
      <label>전화번호 : </label><input type="text" id="input3">
      <br>

      <button @click="show()">확인</button>
    </div>
    <div id="output1">

    </div>

  </div>

</template>


<script setup>
  function show() {
    console.log(`show 함수 호출됨`)
    const input1 = document.querySelector('#input1')  
    const name = input1.ariaValueMax;

    const output1 = document.querySelector('#input1')  
    output1.innerHTML = `<p>입력된 값 : ${name}</p`;
    // 뷰, 리액트는 이런 방법을 권장하지 않음

  }


</script>



<style scoped>



</style>

