package com.Nopcommerce;

import org.openqa.selenium.By;

/**
 * @ author Jay Vaghani on 13/04/2017.
 * This is Digital Download Page
 */
public class DigitalDownloadsPage extends Utils
{
    // Click on Home Button to navigate Home Page
    public void clickOnHomeButton()
    {
        clickOnElement(By.xpath("//a[text()='Home']"));

        // Verify that User navigate to Home Page
        assertTrueContains("topic-block-title","class","Welcome to our store","User Not navigate to Home page");
    }

}
