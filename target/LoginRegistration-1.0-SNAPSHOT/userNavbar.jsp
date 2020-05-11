<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page import="com.metrix.loginpackage.UserDatabase"%>
<%@page import="com.metrix.loginpackage.User"%>
<%@page import="com.metrix.loginpackage.ConnectionProvider"%>
<% User user = (User) session.getAttribute("logUser"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/userNavbar.css" rel="stylesheet" />
    </head>
    <body>
        <div class="vertical-menu">
            <h2>UMS</h2>
            <a href="userDashboard.jsp" class="active">Dashboard</a>
            <a href="EditProfile.jsp">Profile</a>
            <a href="userHistory.jsp">History</a>
        </div>
        <div class="horizontal-menu">
            <a href="LogoutServlet" class="logout">Logout</a>
            <h3>Hello, <%= user.getFirstName()%></h3>
        </div>
    </body>
</html>
