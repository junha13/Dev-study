<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<script>
		//$(document).ready(function() {  // 이걸로 감싸면 바디가 다 실행이 되고 나서 실행됨
		//	$('p').on('click', function() {  // 이 함수가 바인딩하기 위해서는 선택자가 있어야됨. 그리고 순서대로 진행되기때문에 위에 있으면 안됨
		//		alert('myp');
		//	});
		//});
		//window.onload = function() {  // 이걸로 감싸면 바디가 다 실행이 되고 나서 실행됨
		//	$('p').on('click', function() {  // 이 함수가 바인딩하기 위해서는 선택자가 있어야됨. 그리고 순서대로 진행되기때문에 위에 있으면 안됨
		//		alert('myp');
		//	});
		//};
		
		console.log('head');
		window.onload = function() { console.log('onload')};
		$(document).ready(function() { console.log('document.ready')});
	</script>
</head>
<body>
	<p>this is p</p>
	<script> // 3개가 다 동작이 똑같음
		$(function() {  // $(document).ready(function()) 이랑 똑같음
			$('p').on('click', function() { // 이 함수가 바인딩하기 위해서는 선택자가 있어야됨. 그리고 순서대로 진행되기때문에 위에 있으면 안됨
				alert('myp');
			console.log('()');
			});
		});
	</script>
	
	<p>this is p</p>
	<script>
		console.log('end of body');
	</script>
</body>
</html>