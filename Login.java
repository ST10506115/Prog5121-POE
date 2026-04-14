/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program;

/**
 *
 * @author Nathan Cant
 */
public class Login 
{
    private String enteredUsername;
    private String enteredPassword;
    private User   registeredUser;
 
    public Login(String enteredUsername, String enteredPassword, User registeredUser) 
    {
        this.enteredUsername = enteredUsername;
        this.enteredPassword = enteredPassword;
        this.registeredUser  = registeredUser;
    }
 
//LoginUser
    public boolean loginUser() 
    {
        return registeredUser.getUsername().equals(enteredUsername) &&
               registeredUser.getPassword().equals(enteredPassword);
    }
 
//returnLoginStatus
    public String returnLoginStatus() 
    {
        if (loginUser()) 
        {
            return "Welcome " + registeredUser.getFirstName()  + " "  +
                   registeredUser.getLastName() + " it is great to see you again.";
        } 
        else 
        {
            return "Username or password incorrect, please try again.";
        }
    }
}
