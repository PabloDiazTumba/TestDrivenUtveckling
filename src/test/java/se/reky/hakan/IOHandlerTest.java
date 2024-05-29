package se.reky.hakan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

<<<<<<< HEAD
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
=======
public class IOHandlerTest {

    private String nextLine(Scanner scanner) {
        return scanner.nextLine();
    }

    private boolean hasNextInt(Scanner scanner) {
        return scanner.hasNextInt();
    }
>>>>>>> 84159dcdb723d4cdb2267b1d14fa2fb5106bba4e

    @Test
    public void testNextLine() {
        String input = "Yes/No";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

<<<<<<< HEAD
        IOHandler ioHandler = createIOHandler(System.in);

        String result = nextLine(ioHandler);
=======
        Scanner scanner = new Scanner(System.in);

        String result = nextLine(scanner);
>>>>>>> 84159dcdb723d4cdb2267b1d14fa2fb5106bba4e

        assertEquals("Yes/No", result);
    }

    @Test
    public void testHasNextInt() {
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

<<<<<<< HEAD
        IOHandler ioHandler = createIOHandler(System.in);

        boolean result = hasNextInt(ioHandler);
=======
        Scanner scanner = new Scanner(System.in);

        boolean result = hasNextInt(scanner);
>>>>>>> 84159dcdb723d4cdb2267b1d14fa2fb5106bba4e

        assertTrue(result);
    }
}