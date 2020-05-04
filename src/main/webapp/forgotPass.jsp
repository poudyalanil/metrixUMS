<%-- 
    Document   : forgotPass
    Created on : May 4, 2020, 9:39:32 PM
    Author     : College
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <form action = "ResetPass" method="post">
            <h1> Reset Pass </h1>
            Enter email:<input type = "email" name="email"><br>
            New Password:<input type ="password" name="password"><br>
            Confirm Password:<input type ="password" name="repassword">
            <input type ="submit" value="Click">
            
        </form>
    </center>
        
    </body>
</html>
