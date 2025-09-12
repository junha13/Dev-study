<template>
  <div v-if="location">
    Your location data is {{ location.coords.latitude }}, {{ location.coords.longitude}}
  </div>
</template>
<script setup>

navigator.geolocation.getCurrentPosition(
  (position) => {
    const lat = position.coords.latitude;
    const lon = position.coords.longitude;
    console.log(`현재 위치: 위도 ${lat}, 경도 ${lon}`);
  },
  (error) => {
    console.error('위치 정보를 가져오는 데 실패했습니다:', error);
  },
  {
    enableHighAccuracy: true, // 정확도 향상 (배터리 사용량 증가 가능)
    timeout: 10000,
    maximumAge: 0
  }
);



</script>
<style scoped>

</style>