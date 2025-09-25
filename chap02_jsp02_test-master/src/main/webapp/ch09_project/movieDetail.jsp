<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movieDetail.jsp</title>
</head>
<body>
	<h3>영화 상세 정보</h3>

	<table border="1">
		<tr>
			<th>제목</th>
			<td><%= title %></td>
		</tr>
		<tr>
			<th>제작자</th>
			<td><%= director %></td>
		</tr>
		<tr>
			<th>제작자</th>
			<td><%= releaseYear %></td>
		</tr>
	</table>
</body>
</html>