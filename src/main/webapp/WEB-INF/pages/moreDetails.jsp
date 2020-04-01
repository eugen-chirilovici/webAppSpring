<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Personal Data</title>
    <style type="text/css">
        <%@include file="../resources/style.css"%>
    </style>
</head>
<body>
<h1>${title}</h1>
<br>
<h2>${message}</h2>
<table>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Birth date</th>
    <th>Email</th>
    <c:forEach items="${users}" var="user">
        <tr>
            <td> ${user.firstName} </td>
            <td> ${user.lastName} </td>
            <td> ${user.birthDate} </td>
            <td> ${user.email} </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
