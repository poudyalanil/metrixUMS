<%-- 
    Document   : resetPassword
    Created on : May 8, 2020, 11:12:33 PM
    Author     : goani
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.metrix.loginpackage.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ${error}
        <form method="POST" action="${pageContext.request.contextPath}/ResetPasswordUser">
            <input  name="emailReset" type="email" placeholder="Enter your email to reset password">
            <button type="submit"  >Submit</button>
        </form>>
    </body>
</html>
