<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/22/2022
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form action="/student/update" method="post">
    <table>
        <tr>
            <th>Id</th>
            <td><input type="text" name="id" value="${student.id}"></td>
        </tr>
        <tr>
            <th>Name</th>
            <td><input type="text" name="name" value="${student.name}"></td>
        </tr>
        <tr>
            <th>Age</th>
            <td><input type="text" name="age" value="${student.age}"></td>
        </tr>
        <tr>
            <th>Address</th>
            <td><input type="text" name="address" value="${student.address}"></td>
        </tr>
        <tr>
            <td><button type="submit">Cập nhật</button></td>
        </tr>
    </table>
</form>
</body>
</html>
