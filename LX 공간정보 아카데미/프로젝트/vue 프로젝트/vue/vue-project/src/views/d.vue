<template>

    <GoogleMap
        ref="mapRef"
        style="width: 100vw; height: 50vh;"
        :api-key="GOOGLE_MAP_KEY"
        :center="centerPoint"
        :zoom="zoomLevel"
        >
    <CustomMarker
        v-for="(item, index) in locations" :key="index"
        :options="{position : {lat:item.latitude, lng:item.longitude}, anchorPoint:'BOTTOM_CENTER' }"
    >
    <div>
        <div><span>{{ item.name }}</span></div>
        <img src="dd" width="60"></img>
    </div>

    </CustomMarker>

    </GoogleMap>

</template>

<script setup>
//구글맵 사용하기
import { GoogleMap, CustomMarker } from 'vue3-google-map'
import { ref, onMounted } from 'vue'

onMounted(() => {

    // 내위치 찍기
    getMyLocation()

    // 커피숍 찾기
    requestSearchCoffee();

})

async function requestSearchCoffee() {
    try {
        const response = await axios({
            method:'post',
            BaseUrl:'http://localhost:8080/',
            url:'coffee/v1/search-distance',
            data: {
                location1: `POINT(${longitude} ${latitude})`,
                location2: `POINT(${longitude} ${latitude})`,
                radius
            },
            timeout:500,
            type
        })
        console.log(`${JSON.stringify(response.data)}`)


    } catch(err) {
        console.log(err);
    }
}

function getMyLocation() {

    navigator.geolocation.getCurrentPosition((position) => {

        MyLocation.value = {
            lat: position.coords.latitude,
            lng: position.coords.longitude
        }

        console.log(`${JSON.stringify(MyLocation.value)}`)

    })
}



const MyLocation = ref({});

const GOOGLE_MAP_KEY = ''

const centerPoint = ref({ lat: 37, lng: 126})

const zoomLevel = 17

</script>
