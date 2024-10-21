<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.user.dto.UserResponse" %>
<html>
<head>
    <title>All Users</title>
</head>
<body>
<h2>User List</h2>
<table border="1">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Contact</th>
        <th>Address</th>
    </tr>
    <% 
        List<UserResponse> users = (List<UserResponse>) request.getAttribute("users");
        for (UserResponse user : users) { 
    %>
        <tr>
            <td><%= user.getFirstName() %></td>
            <td><%= user.getLastName() %></td>
            <td><%= user.getEmail() %></td>
            <td><%= user.getContact() %></td>
            <td><%= user.getAddress() %></td>
        </tr>
    <% } %>
</table>
</body>
</html>
