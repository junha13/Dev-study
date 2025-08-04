<template>
    <div class="d-flex flex-column flex-root app-root" id="kt_app_root">
    	<div class="app-page flex-column flex-column-fluid" id="kt_app_page">
			<!--begin::Header-->
			<div id="kt_app_header" class="app-header" data-kt-sticky="true" data-kt-sticky-activate="{default: true, lg: true}" data-kt-sticky-name="app-header-minimize" data-kt-sticky-offset="{default: '200px', lg: '0'}" data-kt-sticky-animation="false">
				<!--begin::Header container-->
				<div class="app-container container-xxl d-flex align-items-stretch bg-secondary" id="kt_app_header_container">
					<!--begin::Logo-->
					<div class="d-flex align-items-center flex-grow-1 flex-lg-grow-0 me-lg-15">
						<a @click.prevent="goToMain()">
							<img alt="Logo" src="/assets/media/logos/logologo.png" class="h-30px h-lg-50px app-sidebar-logo-default theme-light-show" />
						</a>
					</div>
					<!--end::Logo-->
					<!--begin::Header wrapper-->
					<div class="text-center">
						<!--begin::Menu wrapper-->
						<div class="app-header-menu app-header-mobile-drawer align-items-stretch" data-kt-drawer="true" >
							<!--begin::Menu-->
							<div class="menu d-flex menu-rounded menu-row my-5 my-lg-4 align-items-stretch fw-semibold px-2 px-lg-0 " id="kt_app_header_menu" data-kt-menu="true">
								<!--data-kt-menu="true"  =  드롭다운 메뉴 초기화용 데이터 속성-->
								<!--begin:Menu item (학과소개)-->
								<div data-kt-menu-trigger="{default: 'click', lg: 'hover'}" data-kt-menu-placement="bottom-start" class="menu-item me-0 me-lg-2 me-auto">
									<span class="menu-link">
										<span class="menu-title text-ifo">학과소개</span>
										<span class="menu-arrow d-lg-none"></span> <!--992px 이하에서 보이는 모양-->
									</span>
									<div class="menu-sub menu-sub-lg-dropdown px-lg-2 py-lg-4 w-lg-150px">
										<div class="menu-item">
											<a class="menu-link" @click="goToMain()">
												<span class="menu-title">인사말</span>
											</a>
										</div>
										<div class="menu-item">
											<a class="menu-link" @click="goToMain()">
												<span class="menu-title">학과안내</span>
											</a>
										</div>
										<div class="menu-item">
											<a class="menu-link" @click="goToMain()">
												<span class="menu-title">연혁</span>
											</a>
										</div>
									</div>
								</div>
								<!--end:Menu item (학과소개)-->
								<!--begin:Menu item (아카이브)-->
								<div data-kt-menu-trigger="{default: 'click', lg: 'hover'}" data-kt-menu-placement="bottom-start" class="menu-item me-0 me-lg-2">
									<span class="menu-link">
										<span class="menu-title">아카이브</span>
										<span class="menu-arrow d-lg-none"></span>
									</span>
									<div class="menu-sub menu-sub-lg-dropdown px-lg-2 py-lg-4 w-lg-150px">
										<div class="menu-item">
											<a class="menu-link" @click="goToStuArchive()">
												<span class="menu-title">학부설계</span>
											</a>
										</div>
										<div class="menu-item">
											<a class="menu-link" @click="goToMain()">
												<span class="menu-title">공모전</span>
											</a>
										</div>
									</div>
								</div>
								<!--end:Menu item (아카이브)-->
								<!--begin:Menu item (커뮤니티)-->
								<div data-kt-menu-trigger="{default: 'click', lg: 'hover'}" data-kt-menu-placement="bottom-start" class="menu-item me-0 me-lg-2">
									<span class="menu-link">
										<span class="menu-title">커뮤니티</span>
										<span class="menu-arrow d-lg-none"></span>
									</span>
									<div class="menu-sub menu-sub-lg-dropdown px-lg-2 py-lg-4 w-lg-150px">
										<div class="menu-item">
											<a class="menu-link" @click="goToMain()">
												<span class="menu-title">학과소식</span>
											</a>
										</div>
										<div class="menu-item">
											<a class="menu-link" @click="goToMain()">
												<span class="menu-title">공지사항</span>
											</a>
										</div>
										<div class="menu-item">
											<a class="menu-link" @click="goToAddProject()">
												<span class="menu-title">자료실</span>
											</a>
										</div>
									</div>
								</div>
								<!--end:Menu item (커뮤니티)-->
								<div data-kt-menu-trigger="{default: 'click', lg: 'hover'}" data-kt-menu-placement="bottom-start" class="menu-item ms-auto me-0 me-lg-2">
									<span class="menu-link">
										<a v-if="!loginUser" class="menu-title" @click.prevent="goToLogin()">로그인</a>  <!--v-if를 사용하여 로그인 여부 체크-->
										<a v-else class="menu-title" @click="myPage()">{{ loginUser }}</a> <!--다음엔 세션을 활용해 해보기-->
										<span class="menu-arrow d-lg-none"></span>
									</span>
                                        
								</div>
							</div>
							<!--end::Menu-->
						</div>
						<!--end::Menu wrapper-->
					</div>
					<!--end::Header wrapper-->
				</div>
				<!--end::Header container-->
			</div>
        </div>
    </div>
</template>

<script setup>
import {ref, onMounted} from 'vue';
import {useRouter, useRoute} from 'vue-router'

const router = useRouter();
const route = useRoute();
import axios from 'axios';

let loginUser = ref(``)

onMounted (() => {
	if (window.KTMenu) window.KTMenu.init() // data-kt-menu="true"가 붙은 요소를 찾아 메뉴 기능을 활성화(초기화) 페이지 이동 시 드롭다운 메뉴가 안뜨던 현상 해결

	loginUser.value = route.query.id
})

async function goToMain() { // 메인 페이지로
  	router.push({
    path: '/',
	query: {id:loginUser.value}
  	})
}
async function goToLogin() { // 로그인 페이지로
  	router.push({
    path: '/signIn'
  	})
}

async function myPage() { // 마이 페이지로
  	router.push({
    path: '/myPage',
	query: {id:loginUser.value}
  	})
}

async function goToStuArchive() { // 학부설계 페이지로
  	router.push({
    path: '/stuArchive',
	query: {id:loginUser.value}
  	})
}

async function goToAddProject() { // 공모전 페이지로
  	router.push({
    path: '/addProject',
	query: {id:loginUser.value}
  	})
}



</script>

<style>
</style>