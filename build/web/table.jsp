<%-- 
    Document   : table
    Created on : 16.03.2017, 23:04:51
    Author     : Pyc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CarsSystematic</title>        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />        
    </head>
    <body>  
        <h1>Сейчас в наличии</h1>
        
   <table border=1 class="floatedTable">
            <tr>
            <th>Модель</th>           
        </tr>

        <c:forEach var="model" items="${form.model}">
            <tr> 
                <td><c:out value="${model}"/></td>           
            </tr>
       </c:forEach >        
    </table>
   <table border=1 class="floatedTable">
          <tr>
            <th>Цвет</th>           
        </tr>

        <c:forEach var="color" items="${form.color}">
            <tr> 
                <td><c:out value="${color}"/></td>           
            </tr>
       </c:forEach >        
    </table>
   <table border=1 class="floatedTable">
          <tr>
            <th>Комплектация</th>           
        </tr>
        <c:forEach var="equipment" items="${form.equipment}">
            <tr> 
                <td><c:out value="${equipment}"/></td>           
            </tr>
       </c:forEach >        
   </table>
   
    </body>
</html>
