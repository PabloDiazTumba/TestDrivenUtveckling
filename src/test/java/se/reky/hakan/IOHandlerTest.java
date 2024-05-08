package se.reky.hakan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IOHandlerTest {

    @Test
    public void testNextLine() {

        String input = "Yes/No";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);
        IOHandler ioHandler = new IOHandler(scanner);

        String result = ioHandler.nextLine();

        assertEquals("Yes/No", result);
    }

    @Test
    public void testHasNextInt() {

        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);

        IOHandler ioHandler = new IOHandler(scanner);

        boolean result = ioHandler.hasNextInt();

        assertTrue(result);
    }
}