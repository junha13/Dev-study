import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { // 홈 화면
      path: '/',
      name: 'home',
      component: HomeView,  // 첫 화면을 불러오는 건 미리 import를 해두는 거임  그 이후에 다른 경로를 요청하면 그때 import를 하는거고
    },
    { // 정보 화면
      path: '/about',
      name: 'about',
      component: () => import('../views/AboutView.vue'),
    },
    { // 메뉴 화면
      path: '/menu',
      name: 'menu',
      component: () => import('../views/MenuView.vue'),
    },
  ],
})

export default router
