package pageobjects;

import abstractcomponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends AbstractComponents {
    WebDriver driver;

    public OrderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "tr td:nth-child(3)")
    List<WebElement> productNames;
    public boolean verifyOrderDisplay(String productName)
    {
        boolean match = productNames.stream().anyMatch(cartProduct->
                cartProduct.getText().equalsIgnoreCase(productName));
        return match;
    }
}
