package com.Nopcommerce;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple BasePage.
 */
public class BaseTest extends BasePage
{
    BrowserSelector browserSelector = new BrowserSelector();

    @BeforeMethod
    public void openBrowser()
    {
        browserSelector.selectBrowser();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.nopcommerce.com/");

    }
    @AfterMethod
    public void closeBrowser()
    {
        driver.quit();

    }
}
