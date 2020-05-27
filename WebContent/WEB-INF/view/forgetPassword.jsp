<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hrms</title>
</head>
<link href="./resources/css/bootstrap.min.css" rel="stylesheet">
<body>
<jsp:include page="headerV2.jsp"></jsp:include>
<br>
<form action="forgetPasswordSubmit.obj" method="POST">
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-6">
<label>Enter email'id to recover password</label>
<input type="text" placeholder="email'id" id="emailid" name="emailid" required>
<input type="submit" value="Submit" class="btn btn-primary">
<label>${error}</label>
</div>
<div class="col-md-3"></div>

</div>
</form>
</body>
</html>