/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.metrix.loginpackage.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
}
