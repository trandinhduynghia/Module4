<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/21/2022
  Time: 7:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create student</title>
</head>
<body>

<form action="/student/create" method="post">
    <table>
        <tr>
            <th>Id</th>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <th>Name</th>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <th>Age</th>
            <td><input type="text" name="age"></td>
        </tr>
        <tr>
            <th>Address</th>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td><button type="submit">Thêm mới</button></td>
        </tr>
    </table>
</form>

</body>
</html>
