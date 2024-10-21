<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.user.dto.UserResponse" %>
<html>
<head>
    <title>View User</title>
</head>
<body>
<h2>User Details</h2>
<% UserResponse user = (UserResponse) request.getAttribute("user"); %>
<% if (user != null) { %>
    <p>First Name: <%= user.getFirstName() %></p>
    <p>Last Name: <%= user.getLastName() %></p>
    <p>Email: <%= user.getEmail() %></p>
    <p>Contact: <%= user.getContact() %></p>
    <p>Address: <%= user.getAddress() %></p>
<% } else { %>
    <p>User not found.</p>
<% } %>
</body>
</html>
