<%@ tag language="java"  pageEncoding="iso-8859-1" %>
<%@ attribute name="title" required="true" rtexprvalue="true" %>
<%@ attribute name="content" fragment="true" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html"; charset="ISO-8859-1">
        <title>${title}</title>
    </head>
    <body>
        <a href="index.jsp">Home</a>
        <a href="index.xhtml">XHTML home</a>
        <br>
            <jsp:invoke fragment="content"/>
        <br>
        Footer here
    </body>
</html>
