package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

/**
 * @ author Jay Vaghani on 13/04/2017.
 * This is a apparel Page
 */
public class ApparelPage extends Utils
{
    // Click on Home Button to navigate Home Page
    public void clickOnHomeButton()
    {
        clickOnElement(By.xpath("//a[text()='Home']"));

        // Verify that User navigate to Home Page
        assertTrueContains("topic-block-title","class","Welcome to our store","User Not navigate to Home page");
    }

    // Click on Shoes Categories
    public void clickOnShoesButton()
    {
        clickOnElement(By.xpath("(//a[contains(@href, '/shoes')])[3]"));

        // Assert user should navigate to Shoes Page
        assertTrueContains("h1","css","Shoes","User is not navigate to shoes page");

    }

    // Click on Clothing Categories
    public void clickOnClothingButton()
    {
        clickOnElement(By.xpath("(//a[contains(@href, '/clothing')])[3]"));

        // Assert user should navigate to Clothing Page
        assertTrueContains("h1","css","Clothing","User is not navigate to Clothing page");
    }

    // Click on Accessories Categories
    public void clickOnAccessoriesButton()
    {
        clickOnElement(By.xpath("(//a[contains(@href, '/accessories')])[3]"));

        // Assert user should navigate to Accessories page
        assertTrueContains("h1","css","Accessories","User is not navigate to Accessories page");
    }
}
