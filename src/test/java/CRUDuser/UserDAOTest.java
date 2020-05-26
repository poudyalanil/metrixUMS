/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDuser;

import com.metrix.loginpackage.ConnectionProvider;
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
   

    public LocalDate today = LocalDate.of(2020, 05, 10);
   
    
    public UserDAOTest() {
    
    }
    @Before
    public void setUp() throws Exception{
        
    }

    @Test
    public void testAddUser() {
        System.out.println("Input on all fields");
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
    public void testAddUser2() {
        System.out.println("Empty Firstname");
        User user = new User();
        UserDAO userObj = new UserDAO();
        
        user.setFirstName("");
        user.setMiddleName("Parsad");
        user.setLastName("Poudyal");
        user.setAddress("Kathmandu");
        user.setEmail("anil@anill.com");
        user.setPassword("12345678");
        user.setJoinDate(today);
       
        userObj.addUser(user);
        String actual = "";
        String expected = user.getFirstName();
        
        if(actual.equals(expected)){
            assertTrue(true);
        }else{
            assertTrue(false);
        }      
    }
    
    @Test
    public void testAddUser3() {
        System.out.println("Empty Address Field");
        User user = new User();
        UserDAO userObj = new UserDAO();
        
        user.setFirstName("Anil");
        user.setMiddleName("Parsad");
        user.setLastName("Poudyal");
        user.setAddress("");
        user.setEmail("anil@anill.com");
        user.setPassword("12345678");
        user.setJoinDate(today);
       
        userObj.addUser(user);
        String actual = "";
        String expected = user.getAddress();
        
        assertEquals(actual, expected);  
    }
    
    @Test
    public void testAddUser4() {
        System.out.println("Empty Email Field");
        User user = new User();
        UserDAO userObj = new UserDAO();
        
        user.setFirstName("Anil");
        user.setMiddleName("Parsad");
        user.setLastName("Poudyal");
        user.setAddress("Ktm");
        user.setEmail("");
        user.setPassword("12345678");
        user.setJoinDate(today);
       
        userObj.addUser(user);
        String actual = "";
        String expected = user.getEmail();
        
        assertEquals(actual, expected);  
    }
    
    @Test
    public void testAddUser5() {
        System.out.println("Empty Password Field");
        User user = new User();
        UserDAO userObj = new UserDAO();
        
        user.setFirstName("Anil");
        user.setMiddleName("Parsad");
        user.setLastName("Poudyal");
        user.setAddress("");
        user.setEmail("anil@anill.com");
        user.setPassword("");
        user.setJoinDate(today);
       
        userObj.addUser(user);
        String actual = "";
        String expected = user.getPassword();
        
        assertEquals(actual, expected);  
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
    public void testOpenConnection1( ) throws Exception{
        System.out.println("openConnection");
        Connection result = ConnectionProvider.getConnection();
        assertEquals(result != null,true);
    }
    
    @Test
    public void testOpenConnection2( ) throws Exception{
        System.out.println("Not Null Connection");
        Connection result = ConnectionProvider.getConnection();
        assertNotNull(result);
    }
    
    @Test
    public void testOpenConnection3( ) throws Exception{
        System.out.println("openConnection3");
        Connection result = ConnectionProvider.getConnection();
        assertTrue(result !=null);
    }
   
    @Test
    public void testOpenConnection4( ) throws Exception{
        System.out.println("Null Connection");
        Connection result = null;
        assertNull(result);
    }
    
    @Test
    public void testOpenConnection5( ) throws Exception{
        System.out.println("openConnection5");
        Connection result = ConnectionProvider.getConnection();
        assertNotNull(result);
    }
    
    
    /*@Test
    public void testGetSingleUser() {
        User user = new User();
        UserDAO usersInfo = new UserDAO();
        user.setIduser(22);
        user.setFirstName("Anil");
        user.setMiddleName("Parsad");
        user.setLastName("Poudyal");
        user.setAddress("Kathmandu");
        user.setEmail("anil@anill.com");
        user.setPassword("12345678");
        user.setJoinDate(today);
        User user1 = usersInfo.getSingleUser(22);
        
        String name = user.getFirstName();
        
        assertEquals("Anil", name);
            
    }

    @Test
    public void testBlockUser() {
        UserDAO usersInfo = new UserDAO();
        ConnectionProvider.getConnection();
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
        ConnectionProvider.getConnection();
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
        ConnectionProvider.getConnection();
        usersInfo.resetPassword(14);
        User user = usersInfo.getSingleUser(14);
        
        if(user.getPassword().equals("password!!") ){
            assertTrue(true);
        }else{
            assertTrue(false);
        }
    }

    

    @Test
    public void testMakeAdmin() {
        UserDAO usersInfo = new UserDAO();
        ConnectionProvider.getConnection();
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
        ConnectionProvider.getConnection();
        usersInfo.makeNormalUser(14);
        User user = usersInfo.getSingleUser(14);
        
        if(user.getUserRole() ==0 ){
            assertTrue(true);
        }else{
            assertTrue(false);
        }
    }*/
    
}
