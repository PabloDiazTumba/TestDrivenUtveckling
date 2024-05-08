import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumSetupTest {

    @Test
    public void testSeleniumSetup() {
        // Använd WebDriverManager för att hantera drivrutinen automatiskt
        WebDriverManager.chromedriver().setup();

        // Skapa en instans av Chrome WebDriver
        WebDriver driver = new ChromeDriver();

        // Öppna en webbläsare och navigera till en webbplats
        driver.get("https://www.google.com");

        // Hämta och skriv ut titeln på webbsidan
        System.out.println("Title of the page is: " + driver.getTitle());

        // Stäng ned webbläsaren
        driver.quit();
    }
}