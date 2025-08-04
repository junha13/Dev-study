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
      path: '/detailImage',
      name: 'detailImage',
      component: () => import('../views/DetailImageView.vue'),
    },
    {
      path:'/header',
      name: 'header',
      component: () => import('../views/HeaderView.vue'),
    },
    {
      path:'/signIn',
      name: 'signin',
      component: () => import('../views/SignInView.vue'),
    },
    {
      path:'/signUp',
      name: 'sigUp',
      component: () => import('../views/SignUpView.vue'),
    },
    {
      path:'/mypage',
      name: 'myPage',
      component: () => import('../views/MyPageView.vue'),
    },
    {
      path:'/stuArchive',
      name: 'stuArchive',
      component: () => import('../views/StuArchiveView.vue'),
    },
    {
      path:'/submit',
      name: 'submit',
      component: () => import('../views/SubmitView.vue'),
    },
    {
      path:'/addProject',
      name: 'addProject',
      component: () => import('../views/AddProjectView.vue'),
    },
    {
      path:'/tail',
      name: 'tail',
      component: () => import('../views/TailView.vue'),
    }
  ],
})

export default router