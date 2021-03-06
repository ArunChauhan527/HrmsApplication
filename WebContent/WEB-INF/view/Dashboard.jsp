<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="./resources/css/bootstrap.min.css" rel="stylesheet">
<style>
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.column {
	float: left;
	/* width: 25%; */
	padding: 0 5px;
	margin: 30px 0px 0px 10px;
}

.row {
	margin: 50px 50px;
}

.row:after {
	content: "";
	display: table;
	clear: both;
}

.card {
	
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
    padding: 22px 25px 5px 25px;
    text-align: center;
    background-color: #fff;
    color: #fff;
}
.card p{
	font-size: 18px;
	color: #333;
	font-family: calibri;
	margin: 5px;
}

.header {
	overflow: hidden;
	background-color: #288cd6;
	padding: 10px 10px;
}

#a {
	background-color: #288cd6;
	color: #fff;
	text-align: left;
	font-size: 40px;
}
</style>
</head>
<body>
	<div class="header">
		<div id="a">HRMS</div>
	</div>

	<div class="row">
		<div class="column">
			<div class="card">
			<img src="./resources/images/admin.png" width="150px" height="190px">
				<p>Admin</p>
			</div>
		</div>

		<div class="column">
			<div class="card">
			<img src="./resources/images/leave.png" width="150px" height="190px">
				<p>Leave</p>
			</div>
		</div>

		<div class="column">
			<div class="card">
			<img src="./resources/images/attendence.png" width="150px" height="190px">
				<p>Attendence</p>
			</div>
		</div>
		<div class="column">
			<div class="card">
			<img src="./resources/images/calender.jpg" width="150px" height="190px">
				<p>Calender</p>
			</div>
		</div>
		<div class="column">
			<div class="card">
			<img src="./resources/images/performance.png" width="150px" height="190px">
				<p>performance</p>
			</div>
		</div>

	</div>
</body>
</html>