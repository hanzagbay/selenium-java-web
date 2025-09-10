package Test;

import Utils.ConfigReader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {
    protected static WebDriver driver;
    protected static final String BASE_URL = ConfigReader.get("base_url");

    @BeforeAll
    static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    static void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}
