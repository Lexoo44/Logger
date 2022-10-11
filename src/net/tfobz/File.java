package net.tfobz;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.Files;

public class File implements Logger{
    private String path;
    private String message;

    public File(String path, String message){
        this.path = path;
        this.message = message;
    }

    @Override
    public void ausgabe() {
        message = message + "\n";
        try {
            Files.write(Paths.get(this.path), message.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}