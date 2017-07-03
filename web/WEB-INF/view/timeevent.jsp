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
        <th>Event</th>
        <th>Name</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>
    <c:forEach items="${eventlist}" var="event">
        <tr>
            <td>${event.id}</td>
            <td>${event.event}</td>
            <td>${event.name}</td>
            <td><a href="/event/delete/${event.id}">Delete</a></td>
            <td><a href="/event/edit/${event.id}">Edit</a> </td>
        </tr>
    </c:forEach>
    <tr>

    </tr>
</table>
</body>
</html>
