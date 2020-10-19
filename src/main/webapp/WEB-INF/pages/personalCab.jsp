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
    <p>First Name: ${user.firstName} | Last Name: ${user.lastName}</p>
</c:forEach>
<c:choose>
    <c:when test="${role == 'ROLE_USER'}">
        <a href="/tomcat_spring_app_war/details">More details</a>
        <br />
    </c:when>
    <c:otherwise>
            <div style="width: 300px; height: 500px;">
                <form:form method="POST" action="deleteUser">
                    <div class="container" align="left">
                        <label>Enter ID</label>
                        <input type="text" name="userId"/>

                        <button type="submit">Delete User</button>
                    </div>
                </form:form>
            </div>
    </c:otherwise>
</c:choose>
</body>
</html>