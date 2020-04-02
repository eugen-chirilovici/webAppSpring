<%--
  Created by IntelliJ IDEA.
  User: vduca
  Date: 4/3/2020
  Time: 12:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Detailed Information on the User</title>
</head>
<body>
<c:forEach items="${users}" var="user">
    <div>First Name: ${user.firstName}</div>>
    <div>Last Name: ${user.lastName} </div>
    <div>Age: ${user.age} </div>
    <div>Last Name: ${user.gender} </div>
</c:forEach>

</body>
</html>
