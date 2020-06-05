<%-- 
    Document   : userRole
    Created on : May 8, 2020, 9:19:17 PM
    Author     : goani
--%>
<!--userRole.jsp is used for setting user's roles by the admin-->
<%@page import="java.util.List"%>
<%@page import="com.metrix.loginpackage.User"%>
<%@page import="com.metrix.loginpackage.ConnectionProvider"%>
<%@page import="CRUDuser.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<% User isuser = (User) session.getAttribute("logUser");
    if (isuser == null || isuser.getUserRole() == 0) {
        response.sendRedirect("index.jsp");
    } else if (isuser != null && isuser.getUserRole() == 0) {
        response.sendRedirect("userDashboard.jsp");
    }
    UserDAO userData = new UserDAO(ConnectionProvider.getConnection());
    List<User> user = userData.getAllUsers();
    request.setAttribute("USERS_LIST", user);
%>


<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

        <title>User Management</title>

        <link href="css/admin.css" rel="stylesheet" />
        
    </head>
    <body>
        <jsp:include page="adminNavbar.jsp" />
        <div class="container">
            <div class="inner">
                <h2>Roles</h2>
                <div class="history-card-bg">
                    <table class="table table-hover" align="center" cellpadding="5" cellspacing="5">
                        <thead class="bg-light">
                            <tr>
                                <th scope="col">Full Name</th>
                                <th scope="col">Authenticated User</th>
                                <th scope="col">Administrator</th>
                            </tr>
                        </thead>
                        <tbody>
<!--                            admin has option to make user normal user and admin-->
                            <c:forEach var="user" items="${USERS_LIST}">
                                <tr>
                                    <c:if test="${user.userRole eq 1}">
                                        <td> <abbr title="First Name">${user.firstName } ${user.middleName } ${user.lastName }</abbr> <i class="fa fa-check" aria-hidden="true"></i></td>
                                    </c:if>
                                    <c:if test="${user.userRole eq 0}">
                                        <td >${user.firstName } ${user.middleName } ${user.lastName }</td>
                                    </c:if>
                                    <c:choose>
                                        <c:when test="${user.userRole eq 0}">
                                            <td><input type="radio" checked="checked" onclick="location.href='MakeNormalUser?id=${user.iduser}';"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><input type="radio" onclick="location.href='MakeNormalUser?id=${user.iduser}';"></td>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${user.userRole eq 1}">
                                            <td><input type="radio" checked="checked" onclick="location.href='MakeAdmin?id=${user.iduser}';"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><input type="radio" onclick="location.href='MakeAdmin?id=${user.iduser}';"></td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    </body>
</html>