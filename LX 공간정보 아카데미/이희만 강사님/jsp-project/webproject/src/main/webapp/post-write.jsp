<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<style>
#post {
	text-align:center; 
	margin: 15px
}
input {
	width: 800px;
}
#text {
	margin-top: 15px;
	height: 500px;
}
</style>
</head>
<body>
	<div>
		<div id="post">
			<form>
				<div>
					<input id="title">
				</div>
				<div>
					<input id="location">
				</div>
				<div>
					<input id="dd">
				</div>
				<div id="textBox" contenteditable="true">  <!-- contenteditable는 div를 input처럼 사용할 수 있는 속성, true로 두면 속성 편집이 가능하다  -->
				</div>
				<div>
					<input id="tail">
				</div>
				<div>
					<button type="submit" id="acceptButton">작성 완료</button>
					<button type="button" id="deleteButton">취소</button>
				</div>
			</form>
		</div>
	</div>
	<script>
	$('#acceptButton').on('click', function() {
		let postValue = $('post input').val()
		let title = $('#title')
		if (title.val()==="") {
		alert("title 입력하세요")
		}
	})
	
	let text = $('#text').val();
	console.log('text')
	
	
	$('#textBox').on('change', function() {  // tlqkf
		let text = $('#text').val();
		$('#text').empty();
		console.log('text')
		let innerText = <span>text</span>
		$('#text').val);
	})
	
	
	
	$('post input').val()
	// 그 뭐야 이미지가 올려지면 그 위치에 올라가는? 
	
	</script>
</body>
</html>