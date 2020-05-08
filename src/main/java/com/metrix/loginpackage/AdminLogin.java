/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrix.loginpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author College
 */
public class AdminLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
            
            String logemail = request.getParameter("email");
            String logpass = request.getParameter("password");
            
            UserDatabase db =  new UserDatabase(ConnectionProvider.getConnection());
            User user = db.logAdmin(logemail, logpass);
            List <String> fname = new ArrayList<String>();
            
            if(user!=null){
                HttpSession session = request.getSession();
                session.setAttribute("logAdmin", user);
               
                String query = "SELECT * FROM user INNER JOIN history on user.iduser=history.uid;";
                try{
                PreparedStatement ps = db.con.prepareStatement(query);
                ResultSet rs  =ps.executeQuery();
                int userCount = 0;
                int adminCount= 0;
                HttpSession s = request.getSession();
                while(rs.next()){
                    int id = rs.getInt("iduser");
                    fname.add(rs.getString("fname"));
                    //String fname = rs.getString("fname");
                    String mname = rs.getString("mname");
                    String email = rs.getString("email");
                    String lastUpdated = rs.getString("lastupdated");
                    String lname = rs.getString("lname");
                    String address = rs.getString("address");
                    String joinDate = rs.getString("joindate");
                    int role =  rs.getInt("isadmin");
                    int status = rs.getInt("status");
                    String lastlog = rs.getString("logdate");
                   if(role ==1){
                       adminCount ++;
                   }else{
                       userCount ++;
                   }
                s.setAttribute("uid", id);
                s.setAttribute("fname", fname);
                s.setAttribute("mname", mname);
                s.setAttribute("lname", lname);
                s.setAttribute("email", email);
                s.setAttribute("lastUpdated", lastUpdated);
                s.setAttribute("address", address);
                s.setAttribute("joinDate", joinDate);
                s.setAttribute("role", role);
                s.setAttribute("status", status);
                s.setAttribute("lastlog", lastlog);
                
                
                }
                s.setAttribute("userCount", userCount);
                s.setAttribute("adminCount", adminCount);
                
                }catch(SQLException e){
                    System.out.println(e);
                }
                response.sendRedirect("adminDashboard.jsp");
            }else{
                HttpSession session  =request.getSession();
                session.setAttribute("error", "You got your crendentials wrong OR  Yor are blocked!!");
                response.sendRedirect("adminLogin.jsp");
                
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
