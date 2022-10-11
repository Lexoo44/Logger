package net.tfobz;

import java.net.*;
import java.io.*;

public class UDP implements Logger {
    private String adresse;
    private int port;
    private String message;

    public UDP(String ipport, String message) {
        String[] parts = ipport.split(":");
        this.adresse = parts[0];
        this.port = Integer.parseInt(parts[1]);

        Socket client = null;
        try {
            client = new Socket(adresse, port);
            System.out.println("Socket connected");
            OutputStream out = client.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(out);
            dataOutputStream.writeUTF(message);
            System.out.println("Message sent");
            this.message = inputOutput(client);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
                System.out.println("Socket disconected");
            } catch (Exception e) {
                ;
            }
        }

    }

    
    private static String inputOutput(Socket client) throws IOException {
        InputStream inputStream = client.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        return dataInputStream.readUTF();
    }

    @Override
    public void ausgabe() {
        System.out.print("From Server: " + this.message);

    }
}
