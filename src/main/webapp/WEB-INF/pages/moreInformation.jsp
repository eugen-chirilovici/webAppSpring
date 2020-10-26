<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DSprinceac
  Date: 10/22/2020
  Time: 1:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Personal Data</title>
</head>
<body>
This is full personal data of all users:
<br>
<c:forEach items="${users}" var="user">
    <p>User Id: ${user.userId} | First Name: ${user.firstName} | Last Name: ${user.lastName} | Age: ${user.age} | Is Married: ${user.married}</p>
</c:forEach>
</body>
</html>
