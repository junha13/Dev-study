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
      component: () => import('../views/JoinView.vue'),
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../views/LoginView.vue'),
    },
    {
      path: '/myPage',
      name: 'myPage',
      component: () => import('../views/MyPageView.vue'),
    },
    {
      path: '/post-list',
      name: 'post-list',
      component: () => import('../views/PostListView.vue'),
    },
    {
      path: '/post-add',
      name: 'post-add',
      component: () => import('../views/PostAddView.vue'),
    }
  ],
})

export default router
