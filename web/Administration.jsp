<%--
  Created by IntelliJ IDEA.
  User: Moudi
  Date: 5/9/2017
  Time: 7:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
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
    <script src="./js/adminFunctions.js"></script>
</head>
<body>



<div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <a href="">Home</a>
    <a href="LogoutController">Logout</a>
</div>

<!-- Use any element to open the sidenav -->
<span onclick="openNav()" class="glyphicon glyphicon-menu-right">Menu
</span>

<div id="main">
    <div class="container">
        <div class="row">

            <div class="col-md-4 col-sm-6 artist-adder">
                <button class="add-artist-button btn btn-default btn-lg btn-block" onclick="showArtistAdder()" id="add-artist-button">Hide Artist Artist</button>
                <form action="AddArtistController" id="artist-adder">
                    <label for="artist-name">Artist Name</label>
                    <input type="text" id="artist-name" name="artistName" onblur="checkExistence()">
                    <button type="submit" onClick="addArtist()">AddArtist</button>
                </form>
            </div>


            <div class="col-md-8 col-sm-6 file-adder">
                <button class="add-song-button btn btn-default btn-lg btn-block" onclick="showSongAdder()" id="add-song-button">Hide Song Adder</button>

                <form action="FileAdder" method="post" enctype="multipart/form-data" id="song-adder">

                    <label for="file-name">File name :</label>
                    <input type="file" id="file-name" name="fileName"><br>

                    <label for="var-answer-one">Answer One</label>
                    <input type="text" id="var-answer-one" name="varAnswerOne">
                    <input type="radio" name="option" value="A"><br>

                    <label for="var-answer-two">Answer Two</label>
                    <input type="text" id="var-answer-two" name="varAnswerTwo">
                    <input type="radio" name="option" value="B"><br>

                    <label for="var-answer-three">Answer Three</label>
                    <input type="text" id="var-answer-three" name="varAnswerThree">
                    <input type="radio" name="option" value="C"><br>

                    <label for="var-answer-four">Answer Four</label>
                    <input type="text" id="var-answer-four" name="varAnswerFour">
                    <input type="radio" name="option" value="D"><br>

                    <label for="artist">Artist</label>
                    <input type="text" name="artist" id="artist">

                    <input type="submit" value="Upload" onclick="addSong()">
                </form>
            </div>

        </div>
    </div>
</div>
</body>
</html>
