package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ABTestPage {
    private WebDriver driver;

    public ABTestPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(tagName = "h3")
    private WebElement abTestHeader;

    @FindBy(tagName = "p")
    private WebElement bodyText;

    public String getAbTestHeader() {
        return abTestHeader.getText();
    }

    public String getBodyText() {
        return bodyText.getText();
    }
}
