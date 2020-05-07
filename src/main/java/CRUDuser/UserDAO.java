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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class UserDAO {
    Connection con;

    public UserDAO(Connection con) {
        this.con = con;
    }
    
    
    //add books information to database
    public boolean addUser(User user){
        boolean test = false;
        
        try{
            String query =  "INSERT INTO METRIX.USER(FIRSTNAME,MIDDLENAME,LASTNAME,ADDRESS,EMAIL,PASSWORD,JOINDATE) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, user.getFirstName());
            pst.setString(2, user.getMiddleName());
            pst.setString(3, user.getLastName());
            pst.setString(4, user.getAddress());
            pst.setString(5, user.getEmail());
            pst.setString(6, user.getPassword());
            pst.setObject(7, user.getJoinDate());
            
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
                LocalDate joinDate = rs.getObject ( "joindate" , LocalDate.class );
                
                User row = new User(iduser,firstname,middlename,lastname,address,email,password,joinDate);
                user.add(row);
            }
            rs.close();
            pt.close();
            
        }catch(Exception e){
            e.printStackTrace();;
        }
        return user;
    }
    
    
//    eidt book information
    public boolean editUserInfo(User user){
        boolean test = false;
        
        try {
            String query = "UPDATE USER SET FIRSTNAME=?, middlename=?, lastname=?, address=?, email=?, password=? where iduser=?";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setString(1, user.getFirstName());
            pt.setString(2, user.getMiddleName());
            pt.setString(3, user.getLastName());
            pt.setString(4, user.getAddress());
            pt.setString(5, user.getEmail());
            pt.setString(6, user.getPassword());
            pt.setInt(7, user.getIduser());
            
            pt.executeUpdate();
            test = true;
           
            pt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return test;
    }
        
        
    
    
//    get single book information in edit page
    public User getSingleUser(int id){
        User user = null;
        
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
                LocalDate joinDate = rs.getObject ( "joindate" , LocalDate.class );
                user = new User(iduser,firstname,middlename,lastname,address,email,password,joinDate);
            }
            rs.close();
            pt.close();
        }catch(Exception ex){
            ex.printStackTrace();;
        }
        return user;
    }
    
    
//    delete books from database
    
    
    public void deleteUser(int id){
        try{
            
           String query= "delete from metrix.user where iduser=?";
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setInt(1, id);
           pt.execute();
           
            pt.close();
            
        }catch(Exception ex){
            ex.printStackTrace();;
        }
    }
}
