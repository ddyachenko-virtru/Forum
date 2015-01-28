<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>

<a href="/test/addPost">Add new Post</a>

	<c:forEach var="post" items="${posts}">
         <h3>${post.title}</h3>
         ${post.body}

         <br> -----------------------------------------------------------

    </c:forEach>


</body>

</html>
