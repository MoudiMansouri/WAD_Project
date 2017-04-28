<%-- 
    Document   : LoginView
    Created on : Mar 28, 2016, 10:20:28 AM
    Author     : E-M
--%>

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
    <body>
        <div id='content'>
            <div class="header">
                <img src="./img/btn_playgame.png" width="100px"/>
                <span class="header-text">Game</span>
            </div>
            <nav>
                <ul>
                    <li><a href='#'>Home</a></li>
                    <li><a href='LoginView'>Register</a>
                    <li><a href='#'>Contact</a>

                </ul>
            </nav>

            <c:set var="error" value="${requestScope.get('error')[0]}" />


            <c:if test= "${error != null}" >
                <h3>${error}</h3>
            </c:if>



            <h1>LOGIN</h1>

            <form method="POST" action="LoginControl">
                <div class="form-element">
                    <label for="username">Username</label>
                    <input type="text" name="uname" id="uname" required >
                </div>

                <div class="form-element">
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" required onfocus="resetBorder()">
                </div>

                <div class="form-element">
                    <input type="submit" value="Submit">
                </div> 

            </form>

        </div>

    </body>
</html>
