/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
            out.println("<title>Servlet ResetPasswordUser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResetPasswordUser at " + request.getContextPath() + "</h1>");
            
           
            try{
            Connection con = ConnectionProvider.getConnection();
            String email = request.getParameter("emailReset");

            String query = "update metrix.user set password=? where email =?";
            
            
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, "password!!");
            pst.setString(2, email);
            String pass = "Your new updated password is <b>password!!<b>" ;
            HttpSession s  =request.getSession();
            s.setAttribute("newPassword", pass);
            
            int i = pst.executeUpdate();
            
            if(i>0){
                response.sendRedirect("login.jsp");
            }
            else{
                s.setAttribute("error", "Email is wrong");
                response.sendRedirect("resetPassword.jsp");
            }
            }
            catch(Exception e){
                e.printStackTrace();
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
