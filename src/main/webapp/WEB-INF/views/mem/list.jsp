<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>username</th>
			<th>password</th>
			<th>createTime</th>
			<th>edit</th>
		</tr>
		<c:forEach var="mem" items="${mems}">
			<tr>
				<td>${mem.username}</td>
				<td>${mem.password}</td>
				<td>${mem.createTime}</td>
				<td><button onclick="mem_update(${mem.id})">edit</button></td>
			</tr>

		</c:forEach>
	</table>
	<button onclick="join()">회원가입</button>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

	<script>
		function
		mem_update(mem_id)
		{
			location.href = '/mem/' + mem_id;
		}

		function join(){
			location.href = "/mem/join";
			}
	</script>

</body>
</html>