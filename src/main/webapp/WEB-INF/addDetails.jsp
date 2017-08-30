<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>Add Details</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker({
			showOn : "button",
			buttonImage : "images/calendar.png",
			buttonImageOnly : true,
			buttonText : "Select date"
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<h1>Expense Entry Details</h1>
	<form:form id="addExpense" modelAttribute="expenseCreationBean"
		action="savedata" method="post">
		<table border="6px" cellspacing="10px" cellpadding="10px">
			<tr>
				<td>Date Of Purchase: <input type="text" id="datepicker"
					name="date_of_purchase"></td>
				<td>Item Name:<input type="text" name="description"></td>
				<td>Category: <form:select path="category">
						<form:options items="${categoriesMap}" />
					</form:select>
				</td>
				<td>Paid By: <form:select path="amountPaidBy">
						<form:options items="${usersMap}" />
					</form:select>
				</td>
				<td>Amount Paid:<input type="text" name="total_price"
					id="total_price"></td>
				<td>Quantity:<input type="text" name="quantity_purchased"></td>
				<td>Unit:<form:select path="unit">
						<form:options items="${unitsMap}" />
					</form:select></td>
			</tr>
			<tr>
			<tr>
			<tr>
			<tr>
				<td>Exclude:</td>
				<td><form:checkboxes items="${usersMap}"
						path="excludedUsers" /></td>
			</tr>
			<tr>
				<td>Comments:<textarea rows="3" cols="25" name="comments"></textarea>
				</td>
			</tr>
			<tr>
				&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
				<td><input type="submit" value="Save" align="middle"></td>
		</table>
	</form:form>
</body>
</html>