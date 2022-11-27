<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/24/2022
  Time: 7:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>description</td>
        <td>image</td>
    </tr>

    <c:forEach items="${products}" var="o">
        <tr>
            <td>${o.id}</td>
            <td>${o.name}</td>
            <td>${o.description}</td>
            <td><img src="${o.image}"></td>
        </tr>
    </c:forEach>


</table>
</body>
</html>
