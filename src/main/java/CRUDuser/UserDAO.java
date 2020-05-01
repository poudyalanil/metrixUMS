/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDuser;

/**
 *
 * @author College
 */
import com.metrix.loginpackage.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class UserDAO {
    Connection con;

    public UserDAO(Connection con) {
        this.con = con;
    }
    
    
    //add books information to database
    public boolean addUser(User user){
        boolean test = false;
        
        try{
            String query =  "INSERT INTO METRIX.USER(FIRSTNAME,MIDDLENAME,LASTNAME,ADDRESS,EMAIL,PASSWORD) VALUES(?,?,?,?,?,?)";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, user.getFirstName());
            pst.setString(2, user.getMiddleName());
            pst.setString(3, user.getLastName());
            pst.setString(4, user.getAddress());
            pst.setString(5, user.getEmail());
            pst.setString(6, user.getPassword());
            
            pst.executeUpdate();
            test= true;

        }catch(Exception e){
            e.printStackTrace();
        }
        return test;
    }
    
//    retrieve the book details from databse
    public List<User> getAllUsers(){
        List<User> user = new ArrayList<>();
        
        try{
            
            String query = "select * from metrix.user";
            PreparedStatement pt = this.con.prepareStatement(query);
            ResultSet rs = pt.executeQuery();
            
            while(rs.next()){
                int iduser = rs.getInt("iduser");
                String firstname = rs.getString("firstname");
                String middlename = rs.getString("middlename");
                String lastname = rs.getString("lastname");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String password = rs.getString("password");
                
                User row = new User(iduser,firstname,middlename,lastname,address,email,password);
                user.add(row);
            }
            
        }catch(Exception e){
            e.printStackTrace();;
        }
        return user;
    }
    
    
//    eidt book information
    public void editUserInfo(User user){
        
        try{
            String query = "update metrix.user set firstname=?, middlename=?,lastname=?,address=?,email=?,password=? where iduser=?";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setString(1, user.getFirstName());
            pt.setString(2, user.getMiddleName());
            pt.setString(3, user.getLastName());
            pt.setString(4, user.getAddress());
            pt.setString(5, user.getEmail());
            pt.setString(6, user.getPassword());
            
            pt.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();;
        }
        
        
    }
    
//    get single book information in edit page
    public User getSingleUser(int id){
        User us = null;
        
        try{
            String query = "select * from metrix.user where iduser=? ";
            
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setInt(1, id);
            ResultSet rs= pt.executeQuery();
            
            while(rs.next()){
                int iduser = rs.getInt("iduser");
                String firstname = rs.getString("firstname");
                String middlename = rs.getString("middlename");
                String lastname = rs.getString("lastname");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String password = rs.getString("password");
                us = new User(iduser,firstname,middlename,lastname,address,email,password);
            }
        }catch(Exception ex){
            ex.printStackTrace();;
        }
        return us;
    }
    
    
//    delete books from database
    
    
    public void deleteUser(int id){
        try{
            
           String query= "delete from metrix.user where iduser=?";
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setInt(1, id);
           pt.execute();
            
        }catch(Exception ex){
            ex.printStackTrace();;
        }
    }
}
