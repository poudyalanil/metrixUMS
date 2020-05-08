<%-- 
    Document   : adminLogin
    Created on : May 1, 2020, 11:04:34 AM
    Author     : Binil
--%>
<%
    String errorMsg  =(String) session.getAttribute("error");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css" rel="stylesheet">
    <title>Admin Login</title>
  </head>
  <body>
    
  <div class="container">
      
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto"style="margin-top:130px; padding-top: 20px;padding-bottom: 20px"; >
          <div class="card card-signin my-5 " >
                <% if (errorMsg != null) {%>
                                            <p style="color:red; font-size: 12px;"> 
                                                <%= errorMsg %>
                                                <% session.removeAttribute("error");%>
                                            </p>
                                            <% }%> 
          <div class="card-body">
            <h5 class="card-title text-center"> Admin-SignIn</h5>
            <form class="form-signin" action="AdminLogin" method="POST">
              <div class="form-label-group">
                <input type="email" name="email" class="form-control" placeholder="Email address" required autofocus>
                <label for="inputEmail">Email address</label>
              </div>

              <div class="form-label-group">
                <input type="password" name="password" class="form-control" placeholder="Password" required>
                <label for="inputPassword">Password</label>
              </div>

                <div style='text-align: center;'>
                    <button class="btn btn-md btn-light btn-login" type="submit">Login</button>
                </div>
                                   
              
              </form>
          </div>
        </div>
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
