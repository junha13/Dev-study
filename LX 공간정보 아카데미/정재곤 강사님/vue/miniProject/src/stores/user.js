import { ref } from 'vue'
import { defineStore } from 'pinia'

export const useUserStore = defineStore('counter', () => {

  // ======== 로그인 유무 체크 =========
  let loginCheck = ref(false)

  // ======== post에 userID 담으려고 =========
  let user_Id = ref('')

  // ======== post PK ID =========
  let post_pkNumber = ref('')

  // ======== 헤더 유무 변수 =========
  let fullScreen = ref(true)

  // ======== add, modify =========
  let post = ref([])

  // ======== add, modify =========
  let mode = ref('')

  // ======== post modify 시 글 선택 =========
  let selectIndex = ref('')

  return { 
    loginCheck, user_Id, post_pkNumber, fullScreen, post, mode, selectIndex
  }
})

