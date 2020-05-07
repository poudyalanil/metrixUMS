<%@page import="java.util.List"%>
<%@page import="com.metrix.loginpackage.User"%>
<%@page import="com.metrix.loginpackage.ConnectionProvider"%>
<%@page import="CRUDuser.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
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
        <div  class="container-fluid">
            <nav class="navbar navbar-light">
                <a class="navbar-brand">Manage Users</a>
                <a class="navbar-brand" href="adminDashboard.jsp">Home</a>
                <form class="form-inline">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
</nav>
        </div>
<div class="container">
            <div class="inner">
                <div class="row">
                    <div class="col-md-3">
                        <h3>
Create New User</h3>
                  
<form action="AddUserServlet" method="post">
                            <div class="form-group">
                                <label>First Name</label>
                                <input class="form-control" name="fname" place-holder="First Name" required>
                            </div>
<div class="form-group">
                                <label>Middle Name</label>
                                <input class="form-control" name="mname" place-holder="Middle Name">
                            </div>
<div class="form-group">
                                <label>Last Name</label>
                                <input class="form-control" name="lname" place-holder="Last Name" required>
                            </div>
<div class="form-group">
                                <label>Address</label>
                                <input class="form-control" name="address" place-holder="Address" required>
                            </div>
    <div class="form-group">
        <label>Email</label>
                                <input class="form-control" name="email" place-holder="Email" required>
                            </div>
    <div class="form-group">
        <label>Password</label>
        <input class="form-control" name="password" place-holder="Password" required>
                            </div>
<button type="submit" class="btn btn-primary">Submit</button>
                            <button type="reset" class="btn btn-primary">Reset</button>
                        </form>
</div>
<div class="col-md-9">
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
                                <c:forEach var="tempBook" items="${USERS_LIST}">
<tr>
                                        <td>${tempBook.firstName }</td>
                                        <td>${tempBook.middleName }</td>
                                        <td>${tempBook.lastName }</td>
                                        <td>${tempBook.address }</td>
                                        <td>${tempBook.email }</td>
                                        <td>${tempBook.password}</td>
                                        <td><a href="EditUser.jsp?id=${tempBook.iduser }">Edit</a> 
                                            <a href="DeleteUserServlet?id=${tempBook.iduser}">Delete</a></td>
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