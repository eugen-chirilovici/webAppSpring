<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>${title}</h1>
<br>
<h2>${message}</h2>
<c:forEach items="${users}" var="user">
    <form:form method="POST" action="/deleteUser/${user.userId}">
        <input type="hidden" th:field="${users}">
        <p><button type="submit" onClick="return confirm('Delete User: ${user.firstName}  ${user.lastName}?' )">Delete</button>
            User Id: ${user.userId} | First Name: ${user.firstName} | Last Name: ${user.lastName} | Stream:  ${user.stream}</p>
    </form:form>
</c:forEach>
<a href="/logout" >logOut</a>

</body>
</html>