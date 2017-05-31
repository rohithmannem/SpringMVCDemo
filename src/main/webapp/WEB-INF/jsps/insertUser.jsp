<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello</title>
</head>
<body>
	<h1>Hello Spring MVC. Please add new user below!</h1>

	<spring:url value="/welcome/home" var="urlHome" />
	<spring:url value="/welcome/addUser" var="urlAddUser" />

	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">Spring MVC Form</a>
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${urlAddUser}">Add User</a></li>
			</ul>
		</div>
	</div>


	<spring:url value="/welcome/submit/user" var="userActionUrl" />

	<form:form class="form-horizontal" method="post" modelAttribute="userForm" action="${userActionUrl}">

			<form:hidden path="id" />
	
			<spring:bind path="name">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Name</label>
					<div class="col-sm-10">
						<form:input path="name" type="text" class="form-control " id="name" placeholder="Name" />
						<form:errors path="name" class="control-label" />
					</div>
				</div>
			</spring:bind>
	
			<spring:bind path="email">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Email</label>
					<div class="col-sm-10">
						<form:input path="email" class="form-control" id="email" placeholder="Email" />
						<form:errors path="email" class="control-label" />
					</div>
				</div>
			</spring:bind>
	
			<spring:bind path="password">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
						<form:password path="password" class="form-control" id="password" placeholder="password" />
						<form:errors path="password" class="control-label" />
					</div>
				</div>
			</spring:bind>
	
			<spring:bind path="confirmPassword">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">confirm Password</label>
					<div class="col-sm-10">
						<form:password path="confirmPassword" class="form-control" id="password" placeholder="password" />
						<form:errors path="confirmPassword" class="control-label" />
					</div>
				</div>
			</spring:bind>
	
			<spring:bind path="address">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Address</label>
					<div class="col-sm-10">
						<form:textarea path="address" rows="5" class="form-control" id="address" placeholder="address" />
						<form:errors path="address" class="control-label" />
					</div>
				</div>
			</spring:bind>
	
			<spring:bind path="newsletter">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Newsletter</label>
					<div class="col-sm-10">
						<div class="checkbox">
							<label> <form:checkbox path="newsletter" id="newsletter" /></label>
							<form:errors path="newsletter" class="control-label" />
						</div>
					</div>
				</div>
			</spring:bind>
	
			<%-- <spring:bind path="framework">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Web Frameworks</label>
					<div class="col-sm-10">
						<form:checkboxes path="framework" items="${frameworkList}" element="label class='checkbox-inline'" />
						<br />
						<form:errors path="framework" class="control-label" />
					</div>
				</div>
			</spring:bind> --%>
	
			<spring:bind path="sex">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Sex</label>
					<div class="col-sm-10">
						<label class="radio-inline"> 
							<form:radiobutton path="sex" value="M" /> Male
						</label> 
						<label class="radio-inline"> 
							<form:radiobutton path="sex" value="F" /> Female
						</label> <br />
						<form:errors path="sex" class="control-label" />
					</div>
				</div>
			</spring:bind>
	
			<%-- <spring:bind path="number">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Number</label>
					<div class="col-sm-10">
						<form:radiobuttons path="number" items="${numberList}" element="label class='radio-inline'" />
						<br />
						<form:errors path="number" class="control-label" />
					</div>
				</div>
			</spring:bind> --%>
	
			<!-- Custom Script, Spring map to model via 'name' attribute
			<div class="form-group">
				<label class="col-sm-2 control-label">Number</label>
				<div class="col-sm-10">
	
					<c:forEach items="${numberList}" var="obj">
						<div class="radio">
							<label> 
								<input type="radio" name="number" value="${obj}">${obj}
							</label>
						</div>
					</c:forEach>
				</div>
			</div>
	 		-->
	
			<spring:bind path="country">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Country</label>
					<div class="col-sm-5">
						<form:select path="country" class="form-control">
							<form:option value="NONE" label="--- Select ---" />
							<form:options items="${countryList}" />
						</form:select>
						<form:errors path="country" class="control-label" />
					</div>
					<div class="col-sm-5"></div>
				</div>
			</spring:bind>
	
			<<%-- spring:bind path="skill">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Java Skills</label>
					<div class="col-sm-5">
						<form:select path="skill" items="${javaSkillList}" multiple="true" size="5" class="form-control" />
						<form:errors path="skill" class="control-label" />
					</div>
					<div class="col-sm-5"></div>
				</div>
			</spring:bind> --%>
	
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn-lg btn-primary pull-right">Add 123</button>
				</div>
		
			
	</form:form>


</body>
</html>
