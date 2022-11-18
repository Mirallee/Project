package pageobjects;

import abstractcomponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponents {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".cartSection h3")
            List<WebElement> productTitles;
    @FindBy(css = ".totalRow button")
            WebElement checkoutEle;
    public boolean verifyProductDisplay(String productName)
    {
        boolean match = productTitles.stream().anyMatch(cartProduct->
                cartProduct.getText().equalsIgnoreCase(productName));
        return match;
    }
    public CheckoutPage goToCheckout()
    {
        checkoutEle.click();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        return checkoutPage;
    }
    }



