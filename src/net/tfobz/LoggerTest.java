package net.tfobz;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class LoggerTest {
    
    @Test
    public void consoleTest(){
        LoggerFactory lf = new LoggerFactory();
        Logger logger = lf.createLogger("", "This is the console Logger");
        logger.ausgabe();
        assertTrue(logger instanceof Console);
    }

    @Test
    public void fileTest(){
        LoggerFactory lf = new LoggerFactory();
        Logger logger = lf.createLogger("file.txt", "This is the file Logger");
        logger.ausgabe();
        assertTrue(logger instanceof File);
    }

    @Test
    public void udpTest(){
        LoggerFactory lf = new LoggerFactory();
        Logger logger = lf.createLogger("localhost:65535", "This is the UDP-Logger");
        logger.ausgabe();
        assertTrue(logger instanceof UDP);
    }
}
