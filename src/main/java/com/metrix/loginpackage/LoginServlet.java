/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrix.loginpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.time.LocalDate;

/**
 *
 * @author College
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String logemail = request.getParameter("email");
            String logpass = request.getParameter("password");
            
            UserDatabase db =  new UserDatabase(ConnectionProvider.getConnection());
            User user = db.logUser(logemail, logpass);
            
            if(user!=null){
                
                
                HttpSession session = request.getSession();
                session.setAttribute("logUser", user);
                session.setAttribute("joinDate",user.getJoinDate());
                
                 Instant time = Instant.now();
                 
                session.setAttribute("sessionTime", time);
              
                String query = "INSERT INTO METRIX.HISTORY(UID, LOGDATE) values(?,?);";
                LocalDate date = LocalDate.now();
             try{
                PreparedStatement ps = db.con.prepareStatement(query);
                ps.setInt(1, user.getIduser());
                ps.setObject(2, date);
                ps.execute();
                ps.close();
             }catch(SQLException e){
                 e.printStackTrace();
             }
                
                response.sendRedirect("userDashboard.jsp");
                
            }else{
                HttpSession session = request.getSession();
                session.setAttribute("error", "Wrong Crendentials \n"
                                                + "<br> OR<br> "
                                                + "You might have been blocked");
               response.sendRedirect("login.jsp");
                
                        
               
            }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
