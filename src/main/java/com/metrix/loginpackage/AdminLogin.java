// AdminLogin is used for loggin admin
package com.metrix.loginpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminLogin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminLogin at " + request.getContextPath() + "</h1>");
             
            // getting login information from login form
            String logemail = request.getParameter("email");
            String logpass = request.getParameter("password");
            
            // getting database connection
            UserDatabase db = new UserDatabase(ConnectionProvider.getConnection());
            User user = db.logAdmin(logemail, logpass);

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("logUser", user);
                try {

                    String sql1 = "INSERT INTO METRIX.HISTORY(UID, LOGDATE) values(?,?);";
                    // getting current date
                    LocalDate date = LocalDate.now();
                    
                    PreparedStatement ptt = db.con.prepareStatement(sql1);
                    ptt.setInt(1, user.getIduser());
                    ptt.setObject(2, date);
                    ptt.execute();
                    ptt.close();
                    String query = "SELECT * FROM USER";
                    PreparedStatement ps = db.con.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();
                    // initializing admincount and client count
                    int adminCount = 0;
                    int clientCount = 0;
                    while (rs.next()) {
                        int userStatus = rs.getInt("status");
                        int isadmin = rs.getInt("isadmin");
                        session.setAttribute("status", userStatus);
                        session.setAttribute("isadmin", isadmin);
                        if (rs.getInt("isadmin") == 0) {
                            clientCount++;

                        } else {
                            adminCount++;
                        }
                    }
                    // getting user's all history
                    String sql = "SELECT * FROM history";
                    PreparedStatement pt = db.con.prepareStatement(sql);
                    ResultSet rt = pt.executeQuery();

                    int totalLogin = 0;
                    while (rt.next()) {
                        totalLogin++;
                    }
                    pt.close();
                    rt.close();
                    session.setAttribute("adminCount", adminCount);
                    session.setAttribute("clientCount", clientCount);
                    session.setAttribute("totalLogin", totalLogin);
                } catch (SQLException e) {

                    System.out.println(e);
                }
                response.sendRedirect("adminDashboard.jsp");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("error", "You got your crendentials wrong OR  Yor are blocked!!");
                response.sendRedirect("adminLogin.jsp");

            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
