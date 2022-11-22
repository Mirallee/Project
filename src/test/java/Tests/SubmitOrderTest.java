package Tests;

import TestComponents.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseTest {

    @Test(dataProvider="getData",groups={"Purchase"})
    public void submitOrder(HashMap<String, String> input) throws InterruptedException {

        ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));

        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(input.get("product"));
        CartPage cartPage = productCatalogue.goToCartPage();

        boolean match = cartPage.verifyProductDisplay(input.get("product"));
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();

        checkoutPage.selectCountry("Poland");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();

        String confirmMessage = confirmationPage.getTheMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }

    @Test(dependsOnMethods = {"submitOrder"},dataProvider = "getData",groups = {"Purchase"})
    public void orderHistoryTest(HashMap<String, String> input) {
        ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), (input.get("password")));
        OrderPage orderPage = productCatalogue.goToOrdersPage();
        Assert.assertTrue(orderPage.verifyOrderDisplay(input.get("product")));

    }

    @DataProvider
    public Object[][] getData() throws IOException {
       /* HashMap<String, String> map = new HashMap<String,String>();
        map.put("email", "patryk@gmail.com");
        map.put("password", "Patryk1@3");
        map.put("product", "ADIDAS ORIGINAL");
        HashMap<String, String> map1 = new HashMap<String,String>();
        map1.put("email", "shetty@gmail.com");
        map1.put("password", "Iamking@000");
        map1.put("product", "ZARA COAT 3");*/
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")
                + "//src//test//java//data//PurchaseOrder.json" );
        return new Object[][] {  {data.get(0)} , {data.get(1)  }};
    }


}


