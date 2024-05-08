package se.reky.hakan.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AttackTest {

    @Test
    public void testAttack() {
        // Arrange
        Actor attacker = new Goblin("Attacker", 10, 5); // Skapa en goblin som angriparen
        Actor target = new Guard("Target", 10, 2); // Skapa en väktare som offret
        int initialHealth = target.getHp();
        int damage = attacker.getDamage();

        // Act
        attacker.attack(target); // Låt goblinen attackera väktaren

        // Assert
        assertEquals(initialHealth - damage, target.getHp()); // Kontrollera att väktarens hälsa har minskat med goblinens skada
    }
}