<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>id</th>
			<th>username</th>
			<th>password</th>
			<th>email</th>
			<th>createTime</th>
		</tr>

		<tr>
			<td><input id="id" type="text" value="${mem.id}" readonly></td>
			<td><input type="text" value="${mem.username}" readonly></td>
			<td><input id="password" type="password" value="${mem.password}"></td>
			<td><input id="email" type="email" value="${mem.email}"></td>
			<td><input type="text" value="${mem.createTime}" readonly></td>
		</tr>

	</table>
	<button id="mem_update_proc">수정하기</button>
	<button id="mem_delete">삭제하기</button>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

	<script>

	$('#mem_update_proc').on('click', function(){
		let data={
			id : $('#id').val(),
			password : $('#password').val(),
			email : $('#email').val()		
				};

		$.ajax({
			type: 'PUT',
			url: '/mem/api/update',
			data: JSON.stringify(data),
			contentType: 'application/json; charset=utf-8',
			dataType: 'json'
			}).done(function(){
				if(result == 'ok'){
					alert('회원정보가 수정되었습니다!!');
				// DML 사용할 때는 ajax에서 직접 페이지 이동해줘야 한다!! (GET 빼고)
				location.href='/mem';
				}else{
					alert('회원정보 수정에 실패했습니다...')
				}
			}).fail(function(){
				alert('서버 오류');
			});
		});
	

	$('#mem_delete').on('click', function() {
		let data = {
			id : $('#id').val()
		};

		$.ajax({
			type : 'DELETE',
			url : '/mem',
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