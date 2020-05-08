<%@page import="com.metrix.loginpackage.User"%>
<%@page import="CRUDuser.UserDAO"%>
<%@page import="com.metrix.loginpackage.ConnectionProvider"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    UserDAO dao = new UserDAO(ConnectionProvider.getConnection());
    User usr = dao.getSingleUser(id);
    request.setAttribute("edit_users", usr);
%>
<!DOCTYPE html>
<html>
    <head>
         <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

        <title>Edit User Data</title>
        <style>
            .inner{
                position: relative;
                margin: 0 auto;
                width: 650px;
                display: block;
                padding: 50px 0;
            }
            h3{
                text-align: center;
                border-bottom: 2px solid midnightblue;
                margin-bottom: 20px;
            }
            nav li a{
                font-size: 25px;
                font-weight: 500;
            }
            a{
                color: #fff;
                text-decoration: none;
            }
        </style>
    </head>
    <body>
       <div  class="container-fluid">
            <nav class="navbar navbar-light">
                <a class="navbar-brand">Edit User Form</a>
                <ul class="navbar-nav ml-auto mt-3 mx-5">
<li class="nav-item">
                            <a class="nav-link active" href="adminDashboard.jsp">Home</a>
                        </li>
</ul>
</nav>
        </div>
<div class="inner">
            <div class=" container">
                <div class="row">
                    <div class="col-12">
                        <h3>
Edit User Details</h3>
<form action="EditUserServlet" method="post">
                            <div class="form-group">
                                <label>User ID: ${edit_users.iduser }</label>
                               
                               
                            </div>
                            
<div class="form-group">
                                <label>First Name</label>
                                <input class="form-control" name="fname" value="${edit_users.firstName }" required>
                            </div>
                            
<div class="form-group">
                                <label>Middle Name</label>
                                <input class="form-control" name="mname" value="${edit_users.middleName}">
                            </div>
                            
<div class="form-group">
                                <label>Last Name</label>
                                <input class="form-control" name="lname" value="${edit_users.lastName}" required>
                            </div>
                            
<div class="form-group">
                                <label>Address</label>
                                <input class="form-control" name="address" value="${edit_users.address }" required>
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input class="form-control" name="email" value="${edit_users.email }" required>
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input class="form-control" name="password" value="${edit_users.password }" required>
                            </div>
<button name="iduser" value="${edit_users.iduser }" type="submit" class="btn btn-primary">Submit</button>
<button class="btn btn-primary"><a href="userList.jsp">Cancel</a></button>
                        </form>
</div>
</div>
</div>
</div>
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        
    </body>
</html>

