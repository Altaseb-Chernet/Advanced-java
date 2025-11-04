package Chapter3;

import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 9806;
        try {
            Socket socket = new Socket(host, port);
            System.out.println("Connected to " + host + ":" + port);

            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
            String message = "Hello, Altaseb!";
            writer.write(message);
            writer.flush();
            System.out.println("Message sent to server: " + message);

            writer.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
