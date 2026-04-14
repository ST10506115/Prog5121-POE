/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nathan Cant
 */
public class PartOneTest {
    
    public PartOneTest() 
    {
     @Test
    public void testUsernameCorrectlyFormatted() {
        User user = new User("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(user.checkUserName());
    }
 
    @Test
    public void testUsernameIncorrectlyFormatted() {
        User user = new User("Kyle", "Smith", "kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(user.checkUserName());
    }
 
    @Test
    public void testUsernameIncorrectlyFormattedMessage() {
        User user = new User("Kyle", "Smith", "kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976");
        String expected = "Username is not correctly formatted; please ensure that your username " +
                          "contains an underscore and is no more than five characters in length.";
        assertEquals(expected, user.registerUser());
    }
 
    @Test
    public void testPasswordMeetsComplexityRequirements() {
        User user = new User("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(user.checkPasswordComplexity());
    }
 
    @Test
    public void testPasswordDoesNotMeetComplexityRequirements() {
        User user = new User("Kyle", "Smith", "kyl_1", "password", "+27838968976");
        assertFalse(user.checkPasswordComplexity());
    }
 
    @Test
    public void testPasswordDoesNotMeetComplexityMessage() {
        User user = new User("Kyle", "Smith", "kyl_1", "password", "+27838968976");
        String expected = "Password is not correctly formatted; please ensure that the password " +
                          "contains at least eight characters, a capital letter, a number, and a special character.";
        assertEquals(expected, user.registerUser());
    }
 
    @Test
    public void testCellPhoneCorrectlyFormatted() {
        User user = new User("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(user.checkCellPhoneNumber());
    }
 
    @Test
    public void testCellPhoneIncorrectlyFormatted() 
    {
        User user = new User("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "08966553");
        assertFalse(user.checkCellPhoneNumber());
    }
 
    @Test
    public void testLoginSuccessful() 
    {
        User user = new User("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", user);
        assertTrue(login.loginUser());
    }
 
    @Test
    public void testLoginFailed() 
    {
        User user = new User("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        Login login = new Login("kyl_1", "wrongpassword", user);
        assertFalse(login.loginUser());
    }
 
    @Test
    public void testReturnLoginStatusSuccess() 
    {
        User user = new User("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", user);
        String expected = "Welcome Kyle, Smith it is great to see you again.";
        assertEquals(expected, login.returnLoginStatus());
    }
 
    @Test
    public void testReturnLoginStatusFailed() 
    {
        User user = new User("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        Login login = new Login("kyl_1", "wrongpassword", user);
        String expected = "Username or password incorrect, please try again.";
        assertEquals(expected, login.returnLoginStatus());
    }
    }

}
