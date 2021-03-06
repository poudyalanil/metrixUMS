
package CRUDuser;
import com.metrix.loginpackage.User;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class UserDAO {
    // Creating Connection object from ConnectionProvider Class
    Connection con;
    
   //Empty Constructor
    public UserDAO(){}

    public UserDAO(Connection con) {
        this.con = con;
    }
//    adding user by admin
    public boolean addUser(User user){
        boolean test = false;
        
        try{
            String query =  "INSERT INTO METRIX.USER(FNAME,MNAME,LNAME,ADDRESS,EMAIL,PASSWORD,JOINDATE) VALUES(?,?,?,?,?,?,?)";
            System.out.println("Connection In Progress......");
            PreparedStatement pst = this.con.prepareStatement(query);
            System.out.println("Connection Success......");
            
//            setting user's data from adduser servlet
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
    public List<User> getAllUsers(){
        List<User> user = new ArrayList<>();
        
        try{
            
            String query = "select * from metrix.user";
            PreparedStatement pt = this.con.prepareStatement(query);
            ResultSet rs = pt.executeQuery();
            
//            getting information
            while(rs.next()){
                
                int iduser = rs.getInt("iduser");
                String firstname = rs.getString("fname");
                String middlename = rs.getString("mname");
                String lastname = rs.getString("lname");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String password = rs.getString("password");
                LocalDate joinDate = rs.getObject ( "joindate" , LocalDate.class );
                int userRole = rs.getInt("isadmin");
                int userStatus = rs.getInt("status");
               User row = new User(iduser,firstname,middlename,lastname,address,email,password,joinDate,userRole,userStatus);
               user.add(row);
            }
            rs.close();
            pt.close();
            
        }catch(Exception e){
            e.printStackTrace();;
        }
        return user;
    }
    //editing user information by admin
    public boolean editUserInfo(User user){
        boolean test = false;
        
        try {
            // sql query for updating information
            String query = "UPDATE USER SET FNAME=?, mname=?, lname=?, address=?, email=?, password=? where iduser=?";
            
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
    // getting information about sinfle user using user's unique id
    public User getSingleUser(int id){
        User user = null;
        
        try{
            String query = "select * from metrix.user where iduser=? ";
            
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setInt(1, id);
            ResultSet rs= pt.executeQuery();
            
            while(rs.next()){
                int iduser = rs.getInt("iduser");
                String firstname = rs.getString("fname");
                String middlename = rs.getString("mname");
                String lastname = rs.getString("lname");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String password = rs.getString("password");
                LocalDate joinDate = rs.getObject ( "joindate" , LocalDate.class );
                 int userRole = rs.getInt("isadmin");
                int userStatus = rs.getInt("status");
                user = new User(iduser,firstname,middlename,lastname,address,email,password,joinDate,userRole,userStatus);
            }
            rs.close();
            pt.close();
        }catch(Exception ex){
            ex.printStackTrace();;
        }
        return user;
    }
    // blocking user using user's id
    public void blockUser(int id){
    try{
    String query= "UPDATE user set status = 0 where iduser=?";
      PreparedStatement pt = this.con.prepareStatement(query);
           pt.setInt(1, id);
           pt.execute();
           
            pt.close();
    
    }catch(SQLException e){
        System.out.println(e);
    }
    }
    // unblocking user using user's id
      public void unBlockUser(int id){
    try{
    String query= "UPDATE user set status = 1 where iduser=?";
      PreparedStatement pt = this.con.prepareStatement(query);
           pt.setInt(1, id);
           pt.execute();
           
            pt.close();
    
    }catch(SQLException e){
        System.out.println(e);
    }
    }
      // resetting user's password and setting it to "password!!"
        public void resetPassword(int id){
    try{
    String query= "UPDATE user set password = ? where iduser=?";
      PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, "password!!");
           pt.setInt(2, id);
           pt.execute();
           
            pt.close();
    
    }catch(SQLException e){
        System.out.println(e);
    }
    } 
        // deleting user using user's id
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
    // changing user's iadmin value to 1
    public void makeAdmin(int id){
        try{
            String query= "UPDATE user set isadmin = 1 where iduser=?";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setInt(1, id);
            pt.execute();
            pt.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
    //changing user's isadmin value 0
    public void makeNormalUser(int id){
        try{
            String query= "UPDATE user set isadmin = 0 where iduser=?";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setInt(1, id);
            pt.execute();
            pt.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
