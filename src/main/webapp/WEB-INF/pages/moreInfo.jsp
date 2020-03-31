<%--
  Created by IntelliJ IDEA.
  User: nganja
  Date: 3/31/2020
  Time: 12:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>More information</title>
</head>
<body>
<c:forEach items="${users}" var="user">
    <p>First Name: ${user.firstName} | Last Name: ${user.lastName} </p>
    <p>Date of birth: ${user.dob}</p>
    <p>Gender: ${user.gender}</p>
</c:forEach>
</body>
</html>
