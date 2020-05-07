<%-- 
    Document   : userDashboard
    Created on : May 6, 2020, 8:15:15 PM
    Author     : goani
--%>
<%@page import="com.metrix.loginpackage.UserDatabase"%>
<%@page import="com.metrix.loginpackage.User"%>
<%@page import="com.metrix.loginpackage.ConnectionProvider"%>


<%@ page import="java.util.*" %>



<%@page contentType="text/html" pageEncoding="UTF-8"%>


<% User user = (User) session.getAttribute("logUser");
    if(user==null){
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

        <title>User Dashboard</title>

        <style>
            .inner{
                margin: 15px 0;
            }
        </style>
    </head>
    <body>
        <br>
        <br>
     <h4>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Today's Date: <%= (new java.util.Date()).toLocaleString()%>
          
        </h4>
              <hr>
              <h4>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Session Time Date: ${sessionTime}
          
        </h4>
              <hr>
              <h4>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Account Age:
            
        </h4><br>
              <hr>
              <br>
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <p>
              <a href="EditProfile.jsp">Profile</a>
              <br>
               <a href="userHistory.jsp">My History</a>
              </p>
           
       
    </body>
</html>