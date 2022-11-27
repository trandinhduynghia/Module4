<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/26/2022
  Time: 8:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<form:form action="/setting/update" method="post" modelAttribute="setting">
    <label>Id</label>
    <form:input type="text" path="id" /><br>
    <label>Language</label>
    <form:input type="text" path="language"/><br>
    <label>Size</label>
    <form:input type="text"  path="size"/><br>
    <label>Span</label>
    <form:input type="text"  path="spam"/><br>
    <label>Signature</label>
    <form:input type="text"  path="signature"/><br>
    <button type="submit">Update</button>

</form:form>
</body>
</html>
