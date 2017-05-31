<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> User details</title>
</head>
<body>

      <h1> login successfull. Your details are as follows</h1>

<table>
		<tr>
			<th>Username</th>
			<th>email</th>
			<th>address</th>
		    <th>sex</th>
	        <th>country</th>
		</tr>
	<tr>
		     
		  
				  
				 <td>    <c:out value="${userBean.name}"/>        <td/>
			 	 <td>    <c:out value="${userBean.email}"/>     <td/>
				 <td>    <c:out value="${userBean.address}"/>          <td/>
				 <td>    <c:out value="${userBean.sex}"/>     <td/>
				 <td>    <c:out value="${userBean.country}"/>     <td/>
		</tr>


</table>

</body>
</html>