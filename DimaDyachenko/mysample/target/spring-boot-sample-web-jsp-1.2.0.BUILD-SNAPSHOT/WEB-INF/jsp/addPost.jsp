<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring 3 MVC Series - Contact Manager</title>
</head>
<body>
<h2>Contact Manager</h2>
<form:form method="post" action="addPost">
 
    <table>
    <tr>
        <td><form:label path="title">First Name</form:label></td>
        <td><form:input path="title" /></td>
    </tr>
    <tr>
        <td><form:label path="body">Last Name</form:label></td>
        <td><form:input path="body" /></td>
    </tr>

    <tr>
        <td colspan="2">
            <input type="submit" value="Add Post"/>
        </td>
    </tr>
</table>  
     
</form:form>
</body>
</html>