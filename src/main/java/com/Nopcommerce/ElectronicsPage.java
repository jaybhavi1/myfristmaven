package com.Nopcommerce;

import org.openqa.selenium.By;

/**
 * @ author Jay Vaghani on 10/04/2017.
 * This is Electronics Page
 */
public class ElectronicsPage extends Utils
{
    // Click on Home Button to navigate Home Page
    public void clickOnHomeButton()
    {
        clickOnElement(By.xpath("//a[text()='Home']"));

        // Verify that User navigate to Home Page
        assertTrueContains("topic-block-title","class","Welcome to our store","User Not navigate to Home page");
    }

    // Click on Camera & Photo Categories
    public void clickOnCameraAndPhoto()
    {
        clickOnElement(By.xpath("//ul[@class='sublist']/li[1]/a"));

        // Verify that user navigate to Camera & Photo Page
        assertTrueContains("page-title","class","Camera & photo","User not navigate to Camera & Photo");
    }

    // Click on Cell phones Categories
    public void clickOnCellPhones()
    {
        clickOnElement(By.xpath("//ul[@class='sublist']/li[2]/a"));

        // Verify that user navigate to Cell phones Page
        assertTrueContains("page-title","class","Cell phones","User not navigate to Cell phones");
    }

    // Click on Others Categories
    public void clickOnOthers()
    {
        clickOnElement(By.xpath("//ul[@class='sublist']/li[3]/a"));

        // Verify that user navigate to Others Page
        assertTrueContains("page-title","class","Others","User not navigate to Others");
    }


}
