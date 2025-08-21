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
      path: '/about',
      name: 'about',
      component: () => import('../views/AboutView.vue'),
    },
    {
      path: '/course',
      name: 'course',
      component: () => import('../views/CourseView.vue'),
    },
    {
      path: '/mountain',
      name: 'mountain',
      component: () => import('../views/MountainView.vue'),
    },
    {
      path: '/report',
      name: 'report',
      component: () => import('../views/ReportView.vue'),
    },
    {
      path: '/community',
      name: 'community',
      component: () => import('../views/CommunityView.vue'),
    },
    {
      path: '/myPage',
      name: 'myPage',
      component: () => import('../views/MyPageView.vue'),
    },
    {
      path: '/myLocation',
      name: 'MyLocation',
      component: () => import('../views/MyLocationView.vue'),
    },
  ],
})

export default router
