<template>

<!--상단 타이틀 추가하기-->
  <div class="d-flex flex-column h-100">
    <div  v-if="!fullScreen">
      <div class="app-header d-flex align-items-center justify-content-between border-bottom border-3 border-secondary bg-white p-1 shadow-sm">
        <button class="w-80px btn btn-icon align-self-center" @click="tabButtonClicked('home')">
            <i class="ki-duotone ki-route fs-3x">
              <span class="path1"></span>
              <span class="path2"></span>
              <span class="path3"></span>
              <span class="path4"></span>
            </i>
        </button>
        <div class="w-550px d-flex align-self-center">
          <span class="fs-1 fw-bold">안전등산</span>
        </div>
        <button class="w-80px btn btn-icon" id="kt_app_sidebar_mobile_toggle">
          <i class="ki-duotone ki-abstract-14 fs-3x">
            <span class="path1"></span>
            <span class="path2"></span>
          </i>
      </button>
    </div>
  </div>

  <!--중앙애들-->
  <div class="d-flex flex-column flex-root app-root" id="kt_app_root">
    <RouterView />
  </div>
  	<!--하단 탭-->

	<!--border-top:위쪽 테두리 -->

 <!--:이 붙으면 어떤 상황에 있을 때를 말하는ㄱ임-->

 <!--호출되는 상황 이해하기-->
    <div  v-if="!fullScreen" class="fixed-bottom bg-white border-top h-10">

      <div class="menu menu-row d-flex justify-content-around py-2 fs-6 fw-bold cursor-pointer">

        <div class="menu-item flex-column align-items-center flex-fill mx-4 tab-btn"
             :class="(activeTab == 'course') ? 'active' : ''"
             @click="tabButtonClicked('course')">
          <span class="menu-icon mb-1">
            <i class="ki-duotone ki-compass fs-2x">
              <span class="path1"></span>
              <span class="path2"></span>
            </i>
          </span>
          <span class="menu-title">코스</span>
        </div>

        <div class="menu-item flex-column align-items-center flex-fill mx-4 tab-btn"
            :class="(activeTab == 'mountain') ? 'active' : ''"
             @click="tabButtonClicked('mountain')">
          <span class="menu-icon mb-1">
            <i class="ki-duotone ki-document fs-2x">
            <span class="path1"></span>
            <span class="path2"></span>
            </i>
          </span>
          <span class="menu-title">등산</span>
        </div>

        <div class="menu-item flex-column align-items-center flex-fill mx-4 tab-btn"
            :class="(activeTab == 'home') ? 'active' : ''"
             @click="tabButtonClicked('home')">
          <span class="menu-icon mb-1">
            <i class="ki-duotone ki-home fs-2x">
            </i>
          </span>
          <span class="menu-title">홈</span>
        </div>

        <div class="menu-item flex-column align-items-center flex-fill mx-4 tab-btn"
            :class="(activeTab == 'report') ? 'active' : ''"
             @click="tabButtonClicked('report')">
          <span class="menu-icon mb-1">
            <i class="ki-duotone ki-call fs-2x">
              <span class="path1"></span>
              <span class="path2"></span>
              <span class="path3"></span>
              <span class="path4"></span>
              <span class="path5"></span>
              <span class="path6"></span>
              <span class="path7"></span>
              <span class="path8"></span>
            </i>
          </span>
          <span class="menu-title">위험신고</span>
        </div>

        <div class="menu-item flex-column align-items-center flex-fill mx-4 tab-btn"
            :class="(activeTab == 'community') ? 'active' : ''"
             @click="tabButtonClicked('community')">
          <span class="menu-icon mb-1">
            <i class="ki-duotone ki-address-book fs-2x">
              <span class="path1"></span>
              <span class="path2"></span>
              <span class="path3"></span>
            </i>
          </span>
          <span class="menu-title">커뮤니티</span>
        </div>

      </div>

    </div>

  </div>


  <div v-if="fullScreen" class="fixed-bottom bg-white border-top">
    <div class="menu menu-row d-flex justify-content-around cursor-pointer py-2">
      <div class="menu-item flex-column align-items-center flex-fill tab-btn">
          <span class="menu-icon mb-1">
            <i class="ki-duotone ki-home fs-2x">
            </i>
          </span>
          <span class="menu-title">HOME</span>
      </div>
      <div class="menu-item flex-column align-items-center flex-fill">
        <i class="ki-duotone ki-geolocation fs-2x">
          <span class="path1"></span>
          <span class="path2"></span>
        </i>
          <span class="menu-title">내 위치</span>
      </div>
      <div class="menu-item flex-column align-items-center flex-fill">
          <span class="menu-icon mb-1">
            <i class="ki-duotone ki-home fs-2x">
            </i>
          </span>
          <span class="menu-title">MY</span>
      </div>
    </div>
  </div>

  <!-- 드로어 -->
  <div id="kt_drawer_basic1"
    class="bg-white d-flex flex-column drawer-hidden"
    data-kt-drawer="true"
    data-kt-drawer-activate="true"
    data-kt-drawer-toggle="#kt_app_sidebar_mobile_toggle"
    data-kt-drawer-width="{default: '250px', 'md': '500px'}"
    data-kt-drawer-direction="end" 
  >
  <!--start: 왼쪽, 오른쪽은 end로 바꾸면 됨-->

    <div class="p-5 border-bottom">
      <h3>메뉴</h3>
    </div>

    <div class="p-5">

      <div class="menu menu-column fs-6 fw-bold">

        <div class="menu-item">
          <div class="menu-link bg-light-primary text-primary px-4 py-2 rounded">
            <span class="menu-icon">
              <i class="ki-duotone ki-home fs-2x text-primary">
              </i>
            </span>
            <span class="menu-title m-2">홈</span>
          </div>
        </div>

        <div class="menu-item">
          <div class="menu-link bg-light-secondary text-dark px-4 py-2 rounded">
            <span class="menu-icon">
              <i class="ki-duotone ki-parcel-tracking fs-2x">
                <span class="path1"></span>
                <span class="path2"></span>
                <span class="path3"></span>
              </i>
            </span>
            <span class="menu-title m-2">찾기</span>
          </div>
        </div>

        <div class="menu-item">
          <div class="menu-link bg-light-secondary text-dark px-4 py-2 rounded">
            <span class="menu-icon">
              <i class="ki-duotone ki-document fs-2x">
                <span class="path1"></span>
                <span class="path2"></span>
              </i>
            </span>
            <span class="menu-title m-2">문서</span>
          </div>
        </div>

      </div>

    </div>

    <div class="m-10">

      <button class="btn btn-sm btn-primary" @click="closeDrawer()">닫기</button>

    </div>
  </div>







</template>

<script setup>

import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter();
let drawer;

import { storeToRefs } from 'pinia';

import { useCounterStore } from '@/stores/counter';
const counterStore =  useCounterStore();
const { fullScreen, activeTab } = storeToRefs(counterStore);


// 화면이 보이기 전에 한번 호출됨
onMounted(() => {
  console.log(`HomeView::onMounted 호출됨.`);

  activeTab.value = 'home'

  // Drawer 설정
  KTDrawer.createInstances();

  const drawerElem = document.querySelector('#kt_drawer_basic1');
  drawer = KTDrawer.getInstance(drawerElem);
  drawer.on('kt.drawer.shown', () => {
    console.log(`Drawer가 보여짐`);

    drawerElem.classList.remove('drawer-hidden');
  })
  drawer.on('kt.drawer.hidden', () => {
    console.log(`Drawer가 사라짐`);
    drawerElem.classList.add('drawer-hidden');
  })

})


// 드로어 안에 있는 [닫기] 버튼을 눌렀을 때
function closeDrawer() {
  console.log(`closeDrawer 호출됨`);

  if (drawer) {
    drawer.hide();
  }

}


// 하단 탭의 버튼이 눌렸을 때
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
  fullScreen.value = true
  router.push('/report');
}

function goToCommunity() {
  router.push('/community');
}

</script>

<style scoped>


.my-border {
  border: 2px dashed violet;
}

/* 드로어 */
.drawer-hidden {
  transform: translateX(-100%);
  visibility: hidden;
}

.drawer-shown {
  visibility: visible;
}

/* 탭버튼 */
.tab-btn {
  padding: 4px 8px;
  border-radius: 8px;
  transition: all 0.25s ease-in-out;
}

.tab-btn.active {
  background-color: rgba(15, 110, 253, 0.1);
  color: var(--bs-primary) !important;
  border-radius: 8px;
  transform: scale(1.1);
}

.tab-btn .menu-icon {
  transition: color 0.25s ease-in-out;
}

.tab-btn.active .menu-icon i {
  color: var(--bs-primary) !important;
}



</style>
