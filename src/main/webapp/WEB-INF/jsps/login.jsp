<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Spring world</title>
</head>
<body>

	<spring:url value="/welcome/login/submit" var="urlLoginSubmit" />
	<spring:url value="/welcome/userDetails" var="urlSearchUser" />
	<spring:url value="/user/addUser" var="urlAddUser" />

	<form:form class="form-horizontal" method="post"
		modelAttribute="loginForm" action="${urlLoginSubmit}">

		<spring:bind path="userName">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">User Name</label>
				<div class="col-sm-10">
					<form:input path="userName" class="form-control " id="userName"
						placeholder="Enter username" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="password">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Password</label>
				<div class="col-sm-10">
					<form:input path="password" class="form-control " id="password"
						placeholder="Enter Password" />
				</div>
			</div>
		</spring:bind>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn-lg btn-primary pull-right">Log In</button>
			</div>
		</div>
	</form:form>

	<div class="navbar-header">
		<a class="navbar-brand" href="${urlAddUser}">
			<button>Sign Up</button>
		</a>
	</div>

</body>
</html>