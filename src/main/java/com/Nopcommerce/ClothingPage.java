package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * @ author Jay Vaghani on 14/04/2017.
 * This is Clothing page
 */
public class ClothingPage extends Utils
{
    // Cloth Shopping
    public void clothing() {
        // Taking Screen Shot of Clothing Page
        browserScreenShot("C:\\Users\\user\\Desktop\\WebDriverScreenShot");

        // Sort product By Price: Low to High
        sortByPosition("Price: Low to High");

        // Assert that products are arrange in Price: Low to High
        Assert.assertTrue(ascendingOrLowToHighOrder(By.xpath("//div[@class='item-grid']//div/div[2]/div[3]/div[1]/span")),"Products are not arrange in Low to High");

        // Display Product 3 per Page
        displayBy(3);

        // Assert that product are display per page is 3
        Assert.assertTrue(assertDisplayPerPage(By.xpath("//div[@class='item-grid']//div/div[2]/div[3]/div[1]/span"),3),"Display per page is wrong");


        // Arrange product in List View
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

        // Taking Screen Shot of Clothing Page
        browserScreenShot("C:\\Users\\user\\Desktop\\WebDriverScreenShot");

        // Add Product Custom Nike Tailwind Loose Short-Sleeve Running Shirt to Compare List
        clickOnElement(By.xpath("//div[1]/div/div[2]/div[3]/div[2]/input[2]"));

        // Taking ScreenShot of Whole Screen
        elementToBeVisible(By.id("bar-notification"), 1);
        printScreen("C:\\Users\\user\\Desktop\\WebDriverScreenShot");

        // Refresh Windows
        refresh();

        // Add product OverSized Women T-Shirt to Compare List
        clickOnElement(By.xpath("//div[3]/div/div[2]/div[3]/div[2]/input[2]"));
        assertTrueContains("//*[@id='bar-notification']/p","xpath", "The product has been added to your product comparison", "Product is not added to Comparison List");

        // Go to Compare list
        clickOnElement(By.xpath("//*[@id='bar-notification']/p/a"));

        // Assert Same product are in to compare list
        assertTrueContains("(//a[contains(@href, '/nike-tailwind-loose-short-sleeve-running-shirt')])[2]","xpath", "Nike Tailwind Loose Short-Sleeve Running Shirt", "Product is not in comparison list");
        assertTrueContains("(//a[contains(@href, '/oversized-women-t-shirt')])[2]","xpath", "Oversized Women T-Shirt", "Product is not in comparison list");

    }

}
