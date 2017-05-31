<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Users</title>
</head>
<body>


	<h1>Hello Spring MVC. Welcome!!!</h1>


	<table>
		<tr>
			<th>Name</th>
			<th>email</th>
			<th>address</th>
			<th>sex</th>
			<th>country</th>
		</tr>



		<c:forEach var="user" items="${userList}">

			<tr>

				<td><c:out value="${user.name}" />
				<td />
				<td><c:out value="${user.email}" />
				<td />
				<td><c:out value="${user.address}" />
				<td />
				<td><c:out value="${user.sex}" />
				<td />
				<td><c:out value="${user.country}" />
				<td />
			</tr>

		</c:forEach>
	</table>

</body>
</html>