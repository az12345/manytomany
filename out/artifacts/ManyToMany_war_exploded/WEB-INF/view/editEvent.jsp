<%--
  Created by IntelliJ IDEA.
  User: Сизиф
  Date: 02.07.2017
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/event/add" method="post">
    <input type="hidden" name="id" value="${event.id}">
    <input type="text" name="event" value="${event.event}">
    <input type="text" name="name" value="${event.name}">
    <input type="submit" value="add">
</form>
</body>
</html>
