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
	margin: 20px 30px 10px 100px;
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

#home {
	background-color: #288cd6;
	color: #fff;
	text-align: left;
	font-size: 40px;
	float: left;

}

.dropbtn {
  background-color: #3498DB;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
  cursor: pointer;
}

.dropbtn:hover, .dropbtn:focus {
  background-color: #2980B9;
}

.dropdown {
  position: relative;
  display: inline-block;
  float: right;
  margin-right: 10px;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  overflow: auto;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
  position: fixed;
  margin-right: 10px;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown a:hover {background-color: #ddd;}

.show {display: block;}
</style>
</head>
<body>
	 <div class="header">
		<div id="home">HRMS</div> 
		
		<!-- <div class="header">
		<a href="#hrms">HRMS</a> -->
		<div class="dropdown">
  <button onclick="myFunction()" class="dropbtn">Dropdown</button>
  <div id="myDropdown" class="dropdown-content">
    <a href="#changepassowrd">Change Password</a>
    <a href="#profile">Profile</a>
    <a href="#logout">Log Out</a>
  </div>
</div>
</div>
<script>
/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
function myFunction() {
  document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {
    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
</script>
	</div>

	<div class="row">
		<div class="column">
			<div class="card">
			<img src="./resources/images/admin.png" width="150px" height="150px">
				<p>Admin</p>
			</div>
		</div>

		<div class="column">
			<div class="card">
			<img src="./resources/images/leave.png" width="150px" height="150px">
				<p>Leave</p>
			</div>
		</div>

		<div class="column">
			<div class="card">
			<img src="./resources/images/attendence.png" width="150px" height="150px">
				<p>Attendance</p>
			</div>
		</div>
		<div class="column">
			<div class="card">
			<img src="./resources/images/HR.jpg" width="150px" height="150px">
				<p>HR Section</p>
			</div>
		</div>
		<div class="column">
			<div class="card">
			<img src="./resources/images/registration.jpg" width="150px" height="150px">
				<p>Registration</p>
			</div>
		</div>
		<div class="column">
			<div class="card">
			<img src="./resources/images/videochat.jpg" width="150px" height="150px">
				<p>Video Chat</p>
			</div>
		</div>
		<div class="column">
			<div class="card">
			<img src="./resources/images/task.jpg" width="150px" height="150px">
				<p>Task</p>
			</div>
		</div>
		<div class="column">
			<div class="card">
			<img src="./resources/images/messageclient.jpg" width="150px" height="150px">
				<p>Message Client</p>
			</div>
		</div>
		<div class="column">
			<div class="card">
			<img src="./resources/images/calender.jpg" width="150px" height="150px">
				<p>Calendar</p>
			</div>
		</div>

	</div>
</body>
</html>