<%-- 
    Document   : userDashboard
    Created on : May 6, 2020, 8:15:15 PM
    Author     : goani
--%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.metrix.loginpackage.UserDatabase"%>
<%@page import="com.metrix.loginpackage.User"%>



<%@ page import="java.util.*" %>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%
    UserDAO userData = new UserDAO(ConnectionProvider.getConnection());
    List<User> user = userData.getAllUsers();
    request.setAttribute("USERS_LIST", user);
   
    
%>

<% User admin = (User) session.getAttribute("logUser");
   
    if(admin==null && admin.getUserRole()==0){
        response.sendRedirect("login.jsp");
    }
%>
<%@page import="java.util.List"%>
<%@page import="com.metrix.loginpackage.User"%>
<%@page import="com.metrix.loginpackage.ConnectionProvider"%>
<%@page import="CRUDuser.UserDAO"%>




<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

        <link href="css/admin.css" rel="stylesheet" />
        
        <title>Admin Dashboard</title>

    </head>
    <body>
        <jsp:include page="adminNavbar.jsp" />
        
        <div class="container">
            <h4>Welcome Admin, 
            <%= admin.getUserRole()%>
            
            </h4>
            <div class="time-card">
                <%= (new java.util.Date()).toLocaleString()%>
            </div>
        </div>
        <div class="container">
            <div class="card-bg">
                <div class="card-number">
                <%= session.getAttribute("clientCount")%>
                </div>
                <div class="card-desc">
                    Total Clients
                </div>
            </div>
            <div class="card-bg">
                <div class="card-number">
               <%= session.getAttribute("adminCount")%>
                </div>
                <div class="card-desc">
                    Total Admins
                </div>
            </div>
            <div class="card-bg">
                <div class="card-number">
                   <%= session.getAttribute("totalLogin")%>
                </div>
                <div class="card-desc">
                    Total Logins
                </div>
            </div>
        </div>
        
        <!-- Bootstrap core JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>          
       
    </body>
</html>