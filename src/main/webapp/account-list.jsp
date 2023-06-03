<%--
  Created by IntelliJ IDEA.
  User: dzelapino
  Date: 6/3/23
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:f="http://xmlns.jcp.org/jsf/core"
      xmlns:jsf="http://xmlns.jcp.org/jsf"
      xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
      xmlns:p="http://primefaces.org/ui">
<f:view contentType="text/html;charset=UTF-8" encoding="UTF-8">
<head>
    <title>Accounts</title>
</head>
<body>
    <h1>Account Management</h1>
    <h2>
        <a href="form">Add New User</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list">List All Users</a>
    
    </h2>
<div>
    <p:dataTable value="#{accounts}" var="account">
        <f:facet name="header">
            <h:outputText value="ID"/>
        </f:facet>
        <h:outputText value="#{account.id}"/>
        <f:facet name="header">
            <h:outputText value="Name"/>
        </f:facet>
        <h:outputText value="#{account.name}"/>
        <f:facet name="header">
            <h:outputText value="Phone"/>
        </f:facet>
        <h:outputText value="#{account.phone}"/>
    </p:dataTable>
<%--        <c:forEach var="user" items="${listUser}">--%>
<%--            <tr>--%>
<%--                <td><c:out value="${user.id}" /></td>--%>
<%--                <td><c:out value="${user.name}" /></td>--%>
<%--                <td><c:out value="${user.email}" /></td>--%>
<%--                <td><c:out value="${user.country}" /></td>--%>
<%--                <td>--%>
<%--                    <a href="edit?id=<c:out value='${user.id}' />">Edit</a>--%>
<%--                    &nbsp;&nbsp;&nbsp;&nbsp;--%>
<%--                    <a href="delete?id=<c:out value='${user.id}' />">Delete</a>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
</div>
</body>
</f:view>
</html>
