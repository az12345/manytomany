<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>
                <form action="/time/add">
                <input type="text" name="time">
                <input type="date" name="date">
                <input type="submit" value="add">
                </form>
        </td>
        <td>
            <form action="/event/add">
                <input type="text" name="event">
                <input type="text" name="name">
                <input type="submit" value="add">
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <table>
            <tr>
                <th>ID</th>
                <th>Time</th>
                <th>Date</th>
                <th>Delete</th>
                <th>Edit</th>
            </tr>
            <c:forEach items="${timelist}" var="time">
                <tr>
                    <td>${time.id}</td>
                    <td><a href="/time/timeevent/${time.id}">${time.time}</a> </td>
                    <td>${time.date}</td>
                    <td><a href="/time/delete/${time.id}">Delete</a></td>
                    <td><a href="/time/edit/${time.id}">Edit</a> </td>
                </tr>
            </c:forEach>
            <tr>

            </tr>
        </table></td>
        <td><table>
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
                    <td><a href="/event/eventtime/${event.id}">${event.event}</a></td>
                    <td>${event.name}</td>
                    <td><a href="/event/delete/${event.id}">Delete</a></td>
                    <td><a href="/event/edit/${event.id}">Edit</a> </td>
                </tr>
            </c:forEach>
            <tr>

            </tr>
        </table></td>
    </tr>
</table>


</body>
</html>
