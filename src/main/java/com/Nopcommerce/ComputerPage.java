package com.Nopcommerce;

import org.openqa.selenium.By;

/**
 * @ author Jay Vaghani on 09/04/2017.
 * This is the Computers Categories Page
 */
public class ComputerPage extends Utils
{
    // Click on Home Button to navigate Home Page
    public void clickOnHomeButton()
    {
        clickOnElement(By.xpath("//a[text()='Home']"));

        // Verify that User navigate to Home Page
        assertTrueContains("topic-block-title","class","Welcome to our store","User Not navigate to Home page");
    }

    // Click on Desktops Category
    public void clickOnDesktopsCategory()
    {
        clickOnElement(By.xpath("//ul[@class='sublist']/li[1]/a"));

        // Verify that user should move to Desktops Page
        assertTrueContains("page-title","class","Desktops","User not Move to Desktops Page");
    }

    // Click on Notebooks Category
    public void clickOnNotebooksCategory()
    {
        clickOnElement(By.xpath("//ul[@class='sublist']/li[2]/a"));

        // Verify that user should move to Notebooks Page
        assertTrueContains("page-title","class","Notebooks","User not Move to Notebooks Page");
    }

    // Click on Software Category
    public void clickOnSoftwareCategory()
    {
        clickOnElement(By.xpath("//ul[@class='sublist']/li[3]/a"));

        // Verify that user should move to Software Page
        assertTrueContains("page-title","class","Software","User not Move to Software Page");
    }


}
