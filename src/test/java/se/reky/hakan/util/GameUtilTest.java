package se.reky.hakan.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import se.reky.hakan.GameException;

public class GameUtilTest {

    @Test
    public void testToLowerCaseButFirstLetterCapitalized() throws GameException {
        // Arrange
        GameUtil gameUtil = new GameUtil();

        // Act
        String result = gameUtil.toLowerCaseButFirstLetterCapitalized("aPPle");

        // Assert
        assertEquals("Apple", result); // Kontrollera att första bokstaven är stor och resten små
    }

    @Test
    public void testToLowerCaseButFirstLetterCapitalizedEmptyString() {
        // Arrange
        GameUtil gameUtil = new GameUtil();

        // Act & Assert
        assertThrows(GameException.class, () -> {
            gameUtil.toLowerCaseButFirstLetterCapitalized("");
        });
    }
}
