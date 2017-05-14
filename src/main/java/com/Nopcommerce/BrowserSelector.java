package com.Nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.Nopcommerce.BasePage.driver;

/**
 * @ author Jay Vaghani on 22/04/2017.
 */
public class BrowserSelector
{
    // This is object of LoadProp class
    LoadProp loadProp = new LoadProp();

    // This is object of DesiredCaps class
    DesireCaps desireCaps = new DesireCaps();

    // This is for passing key to Browser run through TestSuite
    String  browser = loadProp.getProperty("browser");

    // This is use for run test from Jenkins
    //String browser = System.getProperty("browser");

    public void selectBrowser()
    {
        String  browser = loadProp.getProperty("browser");
        String runWith = loadProp.getProperty("runWith");

        System.out.println("Selected browser is "+browser);

        if (browser.equalsIgnoreCase("Chrome"))
        {
            if (runWith.equalsIgnoreCase("saucelab")){
                // Run test on Sauce lab
                desireCaps.chromeCaps();
            }else {
                //Run Test on System
                   System.setProperty("webdriver.chrome.driver","src\\test\\Resources\\BrowserDriver\\chromedriver.exe");
                   driver = new ChromeDriver();
            }

        }else if(browser.equalsIgnoreCase("IE"))
            {
                if(runWith.equalsIgnoreCase("saucelab")){
                    //Run Test on Sauce lab
                    desireCaps.ieCaps();
                }else {
                    //Run Test on System
                    System.setProperty("webdriver.ie.driver","src\\test\\Resources\\BrowserDriver\\IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
                }

            }else if(browser.equalsIgnoreCase("FireFox"))
                {
                    if (runWith.equalsIgnoreCase("saucelab")){
                        //Run Test on Sauce lab
                        desireCaps.fireFoxCaps();
                    }else if (runWith.equalsIgnoreCase("laptop")){
                        //Run Test on System
                        driver = new FirefoxDriver();
                    }
                }else {
                    System.out.println(" Browser name is Wrong ");
                }
    }

}

