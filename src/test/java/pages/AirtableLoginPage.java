package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AirtableLoginPage {

    public AirtableLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//a[.='Sign in']")
    public WebElement signInButton;

    @FindBy (css = "#emailLogin")
    public WebElement login;





}
