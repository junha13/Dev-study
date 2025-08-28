import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/join',
      name: 'join',
      component: () => import('../views/user/JoinView.vue'),
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../views/user/LoginView.vue'),
    },
    {
      path: '/myPage',
      name: 'myPage',
      component: () => import('../views/user/MyPageView.vue'),
    },
    {
      path: '/user-modify',
      name: 'user-modify',
      component: () => import('../views/user/UserModifyView.vue'),
    },
    {
      path: '/archive',
      name: 'archive',
      component: () => import('../views/post/ArchiveView.vue'),
    },
    {
      path: '/post-detail',
      name: 'post-detail',
      component: () => import('../views/post/PostDetailView.vue'),
    },
    {
      path: '/post-add',
      name: 'post-add',
      component: () => import('../views/post/PostAddView.vue'),
    },
    {
      path: '/data-room',
      name: 'data-room',
      component: () => import('../views/community/DataRoomView.vue'),
    },
    {
      path: '/notice',
      name: 'notice',
      component: () => import('../views/community/NoticeView.vue'),
    },
    {
      path: '/news',
      name: 'news',
      component: () => import('../views/community/NewsView.vue'),
    },
    {
      path: '/description',
      name: 'description',
      component: () => import('../views/department/DescriptionView.vue'),
    },
    {
      path: '/history',
      name: 'history',
      component: () => import('../views/department/HistoryView.vue'),
    },
    {
      path: '/introduction',
      name: 'introduction',
      component: () => import('../views/department/IntroductionView.vue'),
    },
  ],
})

export default router
