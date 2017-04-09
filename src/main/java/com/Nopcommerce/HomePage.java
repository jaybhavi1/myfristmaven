package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by user on 08/04/2017.
 */
public class HomePage extends Utils
{
    // click on Register Button on NopCommerce Home Page
    public void clickOnRegisterButton()
    {
        // click on Register Button from top menu
        clickOnElement(By.className("ico-register"));

        // Verify that IS user navigate to Registration page Successfully ?
        Assert.assertEquals("Register",getText(By.xpath("//div[@class='page-title']/h1")));
    }
    //click on Login Button
    public void clickOnLoginButton()
    {
        clickOnElement(By.className("ico-login"));
        // Verify that user should navigate to Login page
        assertByGetAttribute(By.className("page-title"),"innerText","Welcome, Please Sign In!","User is not in SignIn page");
    }
    // click on Computers categories
    public void clickOnComputers()
    {
        clickOnElement(By.xpath(".//ul[@class='top-menu']//a[@href=\"/computers\"]"));
    }
    // click on Electronics categories
    public void clickOnElectonics()
    {
        clickOnElement(By.xpath("//ul[@class='top-menu']/li[2]/a"));
    }
    // click on Apparel categories
    public void clickOnApparel()
    {
        clickOnElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Apparel')]"));
    }
    // click on Books categories
    public void clickOnBooks()
    {
        clickOnElement(By.xpath("//div[@class=\"header-menu\"]/ul/li[5]/a"));
    }
    // click on Virtual gift card in Featured product on Homepage
    public void clickOnVitualGiftCard()
    {
        clickOnElement(By.xpath("(//input[@value='Add to cart'])[4]"));
    }
    // Click on Shopping Cart Button
    public void goToShoppingCart()
    {
        clickOnElement(By.xpath("//*[@id='topcartlink']/a/span[1]"));
    }
}


