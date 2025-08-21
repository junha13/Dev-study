import { ref } from 'vue'
import { defineStore } from 'pinia'

export const useCounterStore = defineStore('counter', () => {
  const activeTab = ref('')
  const fullScreen = ref(false);
    
    return {
      activeTab, fullScreen
    }
})