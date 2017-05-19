<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="Entity.SongsEntity" %><%--
  Created by IntelliJ IDEA.
  User: Moudi
  Date: 3/29/2017
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Playing...</title>
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
  <script src="./js/answersFuncs.js"></script>
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



<div class="container">

<div class="row">
  <div class="col-md-6 col-md-offset-3 text-center col-centered">
    <h2>What are they even saying?</h2>
      <div class="wave1"></div>
  </div>
</div>


<%
  Integer num = (Integer) request.getSession().getAttribute("num");
  List<SongsEntity> songs = (List<SongsEntity>) request.getSession().getAttribute("songs");
  SongsEntity song = songs.get(num);
  pageContext.setAttribute("num",num);
  pageContext.setAttribute("song", song);
  pageContext.setAttribute("songs", songs);
%>

    <div class="row">
          <div class="col-md-3 col-md-offset-4 col-centered text-center">
              <div id="score" class="hidden">Your scored </div>
          </div>
    </div>

<div class="row">
    <div class="col-md-3 col-md-offset-4 col-centered text-center">
        <div id="song" class="" /></div>
        <div id="number" class=<c:out value="${num}" />></div>

        <script>
          var num = $("#number").attr('class');
          var songsArray = [];
          <c:set var="counter" value="0" scope="page"/>
          <c:forEach items="${songs}" var="songs">
          songsArray[${pageScope.counter}] ="${songs.filePath}";
          <c:set var="counter" value="${counter + 1}" scope="page"/>
          </c:forEach>
          var path = songsArray[num];
          $("#song").addClass(path);
        </script>

        <c:set var="count" value="0" scope="page"/>
</div>

    <div class="row">
        <div class="col-md-3 col-md-offset-4 col-centered text-center">
        <c:forEach items="${songs}" var="songs">
                <form action="AnswerController" name="answers_form" >
                <div class="hidden" id="answers_furm<c:out value="${count}"/>">
                    <div class="answer" id="A"><c:out value="${songs.varAnswerOne}"/></div>
                    <div class="answer" id="B"><c:out value="${songs.varAnswerTwo}"/></div>
                    <div class="answer" id="C"><c:out value="${songs.varAnswerThree}"/></div>
                    <div class="answer"  id="D"><c:out value="${songs.varAnswerFour}"/></div>
                    <input type="hidden" name="option" value="" id="answer_id">
                </div>
          <c:set var="count" value="${count + 1}" scope="page"/>
        </c:forEach>
    </form>
    </div>

        <div id="current-score" class=" col-md-3 col-md-offset-4 col-centered text-center"></div>
</div>

</div>
    </div>
<script>
    var show_num = $("#number").attr('class');
    $("#answers_furm".concat(show_num)).addClass('shown').removeClass("hidden");
</script>
<script src="./js/wave.js"></script>

</body>
</html>