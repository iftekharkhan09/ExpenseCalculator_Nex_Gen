<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<form:form id="regForm" modelAttribute="staffRegistrationBean" action="registerStaff"
		method="post">
		<table align="center">
			<tr>
				<td>user name : <form:input path="userName" name="username"
						id="username" />
				</td>
			</tr>
			<tr>
				<td>Organization : <form:input path="organization" name="username"
						id="organization" />
				</td>
			</tr>
			<tr>
				<td>Password : <form:input path="password" name="password"
						id="password" /></td>
			</tr>
			<tr>
				<td>First Name :<form:input path="firstName" name="firstname"
						id="firstname" /></td>
			</tr>
			<tr>
				<td>Last Name :<form:input path="lastName" name="lastname"
						id="lastname" />
				</td>
			</tr>
			<tr>
				<td>Email :<form:input path="email" name="email" id="email" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="register"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>