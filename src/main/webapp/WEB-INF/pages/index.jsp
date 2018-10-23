<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style type="text/css">
        <%@include file="../resources/style.css"%>
    </style>
</head>
<body>
<h6>${message}</h6>
<div align="center">
    <div style="width: 300px; height: 500px;">
        <form:form method="POST" action="login">
            <div class="imgcontainer">
                <img src="../resources/incognito.jpg" alt="Avatar" class="avatar">
            </div>
            <h3 align="center" style="color:maroon;">Hi there! Log in, please</h3>

            <div class="container" align="left">
                <label>Username</label>
                <input type="text" name="name" required="required"/>

                <label>Password</label>
                <input type="password" name="password" required="required"/>

                <form action="" >
                    <input type="radio" name="genders" value="MALE"> Male<br>
                    <input type="radio" name="genders" value="FEMALE"> Female<br>
                </form>

                <button type="submit">Login</button>

            </div>
        </form:form>
    </div>
</div>
</body>
</html>
