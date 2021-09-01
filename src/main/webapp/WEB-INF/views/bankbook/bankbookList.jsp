<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>
</head>
<body>
	<c:import url="../temp/boot_nav.jsp"></c:import>
	<h1>List Renewal</h1>
	<table>
		<tr>
			<th>Number</th><th>Name</th><th>Rate</th>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.bookNumber}</td>
					<td>${dto.bookName}</td>
					<td>${dto.bookRate}</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
</body>
</html>