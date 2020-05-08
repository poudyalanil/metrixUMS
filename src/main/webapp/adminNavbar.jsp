<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page import="com.metrix.loginpackage.UserDatabase"%>
<%@page import="com.metrix.loginpackage.User"%>
<%@page import="com.metrix.loginpackage.ConnectionProvider"%>


<% User user = (User) session.getAttribute("logAdmin");%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/adminNavbar.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://kit.fontawesome.com/b8ae0f5cf3.js" crossorigin="anonymous"></script>
        <script src="js/main.js"></script>
        <title></title>
    </head>
    <body>
        <div class="vertical-menu">
            <h2>UMS</h2>
            <a href="adminDashboard" class="active">Dashboard</a>
            <a href="userList.jsp">Users</a>
            <a href="#">Role</a>
            <a href="userHistory.jsp">History</a>
        </div>
        <div class="horizontal-menu">
            <div class="dropdown">
                <i class="dropbtn fas fa-user-circle fa-2x" onclick="myFunction()">
                    <div id="myDropdown" class="dropdown-content">
                        <a href="EditProfile.jsp">Profile</a>
                        <a href="LogoutServlet">Logout</a>
                    </div>
                </i>
            </div>
            <h3>Hello, <%= user.getFirstName()%></h3>
        </div>
        
        
    </body>
</html>
