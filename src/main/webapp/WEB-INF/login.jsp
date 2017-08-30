<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css\styles.css">
</head>
<body>
	<h2>Login page</h2>
	<form:form method="POST" modelAttribute="loginBean"
		action="showProfile">
		<table>
			<tr>
				<td><form:label path="userName" cssErrorClass="error">
						<spring:message code="userName" /> : </form:label> <form:input path="userName"
						cssErrorClass="error" name="username"/></td>
			</tr>
			<tr>
				<td><form:label path="OrganizationName" cssErrorClass="error">
						<spring:message code="organizationName" /> : </form:label> <form:input
						path="OrganizationName" cssErrorClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="password" cssErrorClass="error">
						<spring:message code="password" /> : </form:label> <form:input path="password"
						cssErrorClass="error" name="password"/></td>
			</tr>
			<%-- <tr>
				<div class="input-group input-sm">
					<div class="checkbox">
						<label><input type="checkbox" id="rememberme"
							name="remember-me"> Remember Me</label>
					</div>
				</div>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</tr> --%>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>