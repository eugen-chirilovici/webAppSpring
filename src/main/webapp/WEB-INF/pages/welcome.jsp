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
    <p>User Id: ${user.userId} | First Name: ${user.firstName} | Last Name: ${user.lastName}</p>
</c:forEach>

<form:form method="post" action="deleteUser">
    </br><p>Enter the id of the user you want to delete</p>
    <input type="number" name="deletedUserId" value="Id"></br>
    <button type="submit" name="deleteUser">Delete</button>
</form:form>

</body>
</html>