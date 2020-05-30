// ResetPassword is used for resetting user's password
package com.metrix.loginpackage;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author goani
 */
public class ResetPasswordUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ResetPasswordUser</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResetPasswordUser at " + request.getContextPath() + "</h1>");

            try {
                // getting databse connection
                Connection con = ConnectionProvider.getConnection();
                String email = request.getParameter("emailReset");
                String query = "update metrix.user set password=? where email =?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, "password!!");
                pst.setString(2, email);
                String pass = "Your new updated password is <b>password!!<b>";
                HttpSession s = request.getSession();
                s.setAttribute("newPassword", pass);
                int i = pst.executeUpdate();

                if (i > 0) {
                    response.sendRedirect("login.jsp");
                } else {
                    s.setAttribute("errorReset", "Email is wrong");
                    response.sendRedirect("resetPassword.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
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
