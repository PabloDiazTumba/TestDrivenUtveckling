package se.reky.hakan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

// Antagande: IOHandler är en klass som hanterar I/O-operationer
class IOHandler {
    private Scanner scanner;

    public IOHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    public boolean hasNextInt() {
        return scanner.hasNextInt();
    }
}

public class IOHandlerTest {

    private IOHandler createIOHandler(InputStream input) {
        return new IOHandler(new Scanner(input));
    }

    private String nextLine(IOHandler ioHandler) {
        return ioHandler.nextLine();
    }

    private boolean hasNextInt(IOHandler ioHandler) {
        return ioHandler.hasNextInt();
    }

    @Test
    public void testNextLine() {
        String input = "Yes/No";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        IOHandler ioHandler = createIOHandler(System.in);

        String result = nextLine(ioHandler);

        assertEquals("Yes/No", result);
    }

    @Test
    public void testHasNextInt() {
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        IOHandler ioHandler = createIOHandler(System.in);

        boolean result = hasNextInt(ioHandler);

        assertTrue(result);
    }
}