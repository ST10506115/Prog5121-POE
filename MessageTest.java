/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Nathan Cant
 */
public class MessageTest 
{
   @Test
    public void testMessageLengthWithinLimit() 
    {
/**
Message does NOT exceed 250 characters
Expected: "Message ready to send."
*/
        
        Message msg = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?", 1);
        assertEquals("Message ready to send.", msg.checkMessageLength());
        
/**
Message DOES exceed 250 characters
Expected: "Message exceeds 250 characters by X; please reduce the size."
*/

    }

 @Test
    public void testMessageLengthExceedsLimit() 
    {
// Build a message longer than 250 characters
        String longMessage = "A".repeat(260);
        Message msg = new Message("+27718693002", longMessage, 1);
        String result = msg.checkMessageLength();
        assertTrue(result.contains("Message exceeds 250 characters by 10"));
    }   

/**
Recipient number correctly formatted
Test Data: +27718693002
Expected: "Cell phone number successfully captured."
*/
    
    @Test
    public void testRecipientCellCorrectlyFormatted() 
    {
        Message msg = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?", 1);
        assertEquals("Cell phone number successfully captured.", msg.checkRecipientCell());
    }
    
/**
Recipient number incorrectly formatted
Test Data: 0857597S889 (no international code)
Expected: contains "incorrectly formatted"
*/
    @Test
    public void testRecipientCellIncorrectlyFormatted() 
    {
        Message msg = new Message("0857597S889", "Hi Keegan, did you receive the payment?", 2);
        assertTrue(msg.checkRecipientCell().contains("incorrectly formatted"));
    }
    
/**
Message hash is correct
Test Data: message "Hi Mike, can you join us for dinner tonight?", messageNumber 1
Hash format: first 2 of ID : messageNumber : FIRSTWORDLASTWORD
First word: HI, Last word: TONIGHT → hash ends with HITONIGHT
The system should return: XX:1:HITONIGHT (XX = first 2 digits of auto-generated ID)
*/
    @Test
    public void testMessageHashCorrectFormat() 
    {
        Message msg = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?", 1);
        String hash = msg.getMessageHash();
        // Hash must match pattern: 2chars : 1 : HITONIGHT
        assertTrue("Hash should end with :1:HITONIGHT", hash.endsWith(":1:HITONIGHT"));
        assertTrue("Hash should contain a colon separator", hash.contains(":"));
    }    
    
/**
Message sent successfully
Expected: "Message successfully sent."
*/
    @Test
    public void testMessageSentSuccessfully() 
    {
        Message msg = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?", 1);
        assertEquals("Message successfully sent.", msg.sentMessage(1));
    }

/**
Message disregarded
Expected: "Press 0 to delete the message."
*/
    
    @Test
    public void testMessageDisregarded() 
    {
        Message msg = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?", 1);
        assertEquals("Press 0 to delete the message.", msg.sentMessage(2));
    }

/**
Message stored
Expected: "Message successfully stored."
*/
    @Test
    public void testMessageStored() 
    {
        Message msg = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?", 1);
        assertEquals("Message successfully stored.", msg.sentMessage(3));
    }

/**
Message ID is not more than 10 characters
*/
    @Test
    public void testMessageIDLength() 
    {
        Message msg = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?", 1);
        assertTrue("Message ID should be 10 characters or less", msg.checkMessageID());
    }
}
