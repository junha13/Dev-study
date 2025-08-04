<template>
	<HeaderView />
	<div class="mt-5 vw-100 position-relative">
		<div class="mt-lg-20 p-5 bg-light vw-100 position-relative">
			<div class="d-flex gap-3 mb-4 w-50 ms-3">
				<div class="dropdown flex-fill"> 
					<button v-if="!year" class="btn btn-secondary dropdown-toggle w-100" data-bs-toggle="dropdown">연도</button>
					<button v-else class="btn btn-secondary dropdown-toggle w-100" data-bs-toggle="dropdown">{{ year }}년</button>
					<!--드롭다운 메뉴를 누르면 ref변수에 값이 들어가면서 v-else로 빠지고 화면에 값 표시-->
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" @click="setYear(2017)">2017년</a></li>
						<li><a class="dropdown-item" @click="setYear(2018)">2018년</a></li>
						<li><a class="dropdown-item" @click="setYear(2019)">2019년</a></li>
						<li><a class="dropdown-item" @click="setYear(2020)">2020년</a></li>
						<li><a class="dropdown-item" @click="setYear(2021)">2021년</a></li>
						<li><a class="dropdown-item" @click="setYear(2022)">2022년</a></li>
						<li><a class="dropdown-item" @click="setYear(2023)">2023년</a></li>
						<li><a class="dropdown-item" @click="setYear(2024)">2024년</a></li>
						<li><a class="dropdown-item" @click="setYear(2025)">2025년</a></li>
					</ul>
				</div>
				<div class="dropdown flex-fill"> 
					<button v-if="!grade" class="btn btn-secondary dropdown-toggle w-100" data-bs-toggle="dropdown">학년</button>
					<button v-else class="btn btn-secondary dropdown-toggle w-100" data-bs-toggle="dropdown">{{ grade }}학년</button>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" @click="setGrade(1)">1학년</a></li>
						<li><a class="dropdown-item" @click="setGrade(2)">2학년</a></li>
						<li><a class="dropdown-item" @click="setGrade(3)">3학년</a></li>
						<li><a class="dropdown-item" @click="setGrade(4)">4학년</a></li>
					</ul>
				</div>
				<div class="dropdown flex-fill"> 
					<button v-if="!semester" class="btn btn-secondary dropdown-toggle w-100" data-bs-toggle="dropdown">학기</button>
					<button v-else class="btn btn-secondary dropdown-toggle w-100" data-bs-toggle="dropdown">{{ semester }}학기</button>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" @click="setSemester(1)">1학기</a></li>
						<li><a class="dropdown-item" @click="setSemester(2)">2학기</a></li>
				</ul>
				</div>
				<div class=" flex-fill"> 
					<button class="btn btn-secondary w-100" @click="search()">검색</button>
				</div>
				<div class=" flex-fill ms-20">
					<button v-if="id" class="btn btn-primary w-50 ms-20" @click="submit()">등록</button>
					<button v-else class="btn btn-primary w-50 ms-20" @click="alertId()">등록</button>
				</div>
			</div>

			<div class="row w-100 mx-0">
				<div class="col-5 px-2 mb-4" v-for="(Archive, index) in StuArchivelist" :key ="Archive.number">
					<div class="card w-100">
						<div class="row g-0">
							<div class="col-md-4">
								<img :src="'http://localhost:7004' + Archive.image" class="img-fluid rounded-start" alt="이미지"> <!--Archive.image는 (/uploads/)으로 되어 있음-->
							</div>
							<div class="col-md-8">
								<div class="card-body">
									<h5 class="card-title">제목 : {{ Archive.title }} ( {{ Archive.year }}년 - {{ Archive.semester }}학기 )</h5>
									<p class="card-text">{{ Archive.explanation }}</p>
									<p class="card-text">
										<small class="text-body-secondary">아이디 : {{ Archive.id }}</small>
									</p>
									<p>
										<button class="btn btn-light ms-auto btn-sm" @click="detailImage( Archive.image, Archive.title, Archive.id, Archive.number )">상세보기</button>
									</p>
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
import HeaderView from '../views/HeaderView.vue' // Headerview import
import {ref, onMounted} from 'vue';
import {useRouter, useRoute} from 'vue-router'

const route = useRoute();
const router = useRouter();
import axios from 'axios';

let id= ref('')
let year= ref('')
let grade= ref('')
let semester= ref('')
let StuArchivelist = ref([])

onMounted(async() => {
    id.value = route.query.id  // id 값 들고오기

    try {
        const response = await axios ({
            method:'get',
            url:'http://localhost:7004/stuArchiveSelectAll',
            data:{},
        })
        StuArchivelist.value = response.data.output
        } catch(err) {
            console.log(`오류 발생 --> ${err}`)
        }

})

function setYear(input) {
    year.value = input;
};

function setGrade(input) {
    grade.value = input;
};

function setSemester(input) {
    semester.value = input;
};

async function search() {
    console.log(`search 실행`)
    if (!year.value || !grade.value) {  // 밸류값 확인해서 없으면 경고
        alert('연도와 학년을 먼저 선택하세요')
    } else {
        try {
        const response = await axios ({
            method:'get',
            url:'http://localhost:7004/stuArchiveSelectWhere',
            data:{},
            params:{
                year:year.value,
                grade:grade.value,
                semester:semester.value
            }
        })
        StuArchivelist.value = response.data.output

        } catch(err) {
            console.log(`오류 발생 --> ${err}`)
        }

    }
};

function submit() {
    console.log(`submit 실행`)
    router.push({
        path:'/submit',
        query: {
            id:id.value
        }
    })

};

function detailImage(input, input2, input3, input4) {
    console.log(`detailImage 실행`)
    router.push({
        path:'/detailImage',
        query: {
            image:input,
            title:input2,
			arcID:input3,
			number:input4,
            id:id.value
        }
    })

};

function alertId() {
	alert('로그인 먼저 하세요')
}


</script>

<style scoped>
</style>


