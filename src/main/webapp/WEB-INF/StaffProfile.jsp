<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Staff profile Form</h1>
	<form:form id="regForm" modelAttribute="staffProfileBean"
		action="updateStaffProfile" method="post">
		<table>
			<tr>
				<td>Email id : 
				<c:out value="${staffRegistrationBean.email}"></c:out>
				</td>
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
				<td><form:label path="phoneNo" cssErrorClass="error">
						<spring:message code="phoneNo" /> : 
					</form:label> <form:input path="phoneNo" name="phoneNo" id="phoneNo"
						cssErrorClass="error" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>