package Chapter3;

import java.net.Socket;

public class clintSide {
    public static void main(String[] args) {
        
        try{
            System.out.println("connecting to server...");
            Socket soc = new Socket("localhost",9806);
            System.out.println("connected to server");
        }catch(Exception e){
            e.printStackTrace();
    
        }
    }
}
