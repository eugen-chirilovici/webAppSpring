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
<h1>Hi, Welcome to our super-puper secret page!</h1>
<br>
<h2>Here are all our users:</h2>
<c:forEach items="${users}" var="user">
    <p>Name: ${user.name} | Password: ${user.password} </p>
</c:forEach>

<p>
    <h3>View: </h3>
    <a href="/allusers/male">male</a>
    <a href="/allusers/female"> female</a>
    <a href="/allusers"> allUsers</a>

</p>



</body>
</html>