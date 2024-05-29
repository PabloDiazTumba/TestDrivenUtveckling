package se.reky.hakan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import se.reky.hakan.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class PlayerInteractionTest {

    private Player player;
    private PlayerInteraction playerInteraction;

    @BeforeEach
    public void setUp() {
        player = new Player();
        String input = "John"; // Användaren matar in namnet "John"
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);
        IOHandler ioHandler = new IOHandler(scanner);
        playerInteraction = new SimplePlayerInteraction(ioHandler);
    }

    @Test
    public void testPlayerSetup() {
        playerInteraction.setupPlayer(player);
        assertEquals("John", player.getName());
    }

    @Test
    public void testUpdatePlayerHealth() {
        int initialHealth = 10;
        player.setHp(initialHealth);

        playerInteraction.updatePlayerHealth(player, 5);
        int newHealth = player.getHp();

        assertEquals(initialHealth + 5, newHealth);

        playerInteraction.updatePlayerHealth(player, -3);
        newHealth = player.getHp();

        assertEquals(initialHealth + 5 - 3, newHealth);
    }
}