package Chapter3;
import java.net.Socket;
import java.io.IOException;
public class SocketClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 9999;
        System.out.println();
    
    try (Socket socket = new Socket(host, port)) {
        System.out.println("Connected to " + host + ":" + port);
    }
    catch(IOException e){
        e.printStackTrace();
    }
}
}