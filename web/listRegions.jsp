<%--
  Created by IntelliJ IDEA.
  User: Administrador
  Date: 14/10/2017
  Time: 09:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>HR Services - Regions List</title>
</head>
<body>
    <h1>Regions List</h1>
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>
        <c:forEach var="region" items="${regions}">
            <tr>
                <td><c:out value="${region.id}"/></td>

                <td><c:out value="${region.name}"/></td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
