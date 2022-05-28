package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SmartBearLoginPage {

    public SmartBearLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//input[@id=\"ctl00_MainContent_username\"]")
    public WebElement login;

    @FindBy (xpath = "//input[@id=\"ctl00_MainContent_password\"]")
    public WebElement password;

    @FindBy (xpath = "//input[@id=\"ctl00_MainContent_login_button\"]")
    public WebElement loginButton;


}
