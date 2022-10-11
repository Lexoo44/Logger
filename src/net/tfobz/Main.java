package net.tfobz;


public class Main {
    
    public static void main(String[] args) {
        LoggerFactory lf = new LoggerFactory();
        Logger logger = lf.createLogger("", "This is the console Logger");
        logger.ausgabe();

        logger = lf.createLogger("file.txt", "This is the file Logger");
        logger.ausgabe();

        logger = lf.createLogger("localhost:65535", "This is the UDP-Logger");
        logger.ausgabe();

    }
}
