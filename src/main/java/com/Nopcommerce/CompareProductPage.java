package com.Nopcommerce;

import org.openqa.selenium.By;

/**
 * @ author Jay Vaghani on 15/04/2017.
 * This is the Compare Product page
 */
public class CompareProductPage extends Utils
{
    // Click on Clear Compare list
    public void clickOnClearList()
    {
        // clear the compare list
        clickOnElement(By.xpath("//a[contains(@href, '#')]"));

        // Verify that comparision list clear
        assertTrueContains("//div[2]/div/div[2]/div","xpath","You have no items to compare.","Compare list is not clear");

    }
}
