<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>
                <form action="/time/add" method="post">
                <input type="time" name="time" step="1">
                <input type="date" name="date">
                    <select name="userevents[0].id">
                        <option value="NONE">Select Event</option>
                        <c:forEach items="${eventlist}" var="event" varStatus="status">

                            <option value='<c:out value="${event.id}"/>'><c:out value="${event.name}"></c:out></option>

                        </c:forEach>
                    </select>
                <input type="submit" value="add">
                </form>
        </td>
        <td>
            <%--<form action="/event/add">--%>
                <%--<input type="text" name="event">--%>
                <%--<input type="text" name="name">--%>
                <%--<select >--%>
                    <%--<option value="NONE">SELECT TIME</option>--%>
                    <%--<c:forEach items="${timelist}" var="time">--%>

                        <%--<option value="${time.id}"><c:out value="${time.date}"></c:out></option>--%>
                    <%--</c:forEach>--%>
                <%--</select>--%>
                <%--<input type="submit" value="add">--%>
            <%--</form>--%>
                <spring:form modelAttribute="event" method="get" action="/event/add">
                    <%--<form:input type="text" name="event">--%>
                    <%--<form:input type="text" name="name">--%>
                    <spring:errors path="event" cssClass="error"></spring:errors>
                    <spring:input path="event"></spring:input>
                    <spring:input path="name"></spring:input>
                    <select name="${time.id}">
                        <option value="NONE">SELECT TIME</option>
                        <c:forEach items="${timelist}" var="time" varStatus="status">

                            <option value="${time.id}"><c:out value="${time.date}"></c:out></option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="add">
                </spring:form>
        </td>
    </tr>
    <tr>
        <td>
            <table>
            <tr>
                <th>ID</th>
                <th>Time</th>name
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
