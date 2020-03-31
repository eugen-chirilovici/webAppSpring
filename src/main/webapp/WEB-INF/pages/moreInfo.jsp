<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <title>${title}</title>
</head>
<body>
<h1>${message}</h1>
<c:forEach items="${users}" var="user">
    <p>First Name: ${user.firstName} | Last Name: ${user.lastName} </p>
    <p>Date of birth: ${user.dob}</p>
</c:forEach>
</body>
</html>
