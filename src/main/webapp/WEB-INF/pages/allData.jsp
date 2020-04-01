<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>All user data</title>
</head>
<body>
<div>Prenume: ${user.firstName}</div>
<div>Nume: ${user.lastName}</div>
<div>Varsta: ${user.age}</div>
<div>Hobby: ${user.hobby}</div>
</body>
</html>