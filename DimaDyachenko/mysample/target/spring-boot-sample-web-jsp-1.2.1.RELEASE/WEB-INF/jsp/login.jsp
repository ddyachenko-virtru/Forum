<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Please Login</title>
</head>
<body>
<div align="center" style="font-family: Calibri">
    <h3>Please Login</h3>
    <form:form method="post" action="login">

        <table>
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
                    <br><input type="submit" value="Login" id="login" style="background:#aa99ff"/>
                    <a href="/test/register">Register new User</a>
                </td>
            </tr>
        </table>

    </form:form>

    <div style="color:#FF0000" align="center" id="loginFailure">${errorMessage}</div>
</div>
</body>
</html>