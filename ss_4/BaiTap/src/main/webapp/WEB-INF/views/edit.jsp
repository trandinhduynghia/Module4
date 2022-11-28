<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/28/2022
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<h3>Update Setting</h3>

<div id="form">
    <form:form action="/setting/update" modelAttribute="settingedit" method="post">
        <div>
            <label>Id</label>
            <form:input type="text" path="id"/>
        </div>

        <div>
            <label>Language</label>
            <form:input type="text" path="language"/>
        </div>
        <div>
            <label>Size</label>
            <form:input type="text" path="size"/>
        </div>
        <div>
            <label>Spam</label>
            <form:checkbox path="spam" />
        </div>
        <div>
            <label>Signature</label>
            <form:input type="text" path="signature"/>
        </div>
        <input type="submit" value="Update"/>
    </form:form>

    <%--    <form:select path="gender">--%>
    <%--        <form:options items="${genderList}"></form:options>--%>
    <%--    </form:select>--%>
    <%--    <form:checkboxes path="gender" items="${genderList}"></form:checkboxes>--%>
<%--    <form:radiobuttons path="gender" items="${genderList}"></form:radiobuttons>--%>
</div>

</body>
</html>
