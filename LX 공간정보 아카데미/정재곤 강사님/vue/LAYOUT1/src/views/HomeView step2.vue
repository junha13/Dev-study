

<template>



	<!--정렬하기-->
	
	<div class="d-flex flex-column">

		<!--align-items-center : 세로방향 중간정렬-->
		<div class="d-flex justify-content-center align-items-start bg-secondary my-border gap-2 p-10 w-400px h-200px">
			<button class="btn btn-primary">버튼1</button>
			<button class="btn btn-primary">버튼2</button>
			<button class="btn btn-primary">버튼3</button>

		</div>

		<div class="d-flex justify-content-between bg-secondary my-border gap-2 p-10">
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