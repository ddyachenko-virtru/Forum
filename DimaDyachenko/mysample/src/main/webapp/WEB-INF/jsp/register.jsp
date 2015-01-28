<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp" %>
<html>
<head>
    <title>New User Registration</title>
</head>
<body>
<div align="center" style="font-family: Calibri">
    <h3>New User Registration</h3>
    <form:form method="post" action="register">

        <table align="center">
            <tr>
                <td><form:label path="userName">User Name</form:label></td>
                <td><form:input path="userName" id="userName" required="required"/></td>
            </tr>
            <tr>
                <td><form:label path="userPassword">Password</form:label></td>
                <td><form:input path="userPassword" type="password" id="userPassword" required="required"/></td>
            </tr>

            <tr>
                <td colspan="2">
                    <br> <input type="submit" value="Register" id="register" style="background:#aa99ff"/>
                    <a href="/test/login">Login</a>
                </td>
            </tr>
        </table>

    </form:form>
    <div style="color:#FF0000" align="center">${errorMessage}</div>
</div>
</body>
</html>