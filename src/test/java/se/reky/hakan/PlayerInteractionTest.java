package se.reky.hakan;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.reky.hakan.model.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class PlayerInteractionTest {

    private Player player;

    @BeforeEach
    public void setUp() {
        // Skapa en instans av Player före varje test
        player = new Player();
    }

    @Test
    public void testPlayerSetup() {
        // Förbered testdata
        String playerName = "John";

        // Förbered input för Scanner
        String input = playerName;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Skapa en instans av PlayerInteraction med förberedd Scanner-input
        PlayerInteraction playerInteraction = getPlayerInteractionWithInput(input);

        // Kalla på metod playerSetup() och sätt spelarens namn
        playerInteraction.playerSetup(player);

        // Verifiera att playerSetup() har satt rätt namn på spelaren
        assertEquals(playerName, player.getName());
    }

    // Privat metod för att skapa en instans av PlayerInteraction med förberedd Scanner-input
    private PlayerInteraction getPlayerInteractionWithInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        return new SimplePlayerInteraction(scanner);
    }
}