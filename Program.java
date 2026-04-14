/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package program;

/**
 *
 * @author Nathan Cant
 */
import java.util.Scanner;
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
 Scanner scanner = new Scanner(System.in);
 
        System.out.println("Welcome to Chat");
        System.out.println();
 
//Registration
        System.out.println("Please Register");
 
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
 
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
 
        System.out.print("Enter username (must contain _ and be max 5 characters): ");
        String username = scanner.nextLine();
 
        System.out.print("Enter password (min 8 characters, 1 capital, 1 number, 1 special character): ");
        String password = scanner.nextLine();
 
        System.out.print("Enter cell phone number with international code (e.g. +27831234567): ");
        String cellPhone = scanner.nextLine();
 
// Create user 
        User newUser = new User(firstName, lastName, username, password, cellPhone);
        String registrationResult = newUser.registerUser();
 
        System.out.println();
        System.out.println(registrationResult);
 
        if (!registrationResult.contains("successfully")) {
            System.out.println("\nRegistration failed. Please restart and try again.");
            scanner.close();
            return;
        }
 
        System.out.println();
 
// Login
        System.out.println("Please Login");
 
        System.out.print("Enter username: ");
        String loginUsername = scanner.nextLine();
 
        System.out.print("Enter password: ");
        String loginPassword = scanner.nextLine();
 
        Login login = new Login(loginUsername, loginPassword, newUser);
        System.out.println();
        System.out.println(login.returnLoginStatus());
 
        scanner.close();
    }
    }
    

/*REFRENCES: 
JAVA Programming tenth edition, Joyce Farell, Cengage, 2016
https://www.w3schools.com/js/
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide
https://www.reddit.com/r/learnjavascript/?rdt=39747
https://youtu.be/Ihy0QziLDf0?si=z8YmOr9Fhtmijb0n
https://youtu.be/nbX0MIV7-Ek?si=1axa-QBWB8unvwAy
http://www.youtube.com/@BroCodez
*/
