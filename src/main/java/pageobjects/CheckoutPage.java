package pageobjects;

import abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstractComponents {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "[placeholder*='Select']")
    WebElement countryName;

    @FindBy(css = ".btnn.action__submit.ng-star-inserted")
            WebElement confirmationButton;

    public void typeCountryName(String country)
    {
        countryName.sendKeys(country);
        confirmationButton.click();
    }
}
