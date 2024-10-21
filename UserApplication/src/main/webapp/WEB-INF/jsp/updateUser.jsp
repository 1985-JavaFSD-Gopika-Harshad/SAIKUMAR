<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.user.dto.UserResponse" %>
<html>
<head>
    <title>Update User</title>
</head>
<body>
<h2>Update User</h2>
<% UserResponse user = (UserResponse) request.getAttribute("user"); %>
<form action="${pageContext.request.contextPath}/user/${user.id}" method="post">
    <input type="hidden" name="_method" value="put" />
    First Name: <input type="text" name="firstName" value="<%= user.getFirstName() %>" required><br>
    Last Name: <input type="text" name="lastName" value="<%= user.getLastName() %>" required><br>
    Email: <input type="email" name="email" value="<%= user.getEmail() %>" required><br>
    Password: <input type="password" name="password" required><br>
    Contact: <input type="text" name="contact" value="<%= user.getContact() %>" required><br>
    Address: <input type="text" name="address" value="<%= user.getAddress() %>" required><br>
    <input type="submit" value="Update User">
</form>
</body>
</html>
