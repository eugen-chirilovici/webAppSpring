<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dgurduza
  Date: 4/2/2020
  Time: 1:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>More details</title>
</head>
<body>
<h2>${message}</h2>
<c:forEach items="${usersdetails}" var="user">
    <p>First Name: ${user.firstName} <br> Last Name: ${user.lastName} <br> Stream: ${user.stream} <br> Hobby: ${user.hobby}</p>
</c:forEach>

<a href="/logout" >logOut</a>
</body>
</html>
