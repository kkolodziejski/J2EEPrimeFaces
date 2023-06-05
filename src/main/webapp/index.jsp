<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<% response.sendRedirect("index.xhtml"); %>
<mt:pageTemplate title="Main Page">
    <jsp:attribute name="content">
        Main page
    </jsp:attribute>
</mt:pageTemplate>
