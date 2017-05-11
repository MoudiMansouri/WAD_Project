

<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' type='text/css' href='./css/style.css'>
        <title>JSP Page</title>
    </head>
    <body class="form-style-2">
        <div id='content'>
            <div class="header">
                <img src="./img/btn_playgame.png" width="100px"/>
                <span class="header-text">Game</span>
            </div>
            <nav>
                <ul>
                    <li><a href='#'>Home</a></li>
                    <li><a href='RegisterView.jsp'>Register</a></li>
                    <li><a href="LogoutController">Logout</a></li>

                </ul>
            </nav>

            <c:set var="error" value="${requestScope.error}" />


            <c:if test= "${error != null}" >
                <h3>${error}</h3>
            </c:if>



            <h1 class="form-style-2-heading">Login form</h1>

            <form method="POST" action="LoginControl">
                <div class="form-element">
                    <label for="username">Username</label>
                    <input type="text" name="uname" id="uname" required class="input-field">
                </div>

                <div class="form-element">
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" required onfocus="resetBorder()" class="input-field">
                </div>

                <div class="form-element">
                    <input type="submit" value="Submit">
                </div> 

            </form>

        </div>

    </body>
</html>
