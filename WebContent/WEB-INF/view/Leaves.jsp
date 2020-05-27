<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HRMS</title>
<link href="./resources/css/bootstrap.min.css" rel="stylesheet">
<link href="./resources/css/leaves.css" rel="stylesheet">
</head>
<body>
<jsp:include page="headerV2.jsp"></jsp:include>
<div class="row">
<div class="column">
<div class="card">
<div>
Approved Leaves : ${approved}
</div>
</div>
</div>
<div class="column">
<div class="card">
<div>
Planned Leaves : ${paidleave}
</div>
</div>
</div>
<div class="column">
<div class="card">
<div>
Casual Leaves : ${casualleave}
</div>
</div>
</div>
<div class="column">
<div class="card">
<div>
Wait for Approval Leaves : ${waiting}
</div>
</div>
</div>
</div>
</body>
</html>