package com.metrix.loginpackage;

import java.io.IOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String logemail = request.getParameter("email");
        String logpass = request.getParameter("password");

        UserDatabase db = new UserDatabase(ConnectionProvider.getConnection());
        User user = db.logUser(logemail, logpass);
        HttpSession session = request.getSession();
        if (user != null) {
            session.setAttribute("isLoggedIn", "true");
            String sql = "SELECT * from history where uid = " + user.getIduser();

            try {
                PreparedStatement p = db.con.prepareStatement(sql);
                ResultSet rs = p.executeQuery();
                int loginCount = 0;
                while (rs.next()) {
                    loginCount++;
                }
                session.setAttribute("loginCount", loginCount);
            } catch (SQLException e) {
                System.out.println(e);
            }

            int accountAge = LocalDate.now().compareTo(user.getJoinDate());

            session.setAttribute("logUser", user);
            session.setAttribute("joinDate", user.getJoinDate());

            session.setAttribute("accountAge", accountAge);

            String query = "INSERT INTO METRIX.HISTORY(UID, LOGDATE) values(?,?);";
            LocalDate date = LocalDate.now();
            
            
            try {
                PreparedStatement ps = db.con.prepareStatement(query);
                ps.setInt(1, user.getIduser());
                ps.setObject(2, date);
                ps.execute();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            response.sendRedirect("userDashboard.jsp");

        } else {
            
            
            
                session.setAttribute("error", "Wrong Crendentials!!! OR You have been Blocked");
                
            
            
            
            
            response.sendRedirect("login.jsp");

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
