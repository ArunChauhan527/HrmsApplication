<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hrms</title>
<link href="./resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="headerV2.jsp"></jsp:include>
<br>
<form action="changePassword.obj" method="POST">
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-6">
<label>Change Password</label>
<br>
<input type="text" placeholder="enter otp" id="otp" name="otp" required>
<br>
<input type="password" placeholder="enter new password" id="newpassword" name="newPassword" required>
<br>
<input type="password" placeholder="confirm password" id="confirmpassword" name="confirmPassword" required>
<br>
<input type="submit" value="Submit" class="btn btn-primary">
<label>${error}</label>
</div>
<div class="col-md-3"></div>

</div>
</form>
</body>
</html>