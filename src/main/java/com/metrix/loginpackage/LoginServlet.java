/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
            HttpSession session = request.getSession();
            session.setAttribute("isLoggedIn", "false");
           
            if(user!=null){
                session.setAttribute("isLoggedIn", "true");
                String sql = "SELECT * from history where uid = "+user.getIduser();
               
                try{
                PreparedStatement p = db.con.prepareStatement(sql);
                ResultSet rs = p.executeQuery();
                int loginCount =0;
                while(rs.next()){
                    loginCount ++;
                }
                session.setAttribute("loginCount", loginCount);
                }catch(SQLException e){
                    System.out.println(e);
                }
                
                
                int accountAge = LocalDate.now().compareTo(user.getJoinDate());
                
                
                session.setAttribute("logUser", user);
                session.setAttribute("joinDate",user.getJoinDate());
                
                session.setAttribute("accountAge", accountAge);
                
                 
              
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
