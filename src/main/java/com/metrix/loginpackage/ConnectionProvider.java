/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrix.loginpackage;

/**
 *
 * @author College
 */


import java.sql.*;


public class ConnectionProvider {
    public static Connection con;
    
    public static Connection getConnection(){
        try{
            
//            !!! IMPORTANT!!!
//                THIS IS SUBJECTIVE
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/metrix?serverTimezone=UTC","root","");
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
    
}

