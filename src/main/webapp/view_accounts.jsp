<%--
  Created by IntelliJ IDEA.
  User: dzelapino
  Date: 6/3/23
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
    <title>Accounts</title>
</head>
<body>
<a href="index.jsp">Back to main</a>
<a href="register.jsp">Register</a>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Phone</th>
    </tr>
    <c:forEach items="${accounts}" var="account">
        <tr>
            <td>${account.id}</td>
            <td>${account.name}</td>
            <td>${account.phone}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>