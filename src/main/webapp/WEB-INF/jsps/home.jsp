<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
table {
    style="table-layout:fixed"
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>

<title>Hello</title>

</head>

<body>
	<h1>Hello Spring MVC. Welcome!!!</h1>
	
	
	<table>
		<tr>
			<th>Source</th>
			<th>Status</th>
			<th>Sort</th>
		    <th>Artcile Author</th>
	        <th>Artcile title</th>
			<th>Artcile Url</th>
			<th>Artcile url at image</th>
			<th>Artcile published date</th>
	
		</tr>
	
	<c:set var="articles" value="${news.articles}" />
	
	<c:forEach var="article" items="${articles}" >
		 
		 <tr>
		     
				 <td>    <c:out value="${news.status}"/>        <td/>
			 	 <td>    <c:out value="${news.source}"/>     <td/>
				 <td>    <c:out value="${news.sort}"/>          <td/>
				 <td>    <c:out value="${article.author}"/>     <td/>
				 <td>    <c:out value="${article.title}"/>     <td/>
				<td>     <c:out value="${article.url}"/>       <td/>
		        <td>    <c:out value="${article.urlToImage}"/>        <td/>
		        <td>    <c:out value="${article.publishedAt}"/>        <td/>
		</tr>
		
	</c:forEach>
	<c:set var="sourceVal" value="${news.source}" />
		

  </table>
	
	<!-- <input type="button"  onclick="location.href='/addUser'" value="Register" > -->
	
	<!-- <form action="/welcome/addUser" method="GET">
	    <input type="submit" name="action" value="REgister User" onclick="location.href='addUser'" />
	</form> -->
	
	<spring:url value="/welcome/home" var="urlHome" />
	<spring:url value="/welcome/addUser" var="urlAddUser" />
	
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="${urlHome}">Spring MVC Form</a>
			</div>
			<div id="navbar">
				<ul class="nav navbar-nav navbar-right">
					<li class="active">
						<a href="${urlAddUser}">Add User</a>
					</li>
				</ul>
			</div>
		</div>
	
</body>

</html>
