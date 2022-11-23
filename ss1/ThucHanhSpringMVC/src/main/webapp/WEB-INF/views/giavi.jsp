<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/21/2022
  Time: 2:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gia vị</title>
</head>
<body>
<form action="/GiaVi1" method="post">
    <table>
        <th>
        <td><input type="checkbox" name="giavi" value="Lettuce"> Lettuce</td>
        <td><input type="checkbox" name="giavi" value="Tomato" > Tomato</td>
        <td><input type="checkbox" name="giavi" value="Mustard"> Mustard</td>
        <td><input type="checkbox" name="giavi" value="Sprouts"> Sprouts</td>
        </th>
    </table>
    <input type="submit" name="save">
</form>
</body>
</html>
