package Test;

import PageObject.DropDownPage;
import PageObject.HomePage;
import Utils.ConfigReader;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class HomePageTest extends BaseTest {

    @ParameterizedTest
    @CsvSource({
            "A/B Testing, abtest",
            "Add/Remove Elements, add_remove_elements/"
    })
    void canNavigateToLinks(String linkText, String expectedPath) {
        driver.get(ConfigReader.get("base_url"));

        HomePage homePage = new HomePage(driver);
        homePage.clickLink(linkText);

        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(BASE_URL + expectedPath, currentUrl);
    }

    private void canOpenTheInternetAndReadTitle() {
        driver.get(ConfigReader.get("base_url"));
        String url = driver.getCurrentUrl();
        System.out.println(url);
        Assertions.assertTrue(url.startsWith((BASE_URL)), "Page URL is incorrect. Getting = " + url);
    }

    @Test
    void canNavigateToDropDownPage() {
        canOpenTheInternetAndReadTitle();
        HomePage homePage = new HomePage(driver);
        homePage.clickDropDownLink();
        Assertions.assertTrue( driver.getCurrentUrl().contains("dropdown") );

    }

    @Test
    void  dropdownTest() {
        driver.get(BASE_URL + "dropdown");
        DropDownPage dropDownPage = new DropDownPage(driver);

        dropDownPage.selectOption("Option 2");
        Assertions.assertEquals("Option 2", dropDownPage.getDropdownText());
        Assertions.assertEquals("Dropdown List", dropDownPage.getHeaderText());
    }
}

