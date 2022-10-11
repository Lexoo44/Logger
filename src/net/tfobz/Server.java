package net.tfobz;

import java.io.*;
import java.net.*;

public class Server {
    private static final int PORT = 65535;

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started");
            while (true) {
                Socket client = null;
                try {
                    System.out.println("Waiting for client...");
                    client = server.accept();
                    System.out.println("Client conected!");
                    inputOutput(client);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        client.close();
                    } catch (Exception e) {
                        ;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (Exception e) {
                ;
            }
        }
    }

    private static void inputOutput(Socket client) throws IOException {
        InputStream inputStream = client.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String message = dataInputStream.readUTF();
        System.out.println("The message sent from the socket was: " + message);
        OutputStream out = client.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(out);
        dataOutputStream.writeUTF(message);
    
    }
}