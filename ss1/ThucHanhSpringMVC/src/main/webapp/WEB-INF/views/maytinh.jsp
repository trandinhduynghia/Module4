<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/21/2022
  Time: 6:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Máy tính</title>
</head>
<body>
<h1>Máy tính</h1>
<form id="operator" action="/MayTinh1" method="post">
    <input type="number" name="so1" value="firstNumber">
    <input type="number" name="so2" value="secondNumber">
    <br>
    <button type="submit" name="pheptinh" value="cong" >Addition(+)</button>
    <button type="submit" name="pheptinh" value="tru" >Subtraction(-)</button>
    <button type="submit" name="pheptinh" value="nhan" >Multiplication(x)</button>
    <button type="submit" name="pheptinh" value="chia" >Division(/)</button>
    <br>
    <h1>Kết quả: ${ketqua}</h1>
    <h1> ${ketqua1}</h1>

</form>
</body>
</html>
