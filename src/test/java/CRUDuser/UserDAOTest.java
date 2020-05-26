/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDuser;

import com.metrix.loginpackage.User;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.Before;

/**
 *
 * @author goani
 */
public class UserDAOTest {

    public LocalDate today = LocalDate.of(2020, 05, 10);
   
    
    public UserDAOTest() {
    
    }
    @Before
    public void setUp() throws Exception{
        
    }

    @Test
    public void testAddUser() {
        User user = new User();
        UserDAO userObj = new UserDAO();
        
        user.setFirstName("Anil");
        user.setMiddleName("Parsad");
        user.setLastName("Poudyal");
        user.setAddress("Kathmandu");
        user.setEmail("anil@anill.com");
        user.setPassword("12345678");
        user.setJoinDate(today);
       
        userObj.addUser(user);
        String actual = "Anil";
        String expected = user.getFirstName();
        
        if(actual.equals(expected)){
            assertTrue(true);
        }else{
            assertTrue(false);
        }      
    }

   

    @Test
    public void testGetSingleUser() {
        UserDAO usersInfo = new UserDAO();
        User user = usersInfo.getSingleUser(14);
        
        if(user !=null ){
            assertTrue(true);
        }else{
            assertTrue(false);
        }
            
    }

    @Test
    public void testBlockUser() {
        UserDAO usersInfo = new UserDAO();
        usersInfo.blockUser(14);
        User user = usersInfo.getSingleUser(14);
        
        if(user.getUserStatus() ==0 ){
            assertTrue(true);
        }else{
            assertTrue(false);
        }
        
            
    }

    @Test
    public void testUnBlockUser() {

        UserDAO usersInfo = new UserDAO();
        usersInfo.unBlockUser(14);
        User user = usersInfo.getSingleUser(14);
        
        if(user.getUserStatus() ==1 ){
            assertTrue(true);
        }else{
            assertTrue(false);
        }
    }

    @Test
    public void testResetPassword() {
        UserDAO usersInfo = new UserDAO();
        usersInfo.resetPassword(14);
        User user = usersInfo.getSingleUser(14);
        
        if(user.getPassword().equals("password!!") ){
            assertTrue(true);
        }else{
            assertTrue(false);
        }
    }

    @Test
    public void testDeleteUser() {
        UserDAO usersInfo = new UserDAO();
        usersInfo.deleteUser(14);
        User user = usersInfo.getSingleUser(14);
        
        if(user ==null ){
            assertTrue(true);
        }else{
            assertTrue(false);
        }
    }

    @Test
    public void testMakeAdmin() {
        UserDAO usersInfo = new UserDAO();
        usersInfo.makeAdmin(14);
        User user = usersInfo.getSingleUser(14);
        
        if(user.getUserRole() ==1 ){
            assertTrue(true);
        }else{
            assertTrue(false);
        }
    }

    @Test
    public void testMakeNormalUser() {
        UserDAO usersInfo = new UserDAO();
        usersInfo.makeNormalUser(14);
        User user = usersInfo.getSingleUser(14);
        
        if(user.getUserRole() ==0 ){
            assertTrue(true);
        }else{
            assertTrue(false);
        }
    }
    
}
