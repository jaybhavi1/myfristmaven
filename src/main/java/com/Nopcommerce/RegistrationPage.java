package com.Nopcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @ author Jay Vaghani on 09/04/2017.
 * This is registration page
 */
public class RegistrationPage extends Utils
{
    static String userName="";
    // Registration Page Method
    public void registration()
    {
        userName="jaybhavi1"+dateStamp()+"@yahoo.com";
        //Filling User's Personal Details in Every Field
        clickOnElement(By.id("gender-male"));
        typeText(By.id("FirstName"),"Jayendra");
        typeText(By.id("LastName"),"Vghani");
        selectByIndex(By.xpath("//select[@name='DateOfBirthDay']"),14);
        selectByText(By.xpath("//select[@name='DateOfBirthMonth']"),"March");
        selectByValue(By.xpath("//select[@name='DateOfBirthYear']"),"1988");
        typeText(By.id("Email"),userName);
        typeText(By.id("Company"),"Aum");
        typeText(By.id("Password"),"205madhav");
        typeText(By.id("ConfirmPassword"),"205madhav");
        clickOnElement(By.id("register-button"));
    }

    // Click on Continue for Shopping Cart Checkout
    public void clickOnContinueButton()
    {
        clickOnElement(By.name("register-continue"));

        //Assert User should navigate to Shopping Cart Page
        assertTrueContains("//h1","xpath","Shopping cart","User navigate to shopping Cart");
    }

    // Click on Log out Button
    public void clickOnLogoutButton()
    {
        clickOnElement(By.className("ico-logout"));

        // Assert user should log out successfully
        assertTrueContains("//a[contains(text(),'Log in')]","xpath","Log in","User not Log out Successfully");
    }

    // Click on My account Button
    public void clickOnMyAccount()
    {
        clickOnElement(By.className("ico-account"));

        // Assert User navigate to My account page
        assertTrueContains("//h1","xpath","My account - Customer info","User navigate to My account page");
    }

}
