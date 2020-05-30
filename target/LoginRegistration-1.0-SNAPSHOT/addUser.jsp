<%-- 
    Document   : addUser
    Created on : May 22, 2020, 1:07:05 PM
    Author     : Binil
--%>
<!--addUser.jsp is used for adding normal user by the authenticated admin-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New User</title>
    </head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link href="css/admin.css" rel="stylesheet" />
    <body>
        <jsp:include page="adminNavbar.jsp" />
        <div class="container">
            <div class="inner">
                <a href="userList.jsp"><button class="btn btn-light float-right" style="box-shadow: 0px 2px 5px 0px rgba(0,0,0,0.5); margin-top: 5vh;">Go Back</button></a>
                <h2>Create New User</h2>
                <form action="AddUserServlet" method="post">
<!--                    this for is used to enter the deatils of new user-->
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
                        <input class="form-control" minlength="8" name="password" place-holder="Password" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <button type="reset" class="btn btn-primary">Reset</button>
                </form>
            </div>
        </div>
    </body>
</html>
