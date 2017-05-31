<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The User you looking for </title>
</head>
<body>

				<spring:url value="/welcome/userDetails" var="urluserDetails" />
               
				<form:form class="form-horizontal" method="post" modelAttribute="searchUser" action="${urluserDetails}">
                  <spring:bind path="id">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Enter Id</label>
					<div class="col-sm-10">
						<form:input path="id" class="form-control " id="id" placeholder="Enter Id" />
						<form:errors path="id" class="control-label" />
					</div>
				</div>
			</spring:bind>
            
            <spring:bind path="name">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Name</label>
					<div class="col-sm-10">
						<form:input path="name"  class="form-control " id="name" placeholder="Name" />
						<form:errors path="name" class="control-label" />
					</div>
				</div>
            </spring:bind>
            
            <div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn-lg btn-primary pull-right">Search User</button>
				</div>
			</div>
         
  
    </form:form>


</body>
</html>