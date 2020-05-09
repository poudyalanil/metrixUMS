<%-- 
    Document   : userRole
    Created on : May 8, 2020, 9:19:17 PM
    Author     : goani
--%>
<%@page import="java.util.List"%>
<%@page import="com.metrix.loginpackage.User"%>
<%@page import="com.metrix.loginpackage.ConnectionProvider"%>
<%@page import="CRUDuser.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>


<% User isuser = (User) session.getAttribute("logUser");
  
  
   
    if(isuser ==null || isuser.getUserRole() == 0){
        response.sendRedirect("index.jsp");
    }
    else if(isuser !=null && isuser.getUserRole()==0){
        response.sendRedirect("userDashboard.jsp");
    }
%>
   
    


<%
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

        <style>
            .inner{
                margin: 15px 0;
            }
        </style>
    </head>
    <body>
         <jsp:include page="adminNavbar.jsp" />
        <div  class="container-fluid">
            <nav class="navbar navbar-light">
                
                <form class="form-inline">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
</nav>
        </div>
<div class="container">
            <div class="inner">
                <div class="row">
                    
<div class="col-md-12">
                        <h3>
User Information from Database</h3>
<table class="table">
                            <thead class="bg-light">
<tr>
                                    <th scope="col">First Name</th>
                                    <th scope="col">Middle Name</th>
                                    <th scope="col">Last Name</th>
                                    <th scope="col">Address</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Password</th>
                                    <th scope="col">Action</th>
                                </tr>
</thead>
                            <tbody>
                                <c:forEach var="user" items="${USERS_LIST}">
<tr>                
                                        
                                            <c:if test="${user.userRole eq 1}">
                                                <td> <abbr title="First Name">${user.firstName }</abbr> <i class="fa fa-check" aria-hidden="true"></i></td>
                                            </c:if>
                                           <c:if test="${user.userRole eq 0}">
                                            <td >${user.firstName }</td>
                                            </c:if>
                                        <td>${user.middleName }</td>
                                        <td>${user.lastName }</td>
                                        <td>${user.address }</td>
                                        <td>${user.email }</td>
                                        <td>${user.password}</td>
                                
                                            
                                            
                                            <c:choose>
                                                <c:when test="${user.userRole eq 0}">
                                                    <td> <a class="text-success" href="Unblock?id=${user.iduser}">Make Admin</a></td>
                                                </c:when>
                                                <c:otherwise>
                                                   <td> <a class="text-warning" href="BlockUserServlet?id=${user.iduser}">Make Normal User</a></td>
                                                </c:otherwise>
                                            </c:choose>
                                            
                                        
                                    </tr>
</c:forEach>
                            </tbody>
                        </table>
</div>
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