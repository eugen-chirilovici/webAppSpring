<%--
  Created by IntelliJ IDEA.
  User: dvelescu
  Date: 10/20/2020
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>More</title>
</head>
<body>

<c:choose>
    <c:when test="${role == 'ROLE_ADMIN'}">
        <form:form method="POST" action="more" target = "_blank">
        <c:forEach items="${users}" var="user">
            <p>User Id: ${user.userId} | First Name: ${user.firstName} | Last Name: ${user.lastName}
                | Phone: ${user.phone} | Role: ${user.role} <input type = "checkbox" name = "selectedTasks" value="${user.userId}"/>
            </p>
            <br>
        </c:forEach>
            <input type = "submit" value = "Delete" />
        </form:form>
    </c:when>
    <c:otherwise>
        <ul>
            <li>id:${id}</li>
            <li>First Name: ${firstName}</li>
            <li>Last Name: ${lastName}</li>
            <c:choose>
                <c:when test="${phone != 'None'}">
                    <li>Phone:${phone}</li>
                    <br />
                </c:when>
                <c:otherwise>
                    <li><a href="/addPhone">Add Phone Number</a></li>
                </c:otherwise>
            </c:choose>
            <li>Role:${role}</li>
        </ul>
    </c:otherwise>
</c:choose>

</body>
</html>
