package Test;

import PageObject.ABTestPage;
import PageObject.HomePage;
import Utils.ConfigReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class ABTest extends BaseTest {


    private void navigateToAbTest() {
        driver.get(ConfigReader.get("base_url"));

        HomePage homePage = new HomePage(driver);
        homePage.clickLink("A/B Testing");

        Assertions.assertTrue(driver.getCurrentUrl().contains("abtest"));
    }

    @Test
    public void canVerifyElements() {
        navigateToAbTest();

        ABTestPage abTestPage = new ABTestPage(driver);
        Assertions.assertEquals("A/B Test Control", abTestPage.getAbTestHeader());
        Assertions.assertTrue(abTestPage.getBodyText().contains("Also known as split testing"));
    }
}
