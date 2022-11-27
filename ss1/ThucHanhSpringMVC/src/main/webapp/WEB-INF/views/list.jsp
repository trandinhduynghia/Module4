<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/26/2022
  Time: 8:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <tr>
        <th>Language</th>
        <th>Size</th>
        <th>Spam</th>
        <th>Signature</th>
    </tr>
<c:forEach var="o" items="${setting}">
    <tr>
        <td>${o.language}</td>
        <td>${o.size}</td>
        <td>${o.spam}</td>
        <td>${o.signature}</td>
        <td><a href="/setting/${o.id}/edit">edit</a></td>
    </tr>
    </c:forEach>


</table>

</body>
</html>
