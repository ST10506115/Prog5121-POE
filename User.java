/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program;

/**
 *
 * @author Nathan Cant
 */
public class User 
{
    private String username;
    private String password;
    private String cellPhone;
    private String firstName;
    private String lastName;
 
public User() 
{
        this.username = "";
        this.password = "";
        this.cellPhone = "";
        this.firstName = "";
        this.lastName = "";
}
 
public User(String firstName, String lastName, String username, String password, String cellPhone) 
{
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellPhone = cellPhone;
}
//Setters and Getters
//Username
    public String getUsername()
    { return username; }
    
    public void   setUsername(String u)  
    { this.username = u; }
//Password
    public String getPassword()          
    { return password; }
    
    public void   setPassword(String p)  
    { this.password = p; }
//CellPhone  
    public String getCellPhone()         
    { return cellPhone; }
    
    public void   setCellPhone(String c) 
    { this.cellPhone = c; }
//FirstName   
    public String getFirstName()         
    { return firstName; }
    
    public void   setFirstName(String f) 
    { this.firstName = f; }
//LastName  
    public String getLastName()          
    { return lastName; }
    
    public void   setLastName(String l)  
    { this.lastName = l; }
 
//Check Username
    public boolean checkUserName() 
{
        return username.contains("_") && username.length() <= 5;
}
 
//Check Password
    public boolean checkPasswordComplexity() 
{
        if (password.length() < 8) return false;
        boolean hasCapital = false;
        boolean hasNumber  = false;
        boolean hasSpecial = false;
        for (int i = 0; i < password.length(); i++) 
    {
            char c = password.charAt(i);
            if (Character.isUpperCase(c))    hasCapital = true;
            else if (Character.isDigit(c))   hasNumber  = true;
            else if (!Character.isLetter(c)) hasSpecial = true;
    }
        return hasCapital && hasNumber && hasSpecial;
}
    
// checkCellPhoneNumber()
    public boolean checkCellPhoneNumber() 
    {
        return cellPhone.matches("\\+[0-9]{1,3}[0-9]{1,10}");
    }
//Check User
    public String registerUser() 
    {
        if (!checkUserName()) 
        {
            return "Username is not correctly formatted; please ensure that your username " +
                   "contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity()) 
        {
            return "Password is not correctly formatted; please ensure that the password " +
                   "contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber()) 
        {
            return "Cell number is incorrectly formatted or does not contain an international code; " +
                   "please correct the number and try again.";
        }
        return "Username successfully captured.\nPassword successfully captured.\nCell phone number successfully added.";
    }
}
