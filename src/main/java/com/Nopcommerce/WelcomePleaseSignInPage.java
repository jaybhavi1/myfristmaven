package com.Nopcommerce;

import org.openqa.selenium.By;

/**
 * @ author Jay Vaghani on 15/04/2017.
 * This is the Checkout as a guest or register and Returning Customer page
 */
public class WelcomePleaseSignInPage extends Utils
{
    // Checkout As a Guest
    public void checkoutAaAGuest()
    {
        clickOnElement(By.xpath("//input[@value='Checkout as Guest']"));

        // Assert user move to Shopping cart page
        assertTrueContains("page-title","class","Checkout","User not navigate to Shopping cart page");
    }

    // Register As New Customer
    public void clickOnRegisterButton()
    {
        clickOnElement(By.xpath("//input[@value='Register']"));

        // Assert user is navigate to Register page
        assertTrueContains("h1","css","Register","User is not navigate to Register page");
    }

    // Login As Returning Customer
    public void clickOnLoginButton()
    {
        typeText(By.id("Email")," ");
        typeText(By.id("Password")," ");
        clickOnElement(By.xpath("//input[@value='Log in']"));

        // Assert User should login Successfully

    }

}
