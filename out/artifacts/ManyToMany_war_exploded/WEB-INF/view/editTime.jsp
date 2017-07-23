<%--
  Created by IntelliJ IDEA.
  User: Сизиф
  Date: 02.07.2017
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/time/add" method="POST">
    <input type="hidden" name="id" value="${time.id}">
    <input type="time" step="0" name="time" value="${time.time}">
    <input type="date" name="date" value="${time.date}">
    <input type="submit" value="EDIT">
</form>
</body>
</html>
