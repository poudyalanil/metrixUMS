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

public class UserDatabase {
    Connection con ;

    public UserDatabase(Connection con) {
        this.con = con;
    }
    
    //for register user 
    public boolean saveUser(User user){
        boolean set = false;
        try{
            //Insert register data to database
           String query = "INSERT INTO METRIX.USER(FIRSTNAME,MIDDLENAME,LASTNAME,ADDRESS,EMAIL,PASSWORD) VALUES(?,?,?,?,?,?);";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, user.getFirstName());
           pt.setString(2, user.getMiddleName());
           pt.setString(3, user.getLastName());
           pt.setString(4, user.getAddress());
           pt.setString(5, user.getEmail());
           pt.setString(6, user.getPassword());
           
           pt.executeUpdate();
           set = true;
           con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
    
    //user login
    public User logUser(String email, String password){
        User usr=null;
        try{
            String query ="select * from user where email=? and password=?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                usr = new User();
                usr.setIduser(rs.getInt("iduser"));
                usr.setFirstName(rs.getString("fname"));
                usr.setMiddleName(rs.getString("mname"));
                usr.setLastName(rs.getString("lname"));
                usr.setAddress(rs.getString("address"));
                usr.setEmail(rs.getString("email"));
                usr.setPassword(rs.getString("password"));
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return usr;
    }
}

