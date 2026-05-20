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
public class Program 
{

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
 
        if (!registrationResult.contains("successfully")) 
        {
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
        String loginStatus = login.returnLoginStatus();
        System.out.println();
        System.out.println(login.returnLoginStatus());
        
        if (!login.loginUser()) 
        {
            System.out.println("Exiting. Please restart and try again.");
            scanner.close();
            return;
        }

          System.out.println();        
        
//Messaging
        System.out.println("Welcome to QuickChat.");
        System.out.println();
 
// how many messages does the user want to send
        System.out.print("How many messages would you like to send? ");
        int numMessages = Integer.parseInt(scanner.nextLine());
 
        Message lastMessage = null;
        int menuChoice = 0;
 
// Keep running until user quits
        do 
        {
            System.out.println();
            System.out.println("   Menu   ");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Choose an option: ");
            menuChoice = Integer.parseInt(scanner.nextLine());
 
            switch (menuChoice) 
            {
                case 1:
                    // Send messages up to the number the user defined
                    for (int i = 1; i <= numMessages; i++) 
                    {
                        System.out.println("\nMessage " + i + " of " + numMessages + " ");
 
                        System.out.print("Enter recipient number (with international code): ");
                        String recipient = scanner.nextLine();
 
                        System.out.print("Enter message (max 250 characters): ");
                        String messageText = scanner.nextLine();
 
                        Message msg = new Message(recipient, messageText, i);
                        lastMessage = msg;
 
// Check message length first
String lengthCheck = msg.checkMessageLength();
    if (!lengthCheck.equals("Message ready to send.")) 
    {
        System.out.println(lengthCheck);
        i--; // let user retry this message
        continue;
    }
 
// Check recipient
    System.out.println(msg.checkRecipientCell());
 
// Show message details
    System.out.println("Message ID: "   + msg.getMessageID());
    System.out.println("Message Hash: " + msg.getMessageHash());
 
// Ask what to do with the message
    System.out.println("\nWhat would you like to do?");
    System.out.println("1) Send Message");
    System.out.println("2) Disregard Message");
    System.out.println("3) Store Message to send later");
    System.out.print("Choose: ");
        int sendChoice = Integer.parseInt(scanner.nextLine());
 
    System.out.println(msg.sentMessage(sendChoice));
                    }
 
// Display all message details after sending
    if (lastMessage != null) 
    {
        System.out.println("\n--- All Sent Messages ---");
        System.out.println(lastMessage.printMessages());
        System.out.println("Total messages sent: " + lastMessage.returnTotalMessages());
    }
        break;
 
        case 2:
            
            System.out.println("Coming Soon.");
            break;
 
        case 3:
                    
            System.out.println("Goodbye!");
            break;
 
        default:
            System.out.println("Invalid option. Please try again.");
            }
 
        } 
        while (menuChoice != 3);
 
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
