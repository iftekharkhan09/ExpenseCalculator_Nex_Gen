<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Entry</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/style_account_tables1.css">
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
	$(function() {
		$("#datepicker1").datepicker();
	});
	$(function() {
		$("#datepicker2").datepicker();
	});
	$(function() {
		$("#datepicker3").datepicker();
	});
</script>
<script type="text/javascript" language="JavaScript">
	function radioWithText(d) {
		switch (d.value) {
		case "dop":
			document.getElementById('purchase').style.display = "inline";
			document.getElementById('updated_on').style.display = "none";
			document.getElementById('update_by').style.display = "none";
			break;
		case "upo":
			document.getElementById('purchase').style.display = "none";
			document.getElementById('updated_on').style.display = "inline";
			document.getElementById('update_by').style.display = "none";
			break;
		case "upb":
			document.getElementById('purchase').style.display = "none";
			document.getElementById('updated_on').style.display = "none";
			document.getElementById('update_by').style.display = "inline";
			break;
		}
	}
</script>
</head>
<body>
	<br>
	<br>
	<br>
	<form method="post" action="SearchDetail.jsp">
		<center>
			<div id="page-wrap">
				<table border="1" width="80%" cellpadding="0">
					<thead>
						<tr>
							<th colspan="3">Define Your Search Criteria</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<p>
								<b>Search Here</b>
							</p>
						</tr>
						<tr>
							<td><input type="radio" name="search" value="dop"
								onclick="radioWithText(this)" checked="checked">Date Of
								Purchase</td>
							<td><input type="radio" name="search" value="upo"
								onclick="radioWithText(this)">Update Date</td>
							<td><input type="radio" name="search" value="upb"
								onclick="radioWithText(this)">Updated By</td>
						</tr>
						<tr>
							<td><span id="purchase" style="display: inline"> From
									:<input type="text" id="datepicker"
									name="date_of_purchase_from" value="" length="12" /> To : <input
									type="text" id="datepicker1" name="date_of_purchase_to"
									value="" length="12" />
							</span></td>

							<td><span id="updated_on" style="display: none">From
									: <input type="text" id="datepicker2" name="updated_on_from"
									value="" length="12" /> To : <input type="text"
									id="datepicker3" name="updated_on_to" value="" length="12">
							</span></td>
							<td><span id="update_by" style="display: none"></td>
						<tr>
							<td></td>
							<td><input type="submit" name="submit" value="Search"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</center>
	</form>
</body>
</html>