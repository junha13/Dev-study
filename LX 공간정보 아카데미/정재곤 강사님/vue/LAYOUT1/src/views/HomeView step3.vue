

<template>

<!--모바일 화면만들기, h-100: 화면의 높이값을 100%사용-->
<div class="d-flex flex-column h-100">

	<!--메인 영역, flex-glow-1: 남아있는 여유공간을 모두 차지함
		overflow-auto: 내용물이 화면 영역을 넘어가는 경우 스크롤이 자동으로 생김-->
	<div class="flex-glow-1 overflow-auto bg-secondary p-lg-20 h-90">
		
		<h1>메인 영역</h1>

		<p>여기에 메인 내용을 넣어줍니다.</p>
		<p>아래 하단 탭 위쪽까지 보이고, 내용이 많으면 스크랩합니다.</p>

	</div>



	<!--하단 탭, fixed-bottom: 화면 맨 아래에 고정시킴, justify-content-around 버튼들을 가로 방향으로 균등 배치함 -->

	<!--d-md-none 안보이게 하는거 d:display 길어지면 안보임 ㄷㄷ md사이즈라는 조건을 걸어서 -->
	<div class="fixed-bottom d-md-none bg-white border-top h-10">

		<div class="d-flex justify-content-around align-items-center py-3">

			<button class="btn btn-light d-flex flex-column align-items-center w-80px">
				<span>홈</span>
			</button>
			<button class="btn btn-light d-flex flex-column align-items-center w-80px">
				<span>찾기</span>
			</button>
			<button class="btn btn-light d-flex flex-column align-items-center w-80px">
				<span>문서</span>
			</button>
			<button class="btn btn-light d-flex flex-column align-items-center w-80px">
				<span>더보기</span>
			</button>


		</div>


	</div>
</div>


</template>


<script setup>

</script>

<style scoped>


.my-border {
	border: 2px dashed violet;


}
</style>