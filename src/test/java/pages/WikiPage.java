package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WikiPage {

    public WikiPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//input[@id=\"searchInput\"]")
    public WebElement searchBox;

    @FindBy (xpath = "//h1[@id=\"firstHeading\"]")
    public WebElement headerTitle;

    @FindBy (xpath = "//input[@id=\"searchButton\"]")
    public WebElement searchBtn;

    @FindBy (xpath = "//div[@class=\"fn\"]")
    public WebElement imageHeader;
}
