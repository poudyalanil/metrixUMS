<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.metrix.loginpackage.UserDatabase"%>
<%@page import="com.metrix.loginpackage.User"%>
<%@page import="com.metrix.loginpackage.ConnectionProvider"%>

<% User user = (User) session.getAttribute("logUser");%>

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
            <% String uri = request.getRequestURI();
            String pageName = uri.substring(uri.lastIndexOf("/")+1);%>
            <a href="adminDashboard.jsp" class="<%= (pageName.contentEquals("adminDashboard.jsp"))?"active":"" %>" style="border-top: 1px #F6F6F6 solid;">Dashboard</a>
            <a href="userList.jsp" class="<%= (pageName.contentEquals("userList.jsp"))?"active":"" %>">Users</a>
            <a href="userRole.jsp" class="<%= (pageName.contentEquals("userRole.jsp"))?"active":"" %>">Role</a>
            <a href="adminHistory.jsp" class="<%= (pageName.contentEquals("adminHistory.jsp"))?"active":"" %>">History</a>
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
