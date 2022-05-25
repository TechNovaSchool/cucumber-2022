package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EtsyPage {

    public EtsyPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id=\"global-enhancements-search-query\"]")
    public WebElement search;

    @FindBy (xpath = "//div[@data-id=\"search-bar\"]//button[@type=\"submit\"]")
    public WebElement getSearch;

    @FindBy (xpath = "(//img[@data-listing-card-listing-image])[1]")
    public WebElement firstProduct;

    @FindBy (xpath = "//h1")
    public WebElement titleOfTheBook;
}
