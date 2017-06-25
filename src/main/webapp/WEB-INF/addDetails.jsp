<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Details</title>
</head>
<body>
	<h1>Expense Entry Details</h1>
	<form name="Expense_Data" action="savedata.jsp" method="post"
		onsubmit="return validate_data()">
		<table border="6px" cellspacing="10px" cellpadding="10px">
			<tr>
				<td>Date Of Purchase: <input type="text" id="datepicker"
					name="date_of_purchase"></td>
				<td>Item Name:<input type="text" name="description"></td>
				<td>Category: <select name="category_description"></td>
				<td>Paid By: <select name="paid_by"></td>
				<td>Amount Paid:<input type="text" name="total_price"
					id="total_price"></td>
				<td>Quantity:<input type="text" name="quantity_purchased"></td>
				<td>Unit:</td>
			</tr>
			<tr>
			<tr>
			<tr>
			<tr>
				<td>Exclude:</td>
				<td><input TYPE="checkbox" name="exclude">
			</tr>
			<tr>
				<td>Comments:<textarea rows="3" cols="25" name="comments"></textarea>
				</td>
			</tr>
			<tr>
				&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
				<td><input type="submit" value="Save" align="middle"></td>
		</table>
	</form>
</body>
</html>