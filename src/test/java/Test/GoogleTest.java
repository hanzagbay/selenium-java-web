package Test;

import PageObject.DropDownPage;
import PageObject.HomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.Select;

public class GoogleTest {
    private static WebDriver driver;

    private static final String BASE_URL = "https://the-internet.herokuapp.com/";
    private static final String DROPDOWN_URL = BASE_URL + "dropdown";


    @BeforeAll
    static void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless=new"); // Uncomment to run headless
        driver = new ChromeDriver(options); // Selenium Manager auto-downloads driver
        driver.manage().window().maximize();
    }

    @AfterAll
    static void closeBrowser() throws InterruptedException {
        if (driver != null) driver.quit();
    }

    private void canOpenTheInternetAndReadTitle() {
        String url = driver.getCurrentUrl();
        System.out.println(url);
        Assertions.assertTrue(driver.getCurrentUrl().startsWith((BASE_URL)), "Page URL is incorrect. Getting = " + url);
    }

    @Test
    void canNavigateToDropDownPage() {
        driver.get(BASE_URL);
        canOpenTheInternetAndReadTitle();
        HomePage homePage = new HomePage(driver);
        homePage.clickDropDownLink();
        Assertions.assertEquals(DROPDOWN_URL, driver.getCurrentUrl());

    }

    @Test
    void  dropdownTest() {
        driver.get(DROPDOWN_URL);
        DropDownPage dropDownPage = new DropDownPage(driver);

        dropDownPage.selectOption("Option 2");

        Assertions.assertEquals("Option 2", dropDownPage.getDropdownText());
        Assertions.assertEquals("Dropdown List", dropDownPage.getHeaderText());

    }

}

