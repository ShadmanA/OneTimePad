/**
 * Authors: Shadman Ahmed, Alan Piroti
*  Date: 06/14/18 
 * Filename: OneTimePadFINAl
 * Description: This code allows the user to utilise the One Time Pad
 **/

public class OneTimePadFINALCOMMENTS // Class of the One Time Pad 
{
  public static String encrypt(String text, String key)
  {
    String encryptedWord = ""; // Initializes the String encryptedWord
    for (int character=0;character<=(text.length()-1); character+=1){ 
    encryptedWord+=(char)(((((text.charAt(character)-97)))+((key.charAt(character)-97)))%26+97); //This line of code extracts the character from the text, subtracts 97 from the unicode value so that the value matches that of the one time pad, then adds the text to the key (Key is also subtracted by 97), then remainders the sum by 26(Because there are 26 letters in the alphabet), adds it by 97, and casts it all to a char value to get the new char.  
    }
    return encryptedWord; //This line returns the encrypted word or cipher text
  }
  
  public static String decrypt(String text, String key)
  {
    String decryptyedWord = "";
    String decryptionKey = "";
    for (int character=0; character <=key.length()-1; character+=1)
    {
      decryptionKey+=(char)(((26-(key.charAt(character)-97)))%26+97);
    }
    return encrypt(text,decryptionKey); // Returns the plain text that has been decrypted
  }
  
  
  
  public static void main (String[]args){ //Main string of the program
    while(true){ // While statement to keep the program running
      System.out.println("Would you like to encrypt(e), decrypt(d) or finish(f)?"); //Asks the user whether they would like to encrypt a plain text and key, decrypt the key and cipher text, or finish using the program
      String UIn= In.getString(); // Receives the user input.
      if (UIn.equals("e")){ //If statement given the input is "e"
        System.out.println("Please enter the key you will be using."); // Asks user for their key.
        String key=In.getString(); // User input for the key.
        System.out.println("Enter the plain text you would to encrypt."); // Asks user for their plain text.
        String text=In.getString(); // User input for the message they would like to encrypt.
        String eWord=encrypt(text,key); //Initializes the String eWord to encrypt the text and the key, by calling the encrypt method.
        System.out.println("Your encrypted word is: " + eWord); // Tells the user their encrypted word/ cipher text.
      }
        else if (UIn.equals("f")) // Else if statement given the input is "f".
      {
        System.exit(0); // Exits the application
        break; 
      }
      else if (UIn.equals ("d")){ // If statement given the input is "d"
        System.out.println("Please enter the key you will be using."); // Asks user for their key
        String key=In.getString(); // User input for their key
        System.out.println("Please enter the cipher text to decrypt"); // Asks user for their encrypted word/ cipher text
        String text= In.getString(); // User input for cipher text/encrypted word
        String dWord= decrypt(text,key); // Initializes the String dWord to decrypt the text and key, by calling the decrypt method
        System.out.println("Your decrypted word is: " +dWord); // Tells user their decrpyted word
      }
      else{ // Else statement if user decides to input something aside from e, d or f
        System.out.println("INVALID RESPONSE! Please type in either e for encrypt, d for decrypt,or f to finish"); 
      }
      
      
      
    }
    
  }
  
  
}




