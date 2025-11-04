package Chapter3;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
public class socket {
    public static void main(String[] args) {
        try{
            System.out.println("waiting for clients...");
            ServerSocket ss = new ServerSocket(9806);
            Socket soc = ss.accept();
            System.out.println("connection established");
            soc.close();
     }catch(IOException e){
            System.err.println("error starting server: " + e.getMessage());
    }
}}
