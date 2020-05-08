<%-- 
    Document   : adminHistory
    Created on : May 8, 2020, 9:36:37 PM
    Author     : goani
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.metrix.loginpackage.UserDatabase"%>
<%@page import="com.metrix.loginpackage.User"%>



<%@ page import="java.util.*" %>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%
    UserDAO userData = new UserDAO(ConnectionProvider.getConnection());
    List<User> user = userData.getAllUsers();
    request.setAttribute("USERS_LIST", user);
   
    
%>

<% User admin = (User) session.getAttribute("logUser");
   
    if(admin==null && admin.getUserRole()==0){
        response.sendRedirect("login.jsp");
    }
%>
<%@page import="java.util.List"%>
<%@page import="com.metrix.loginpackage.User"%>
<%@page import="com.metrix.loginpackage.ConnectionProvider"%>
<%@page import="CRUDuser.UserDAO"%>




<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<style>
    .scrollbar-x {
position: relative;
height: 280px;
overflow: auto;
}
.scrollbar-y {
display: block;
}
    </style>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

        <link href="css/admin.css" rel="stylesheet" />
        
        <title>History</title>

    </head>
    <body>
        <jsp:include page="adminNavbar.jsp" />
        
        
        <div class="container">
            
                <h5 class="max-auto">User History</h5>
                <div class="scrollbar-x scrollbar-y">
                <table class="table table-hover"" align="center" cellpadding="5" cellspacing="5" border="1">
                    <tr>

                    </tr>
                    <tr>
                            <td><b>SN</b></td>
                        <td><b>User ID</b></td>
                        <td><b>Name</b></td>
                         <td><b>Last Logged in Date</b></td>
                         <td><b>Last Profile Updated</b></td>
                         

                    </tr>
                    <%
                        try {
                             Connection conn = ConnectionProvider.getConnection();
                             int count = 0;
                             PreparedStatement pst = conn.prepareStatement("SELECT  fname, ");
                             
                            String sql = "SELECT user.iduser, user.fname,user.lname, user.lastupdated, history.logdate FROM user INNER JOIN history ON user.iduser=history.uid AND user.isadmin=0;";

                            ResultSet res = pst.executeQuery(sql);
                            while (res.next()) {
                                count +=1;
                    %>
                    <tr>

                         <td><%= count%></td>
                        <td><%=res.getString("iduser")%></td>
                        <td><%=res.getString("fname")%> &nbsp;&nbsp; <%=res.getString("lname")%></td>
                        <td><%=res.getString("logdate")%></td>
                        
                         <td><%=res.getString("lastupdated")%></td>


                    </tr>

                    <%}
                        pst.close();
                        res.close();
                            

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    %>
                </table>
                
                
                
            </div>
            <hr>
            
                <h5 class="mx-auto">My History</h5>
                
                <div class="scrollbar-x scrollbar-y">
                <table class="table table-hover"" align="center" cellpadding="5" cellspacing="5" border="1">
                    <tr>

                    </tr>
                    <tr>
                            <td><b>SN</b></td>
                        <td><b>User ID</b></td>
                        <td><b>Name</b></td>
                         <td><b>Last Logged in Date</b></td>
                         <td><b>Last Profile Updated</b></td>
                         

                    </tr>
                    <%
                        try {
                             Connection con = ConnectionProvider.getConnection();
                             int count = 0;
                             PreparedStatement ps = con.prepareStatement("SELECT  fname, ");
                             
                            String sql = "SELECT user.iduser, user.fname,user.lname, user.lastupdated, history.logdate FROM user INNER JOIN history ON user.iduser=history.uid  AND user.iduser = "+admin.getIduser()+";"  ;

                            ResultSet resultSet = ps.executeQuery(sql);
                            while (resultSet.next()) {
                                count +=1;
                    %>
                    <tr>

                         <td><%= count%></td>
                        <td><%=resultSet.getString("iduser")%></td>
                        <td><%=resultSet.getString("fname")%> &nbsp;&nbsp;<%=resultSet.getString("lname")%></td>
                        <td><%=resultSet.getString("logdate")%></td>
                         <td><%=resultSet.getString("lastupdated")%></td>


                    </tr>

                    <%
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    %>
                </table>
            </div>
            
            
            
        </div>
        
        <!-- Bootstrap core JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>          
       
    </body>
</html>