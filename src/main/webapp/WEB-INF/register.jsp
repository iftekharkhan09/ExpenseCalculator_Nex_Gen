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
				<td><form:label path="userName" cssErrorClass="error">
						<spring:message code="userName" /> : 
					</form:label> <form:input path="userName" name="username" id="username"
						cssErrorClass="error" /></td>
			</tr>
			<tr>
				<td>Title: <form:select path="title">
						<form:options items="${titleMap}" />
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Gender: <form:select path="gender">
						<form:options items="${gendersMap}" />
					</form:select>
				</td>
			</tr>
			<tr>
				<td><form:label path="organization" cssErrorClass="error">
						<spring:message code="organizationName" /> : 
					</form:label> <form:input path="organization" name="username" id="organization"
						cssErrorClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="password" cssErrorClass="error">
						<spring:message code="password" /> : 
					</form:label> <form:input path="password" name="password" id="password"
						cssErrorClass="error" /></td>
			</tr>
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
			<%-- <tr>
				<td><form:label path="gender">
						<spring:message code="gender" /> : </form:label>
				<td><form:select path="${gender}">
						<form:options items="${genderList}" id="id" itemValue="gender">
						</form:options>
					</form:select></td>
			</tr> --%>
			<tr>
				<td><form:label path="email" cssErrorClass="error">
						<spring:message code="email" /> : 
					</form:label> <form:input path="email" name="email" id="email"
						cssErrorClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="phoneNo" cssErrorClass="error">
						<spring:message code="phoneNo" /> : 
					</form:label> <form:input path="phoneNo" name="phoneNo" id="phoneNo"
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