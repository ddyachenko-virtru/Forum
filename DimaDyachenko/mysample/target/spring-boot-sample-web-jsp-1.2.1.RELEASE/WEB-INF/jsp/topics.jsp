<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <title>Topics</title>
</head>
<body>
<div align="center" style="font-family: Calibri">
    <%
        session.getAttribute("userName").toString();

    %>
    <a href="/test/addTopic">Add new Topic</a> <a href="/test/logout">Logout</a>

    <br> =========================================================================<br>
    <style type="text/css">
        TABLE {
            width: 600px;
            border-collapse: collapse;
        }

        TD, TH {
            padding: 3px;
            border: 1px solid black;
            text-align: left;
        }

        TH {
            background: #aa99ff;
        }
    </style>
    <c:forEach var="topic" items="${topics}">
    <table align="center">
        <tr>
            <th>ID</th>
            <th>Topic Name:</th>
        </tr>
        <tr>
            <td width="100"><c:out value="${topic.topicID}"/></td>
            <td><a href="/test/topics/${topic.topicID}/comments"> <c:out value="${topic.topicName}"/></a></td>
        </tr>
        ---------------------------------------------------------------------------------------------------------------------<br>
        </c:forEach>
    </table>
</div>
</body>

</html>
