package com.Nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static com.Nopcommerce.BasePage.driver;

/**
 * @ author Jay Vaghani on 22/04/2017.
 */
public class BrowserSelector
{
    // This is object of LoadProp class
    LoadProp loadProp = new LoadProp();

    // This is for passing key to Browser run through TestSuite
//    String  browser = loadProp.getProperty("browser");

    // This is use for run test from Jenkins
    String browser = System.getProperty("browser");

    public void selectBrowser()
    {
        String  browser = loadProp.getProperty("browser");
        System.out.println("Selected browser is "+browser);

        if (browser.equalsIgnoreCase("Chrome"))
        {
           System.setProperty("webdriver.chrome.driver","src\\test\\Resources\\BrowserDriver\\chromedriver.exe");
            driver = new ChromeDriver();

        }else if(browser.equalsIgnoreCase("IE"))
        {
            System.setProperty("webdriver.ie.driver","C:\\Users\\user\\IdeaProjects\\myfristmaven\\src\\test\\Resources\\BrowserDriver\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }else if(browser.equalsIgnoreCase("FireFox"))
        {
            driver= new FirefoxDriver();
        }else {
            System.out.println(" Browser name is Wrong ");
        }
    }

}

//public class BrowserSelector extends BasePage {
//
//    LoadProp loadProp= new LoadProp();
//   // String browser=loadProp.getProperty("browser");
//   String browser=System.getProperty("browser");
//
//    public void browser() {
//
//
//        if (browser.equalsIgnoreCase("firefox"))
//        {
//            driver = new FirefoxDriver();
//
//        } else if (browser.equalsIgnoreCase("Chrome"))
//        {
//            System.setProperty("webdriver.chrome.driver", "src\\test\\Resources\\BrowserDriver\\chromedriver.exe");
//            driver = new ChromeDriver();
//
//        } else if (browser.equalsIgnoreCase("ie"))
//        {
//            System.setProperty("webdriver.ie.driver", "src\\test\\Resources\\BrowserDriver\\IEDriverServer.exe");
//            driver = new InternetExplorerDriver();
//        }else
//            {
//                System.out.println("Browser name is not correct");
//            }
//    }
