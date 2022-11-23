<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/21/2022
  Time: 2:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Gia vị</title>
</head>
<body>
<h1>Sandwich Condiment</h1>
<c:forEach items="${giavi}" var="o">
    <h1>${o}</h1>
</c:forEach>
</body>
</html>
