/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDuser;

import com.metrix.loginpackage.User;
import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.Before;

/**
 *
 * @author goani
 */
public class UserDAOTest {

//    public LocalDate today = LocalDate.of(2020, 05, 10);
//    UserDAO userObj = new UserDAO();
//    
    public UserDAOTest() {
    
    }
    

    @Test
    public void testAddUser() {
//        User user = new User();
//        user.setFirstName("Anil");
//        user.setMiddleName("Parsad");
//        user.setLastName("Poudyal");
//        user.setAddress("Kathmandu");
//        user.setEmail("anil@anill.com");
//        user.setPassword("12345678");
//        user.setJoinDate(today);
//        userObj.addUser(user);
//        
//        assertEquals("Anil",user.getFirstName());
//        
        
    }

    @Test
    public void testGetAllUsers() {
    }


    @Test
    public void testGetSingleUser() {
        
// User usr = userObj.getSingleUser(0);
//          
//assertEquals("Successfully fetched user","Anil",usr.getFirstName());
//      
    }

    @Test
    public void testBlockUser() {
//        User usr = userObj.getSingleUser(14);
//        userObj.blockUser(14);
//        int isBlock = usr.getUserStatus();
//        assertEquals(0, isBlock);
    }

    @Test
    public void testUnBlockUser() {
//        User usr = userObj.getSingleUser(15);
//        userObj.unBlockUser(15);
//        int isBlock = usr.getUserStatus();
//        assertEquals(0, isBlock);
    }

    @Test
    public void testResetPassword() {
        
    }

    @Test
    public void testDeleteUser() {
    }

    @Test
    public void testMakeAdmin() {
    }

    @Test
    public void testMakeNormalUser() {
    }
    
}
