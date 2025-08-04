<template>
	<HeaderView /> <!--app vue에 넣으면 새로고침 onmounted가 안됨-->
	<div class="mt-20 mb-20">
		<div class="mt-lg-10 mb-20">
			<div class="d-flex flex-row-fluid align-items-center" style="height: 420px;">
				<div class="d-flex flex-column-auto p-5 bg-light">
					<div id="carouselExampleCaptions" class="carousel slide mt-lg-20" style="max-width: 900px ">
						<div class="carousel-indicators">
							<button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
							<button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
						</div>
						<div class="carousel-inner">
							<div class="carousel-item active">
								<img src="/assets/media/image/mt.jpg" class="d-block w-100">
								<div class="carousel-caption d-none d-md-block">
									<h5>2024년 도시정보공학과 MT</h5>
								</div>
							</div>
							<div class="carousel-item">
								<img src="/assets/media/image/baaa.jpg" class="d-block w-100">
								<div class="carousel-caption d-none d-md-block">
									<h5 class="text-light">2024년 대학 연합 성과공유 전시회</h5>
								</div>
							</div>
						</div>
						<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
							<span class="carousel-control-prev-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Previous</span>
						</button>
						<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
							<span class="carousel-control-next-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Next</span>
						</button>
					</div>
				<!--begin::Col-->
					<div class="d-flex flex-column-fluid bg-secondary text-white p-5 mt-lg-20">
						<div class="card h-100">
							<div class="card-body p-10">
								<div class="fs-2hx fw-bold px-5">학부 설계팀</div>
								<div class="fs-4 fw-semibold text-gray-500 mb-10" >2025-1</div>
								<div class="fs-6 d-flex justify-content-between mb-8">
									<div class="fw-semibold">1학년</div>
									<div class="d-flex fw-bold">
										<i class="ki-duotone ki-arrow-up-right fs-3 me-1 mt-1 text-success">
											<span class="path1"></span>
											<span class="path2"></span>
										</i>10팀</div>
								</div>
								<div class="separator separator-dashed"></div>
								<div class="fs-6 d-flex justify-content-between my-8">
									<div class="fw-semibold">2학년</div>
									<div class="d-flex fw-bold">
										<i class="ki-duotone ki-arrow-down-left fs-3 me-1 mt-1 text-danger">
											<span class="path1"></span>
											<span class="path2"></span>
										</i>12팀</div>
								</div>
								<div class="separator separator-dashed"></div>
								<div class="fs-6 d-flex justify-content-between my-8">
									<div class="fw-semibold">3학년</div>
									<div class="d-flex fw-bold">
										<i class="ki-duotone ki-arrow-up-right fs-3 me-1 mt-1 text-success">
											<span class="path1"></span>
											<span class="path2"></span>
										</i>27팀</div>
								</div>
								<div class="separator separator-dashed"></div>
								<div class="fs-6 d-flex justify-content-between my-8">
									<div class="fw-semibold">4학년</div>
									<div class="d-flex fw-bold me-2">
										<i class="ki-duotone ki-arrow-up-right fs-3 me-1 mt-1 text-success">
											<span class="path1"></span>
											<span class="path2"></span>
										</i>8팀</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script setup>

import {ref, onMounted} from 'vue';
import {useRouter} from 'vue-router'
const router = useRouter();
import axios from 'axios';
import HeaderView from './HeaderView.vue';


</script>

<style scoped>

</style>

