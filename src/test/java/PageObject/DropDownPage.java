package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage {
    private WebDriver driver;

    public DropDownPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(tagName = "h3")
    private WebElement header;

    @FindBy(id =  "dropdown")
    private WebElement dropdown;

    public String getHeaderText() {
        return header.getText();
    }

    public void selectOption(String optionText) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(optionText);
    }

    public String getDropdownText() {
        Select select = new Select(dropdown);
        return select.getFirstSelectedOption().getText();
    }

}
