
package com.metrix.loginpackage;

import CRUDuser.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditProfile extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditProfile</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditProfile at " + request.getContextPath() + "</h1>");
            
            String firstName = request.getParameter("fname");
            String middleName = request.getParameter("mname");
            String lastName = request.getParameter("lname");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String password =request.getParameter("password");
            
            HttpSession s = request.getSession();
            User user = (User)s.getAttribute("logUser");
            user.setFirstName(firstName);
            user.setMiddleName(middleName);
            user.setLastName(lastName);
            user.setAddress(address);
            user.setEmail(email);
            user.setPassword(password);
            
            try{
                UserDatabase usdao = new UserDatabase(ConnectionProvider.getConnection());
                if(usdao.updateProfile(user)){
                    
                    response.sendRedirect("userDashboard.jsp");
                }else{
                    out.print("wrong cre3dential");
                }
                
            }catch(Exception e){
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
