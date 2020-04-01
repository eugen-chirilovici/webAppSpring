<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dcrudu
  Date: 4/1/2020
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        <%@include file="../resources/style.css"%>
    </style>
    <title>moreDetails</title>
</head>
<body>
<c:forEach items="${users}" var="user">
    <p>First Name: ${user.firstName} | Last Name: ${user.lastName} | Hobby: ${user.hobby} |
        Music preferences: ${user.musicPreferences} | Age: ${user.age}</p>
</c:forEach>
</body>
</html>
