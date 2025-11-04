package Chapter3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 9806;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started. Waiting for client on port " + port + "...");

            Socket socket = serverSocket.accept(); // Wait for client
            System.out.println("Client connected!");

            BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );

            String message = reader.readLine(); // Read message
            System.out.println("Message received from client: " + message);

            reader.close();
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
