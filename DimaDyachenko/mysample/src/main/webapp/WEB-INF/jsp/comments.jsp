<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html lang="en">

<body>
<div align="center" style="font-family: Calibri">
    <%
        session.getAttribute("userName").toString();

    %>
    <a href="/test/topics">Topics</a> <a href="/test/topics/${comment.topicID}/comments/addComment">Add new Comment</a>
    <a
            href="/test/logout">Logout</a>
    <br> =========================================================================<br>

    <h3> ${comment.topicName} </h3>
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
    <c:forEach var="comment" items="${comments}">
    <table align="center">
        <tr>
            <th></th>
            <th>Added By:</th>
        </tr>
        <td><c:out value="${comment.commentText}"/></td>
        <td width="100"><c:out value="${comment.createdBy}"/></td>
        ---------------------------------------------------------------------------------------------------------------------<br>
        </c:forEach>

    </table>
</div>
</body>

</html>
