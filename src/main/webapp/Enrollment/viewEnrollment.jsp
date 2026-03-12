<%@page import="in.keen.Model.Enrollment"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Enrollment</title>
</head>
<body>
<%List<Enrollment> eList = (List<Enrollment>) request.getAttribute("enrollmentList");%>
<h3>Enrollment List</h3>
<table border = "1">
<thead>
<tr>
<th>Id</th>
<th>Student Name</th>
<th>Course Name </th>
</tr>
</thead>
<tbody>
<% for(Enrollment e : eList){ %>
<tr>
<td><%= e.getEnrollmentId() %></td>
<td> <%= e.getStudentName() %></td>
<td> <%= e.getCourseName() %></td>
</tr>
<%} %>
</tbody>
</table><br><br>
<button><a href="<%= request.getContextPath() %>/DashBoard/adminDashboard.jsp">Back</a></button>
</body>
</html>