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
<form action="/time/add">
    <input type="text" name="id" value="${time.id}">
    <input type="text" name="time" value="${time.time}">
    <input type="date" name="date" value="${time.date}">
    <input type="submit" value="EDIT">
</form>
</body>
</html>
