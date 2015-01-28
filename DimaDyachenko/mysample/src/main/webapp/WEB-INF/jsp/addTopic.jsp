<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Add New Topic</title>
</head>
<body>
<div align="center" style="font-family: Calibri">
    <%
        session.getAttribute("userName").toString();
    %>
    <a href="/test/logout">Logout</a> <br>
    =======================================================<br>

    <h3>Add New Topic</h3>
    <form:form method="post" action="addTopic">
        <table align="center">
            <tr>
                <td><form:input path="topicName" id="topicName" size="70"/></td>
            </tr>
            <tr>
                <td colspan="2"><br>
                    <input type="submit" value="Add" id="addTopic" style="background:#aa99ff"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>