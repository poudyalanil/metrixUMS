/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.metrix.loginpackage.ConnectionProvider;
import com.metrix.loginpackage.User;
import java.sql.Connection;
import static com.metrix.loginpackage.ConnectionProvider.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;
import CRUDuser.UserDAO;
import com.metrix.loginpackage.UserDatabase;

/**
 *
 * @author College
 */
public class JUnitTest {
    
    public JUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testSetFirstName() {
    User user = new User();
    user.setFirstName("Ramesh");
    assertEquals("firstName","Ramesh", user.getFirstName());
    }
    
    @Test
    public void testSetEmail() {
    User user = new User();
    user.setEmail("Rameshkc@gmail.com");
    assertEquals("Email","Rameshkc@gmail.com", user.getEmail());
    }
    
    @Test
    public void testOpenConnection1( ) throws Exception{
        System.out.println("openConnection");
        Connection result = ConnectionProvider.getConnection();
        assertEquals(result != null,true);
    }
    
    @Test
    public void testOpenConnection2( ) throws Exception{
        System.out.println("openConnection");
        Connection result = ConnectionProvider.getConnection();
        assertNotNull(result);
    }
    
    @Test
    public void testOpenConnection3( ) throws Exception{
        System.out.println("openConnection");
        Connection result = ConnectionProvider.getConnection();
        assertTrue(result !=null);
    }
   
    @Test
    public void testOpenConnection4( ) throws Exception{
        System.out.println("openConnection");
        Connection result = null;
        assertNull(result);
    }
    
    @Test
    public void testOpenConnection5( ) throws Exception{
        System.out.println("openConnection");
        Connection result = ConnectionProvider.getConnection();
        assertNotNull(result);
    }
    
    @Test
    public void testAddUserEmpty() throws Exception{
        boolean ans = false;
        boolean val;
    
        User user = new User("","","","","","",null);
   
        UserDatabase dao = new UserDatabase();
        val = dao.saveUser(user);
        assertEquals(ans,val);
        
     }
    
    @Test
    public void testAddUserFirstName() throws Exception{
        boolean ans = false;
        boolean val;
    
        User user = new User("Ram","","","","","",null);
   
        UserDatabase dao = new UserDatabase();
        val = dao.saveUser(user);
        assertEquals(ans,val);
        
     }
    
    @Test
    public void testAddUserAddress() throws Exception{
        boolean ans = false;
        boolean val;
    
        User user = new User("","","","KTM","","",null);
   
        UserDatabase dao = new UserDatabase();
        val = dao.saveUser(user);
        assertEquals(ans,val);
        
     }
    
    @Test
    public void testAddUserMiddleName() throws Exception{
        boolean ans = false;
        boolean val;
    
        User user = new User("","Kumar","","","","",null);
   
        UserDatabase dao = new UserDatabase();
        val = dao.saveUser(user);
        assertEquals(ans,val);
        
     }
    
    @Test
    public void testAddUserLastName() throws Exception{
        boolean ans = false;
        boolean val;
    
        User user = new User("","","KC","","","",null);
   
        UserDatabase dao = new UserDatabase();
        val = dao.saveUser(user);
        assertEquals(ans,val);
        
     }
    
    



}
