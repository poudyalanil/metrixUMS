<%@page import="com.metrix.loginpackage.UserDatabase"%>
<%@page import="com.metrix.loginpackage.User"%>
<%@page import="com.metrix.loginpackage.ConnectionProvider"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% User user = (User) session.getAttribute("logUser");
    if(user==null){
        response.sendRedirect("index.jsp");
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

        <title>Edit Profile</title>

        <style>
            .inner{
                margin: 15px 0;
            }
        </style>
    </head>
    <body>
        <div  class="container-fluid">
            <nav class="navbar navbar-light">
                <a class="navbar-brand">Edit Profile</a>
                <a class="navbar-brand" href="welcome.jsp">Home</a>
                
        </div>
<div class="container">
            <div class="inner">
                <div class="row">
                    <div class="col-md-3">
                        <h3>
Enter Your Updated Information</h3>
                  
                        <form action="EditProfile" method="post">
                            <div class="form-group">
                                <label>First Name</label>
                                <input class="form-control" name="fname" value="<%= user.getFirstName() %>"required>
                            </div>
<div class="form-group">
                                <label>Middle Name</label>
                                <input class="form-control" name="mname" value="<%= user.getMiddleName() %>">
                            </div>
<div class="form-group">
                                <label>Last Name</label>
                                <input class="form-control" name="lname" value="<%= user.getLastName() %>"required>
                            </div>
<div class="form-group">
                                <label>Address</label>
                                <input class="form-control" name="address" value="<%= user.getAddress() %>" required>
                            </div>
    <div class="form-group">
        <label>Email</label>
                                <input class="form-control" name="email" value="<%= user.getEmail() %>" required>
                            </div>
    <div class="form-group">
        <label>Password</label>
        <input class="form-control" name="password" value="<%= user.getPassword() %>" required>
                            </div>
<button type="submit" class="btn btn-primary">Submit</button>
                            </form>
                    </div>