import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'

import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'

import '/styles.css';
// 테일윈드 적용 안됨


const app = createApp(App)

app.use(createPinia())
app.use(router)

app.mount('#app')
