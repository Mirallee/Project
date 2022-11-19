package Tests;

import TestComponents.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.CartPage;
import pageobjects.ProductCatalogue;

import java.util.List;

public class Validations extends BaseTest {
    @Test
    public void loginErrorValidation()
    {
        landingPage.loginApplication("patryk@gmail.com", "Patryk123");
        Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
    }
    @Test
    public void productErrorValidation() throws InterruptedException {
        String productName = "ADIDAS ORIGINALs";
        ProductCatalogue productCatalogue = landingPage.loginApplication("patryk@gmail.com", "Patryk1@3");

        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
        CartPage cartPage = productCatalogue.goToCartPage();

        boolean match = cartPage.verifyProductDisplay(productName);
        Assert.assertTrue(match);
    }
}
