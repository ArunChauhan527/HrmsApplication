<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HRMS</title>
</head>
<body>

<div>

<table>
<thead>
<th>Sno</th>
<th>Occasion</th>
<th>Date</th>
<th>Region</th>
<th>Department</th>
</thead>
<tbody>
<c:forEach items="" var="list">
<tr>
<td></td>
<td>${list.holiday}</td>
<td>${list.occured_date}</td>
<td>${list.region}</td>
<td>${list.department}</td>
</tr>
</c:forEach>
</tbody>
</table>



</div>
<div>
<button id="sampleButton" value="sample Sheet to upload"></button>
<input type="file" id="content">
<button id="upload_National_holiday" value="upload National holiday"></button>
</div>
</body>
</html>