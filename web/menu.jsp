<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Moudi
  Date: 4/9/2017
  Time: 10:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <title>Menu</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
              integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
                integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.0/jquery-ui.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/wavesurfer.js/1.3.2/wavesurfer.min.js"></script>
        <script src="./js/jquery-3.1.1.min.js"></script>
        <link rel="stylesheet" href="./css/styles.css">
        <script src="./js/menuFuncs.js"></script>
        <script src="./js/sidenav.js"></script>

</head>
<body>



<div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <a href="">Home</a>
    <a href="menu.jsp">Select Artist</a>
    <a href="#">My Profile</a>
    <a href="LogoutController">Logout</a>
</div>

<!-- Use any element to open the sidenav -->
<span onclick="openNav()" class="glyphicon glyphicon-menu-right">Menu
</span>



<div id="main">

<c:if test="${empty user}">
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-md-offset-3 text-center  .col-sm-4">
                <h3>You can not play without logging in</h3>
                <a href="LoginViewjsp.jsp">Login here</a>

            </div>
        </div>


</c:if>


<div class="container">
    <div class="row">
        <div class="col-md-3 col-md-offset-3 text-center  .col-sm-4">
            <h2>Select Artist</h2>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6 col-md-offset-3 .col-sm-6 .col-sm-offset-4">
        <form action="ArtistController" name="formm">
            <c:forEach items="${applicationScope.Artists}" var="artist">
                <div class="col-md-3 col-sm-12 text-center menuItem">
                    <div class="artist" id=${artist.name}><span class="artS">${artist.name}</span> </div>
                </div>
            </c:forEach>
            <input type="hidden" value="" id="artist_name" name="artist">
        </form>
        </div>
    </div>
</div>
    </div>
</body>
</html>
