package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    public AmazonPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy (xpath = "(//img[@class=\"s-image\"])[1]")
    public WebElement firstProduct;

    @FindBy (css = "#productTitle")
    public WebElement titleOfProduct;

    @FindBy (css = "input[id=\"add-to-cart-button\"]")
    public WebElement addToCart;
}
