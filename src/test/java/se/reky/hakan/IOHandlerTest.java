package se.reky.hakan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class IOHandlerTest {

    private String nextLine(Scanner scanner) {
        return scanner.nextLine();
    }

    private boolean hasNextInt(Scanner scanner) {
        return scanner.hasNextInt();
    }

    @Test
    public void testNextLine() {
        String input = "Yes/No";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);

        String result = nextLine(scanner);

        assertEquals("Yes/No", result);
    }

    @Test
    public void testHasNextInt() {
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);

        boolean result = hasNextInt(scanner);

        assertTrue(result);
    }
}