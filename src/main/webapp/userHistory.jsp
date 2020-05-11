<%-- 
    Document   : userDashboard
    Created on : May 6, 2020, 8:15:15 PM
    Author     : goani
--%>
<%@page import="com.metrix.loginpackage.ConnectionProvider"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.metrix.loginpackage.User"%>
<%@ page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% User user = (User) session.getAttribute("logUser");
    if (user == null) {
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link href="css/user.css" rel="stylesheet" />
        <title>User History</title>
    </head>
    <body>
        <jsp:include page="userNavbar.jsp" />
        <div class="container">
            
            <h2><%= user.getFirstName()%>'s History</h2>
            

            <div class="inner">
                 <ul class="list-group list-group-flush">
                     <li class="list-group-item list-group-item-primary"><p> You joined <b>Metrix UMS</b> on <%= user.getJoinDate()%>.</p></li>
                                          <li class="list-group-item list-group-item-primary"> You have logged into the system for <b>${loginCount}</b> times.</li>
                                          <br>
                                           <li class="list-group-item list-group-item-dark"> Your Login Sequence</li>
                                           <div style="overflow:scroll; height: 380px">
                                           

                <%
                    try {
                        Connection con = ConnectionProvider.getConnection();
                       

                        String sql = "SELECT user.iduser, user.fname,user.lname, user.lastupdated, history.logdate FROM user INNER JOIN history ON user.iduser=history.uid  AND user.iduser = " + user.getIduser() + " order by history.logdate DESC;";
                        PreparedStatement ps = con.prepareStatement(sql);
                        ResultSet rs = ps.executeQuery(sql);
                        
                        int count = 0;
                       
                        while (rs.next()) {
                            count++;
                            
                %>
                
                    <li class="list-group-item">
                        <%= count%> | &nbsp;&nbsp;&nbsp;
                    You logged into your dashboard on
                       <b> <%=rs.getString("logdate") %></b>
                    
                    </li>
                   
                    
                 
                <%
                        }%>
                 </div>  
                                           </ul>
                <%

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                %>

            </div>
        </div>
    </body>
</html>