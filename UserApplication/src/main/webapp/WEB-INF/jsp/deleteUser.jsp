<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete User</title>
</head>
<body>
<h2>Delete User</h2>
<p>Are you sure you want to delete this user?</p>
<form action="${pageContext.request.contextPath}/user/${userId}" method="post">
    <input type="hidden" name="_method" value="delete" />
    <input type="submit" value="Delete User">
</form>
</body>
</html>
