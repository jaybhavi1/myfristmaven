package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * @ author Jay Vaghani on 09/04/2017.
 * This is a Books Page on Nop Commerce WebSite
 */
public class BooksPage extends Utils
{
    // click on Add to cart button
    public void addToCartFahrenheitByRayBradburyBook()
    {
        // Add to Cart
        clickOnElement(By.cssSelector("input.button-2.product-box-add-to-cart-button"));

        // Assert Text that product add to cart
        elementToBeClickeble(By.cssSelector("p.content"),2);
        assertTrueContains("p.content","css","The product has been added to your shopping cart","Product is not added");

        // close the Tab
        clickOnElement(By.cssSelector("span.close"));
    }

    // Click on Add to Wish List button
    public void addToWishListFahrenheitByRayBradburyBook()
    {
        driver.navigate().refresh();
        // Add to Wish list
        clickOnElement(By.cssSelector("input.button-2.add-to-wishlist-button"));

        //Assert text that product add to wish list
        assertTrueContains("//div[@id='bar-notification']/p","xpath","The product has been added to your wishlist","Product is not added to wishlist");

        //Close wish list tab
        clickOnElement(By.cssSelector("span.close"));
    }

    // Go to Shopping cart
    public void goToShoppingCart()
    {
        // Go to shopping cart from green bar
        mouseHover(By.cssSelector("span.cart-label"));
        clickOnElement(By.cssSelector("input.button-1.cart-button"));

        // Assert user navigate to Shopping cart page
        assertTrueContains("//h1","xpath","Shopping cart","User not navigate to shopping cart page");
    }
}
