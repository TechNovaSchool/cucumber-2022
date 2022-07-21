package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AirtableOnePage {

    public AirtableOnePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//div[@data-tutorial-selector-id=\"ghostRowLeftPane\"]")
    public WebElement plusSign;


}