package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * @ author Jay Vaghani on 13/04/2017.
 * This is a shopping cart Page
 */
public class ShoppingCartPage extends Utils
{
    // Change the Quantity of Product Fahrenheit 451 by Ray Bradbury
    public void changeTheQuantityOfFahrenheit()
    {
        changeQuantity(By.xpath("//td[@class='quantity']/input"), "4");
        clickOnElement(By.cssSelector("input.button-2.update-cart-button"));

        elementToBeVisible(By.cssSelector(".qty-input"), 4);
        assertByGetAttribute(By.cssSelector(".qty-input"),  "value","4", "Quantity is not changed");
    }

    // Change The quantity of CellPhone
    public void changeTheQtyOfCellPhone()
    {
        changeQuantity(By.xpath("//form[@id='shopping-cart-form']/div/table/tbody/tr[1]/td[6]/input"),"2");
        changeQuantity(By.xpath("//form[@id='shopping-cart-form']/div/table/tbody/tr[3]/td[6]/input"),"3");

        // Update Shopping Cart
        clickOnElement(By.cssSelector("input.button-2.update-cart-button"));

        elementToBeVisible(By.xpath("//li[@id='topcartlink']/a/span[2]"),3);
        assertTrueContains("//li[@id='topcartlink']/a/span[2]","xpath","(6)","Quantity is not changed");
    }

    // Accept Terms And Condition and Continue for CheckOut
    public void acceptTermsAndContinueForCheckout()
    {
        // Click on Terms And Conditions check box
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        assertTrueIsSelected(By.id("termsofservice"),"Check box not checked");

        selectByValue(By.id("CountryId"),"82");
        assertTrueIsSelected(By.xpath("//option[@value='82']"),"Country is not selected");

        elementToBeClickeble(By.id("checkout"),2);
        clickOnElement(By.id("checkout"));
        alertAccept();

    }

    // Change the Quantity
    public void changeQuantity(By by, String x)
    {
        typeText(by, x);
    }

    // Take total price of cart for CellPhone
    public String totalOfCartPrice() {

        // Take the Total of Shopping Cart
        double cartTotal = priceConversion(By.cssSelector("span.value-summary > strong"));

        // convert cart price into String
        String totalPriceOfCart = Double.toString(cartTotal);
        return totalPriceOfCart;
    }

}
