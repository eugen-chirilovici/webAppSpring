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
    <c:when test="${role== '1'}">
        <form:form action="delete" method="POST">
        Delete user by id: <input name="id"/>
            <input type="submit" value="Delete"/>

        </form:form>
    </c:when>
    <c:otherwise>
        <a href="${pageContext.request.contextPath}/moreInformation">More information</a>
        <br />
    </c:otherwise>
</c:choose>


</body>
</html>