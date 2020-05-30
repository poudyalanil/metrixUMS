<!--EditUSer.jsp is for editing the user's information by the admin-->

<%@page import="com.metrix.loginpackage.User"%>
<%@page import="CRUDuser.UserDAO"%>
<%@page import="com.metrix.loginpackage.ConnectionProvider"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Checking user's authentication state and getting database connection-->
<%
    int id = Integer.parseInt(request.getParameter("id"));
    UserDAO dao = new UserDAO(ConnectionProvider.getConnection());
    User usr = dao.getSingleUser(id);
    request.setAttribute("edit_users", usr);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/admin.css"/>
        <title>Edit User Data</title>
    </head>
    <body>
        <jsp:include page="adminNavbar.jsp" />
        <div class=" container">
            <div class="inner">
                <h2>Edit User Form</h2>
                <form action="EditUserServlet" method="post">
<!--                    this forms get the user's details and sets them as values to input field values are grabbed using user's id-->
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
                    <button class="btn btn-primary"><a href="userList.jsp" style="color:white; text-decoration: none;">Cancel</a></button>
                </form>
            </div>
        </div>
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

    </body>
</html>

