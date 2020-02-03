<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JOIN</title>
</head>
<body>
	<h1>회원가입</h1>
	<table border="1">
		<tr>
			<th>username</th>
			<th>password</th>
			<th>email</th>
		</tr>
		<tr>
			<td><input id="username" type="text"></td>
			<td><input id="password" type="password"></td>
			<td><input id="email" type="email"></td>
		</tr>
	</table>
	<button id="mem_join_proc">수정하기</button>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

	<script>

	$('#mem_join_proc').on('click', function() {
		let data = {
			username : $('#username').val(),
			password : $('#password').val(),
			email : $('#email').val()	
		};

		$.ajax({
			type : 'POST',
			url : '/mem/api/join',
			data : JSON.stringify(data),
			contentType : 'application/json; charset=utf-8',
			dataType : 'json'
		}).done(function(){
				if(result == 'ok'){
					alert('회원정보가 삭제되었습니다!!');
				location.href='/mem';
				}else{
					alert('회원정보 삭제에 실패했습니다...')
				}
			}).fail(function(){
				alert('서버 오류');
			});
		});
	
	</script>
</body>
</html>