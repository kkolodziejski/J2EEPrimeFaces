<%--
  Created by IntelliJ IDEA.
  User: dzelapino
  Date: 6/3/23
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form action="account-servlet" method="post">
  Name <label>
  <input type="text" name="name">
</label>
  Phone <label>
  <input type="text" name="phone">
</label>
  <input type="submit" value="Register">
</form>
</body>
</html>
