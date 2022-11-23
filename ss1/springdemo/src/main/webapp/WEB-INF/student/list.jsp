<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/19/2022
  Time: 9:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List student</title>
</head>
<body>
<h1>List sudents</h1>
<table style="border: black 1px solid">
    <tr>
        <th style="border: black 1px solid">Id</th>
        <th style="border: black 1px solid">Name</th>
        <th style="border: black 1px solid">Age</th>
        <th style="border: black 1px solid">Address</th>
        <th></th>
        <th></th>
    </tr>

    <c:forEach items="${students}" var="student">

        <tr>
            <td style="border: black 1px solid">${student.id}</td>
            <td style="border: black 1px solid">${student.name}</td>
            <td style="border: black 1px solid">${student.age}</td>
            <td style="border: black 1px solid">${student.address}</td>
            <td style="border: black 1px solid"><a href="/student/update?id=${student.id}">sửa</a></td>
            <td style="border: black 1px solid"><a href="/student/delete?id=${student.id}">xóa</a></td>
        </tr>

    </c:forEach>
    <tr>
        <td style="border: black 1px solid"><a href="/student/create">Thêm mới</a></td>
    </tr>
</table>
</body>
</html>
