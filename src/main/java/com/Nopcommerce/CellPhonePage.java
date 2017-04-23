package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

/**
 * @ author Jay Vaghani on 14/04/2017.
 * This is a cell Phone page
 */
public class CellPhonePage extends Utils
{
    // Create Object of Home Page
    HomePage homePage = new HomePage();

    java.lang.String totalPriceOfProduct;
    double price1, price2, price3;
    double total;
    double cartTotal;

    //Buying Cell phone from Cell phone page
    public void cellPhone()
    {
        // Declare Object for Soft Assert
        SoftAssert softAssert = new SoftAssert();

        // Take price of HTC One M8 Android L 5.0 Lollipop product
        price1 = priceConversion(By.xpath("//div[@class=\"product-item\"]/div[2]/div[3]/div/span"));

        // Add Above Product Shopping to Cart
        clickOnElement(By.xpath("//div[@class=\"master-column-wrapper\"]/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div[3]/div[2]/input"));
        softAssert.assertTrue(getText(By.xpath("//div[@id=\"bar-notification\"]/p")).contains("The product has been added to your shopping cart"),"Product is not added to cart");

        // close the notification bar
        clickOnElement(By.xpath("//span[@class=\"close\"]"));

        // Refresh Page
        refresh();

        // Take Price of HTC One Mini Blue product
        price2 = priceConversion(By.xpath("//div[2]/div/div[2]/div[3]/div/span"));

        // Add Above Product to Add to Cart
        clickOnElement(By.xpath("//div[@class=\"master-column-wrapper\"]/div[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/div[3]/div[2]/input"));
        softAssert.assertTrue(getText(By.xpath("//div[@id=\"bar-notification\"]/p")).contains("The product has been added to your shopping cart"),"Product is not added to Cart");

        // Close the notification bar
        clickOnElement(By.xpath("//span[@class=\"close\"]"));

        // Refresh Page
        refresh();

        // Take price of Nokia lumia 1020 product
        price3 = priceConversion(By.xpath("//div[3]/div/div[2]/div[3]/div/span"));

        // Add above product to Add to Cart
        clickOnElement(By.xpath("//div[@class=\"master-column-wrapper\"]/div[2]/div/div[2]/div[3]/div/div[3]/div/div[2]/div[3]/div[2]/input"));
        softAssert.assertTrue(getText(By.xpath("//div[@id=\"bar-notification\"]/p")).contains("The product has been added to your shopping cart"),"Product is not added to cart");

        // To calculate Total of all Above three price
        total = price1 + price2 + price3;

        // Convert Total of all three product into String
        totalPriceOfProduct = Double.toString(total);

        // Refresh Page
        refresh();
        softAssert.assertAll();

        // Go to Add to Cart
        homePage.goToShoppingCart();
    }
}
