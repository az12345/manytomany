<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Date</th>
        <th>Time</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>
    <c:forEach items="${timelist}" var="time">
        <tr>
            <td>${time.id}</td>
            <td>${time.date}</td>
            <td>${time.time}</td>
            <td><a href="/event/delete/${time.id}">Delete</a></td>
            <td><a href="/event/edit/${time.id}">Edit</a> </td>
        </tr>
    </c:forEach>
    <tr>

    </tr>
</table>
</body>
</html>
