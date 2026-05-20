/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program;
import java.util.ArrayList;
import java.util.Random;
import com.google.gson.JsonObject;
/**
 *
 * @author Nathan Cant
 */
public class Message 
{
    private String messageID;
    private String messageHash;
    private String recipientNumber;
    private String message;
    private String messageSent;
    private int messageNumber;
    
    private static ArrayList<String> sentMessages = new ArrayList<>();
    private static int totalMessagesSent = 0; 
    
//Constructor
    public Message(String recipientNumber, String message, int messageNumber) 
    {
        this.recipientNumber = recipientNumber;
        this.message = message;
        this.messageNumber = messageNumber;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
        this.messageSent = "";
    }   
    
//Getters
    public String getMessageID()
    { return messageID; }
    
    public String getMessageHash()
    { return messageHash; }
    
    public String getRecipientNumber()
    { return recipientNumber; }
    
    public String getMessage()
    { return message; }
    
    public String getMessageSent()
    { return messageSent; }
    
    public int    getMessageNumber()
    { return messageNumber; }
    
//Methods
private String generateMessageID() 
    {
        Random rand = new Random();
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            id.append(rand.nextInt(10));
        }
        return id.toString();
    }
//check message ID
public boolean checkMessageID() 
    {
        return messageID.length() <= 10;
    }

//check recipient cell
    public String checkRecipientCell() 
    {
        if (recipientNumber.matches("\\+[0-9]{1,3}[0-9]{1,10}")) 
        {
            return "Cell phone number successfully captured.";
        } 
        
        else 
        {
            return "Cell phone number is incorrectly formatted or does not contain an international code. " +
                   "Please correct the number and try again.";
        }
    }

//Create message hash
    public String createMessageHash() 
    {
// First 2 digits of message ID
        String idPart = messageID.substring(0, 2);
 
// Split message into words to get first and last
        String trimmed = message.trim();
        String[] words = trimmed.split("\\s+");
        String firstWord = words[0].toUpperCase();
        String lastWord  = words[words.length - 1].toUpperCase();
 
// Remove any punctuation from last word for clean hash
        lastWord = lastWord.replaceAll("[^A-Z0-9]", "");
        firstWord = firstWord.replaceAll("[^A-Z0-9]", "");
 
        return idPart + ":" + messageNumber + ":" + firstWord + lastWord;
    }

//Sent message
 public String sentMessage(int choice) 
    {
        
// First check message length
        if (message.length() > 250) 
        {
            int excess = message.length() - 250;
            return "Message exceeds 250 characters by " + excess +
                   "; please reduce the size.";
        }
 
        switch (choice) 
        {
            case 1:
                totalMessagesSent++;
                messageSent = "Send";
                sentMessages.add(formatMessageDetails());
                return "Message successfully sent.";
                
            case 2:
                messageSent = "Disregard";
                return "Press 0 to delete the message.";
                
            case 3:
                messageSent = "Store";
                storeMessage();
                return "Message successfully stored.";
                
            default:
                return "Invalid choice.";
        }
    }

//Print message
 public String printMessages() 
 {
        if (sentMessages.isEmpty()) 
            
        {
            return "No messages sent yet.";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (String msg : sentMessages) 
            
        {
            sb.append(msg).append("\n----------------------------\n");
        }
        return sb.toString();
    }

 //return total messages
 public int returnTotalMessages() 
    {
        return totalMessagesSent;
    }

//Store messages
 public void storeMessage() 
    {
        sentMessages.add("[STORED] " + formatMessageDetails());
    }

//Format message details
public String formatMessageDetails() 
    {
        return
               "Message ID: " + messageID + "\n" + "Message Hash: "   + messageHash + "\n" +
               "Recipient: "      + recipientNumber + "\n" + "Message: " + message;
    }

//Check message length
    public String checkMessageLength() 
    {
        if (message.length() <= 250) 
        {
            return "Message ready to send.";
        } 
        
        else
        {
            int excess = message.length() - 250;
            return "Message exceeds 250 characters by " + excess +
                   "; please reduce the size.";
        }
    }
}
