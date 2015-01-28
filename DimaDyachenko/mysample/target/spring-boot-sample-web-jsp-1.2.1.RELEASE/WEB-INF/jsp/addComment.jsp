<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Add Comment</title>
</head>
<body>
<div align="center" style="font-family: Calibri">
    <%
        session.getAttribute("userName").toString();
    %>
    <a href="/test/logout">Logout</a> <br>
    =======================================================<br>

    <h3>Add Comment</h3>
    <form:form method="post" action="addComment">
        <table>
            <tr>
                <td><form:input path="commentText" id="commentText" size="70"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <br>
                    <input type="submit" value="Add" id="addComment" style="background:#aa99ff"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>