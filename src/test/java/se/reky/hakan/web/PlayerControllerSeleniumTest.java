package se.reky.hakan.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerControllerSeleniumTest {
    private WebDriver driver;

    @BeforeAll
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginPageButton() {
        driver.get("http://localhost:8080/players");

        WebElement loginButton = driver.findElement(By.tagName("button"));

        assertEquals("Logga in", loginButton.getText(), "Knappens text är inte 'Logga in'");
    }

    @Test
    public void testPageTitle() {
        driver.get("http://localhost:8080/players");

        String pageTitle = driver.getTitle();

        assertEquals("Players List", pageTitle, "Sidans titel är inte 'Players List'");
    }

    @Test
    public void testPlayerListCount() {
        driver.get("http://localhost:8080/players");

        List<WebElement> playerNameInputs = driver.findElements(By.tagName("li"));
        int numberOfPlayers = playerNameInputs.size();

        assertEquals(2, numberOfPlayers, "Felaktigt antal spelare i listan");
    }

    @Test
    public void testFirstPlayerName() {
        driver.get("http://localhost:8080/players");

        WebElement firstPlayer = driver.findElement(By.xpath("/html/body/ul/li[1]/span[1]"));

        assertEquals("Bob", firstPlayer.getText(), "Felaktigt namn på första spelaren");
    }
}