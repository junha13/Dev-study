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
      path: '/insert',
      name: 'insert',
      component: () => import('../views/InsertView.vue'),
    },
    {
      path: '/update',
      name: 'update',
      component: () => import('../views/UpdateView.vue'),
    },
  ],
})

export default router
