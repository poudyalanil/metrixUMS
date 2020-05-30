
package com.metrix.loginpackage;

import java.sql.*;


public class ConnectionProvider {
    public static Connection con;
    
    public static Connection getConnection(){
        try{
            
            // !!! IMPORTANT!!!
            //  THIS IS SUBJECTIVE
            Class.forName("com.mysql.cj.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/metrix?serverTimezone=UTC","root","");
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
    
}

