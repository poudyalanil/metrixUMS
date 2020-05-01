<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
     <link rel="stylesheet" href="css/login.css" type="text/css" rel="stylesheet">
    <title>User Login</title>
  </head>
  <body>
    
  <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto"style="margin-top:130px; padding-top: 20px;padding-bottom: 20px"; >
          <div class="card card-signin my-5 " >
          <div class="card-body">
            <h5 class="card-title text-center"> User Sign In</h5>
            <form class="form-signin" action="LoginServlet" method="POST">
              <div class="form-label-group">
                <input type="email" name="email" class="form-control" placeholder="Email address" required autofocus>
                <label for="inputEmail">Email address</label>
              </div>

              <div class="form-label-group">
                <input type="password" name="password" class="form-control" placeholder="Password" required>
                <label for="inputPassword">Password</label>
              </div>

              
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Sign in</button>
              
              </form>
            <a href="registration.jsp" style="text-align:center;">Create Account</a>
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