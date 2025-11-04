package Chapter3;

import java.net.Socket;
import java.io.*;

public class Echoclient1 {
 public static void main(String[] args) {
  try {

   System.out.println("Client Started");
   Socket soc = new Socket("localhost", 9806);
   BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));


   // System.in is read one byte at a time -> InputStreamReader converts to characters
   // then BufferedReader reads a full line
   System.out.print("Enter your message: ");
   String message = userInput.readLine(); // Read a message from the user or keyboard


   // sending message to server
   PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
   out.println(message); // Send the message to the server
   

   // Read a message from the server
   BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
   String serverMessage = in.readLine(); // Read a message from the server
   System.out.println("Server says: " + serverMessage); // Print the server's response
   soc.close();

   
  } catch (Exception e) {
   e.printStackTrace();
  }
 }
}
