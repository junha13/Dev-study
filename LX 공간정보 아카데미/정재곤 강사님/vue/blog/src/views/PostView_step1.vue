<template>

  <div class="px-4 py-2" style="background-color: #eeeeee; margin-bottom: 160px;">

    <div>

      <div v-for="(item, index) in posts" :key="item.id" class="card postcard">

        <div class="card-body m-0 p-0">
          <img :src="item.thumbnail">

          <div class="p-4">
            <h5 class="fw-bold fs-3">{{ item.title }}</h5>
            <span class="text-muted">{{ item.contents }}</span>
          </div>
        </div>

        <div class="card-footer d-flex justify-content-between align-items-center py-5">
          <span class="d-flex align-items-center text-gray-600 fs-5">
            <i class="ki-duotone ki-like text-primary fs-2x me-2">
              <span class="path1"></span>
              <span class="path2"></span>
            </i>
            <span>{{ item.likes }}</span>
          </span>

          <span class="d-flex align-items-center text-gray-600 fs-5">
            <i class="ki-duotone ki-message-notif text-primary fs-2x me-2">
              <span class="path1"></span>
              <span class="path2"></span>
              <span class="path3"></span>
              <span class="path4"></span>
              <span class="path5"></span>
            </i>
            <span>{{ item.comments }}</span>
          </span>

          <span class="badge badge-light-primary px-4 py-2 fs-5">{{ item.category }}</span>
          <span class="text-muted">{{ item.createDate }}</span>

        </div>

      </div>
  
    </div>

    <div class="fixed-bottom px-10 pt-5 pb-8" style="background-color: #eeeeee; margin-bottom: 69px;">
      <button class="btn btn-light-primary w-100 mt-3 fs-1" @click="goToPostWrite()">
        <i class="ki-duotone ki-plus fs-2x me-2">
        </i> 
        <span>새 게시물 작성</span>
      </button>
    </div>
    
  </div>

</template>

<script setup>

import { ref, onMounted } from 'vue'

// 라우터
import { useRouter } from 'vue-router'
const router = useRouter();

// 스토어 불러오기
import { storeToRefs } from 'pinia'

import { useAppStore } from '@/stores/app'
const appStore = useAppStore();
const { title } = storeToRefs(appStore);


// 게시글 목록을 위한 변수
const posts = ref([
  {
    id: 1,
    title: '게시물 1',
    contents: '게시물 내용입니다.',
    category: '취미',
    createDate: '1시간전',
    likes: 3,
    comments: 1,
    thumbnail: '/assets/media/books/2.png'
  },
  {
    id: 2,
    title: '게시물 2',
    contents: '게시물 내용입니다.',
    category: '생활',
    createDate: '3시간전',
    likes: 2,
    comments: 3,
    thumbnail: '/assets/media/books/12.png'
  },
  {
    id: 3,
    title: '게시물 3',
    contents: '게시물 내용입니다.',
    category: '취미',
    createDate: '2025-08-20',
    likes: 7,
    comments: 5,
    thumbnail: '/assets/media/books/13.png'
  }
])


onMounted(() => {
  console.log(`DocumentView::onMounted 호출됨`);

  title.value = '게시물';

})


// 새 게시글 작성 화면으로
function goToPostWrite() {
  router.push('/post-write');
}


</script>

<style scoped>

  .postcard {
    border: none;
    border-radius: 0.75rem;
    box-shadow: 0 2px 8px rgba(0,0,0,0.05);
    margin-top: 1rem;
    margin-bottom: 1rem;
    transition: transform 0.2s;
  }

  .postcard:hover {
    transform: translateY(-5px);
  }

  .postcard img {
    border-radius: 0.5rem;
    object-fit: cover;
    height: 180px;
    width: 100%;
  }

</style>
