<%-- 
    Document   : Profile
    Created on : May 6, 2017, 6:04:35 PM
    Author     : Eduok Etinyene
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>MY PROFILE</h1>
      <form name="profile" action="search" method="post">
      <table border="0" width="300" align="center" bgcolor="#e9fh">
        <tr><td colspan=2 style="font-size:12pt;" align="center">
        <h3>Search Details</h3></td></tr>
        <tr><td ><b>ID:</b></td>
          <td>: <input  type="text" name="Id" id="Id">
        </td></tr>      
        <tr><td colspan=2 align="center">
        <input  type="submit" value="Search" ></td></tr>
      </table>
</form>
    </body>
</html>
