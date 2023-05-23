<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:p="http://primefaces.org/ui">
<h:head>
    <title>JSPSF TEST</title>
</h:head>

<h:body>
    <p:panel id="horizontal" header="Horizontal Toggle" toggleable="true" toggleOrientation="horizontal">
        <h:panelGrid columns="2" cellpadding="10">
            <h:outputText value="Posok" />
            <div>
                POSOK
            </div>
        </h:panelGrid>
    </p:panel>

</h:body>
</html>