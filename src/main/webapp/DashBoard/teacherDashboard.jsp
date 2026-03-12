<%@page import="in.keen.Model.User"%>

<%
User user = (User) session.getAttribute("session_user");

if(user == null){
    response.sendRedirect("login.html");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<title>Teacher Dashboard</title>
</head>

<body>

<h1>Teacher Dashboard</h1>

<h3>Welcome <%= user.getUserName() %></h3>

<p>Email: <%= user.getUserEmail() %></p>
<p>Role: <%= user.getUserRole() %></p>

<br>

<a href="logoutUser">Logout</a>

</body>
</html>