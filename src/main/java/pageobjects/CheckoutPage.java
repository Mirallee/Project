package pageobjects;

import abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    WebElement country;

    @FindBy(css = ".btnn.action__submit.ng-star-inserted")
            WebElement confirmationButton;
    @FindBy(xpath = "//button[contains(@class,'ta-item')][1]")
    WebElement selectCountryButton;

    public void selectCountry(String nameOfCountry) throws InterruptedException {
        country.sendKeys(nameOfCountry);
        selectCountryButton.click();
        Thread.sleep(2000);
    }
    public ConfirmationPage submitOrder()
    {
        confirmationButton.click();
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        return confirmationPage;

    }
}
