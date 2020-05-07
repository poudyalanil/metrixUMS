<%-- 
    Document   : userDashboard
    Created on : May 6, 2020, 8:15:15 PM
    Author     : goani
--%>
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

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

        <title>User History</title>

        <style>
            .inner{
                margin: 15px 0;
            }
        </style>
    </head>
    <body>
        <br>

        
        <table align="center" cellpadding="5" cellspacing="5" border="1">
            <tr>

            </tr>
            <tr>
               
                <td><b>User ID</b></td>
                <td><b>Last Logged In Date</b></td>
               
            </tr>
            <%
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/metrix?serverTimezone=UTC", "root", "");
                    Statement statement = con.createStatement();
                    String sql = "SELECT * FROM history where uid = "+user.getIduser();

                    ResultSet resultSet = statement.executeQuery(sql);
                    while (resultSet.next()) {
            %>
            <tr>

                
                <td><%=resultSet.getString("uid")%></td>
                <td><%=resultSet.getString("logdate")%></td>
               

            </tr>

            <%
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
        </table>

        <br>
        <a href="EditProfile.jsp">Edit Profile</a>




    </body>
</html>