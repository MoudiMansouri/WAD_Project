<%@page import="java.util.Map"%>
<!DOCTYPE html>
<script type="text/javascript">
    function fillFields(){
        <%
            try{
                Map<String, String[]> params = request.getParameterMap();
                if(params!=null){
            String name = params.get("name")[0];
            String username = params.get("uname")[0];
            String password = params.get("password")[0];
            String rPassword = params.get("rPassword")[0];
            String email = params.get("email")[0];
            %>

            document.getElementById("divName").childNodes[3].value = "<%=name%>";
            document.getElementById("divEmail").childNodes[3].value = "<%=email%>";
            <%
            }
            }
            catch(Exception e){
                
        
            }
        %>
    }
</script>
<html>
    <head>
        <link rel="stylesheet" href="./css/style.css" type="text/css"/>
        <title>Registration</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
    </head>
    <body onload="fillFields()" class="form-style-2">
        <div id="content">
            <nav>
                <ul>
                    <a href="#">Home</a>
                    <a href="LoginViewjsp.jsp">Login</a>

                </ul>
            </nav>
            <h1 class="form-style-2-heading">Registration form </h1>   
            <form method="POST" action="RegisterController"> 
                <div class="form-element" id="divName">
                    <label for="name">Name</label>
                    <input type="text" name="name" id="name" size="40" required class="input-field">
                </div>
                <div class="form-element" id="divUsername">
                    <label for="username">Username</label>
                    <input type="text" name="uname" id="uname" required class="input-field">
                </div>
                <div class="form-element" id ="divPassword">
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" required onfocus="resetBorder()" class="input-field">
                </div>
                <div class="form-element" id = "divrPassword">
                    <label for="rPassword">Repeat password</label>
                    <input type="password" name="rPassword" id="rPassword" required onblur="check()" onfocus="resetBorder()" class="input-field">
                    <span id="error" class="red"></span>
                </div>

                <div class="form-element" id = "divEmail">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" required class="input-field">
                </div>
              
                <div class="form-element">
                    <input type="submit" value="Submit">
                    <input type="reset" value="Reset">
                </div>  

            </form>
        </div>


        <script src="./js/jquery-2.2.1.min.js"></script>   
        <script src="./js/javascript.js"></script>

    </body>
</html>

