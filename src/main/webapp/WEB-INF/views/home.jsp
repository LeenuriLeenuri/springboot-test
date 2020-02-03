<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
</head>
<body>

	<h1>Home에 오신 것을 환영합니다!</h1>

	<!-- 버튼 전송방식 중구난방으로 쓰지마라 -->
	<a href="/home/hello?id=ssar">hello 페이지로 이동 - href, get 방식</a>
	<br />


	<button id="hello-button">hello 페이지로 이동 - button, delete 방식</button>
	<br />


	<form>
		<input type="hidden" id="id" value="ssar">
	</form>
	<button id="hello-button-form">hello 페이지 이동 - form, post 방식</button>
	<br />

	<form>
		<input type="hidden" id="username" value="love"> <input
			type="hidden" id="phone" value="0102222">
	</form>
	<button id="hello-put-button">hello 페이지 이동 - put 방식</button>
	<br />


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script>
		// DELETE 호출
		$('#hello-button').on('click', function() {
			let data = {
				id : 'ssar'
			};

			$.ajax({
				type : 'DELETE',
				url : '/home/hello',
				data : JSON.stringify(data),
				contentType : 'application/json; charset=utf-8',
				dataType : 'json'
			}).done(function(result) {
				if (result.statusCode == 200) {
					alert('글이 삭제되었습니다.');
					location.href = '/home/hello';
				}
			}).fail(function(result) {
				alert('글 삭제를 실패 했습니다.')
			});
		});

		// POST 호출
		$('#hello-button-form').on('click', function() {
			// let id =$('#id').val();
			let data = {
				id : $('#id').val()
			};

			$.ajax({
				type : 'POST',
				url : '/home/hello',
				data : JSON.stringify(data),
				contentType : 'application/json; charset=utf-8',

				// 자바스크립트로 파싱해서 던져준다. 이게 없으면 json형식의 String이다.
				dataType : 'json'
			}).done(function(result) {
				if (result.statusCode == 200) {
					alert('글이 등록되었습니다.');
					location.href = '/home/hello';
				}
			}).fail(function(result) {
				alert('글 등록을 실패 했습니다.')
			});
		});

		// PUT 호출
		$('#hello-put-button').on('click', function() {
			let data = {
				username : $('#username').val(),
				phone : $('#phone').val()
			};

			$.ajax({
				type : 'PUT',
				url : '/home/hello',
				data : JSON.stringify(data),
				contentType : 'application/json; charset=utf-8',
				dataType : 'json'
			}).done(function(result) {
				if (result.statusCode == 200) {
					alert('글이 수정되었습니다.');
					location.href = '/home/hello';
				}
			}).fail(function(result) {
				alert('글 수정을 실패 했습니다.')
			});
		});
	</script>

</body>
</html>