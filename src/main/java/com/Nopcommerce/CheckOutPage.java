package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * @ author Jay Vaghani on 15/04/2017.
 * This is Checkout page
 */
public class CheckOutPage extends Utils
{
    // Check out As a Guest
    public void checkOutAsAGuest()
    {
        //Filling the personal details
        typeText(By.id("BillingNewAddress_FirstName"), "Jayendra");
        typeText(By.id("BillingNewAddress_LastName"), "Vaghani");
        typeText(By.id("BillingNewAddress_Email"), "jaybhavi1@yahoo.com");

        // Select country
        selectByText(By.id("BillingNewAddress_CountryId"), "United Kingdom");

        typeText(By.id("BillingNewAddress_City"), "London");
        typeText(By.id("BillingNewAddress_Address1"), "Flat 38 Goodstone Court ");
        typeText(By.id("BillingNewAddress_Address2"), "205 Headstone Drive");
        typeText(By.id("BillingNewAddress_ZipPostalCode"), "HA1 4FL");
        typeText(By.id("BillingNewAddress_PhoneNumber"), "07988847534");

        //continue to new page
        clickOnElement(By.cssSelector("input.button-1.new-address-next-step-button"));

        // Select Shipping Method
        clickOnElement(By.cssSelector("input.button-1.shipping-method-next-step-button"));

        // click on continue button
        clickOnElement(By.xpath("//div[@id='shipping-method-buttons-container']/input"));

        // click on continue button to Payment Page
        clickOnElement(By.id("paymentmethod_1"));

        // click on Credit Card Radio Button
        clickOnElement(By.cssSelector("input.button-1.payment-method-next-step-button"));

        //payment type
        selectByValue(By.id("CreditCardType"), "MasterCard");
        typeText(By.id("CardholderName"), "JD Vaghani");
        typeText(By.id("CardNumber"), "5580831656701070");
        selectByValue(By.id("ExpireMonth"), "10");
        selectByValue(By.id("ExpireYear"), "2018");
        typeText(By.id("CardCode"), "935");

        // click on continue Button
        clickOnElement(By.cssSelector("input.button-1.payment-info-next-step-button"));
        clickOnElement(By.cssSelector("input.button-1.confirm-order-next-step-button"));

        // confirm order
        assertByStringVariable(getText(By.xpath("//div[@class='master-wrapper-page']/div[3]/div/div/div/div[2]/div/div/strong")),
                "Your order has been successfully processed!","Order not been placed");

    }

    // Check out As a new User
    public void checkOutAsNewUser()
    {
        // Select country
        selectByText(By.id("BillingNewAddress_CountryId"), "United Kingdom");

        typeText(By.id("BillingNewAddress_City"), "London");
        typeText(By.id("BillingNewAddress_Address1"), "Flat 38 Goodstone Court ");
        typeText(By.id("BillingNewAddress_Address2"), "205 Headstone Drive");
        typeText(By.id("BillingNewAddress_ZipPostalCode"), "HA1 4FL");
        typeText(By.id("BillingNewAddress_PhoneNumber"), "07988847534");

        //continue to new page
        clickOnElement(By.cssSelector("input.button-1.new-address-next-step-button"));

        // Select Shipping Method
        clickOnElement(By.cssSelector("input.button-1.shipping-method-next-step-button"));

        // click on continue button
        clickOnElement(By.xpath("//div[@id='shipping-method-buttons-container']/input"));

        // click on continue button to Payment Page
        clickOnElement(By.id("paymentmethod_1"));

        // Select Payment Method
        // click on Credit Card Radio Button
        clickOnElement(By.cssSelector("input.button-1.payment-method-next-step-button"));

        //payment type
        selectByValue(By.id("CreditCardType"), "MasterCard");
        typeText(By.id("CardholderName"), "JD Vaghani");
        typeText(By.id("CardNumber"), "5580831656701070");
        selectByValue(By.id("ExpireMonth"), "10");
        selectByValue(By.id("ExpireYear"), "2018");
        typeText(By.id("CardCode"), "935");

        // click on continue Button
        clickOnElement(By.cssSelector("input.button-1.payment-info-next-step-button"));
        clickOnElement(By.cssSelector("input.button-1.confirm-order-next-step-button"));

        // confirm order
        assertByStringVariable(getText(By.xpath("//div[@class='master-wrapper-page']/div[3]/div/div/div/div[2]/div/div/strong")),"Your order has been successfully processed!","Order not been placed");


    }


}
