<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter info</title>
</head>
<body>
<h2>Enter info below.</h2>
<form action="database-operations" method="post">
<%--    <label>Name : </label>--%>
    <label>
        <input type="text" name="name">
    </label>
<%--    <label>Phone : </label>--%>
    <label>
        <input type="text" name="phone">
    </label><br>
    <input type="submit" value="Send">
</form>
</body>
</html>
