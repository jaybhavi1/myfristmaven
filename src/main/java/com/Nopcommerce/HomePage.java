package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * @ author Jay Vaghani 09/04/2017.
 * This is the Home Page of Demo nop Commerce WebSite.
 */

public class HomePage extends Utils
{
    // Select Currency US Dollar Or Euro On Top Menu
    public void selectCurrency()
    {
        selectByText(By.id("customerCurrency"),"Euro");

        // Assert that Euro is selected
        assertByStringVariable("Euro",getText(By.xpath("//option[text()='Euro']")),"Euro is not selected");

    }

    // click on Register Button on Top Menu
    public void clickOnRegisterButton()
    {
        // click on Register Button from top menu
        clickOnElement(By.className("ico-register"));

        // Verify that user is navigate to Registration page Successfully
        assertTrueContains("//div[@class='page-title']/h1","xpath","Register","User not navigate to Register page");
    }

    //click on Login Button n top menu
    public void clickOnLoginButton()
    {
        clickOnElement(By.className("ico-login"));

        // Verify that user should navigate to Login page
        assertTrueContains("page-title","class","Welcome, Please Sign In!","User not navigate SignIn page");
    }

    //Click on WishList Button on Top Menu
    public void clickOnWishList()
    {
        clickOnElement(By.xpath("//a[@class='ico-wishlist']/span[1]"));

        // Verify that User should navigate to wish list page
        assertTrueContains("h1","css","Wishlist","User not navigate to WishList page");
    }

    // Click on Shopping Cart Button
    public void goToShoppingCart()
    {
        // Go to shopping cart from green bar
        mouseHover(By.cssSelector("span.cart-label"));
        clickOnElement(By.cssSelector("input.button-1.cart-button"));

        // Verify that User navigate to Shopping Cart Page
        assertTrueContains("page-title","class","Shopping cart","User is not navigate to Shopping cart");

    }

    // click on Computers categories
    public void clickOnComputers()
    {
        clickOnElement(By.xpath(".//ul[@class='top-menu']//a[@href=\"/computers\"]"));

        //Assert User Mover to Computers Page
        assertTrueContains("page-title","class","Computers","User not navigate to Computers Page");
    }

    // click on Electronics categories
    public void clickOnElectronics()
    {
        clickOnElement(By.xpath("//ul[@class='top-menu']/li[2]/a"));

        // Verify that user should navigate to Electronics Page
        assertTrueContains("page-title","class","Electronics","User not navigate to Electronics Page");

    }

    // click on Apparel categories
    public void clickOnApparel()
    {
        clickOnElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Apparel')]"));

        // Verify that user should navigate to Apparel Page
        assertTrueContains("page-title","class","Apparel","User not navigate to Electronics Page");
    }

    // click on Digital Download categories
    public void clickOnDigitalDownload()
    {
        clickOnElement(By.xpath("//ul[@class='top-menu']/li[4]/a"));

        // Verify that User navigate to Digital Download Page
        assertTrueContains("page-title","class","Digital downloads","User not navigate to Digital Download Page");
    }

    // Click on Books Categories
    public void clickOnBooks()
    {
        clickOnElement(By.xpath("//ul[@class='top-menu']/li[5]/a"));

        // Verify that User navigate to Books Page
        assertTrueContains("page-title","class","Books","User not navigate to Books Page");
    }

    // click on Jewelry categories
    public void clickOnJewelry()
    {
        clickOnElement(By.xpath("//ul[@class='top-menu']/li[6]/a"));

        // Verify that User navigate to Jewelry Page
        assertTrueContains("page-title","class","Jewelry","User not navigate to Jewelry Page");
    }

    // click on Gift cards Categories
    public void clickOnGiftCards()
    {
        clickOnElement(By.xpath("//ul[@class='top-menu']/li[7]/a"));

        // Verify that User navigate to Gift Cards Page
        assertTrueContains("page-title","class","Gift Cards","User not navigate to Gift Cards Page");
    }

    // Featured Products to select by customer from Home page
    public void clickOn$25VirtualGiftCard()
    {
        clickOnElement(By.xpath("(//input[@value='Add to cart'])[4]"));

        //Assert that user move to $25 Virtual Gift Card Page
        assertTrueContains("h1","css","$25 Virtual Gift Card","User is not navigate to Virtual gift card page");

    }

    public void clickOnBuildYourOwnComputer()
    {
        clickOnElement(By.xpath("html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[1]/div/div[2]/div[3]/div[2]/input[1]"));

        assertTrueContains("h1","css","Build your own computer","User is not navigate to Build your own computer page");
    }


}


