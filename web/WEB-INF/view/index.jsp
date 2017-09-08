<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextpath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <%--<link href="${contextpath}/resources/css/bootstrap.min.css" rel="stylesheet">--%>
    <%--<link href="${contextpath}/resources/css/common.css" rel="stylesheet">--%>
    <%--<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>--%>
    <%--<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>--%>
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" media="screen"
          href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css">


</head>
<body>
<div class="container">
<a href="<c:url value="/logout" />" > Logout</a>



<table>
    <tr>
        <td><div class="well">
                <form action="/time/add" method="post">

                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <div id="datetimepicker3" class="input-append date">
                        <input type="text" name="time"></input>
                        <span class="add-on">
        <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
      </span>
                    </div>

                    <div id="datetimepicker4" class="input-append date">
                        <input type="text" name="date"></input>
                        <span class="add-on">
        <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
      </span>
                    </div>




                    <%--<input type="date" name="date">--%>
                    <select name="userevents[0].id">
                        <%--<option value="NONE">Select Event</option>--%>
                        <c:forEach items="${eventlist}" var="event" varStatus="status">

                            <option value='<c:out value="${event.id}"/>'>
                                <c:out value="${event.name}"></c:out>
                            </option>

                        </c:forEach>
                    </select>
                    <br>
                <input type="submit" value="add">
                </form>
        </div>

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
                <div class="well">
                <spring:form modelAttribute="event" method="POST" action="/event/add">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <%--<form:input type="text" name="event">--%>
                    <%--<form:input type="text" name="name">--%>
                    <spring:errors path="event" cssClass="error"></spring:errors>
                    <spring:input path="event"></spring:input>
                    <br>
                    <spring:input path="name"></spring:input>
                    <br>
                    <select name="usertimes[0].id">
                        <option value="NONE">SELECT TIME</option>
                        <c:forEach items="${timelist}" var="time" varStatus="status">

                            <option value="${time.id}"><c:out value="${time.date}"></c:out></option>
                        </c:forEach>
                    </select>
                    <br>
                    <input type="submit" value="add">
                </spring:form>
                </div>
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
</div>

<script type="text/javascript"
        src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js">
</script>
<script type="text/javascript"
        src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js">
</script>
<script type="text/javascript"
        src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
</script>
<script type="text/javascript"
        src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.pt-BR.js">
</script>
    <script type="text/javascript">

            $('#datetimepicker3').datetimepicker({
                format: 'hh:mm:ss',
                pickDate: false,
                language: 'rus'
            });


                $('#datetimepicker4').datetimepicker({
                    format: 'yyyy-MM-dd',
                    pickTime: false,
                    language: 'rus'

                });




    </script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script  src="${contextpath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
