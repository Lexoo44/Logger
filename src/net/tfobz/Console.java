package net.tfobz;

public class Console implements Logger{
    private String message;
    public Console(String message){
        this.message = message;
    }

    @Override
    public void ausgabe() {
        System.out.println("Console: " + message);
    }
}
