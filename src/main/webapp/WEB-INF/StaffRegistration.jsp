<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<h1>Registration Form</h1>
	<form:form id="regForm" modelAttribute="staffRegistrationBean"
		action="registerStaff" method="post">
		<table>
			<tr>
			<tr>
				<td><form:label path="firstName" cssErrorClass="error">
						<spring:message code="firstName" /> : 
					</form:label> <form:input path="firstName" name="firstname" id="firstname"
						cssErrorClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName" cssErrorClass="error">
						<spring:message code="lastName" /> : 
					</form:label> <form:input path="lastName" name="lastname" id="lastname"
						cssErrorClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="email" cssErrorClass="error">
						<spring:message code="email" /> : 
					</form:label> <form:input path="email" name="email" id="email"
						cssErrorClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="password" cssErrorClass="error">
						<spring:message code="password" /> : 
					</form:label> <form:input path="password" name="password" id="password"
						cssErrorClass="error" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="register"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>