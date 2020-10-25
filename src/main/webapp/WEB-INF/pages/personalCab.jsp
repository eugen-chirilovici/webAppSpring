<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>${title}</h1>
<br>
<h2>${message}</h2>
<c:forEach items="${users}" var="user">
    <p>First Name: ${user.firstName} | Last Name: ${user.lastName} </p>
</c:forEach>

<c:choose>
    <c:when test="${userole == 'ROLE_USER'}">
        <a href="/moredetails">more details</a>
        <br />
    </c:when>
</c:choose>

<c:choose>
    <c:when test="${userole == 'ROLE_ADMIN'}">
        <form:form method="POST" action="deleteUser">
            <div class="container">
                <input type="number" name="UserId" required/>
                <button type="submit">Delete User</button>
            </div>
        </form:form>
    </c:when>
</c:choose>

</body>
</html>