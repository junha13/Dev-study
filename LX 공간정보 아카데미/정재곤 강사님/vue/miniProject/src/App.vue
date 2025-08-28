<template>

  
  <div class="d-flex flex-column h-100">

    <!-- ======== header ======== -->
    <div v-if="fullScreen" class="app-header d-flex justify-content-between border-bottom shadow p-2 bg-secondary">

        <!-- ======== 학교 로고 ======== -->
        <button class="h-100 p-2 btn">
          <img src="/images/anyangLogo.png" class="h-100" @click="goToHome()"></img>
        </button>

        <!-- ======== 햄버거 버튼 ======== -->
        <button class="btn btn-icon" id="kt_app_sidebar_mobile_toggle"> <!-- btn-icon 쓰니까 우로밀착 됨 왜지-->
          <i class="ki-duotone ki-abstract-14 fs-3x ">
            <span class="path1"></span>
            <span class="path2"></span>
          </i>
        </button>
    </div>
    <!-- ======== login, join 헤더 ======== -->
    <div v-if="!fullScreen" class="d-flex flex-column align-items-center">
      <img src="/images/han.jpg" class="w-100 border-top border-primary border-2 shadow-sm"></img>
        <button class="h-60px p-2 btn mt-10">
          <img src="/images/anyangLogo.png" class="h-100" @click="goToHome()"></img>
        </button>
    </div>




  
    <!-- ======== Main ======== -->
    <div class="d-flex flex-column flex-root app-root" id="kt_app_root">
      <RouterView />
    </div>

     <!-- ======== footer ======== -->
      <div class="w-100 bg-secondary h-125px shadow-lg">
        <div>
          <div class="w-100 d-flex flex-column align-items-center">
            <span class="fw-bold mt-3">안양캠퍼스 14028 경기 안양시 만안구 삼덕로37번길 22 (안양대학교) </span> <br /> <span class="mt-n4"> TEL 031-467-0700</span> <br />
            <span class="fw-bold">강화캠퍼스 23038 인천광역시 강화군 불은면 중앙로 602-14 </span> <br /> <span class="mt-n4"> TEL 032-930-6000</span>
          </div>
        </div>

      </div>

    <!--
         ======== footer ======== 
    <div class="fixed-bottom bg-white border-top shadow h-60px">
      <div class="d-flex justify-content-around h-100 ">

        ======== 아카이브 ========
        <div class="d-flex flex-column align-items-center flex-fill cursor-pointer tab-btn"
              :class="(activeTab == 'archive') ? 'active' : ''"
              @click="tabButtonClicked('archive')">
          <span class="mt-2">
            <i class="ki-duotone ki-home-2 fs-3x">
              <span class="path1"></span>
              <span class="path2"></span>
            </i>
          </span>
          <span class="fs-1x fw-bold">아카이브</span>
        </div>

         ======== 홈 ========
        <div class="d-flex flex-column align-items-center flex-fill cursor-pointer tab-btn"
              :class="(activeTab == 'home') ? 'active' : ''"
              @click="tabButtonClicked('home')">
          <span class="mt-2">
            <i class="ki-duotone ki-home-2 fs-3x">
              <span class="path1"></span>
              <span class="path2"></span>
            </i>
          </span>
          <span class="fs-1x fw-bold">홈</span>
        </div>

        <======== 로그인, 마이페이지 ========
        <div v-if="!loginCheck" class="d-flex flex-column align-items-center flex-fill cursor-pointer tab-btn"
              :class="(activeTab == 'login') ? 'active' : ''"
              @click="tabButtonClicked('login')">
          <span class="mt-2"> 
            <i class="ki-duotone ki-home-2 fs-3x">
              <span class="path1"></span>
              <span class="path2"></span>
            </i>
          </span>
          <span class="fs-1x fw-bold">로그인</span>
        </div>
        <div v-if="loginCheck" class="d-flex flex-column align-items-center flex-fill cursor-pointer tab-btn"
              :class="(activeTab == 'myPage') ? 'active' : ''"
              @click="tabButtonClicked('myPage')">
          <span class="mt-2"> 
            <i class="ki-duotone ki-home-2 fs-3x">
              <span class="path1"></span>
              <span class="path2"></span>
            </i>
          </span>
          <span class="fs-1x fw-bold">{{ userName }}</span>
        </div>
      </div>
    </div>
    -->
    
  </div>

 <!-- ======== 드로어 ======== -->
  <div id="kt_drawer_basic1"
      class="bg-white d-flex flex-column drawer-hidden"
      data-kt-drawer="true"
      data-kt-drawer-activate="true"
      data-kt-drawer-toggle="#kt_app_sidebar_mobile_toggle"
      data-kt-drawer-width="{default: '200px', 'md': '500px'}"
      data-kt-drawer-direction="end"
  >
    <div class="p-5 border-bottom">
      <h3 class="ms-2 mb-n1">메뉴</h3>
    </div>
    <div class="p-5">
      <div class="menu menu-column fs-6 fw-blod">

         <!-- ======== 로그인, 마이페이지 ======== -->
        <div class="menu-dropdown">
          <div class="menu-link px-4 py-1 border-bottom border-2 cursor-pointer">
            <span v-if="!loginCheck" class=" fw-bold" style="font-size: 17px;" @click="goToLogin()">로그인</span>
            <span v-if="loginCheck" class=" fw-bold" style="font-size: 17px;" @click="goToMyPage()">마이페이지</span>
          </div>
        </div>

         <!-- ======== 학과소개 ======== -->
        <div class="menu-dropdown">
          <div class=" px-4 py-1 border-bottom border-2 mt-5">
            <span class=" fw-bold" style="font-size: 17px;">학과소개</span>
          </div>
          <div class="bg-secondary shadow mt-2">
            <div class="menu-item ">
              <div class="menu-link mb-2" @click="goToIntroduction()">
                <span class="fw-bold">- 인사말</span>
              </div>
              <div class="menu-link mb-2" @click="goToDescription()">
                <span class="fw-bold">- 학과안내</span>
              </div>
              <div class="menu-link mb-2" @click="goToHistory()">
                <span class="fw-bold">- 연혁</span>
              </div>
            </div>
          </div>
        </div>

         <!-- ======== 아카이브 ======== -->
        <div class="menu-dropdown">
          <div class=" px-4 py-1 border-bottom border-2 mt-5">
            <span class=" fw-bold" style="font-size: 17px;">아카이브</span>
          </div>
          <div class="bg-secondary shadow mt-2">
            <div class="menu-item ">
              <div class="menu-link mb-2" @click="goToArchive()">
                <span class="fw-bold">- 학부설계</span>
              </div>
              <div class="menu-link mb-2" @click="goToArchive()">
                <span class="fw-bold">- 공모전</span>
              </div>
            </div>
          </div>
        </div>

         <!-- ======== 커뮤니티 ======== -->
        <div class="menu-dropdown">
          <div class=" px-4 py-1 border-bottom border-2 mt-5">
            <span class=" fw-bold" style="font-size: 17px;">커뮤니티</span>
          </div>
          <div class="bg-secondary shadow mt-2">
            <div class="menu-item ">
              <div class="menu-link mb-2" @click="goToNews()">
                <span class="fw-bold">- 학과소식</span>
              </div>
              <div class="menu-link mb-2" @click="gotoNotice()">
                <span class="fw-bold">- 공지사항</span>
              </div>
              <div class="menu-link mb-2" @click="goToDataRoom()">
                <span class="fw-bold">- 자료실</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>


<script setup>
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router';
import axios from 'axios'

const router = useRouter();

import { RouterView } from 'vue-router'

// stores
import { storeToRefs } from 'pinia';
import { useUserStore } from '@/stores/user';
const userStore =  useUserStore();
const { loginCheck, user_id, pkNumber, fullScreen } = storeToRefs(userStore);

const activeTab = ref('home')

let drawer;

onMounted(() => {
  console.log(`AppView :: onMounted 실행됨`)

  KTDrawer.createInstances();

  const drawerElem = document.querySelector('#kt_drawer_basic1');
  drawer = KTDrawer.getInstance(drawerElem);
  drawer.on('kt.drawer.shown', () => {
    console.log(`Drawer가 보여짐`);

    drawerElem.classList.remove('drawer-hidden');
  })

  drawer.on('kt.drawer.hidden', () => {
    console.log('Drawer가 사라짐');
    drawerElem.classList.add('drawer-hidden')
  })

})

function closeDrawer() {
  console.log(`closeDrawer 호출됨`)

  if (drawer) {
    drawer.hide()
  }
}


// ======== router push ========
function goToHome() {
  console.log(`goToHome 호출됨`)
  closeDrawer()

  fullScreen.value = true

  router.push('/')  
}

function goToArchive() {
  console.log(`goToArchive 호출됨`)
  closeDrawer()

  router.push('/archive')  
}

function goToLogin() {
  console.log(`goToLogin 호출됨`)
  closeDrawer()

  router.push('/login')  
}

function goToMyPage() {
  console.log(`goToMyPage 호출됨`)
  closeDrawer()

  router.push('/myPage')  
}

function goToDataRoom() {
  console.log(`goToDataRoom 호출됨`)
  closeDrawer()

  router.push('/data-room')  
}

function goToNews() {
  console.log(`goToNews 호출됨`)
  closeDrawer()

  router.push('/news')  
}

function gotoNotice() {
  console.log(`gotoNotice 호출됨`)
  closeDrawer()

  router.push('/notice')  
}

function goToDescription() {
  console.log(`goToDescription 호출됨`)
  closeDrawer()

  router.push('/description')  
}

function goToHistory() {
  console.log(`goToHistory 호출됨`)
  closeDrawer()

  router.push('/history')  
}

function goToIntroduction() {
  console.log(`goToIntroduction 호출됨`)
  closeDrawer()

  router.push('/introduction')  
}



</script>

<style scoped>
/* drawer */
.drawer-hidden {
  transform: translateX(100%);
  visibility: hidden;
}

.drawer-shown {
  visibility: visible;
}


</style>
