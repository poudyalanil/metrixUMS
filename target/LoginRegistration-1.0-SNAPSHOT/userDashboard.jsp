<%-- 
    Document   : userDashboard
    Created on : May 6, 2020, 8:15:15 PM
    Author     : goani
--%>
<%@page import="com.metrix.loginpackage.UserDatabase"%>
<%@page import="com.metrix.loginpackage.User"%>
<%@page import="com.metrix.loginpackage.ConnectionProvider"%>


<%@page import="java.util.*" %>
<%@page import="java.time.*" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>


<% User user = (User) session.getAttribute("logUser");
    if(user==null){
        RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
        
       response.sendRedirect("login.jsp");
    }
    else if(user !=null && user.getUserRole() == 1){
         response.sendRedirect("adminDashboard.jsp");
    }
     long now =  System.currentTimeMillis();
     long time = session.getCreationTime();
     
     long sessionTime  =(now-time)/60000;
     
  
    
    
%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

        <link href="css/user.css" rel="stylesheet" />
        
        <title>User Dashboard</title>

        
    </head>
    <body>
        <jsp:include page="userNavbar.jsp" />
        
        <div class="container">
            <h4>Welcome <%= user.getFirstName()%>,</h4>
            <div class="time-card">
                <%= (new java.util.Date().toGMTString())%>
            </div>
        </div>
        <div class="container">
            <div class="card-bg1">
                <div class="card-number">
                    ${accountAge} 
                </div>
                <div class="card-desc">
                    Days Old Account
                </div>
            </div>
            <div class="card-bg2">
                <div class="card-number">
                    ${loginCount}
                </div>
                <div class="card-desc">
                    No. of Times Logged In
                </div>
            </div>
            <div class="card-bg3">
                <div class="card-number">
                  <%
                      out.println( sessionTime);
                      
                       %>
                </div>
                <div class="card-desc">
                    Current Session Time
                </div>
            </div>
        </div>
          
        <!-- Bootstrap core JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
       
    </body>
</html>