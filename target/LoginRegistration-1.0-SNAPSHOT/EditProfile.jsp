<!--EditProfile.jsp is used for editing user's profile by the authenticated user-->
<%@page import="com.metrix.loginpackage.UserDatabase"%>
<%@page import="com.metrix.loginpackage.User"%>
<%@page import="com.metrix.loginpackage.ConnectionProvider"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!--//checking if the user is logged in or not-->
<% User user = (User) session.getAttribute("logUser");
    
if (user == null) {
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link href="css/user.css" rel="stylesheet" />
        <title>Edit Profile</title>
    </head>
    <body>
<!--        
        Displaying nav bar according to user's authentication state-->
        <%if(user.getUserRole()==0){%>
            <jsp:include page="userNavbar.jsp" />
        <%}%>
        <%if(user.getUserRole()==1){%>
            <jsp:include page="adminNavbar.jsp" />
        <%}%>
        
        <div class="container">
            <h4>Edit Profile</h4>
            <div class="inner">
                <div class="row">
                    <div class="col-md-7 offset-4">
                        <h3>Enter Your Updated Information</h3>

                        <form action="EditProfile" method="post">
<!--                            form with filled values of the logged in user-->
                            <div class="form-group">
                                <label>First Name</label>
                                <input class="form-control" name="fname" value="<%= user.getFirstName()%>"required>
                            </div>
                            <div class="form-group">
                                <label>Middle Name</label>
                                <input class="form-control" name="mname" value="<%= user.getMiddleName()%>">
                            </div>
                            <div class="form-group">
                                <label>Last Name</label>
                                <input class="form-control" name="lname" value="<%= user.getLastName()%>"required>
                            </div>
                            <div class="form-group">
                                <label>Address</label>
                                <input class="form-control" name="address" value="<%= user.getAddress()%>" required>
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input class="form-control" name="email" value="<%= user.getEmail()%>" required>
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input class="form-control" name="password" value="<%= user.getPassword()%>" required>
                            </div>
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>