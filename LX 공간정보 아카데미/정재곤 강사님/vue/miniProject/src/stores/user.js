import { ref } from 'vue'
import { defineStore } from 'pinia'

export const useUserStore = defineStore('counter', () => {
  let loginCheck = ref(false)
  let userName = ref('')
  let pkNumber = ref('')

  return { 
    loginCheck, userName, pkNumber
  }
})

