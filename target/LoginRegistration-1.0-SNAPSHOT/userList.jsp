<%@page import="java.util.List"%>
<%@page import="com.metrix.loginpackage.User"%>
<%@page import="com.metrix.loginpackage.ConnectionProvider"%>
<%@page import="CRUDuser.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<% User isuser = (User) session.getAttribute("logUser");

    if (isuser == null) {
        RequestDispatcher rd = request.getRequestDispatcher("adminLogin.jsp");
        rd.forward(request, response);

       
    } else if (isuser != null && isuser.getUserRole() == 0) {
        response.sendRedirect("userDashboard.jsp");
    }

    UserDAO userData = new UserDAO(ConnectionProvider.getConnection());
    List<User> user = userData.getAllUsers();
    request.setAttribute("USERS_LIST", user);
%>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <style>
            .scrollbar-x {
                position: relative;
                height: 200px;
                overflow: auto;
            }
            .scrollbar-y {
                display: block;
            }
        </style>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        
        <link href="css/admin.css" rel="stylesheet" />
        
        <title>User Management</title>

        
    </head>
    <body>
        <jsp:include page="adminNavbar.jsp" />
        <div  class="container-fluid">
            <nav class="navbar navbar-light" style="float: right; margin-top: 40px; margin-right: 80px;">
                <form class="form-inline">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </nav>
        </div>
        <div class="container">
            <a href="registerAdmin.jsp"><button class="btn btn-light float-right" style="box-shadow: 0px 2px 5px 0px rgba(0,0,0,0.5); margin-top: 5vh;">Create Admin User</button></a>
            <div class="inner">
                <h2> User List </h2>
                <div class="history-card-bg">
                    <table class="table table-hover" align="center" cellpadding="5" cellspacing="5" border="0">
                        <thead class="bg-light">
                            <tr>
                                <th scope="col">Full Name</th>
                                <th scope="col">Address</th>
                                <th scope="col">Email</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" items="${USERS_LIST}">
                                <tr>
                                    <td>
                                        <c:if test="${user.userRole eq 1}">
                                            <b>${user.firstName } ${user.middleName } ${user.lastName }</b>
                                        </c:if>
                                        <c:if test="${user.userRole eq 0}">
                                            ${user.firstName } ${user.middleName } ${user.lastName }
                                        </c:if>
                                    </td>
                                    <td>${user.address }</td>
                                    <td>${user.email }</td>
                                    <td><a href="EditUser.jsp?id=${user.iduser }">Edit</a> 
                                        <a class="text-danger" href="DeleteUserServlet?id=${user.iduser}">Delete</a>
                                        <a class="text-success" href="ResetPasswordServlet?id=${user.iduser}">Reset Password</a>
                                        <c:choose>
                                            <c:when test="${user.userStatus eq 0}">
                                                <a class="text-success" href="Unblock?id=${user.iduser}">UnBlock</a></td>
                                            </c:when>
                                            <c:otherwise>
                                    <a class="text-warning" href="BlockUserServlet?id=${user.iduser}">Block</a></td>
                                </c:otherwise>
                            </c:choose>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <a class="btn btn-light" style="float: right; margin-right:20px; border-radius: 5px; box-shadow: 0px 2px 5px 0px rgba(0,0,0,0.5);" href="addUser.jsp">Add User</a>
                </div>
            </div>
        </div>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    </body>         

</body>
</html>