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
            <% String uri = request.getRequestURI();
            String pageName = uri.substring(uri.lastIndexOf("/")+1);%>
            <a href="userDashboard.jsp" class="<%= (pageName.contentEquals("userDashboard.jsp"))?"active":"" %>" style= "border-top: 1px #F6F6F6 solid;">Dashboard</a>
            <a href="EditProfile.jsp" class="<%= (pageName.contentEquals("EditProfile.jsp"))?"active":"" %>">Profile</a>
            <a href="userHistory.jsp" class="<%= (pageName.contentEquals("userHistory.jsp"))?"active":"" %>">History</a>
        </div>
        <div class="horizontal-menu">
            <a href="LogoutServlet" class="logout">Logout</a>
            <h3>Hello, <%= user.getFirstName()%></h3>
        </div>
    </body>
</html>
