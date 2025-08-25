

<template>

	<!--메인 영역-->
	<div class="flex-grow-1 overflow-auto p-5 ">

		<div>
			<div class="d-flex flex-row flex-fill justify-content-between h-475px">
				<div class="text-white w-50"> <!-- w-50 // 부모 너비의 50퍼만 사용한다는 뜻 flex-fill은 문자열이 남은 공간을 밀어내며 커짐-->
					<div class="d-flex flex-column">
						<div class="h-350px p-2 cursor-pointer"> <!--paddig같은 경우엔 부모에 걸어주는게 효과적임 그리고 너비나 높이설정도 미리 하면 좋음-->
							<div class="w-100 h-100 rounded-3" style="position: relative;" @click="tabButtonClicked('course')"> <!--그랬을때 자식은 부모의 %로 적용하는게 나중에 볼때 좋음-->
                    <!-- 
                      📌 position:relative
                      - 이 div를 기준점으로 삼음
                      - 안쪽 absolute 박스(top/left 등)는 이 div의 좌표(0,0)부터 계산됨
                    -->
                <img src="/src/assets/images/a.png" class="w-100 h-100 rounded-3"></img>
                    <div class="p-3 h-100 w-100 position-absolute" style="z-index:1; top:0; left:0;">
                      <!-- 
                        📍 위치 잡는 방법 정리
                        
                        1) top:0; left:0;
                          → 부모의 "왼쪽 위 모서리"에 고정

                        2) top:50%; left:50%;
                          → 부모의 "가로·세로 중앙점"에
                              자식 박스의 "왼쪽 위 모서리"를 맞춤
                          (→ 텍스트가 오른쪽·아래로 치우쳐 보임)

                        3) top:50%; left:50%; transform:translate(-50%, -50%);
                          → 부모의 정중앙에
                              자식 박스의 "가운데"가 정확히 오도록 보정
                          (화면 크기가 변해도 항상 중앙 유지)
                      -->
                      <span class="fs-1 fw-bold title">오늘의 등산로</span><br>
                      <span class="fs-4">등산로 보기</span>
                  </div>
							</div>
						</div>
						<div class="h-125px p-2 cursor-pointer"> <!--paddig같은 경우엔 부모에 걸어주는게 효과적임 그리고 너비나 높이설정도 미리 하면 좋음-->
							<div class="w-100 h-100 rounded-3" style="z-index: 30; position: relative;" @click="tabButtonClicked('mountain')"> <!--그랬을때 자식은 부모의 %로 적용하는게 나중에 볼때 좋음-->
                <img src="/src/assets/images/c.png" class="w-100 h-100 rounded-3"></img>
                    <div class="p-3 h-100 w-100 position-absolute" style="z-index:1; top:0; left:0;">
                      <span class="fs-1 fw-bold title" >등산</span><br></br>
                      <span class="fs-4">나만의</span><br>
                      <span class="fs-4">등산기록</span>
                    </div>
							</div>
						</div>
					</div>
				</div>
				<div class="text-white w-50">
					<div class="d-flex flex-column">
						<div class="h-200px p-2 cursor-pointer"> <!--paddig같은 경우엔 부모에 걸어주는게 효과적임 그리고 너비나 높이설정도 미리 하면 좋음-->

							<div class="w-100 h-100 rounded-3" style="z-index: 30; position: relative;"> <!--그랬을때 자식은 부모의 %로 적용하는게 나중에 볼때 좋음-->
                <img src="/src/assets/images/b.png" class="w-100 h-100 rounded-3"></img>
                    <div class="p-3 h-100 w-100 position-absolute" style="z-index:1; top:0; left:0;">
                      <span class="fs-1 fw-bold title" >민원신청</span><br></br>
                      <span class="fs-4">불편, 개선사항 접수</span>
                  </div>
							</div>
						</div>
						<div class="h-150px p-2 cursor-pointer"> <!--paddig같은 경우엔 부모에 걸어주는게 효과적임 그리고 너비나 높이설정도 미리 하면 좋음-->

							<div class="w-100 h-100 rounded-3" style="z-index: 30; position: relative;" @click="tabButtonClicked('report')"> <!--그랬을때 자식은 부모의 %로 적용하는게 나중에 볼때 좋음-->
                <img src="/src/assets/images/d.png" class="w-100 h-100 rounded-3"></img>
                    <div class="p-3 h-100 w-100 position-absolute" style="z-index:1; top:0; left:0;">
                      <span class="fs-1 fw-bold title" >긴급</span><br></br>
                      <span class="fs-4">SOS 신고</span>
                  </div>
							</div>
						</div>
						<div class="h-125px p-2 cursor-pointer"> <!--paddig같은 경우엔 부모에 걸어주는게 효과적임 그리고 너비나 높이설정도 미리 하면 좋음-->

							<div class="w-100 h-100 rounded-3" style="z-index: 30; position: relative;" @click="tabButtonClicked('community')"> <!--그랬을때 자식은 부모의 %로 적용하는게 나중에 볼때 좋음-->
                <img src="/src/assets/images/e.png" class="w-100 h-100 rounded-3"></img>
                    <div class="p-3 h-100 w-100 position-absolute" style="z-index:1; top:0; left:0;">
                      <span class="fs-1 fw-bold title" >커뮤니티</span><br></br>
                      <span class="fs-4">#오등완</span><br></br>
                      <span class="fs-4">#등린이</span>
                  </div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
    <div class="p-2 mt-3">
      <div>
        <span class="fs-1 fw-bold title">어서와 등산은 처음이지? 😎</span>
      </div>
      <div>
        <div>
          <span class="fs-4">요즘 뜨는 등산멘토</span>
        </div>
        <div class="d-flex flex-row align-items-center mento-images">
          <div v-for="(image, index) in images" :key="image.image" class="ms-3">
            <img :src="image.image" class="w-95px rounded-circle border border-2 border-secondary shadow cursor-pointer"></img>
          </div>
        </div>
      </div>
      <div class="h-200px">
        <div class="">
          <span class="fs-1 fw-bold title">지금 가장 핫한 게시물 🧡</span>
        </div>
        <div class="d-flex flex-row">
            <img src="/src/assets/images/han.jpg" class="w-50 h-130px p-1 cursor-pointer"></img>
            <img src="/src/assets/images/zi.jpg" class="w-50 h-130px p-1 cursor-pointer"></img>
        </div>
      </div>
    </div>
  </div>




</template>


<script setup>
import { storeToRefs } from 'pinia';

import { useCounterStore } from '@/stores/counter';
import { ref, onMounted } from 'vue';
const counterStore =  useCounterStore();
const { activeTab } = storeToRefs(counterStore);

import { useRouter } from 'vue-router'

const router = useRouter();

onMounted(() => {
  activeTab.value = 'home'
})

const images = ref([
  {
    image:"/src/assets/images/hrr.jpg"
  },
  {
    image:"/src/assets/images/bp.png"
  },
  {
    image:"/src/assets/images/faker.jpg"
  },
  {
    image:"/src/assets/images/bong.jpg"
  },
  {
    image:"/src/assets/images/son.jpg"
  },
  {
    image:"/src/assets/images/hrr.jpg"
  },
])


function tabButtonClicked(name) {
  console.log(`tabButtonClicked 호출됨`);

  activeTab.value = name;

  if (name == 'home') {
    goToHome();
  } else if(name == 'course') {
    goToCourse();
  } else if(name == 'mountain') {
    goToMountain();
  } else if(name == 'report') {
    goToReport();
  } else if(name == 'community') {
    goToCommunity();
  }
}

function goToHome() {
  router.push('/');
}

function goToCourse() {
  router.push('/course');
}

function goToMountain() {
  router.push('/mountain');
}

function goToReport() {
  router.push('/report');
}

function goToCommunity() {
  router.push('/community');
}

</script>

<style scoped>
/*
overflow를 hidden으로 뒀다가 hover때 auto로 두면 
다시 밖으로 나왔을때도 스크롤 위치를 기억함
*/

.mento-images {
  overflow:hidden;
}
.mento-images:hover {
  overflow:auto;
  padding: 0px;
  margin: 0px;
}


</style>