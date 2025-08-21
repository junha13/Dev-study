

<template>



	<!--Flex를 이용해 쌓기, d-flex : flex를 사용함, 기본은 가로로 쌓기(flex-row), 세로로 쌓기(flex-column)-->
	<!--자식 태그에 해당이 되는 거임-->
	
	<div class="d-flex flex-column">

		<div class="d-flex bg-secondar my-border gap-2 p-10">
			<button class="btn btn-primary">버튼1</button>
			<button class="btn btn-primary">버튼2</button>
			<button class="btn btn-primary">버튼3</button>

		</div>

		<div class="d-flex flex-column bg-secondary my-border">
			<button class="btn btn-primary">버튼1</button>
			<button class="btn btn-primary">버튼2</button>
			<button class="btn btn-primary">버튼3</button>
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