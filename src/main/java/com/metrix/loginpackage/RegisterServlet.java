// RegisterServlet is used for regestering new user by guest user
package com.metrix.loginpackage;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
            
            // getting form data
            String firstName = request.getParameter("fname");
            String middleName = request.getParameter("mname");
            String lastName = request.getParameter("lname");
            String address   = request.getParameter("address");
            String email = request.getParameter("email");
            String password =request.getParameter("password");
            
            // getting current date
            LocalDate today = LocalDate.now();
             int userRole = 0;
             int userStatus = 1;
            
            User userModel = new User(firstName,middleName,lastName,address,email,password,today,userRole,userStatus);

            UserDatabase regUser = new UserDatabase(ConnectionProvider.getConnection());
            if (regUser.saveUser(userModel)) {
                response.sendRedirect("login.jsp");
            } else {
               String errorMessage = "User Available";
                HttpSession regSession = request.getSession();
                regSession.setAttribute("RegError", errorMessage);
                response.sendRedirect("registration.jsp");
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
