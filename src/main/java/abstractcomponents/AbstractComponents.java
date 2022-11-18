package abstractcomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.CartPage;

import java.time.Duration;

public class AbstractComponents {

WebDriver driver;
    public AbstractComponents(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "[routerlink*='cart']")
    WebElement cartButton;
    public void waitForElementToAppear(By findBy)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
    public CartPage goToCartPage()
    {
        cartButton.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }
    public void waitForElementToDisappear(WebElement elem) throws InterruptedException {
        Thread.sleep(2000);
    }
}
