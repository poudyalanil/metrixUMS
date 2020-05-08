<%-- 
    Document   : userRegister
    Created on : Apr 25, 2020, 7:59:53 AM
    Author     : goani
--%>


<%@page import="com.metrix.loginpackage.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% User user = (User) session.getAttribute("logUser");
   
    if(user ==null || user.getUserRole() == 0){
        response.sendRedirect("index.jsp");
    }if(user !=null && user.getUserRole()==0){
        response.sendRedirect("userDashboard.jsp");
    }
%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

   
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css" type="text/css" rel="stylesheet">
    <title>Register</title>
  </head>
 
<body>
  <div class="container-fluid">
            <div class="row no-gutter">
                <div class="d-none d-md-flex col-md-4 col-lg-6 mgreen" >
                    <div class="container know-us"> 
                        <h1><span class="random">Add New Admin to</span><span class="logo"> USM</span></h1>
                        <p>
                            Boy the way Glen Miller played, songs that made the hit parade. Guys like us we had it made, those were the days. And you knew who you were then, girls were girls and men were men. Mister, we could use a man like Herbert Hoover again. Didn't need no welfare state, everybody pulled his weight. Gee our old LaSalle ran great. Those were the days.
                        </p>
                        <div style="text-align: center;">
                            <button class="btn btn-sm btn-outline-light" style="text-align: center;">Know Us</button>
                        </div>
                    </div>
                </div>
                <div class="col-md-8 col-lg-6">
                    <div class="login d-flex align-items-center py-5 alignus">
                        <div class="container">
                            <div class="row"  >
                                <div class="col-md-9 col-lg-8 mx-auto" >
                                    <h3 class="login-heading mb-4">Enter Admin Information</h3>
                                    <form action="AdminRegister" method="POST">
                                        <div class="form-label-group">
                                            <input type="text" name ="fname" class="form-control" placeholder="First Name" required autofocus>
                                            <label for="fname">First Name</label>
                                        </div>
                                        <div class="form-label-group">
                                            <input type="text" name ="mname" class="form-control" placeholder="Middle Name" >
                                            <label for="mname">Middle Name</label>
                                        </div>
                                        <div class="form-label-group">
                                            <input type="text" name ="lname" class="form-control" placeholder="Last Name" required>
                                            <label for="lname">Last Name</label>
                                        </div>
                                        <div class="form-label-group">
                                            <input type="number" name ="phno" class="form-control" placeholder="Phone Number" required>
                                            <label for="phno">Phone Number</label>
                                        </div>
                                        <div class="form-label-group">
                                            <input type="text" name ="address" class="form-control" placeholder="Address" required>
                                            <label for="address">Address</label>
                                        </div>

                                        <div class="form-label-group">
                                            <input type="email" name="email" class="form-control" placeholder="Email address" required>
                                            <label for="email">Email address</label>
                                        </div>
                                        <!--               <div class="form-label-group">   
                                                            <input type="file" class="custom-file-input" id="validatedCustomFile" required>
                                                             <label class="custom-file-label" for="validatedCustomFile">Choose file...</label>
                                            
                                                            </div>
                                        -->

                                        <div class="form-label-group">
                                            <input type="password" name = "password"  class="form-control" placeholder="Password" required>
                                            <label for="password">Password</label>
                                        </div>
                                        <div class="form-label-group">
                                            <input type="password" name="repassword"  class="form-control" placeholder="Confirm Password" required>
                                            <label for="rePassword"> Confirm Password</label>
                                        </div>

                                        <div style='text-align: center;'>
                                            <button class="btn btn-md btn-outline-light btn-login" type="submit" href="adminLogin.jsp">SignUp</button>
                                        </div>
                                        
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <a class="small" style="float: right; margin: -40px 20px 0px 0px;" href="adminLogin.jsp">SignIn</a>
                </div>
            </div>
        </div>

      
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>