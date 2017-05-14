package com.Nopcommerce;
import com.google.common.collect.Ordering;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @ author Jay Vaghani on 08/04/2017.
 * This is Utils page will all Reusable Methods
 */
public class Utils extends BasePage {
    // Send or Type to field like name,username or password
    public static void typeText(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    // Clear the Text in Field
    public static void clear(By by) {
        driver.findElement(by).clear();
    }

    // Click on Element( click Method)
    public static void clickOnElement(By by)

    {
        driver.findElement(by).click();
    }

    // Sleep method
    public static void sleep(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Select Method
    // Select Dropdown By Visible Text
    public static void selectByText(By by, String text) {
        new Select(driver.findElement(by)).selectByVisibleText(text); // name less Object of Select class
    }

    // Select Dropdown By Visible Value
    public static void selectByValue(By by, String text) {
        Select select = new Select(driver.findElement(by));  // named object of Select class
        new Select(driver.findElement(by)).selectByValue(text);
    }

    // Select Dropdown By Index
    public static void selectByIndex(By by, int index) {
        new Select(driver.findElement(by)).selectByIndex(index);  // Name less object
    }

    // Close Browser Windows
    public static void close() {
        driver.close();
    }

    public static void quit() {
        driver.quit();
    }

    // Explicit Wait Method
    // Wait until Element to be Present
    public static void elementToBePresent(By by, int second) {
        WebDriverWait wait = new WebDriverWait(driver, second);  // named Object of Wait
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    // Wait until Element To Be Clickable
    public static void elementToBeClickeble(By by, int second) {
        WebDriverWait wait = new WebDriverWait(driver, second);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    // wait until Elemet to be Visible
    public static void elementToBeVisible(By by, int second) {
        WebDriverWait wait = new WebDriverWait(driver, second);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    // Wait until Element to be Selected
    public static void elementToBeSelected(By by, int second) {
        WebDriverWait wait = new WebDriverWait(driver, second);
        wait.until(ExpectedConditions.elementToBeSelected(by));
    }

    // Wait until Element is invisibility of element Located
    public static void invisibilityOfElementLocated(By by, int second) {
        WebDriverWait wait = new WebDriverWait(driver, second);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    // Wait until Element is invisibility of element With Text
    public static void invisibilityOfElementWithText(By by, String text, int second) {
        WebDriverWait wait = new WebDriverWait(driver, second);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(by, text));
    }

    // Get Text From Any Element
    public static String getText(By by) {
        String text = driver.findElement(by).getText();
        return text;
    }

    // Get Text By Attribute
    public static String getTextByAttribute(By by, String attributeName) {
        String text = driver.findElement(by).getAttribute(attributeName);
        return text;
    }

    // drop down selection by Attribute If select Class is not Available in firePath console
    public static void dropDownSelectionByAttribute(By by, String attributeName, String dropDownText) {
        List<WebElement> size_menu = driver.findElements(by);

        for (WebElement element : size_menu) {
            String innerText = element.getAttribute(attributeName);
            if (innerText.contentEquals(dropDownText)) {
                element.click();
                break;
            }
        }
    }

    // Date Stamp Method
    public static String dateStamp() {
        DateFormat dateFormat = new SimpleDateFormat("ddmmhhss");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        return date1;
    }

    // ScreenSHot Method
    // Browser screen shot
    public static void browserScreenShot(String filePath) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scr1, new File(filePath + "\\photo" + dateStamp() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Print Screen ScreenShot
    public static void printScreen(String filePath) {
        try {
            Robot robot = new Robot();
            BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(screenShot, "jpg", new File(filePath + "\\photo" + dateStamp() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    // Random Number Method
    public static int randomNumber(int range) {
        Random random = new Random();
        int number = random.nextInt(range);
        return number;
    }

    // Mouse hover any element
    public static void mouseHover(By by) {
        Actions actions = new Actions(driver);
        WebElement mouse = driver.findElement(by);
        actions.moveToElement(mouse).build().perform();
    }

    // Price Conversion Method
    public static double priceConversion(By by) {
        // To convert price into integer from string
        String price = getText(by);
        StringBuilder value = new StringBuilder();
        StringBuilder currencySymbol = new StringBuilder();
        for (char a : price.toCharArray()) {
            if (Character.isDigit(a) || a == '.') {
                value.append(a);
            } else {
                currencySymbol.append(a);
            }
        }
        String a1 = value.toString();
        double result = Double.parseDouble(a1);
        return result;
    }

    // To enter Locator and print the text on that locator
    public static String printTextOfLocator(By by) {
        WebElement element = driver.findElement(by);
        String text = element.getAttribute("innerText");
        return text;
    }

    // Reusable boolean method for verifying is element present
    public static boolean isElementPresent(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Reusable method for waiting for element to be Present
    public static void waitUntilElementToBePresent(By by) {
        int counter = 0;
        while (counter <= 10) {
            try {
                if (driver.findElement(by).isDisplayed()) {
                    counter++;
                    System.out.println("Waitting for a Second.....");
                    sleep(1);
                } else {
                    return;
                }
            } catch (Exception e) {
                return;
            }
        }
    }

    // Assert by getting text from web location
    public static void assertByGetText(By by, String expectedText, String errorMessage) {
        Assert.assertEquals(getText(by), expectedText, errorMessage);
    }

    // Assertion by getting attribute value from web location
    public static void assertByGetAttribute(By by, String attributeValue, String expectedText, String errorMessege) {
        Assert.assertEquals(getTextByAttribute(by, attributeValue), expectedText, errorMessege);
    }

    // Assertion by String variables
    public static void assertByStringVariable(String expectedText, String actualText, String errorMessage) {
        Assert.assertEquals(expectedText, actualText, errorMessage);
    }

    // Soft Assert Method
    public static void softAssert(By by, String expectedText, String message) {
        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(getText(by), expectedText, message);
        assertion.assertAll();
    }

    public static void softAssertForIntValue(double actual, double expected, String message) {
        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(actual, expected, message);
        assertion.assertAll();
    }

    // Product sortBy Position in any page
    public static void sortByPosition(String position) {
        if (position.equalsIgnoreCase("Price: Low to High")) {
            selectByText(By.id("products-orderby"), "Price: Low to High");
        } else if (position.equalsIgnoreCase("Name: A to Z")) {
            selectByText(By.id("products-orderby"), "Name: A to Z");
        } else if (position.equalsIgnoreCase("Name: Z to A")) {
            selectByText(By.id("products-orderby"), "Name: Z to A");
        } else if (position.equalsIgnoreCase("Created on")) {
            selectByText(By.id("products-orderby"), "Created on");
        }
    }

    // Method to set number of product to Display per Page
    public static void displayBy(int a) {
        if (a == 3) {
            selectByText(By.id("products-pagesize"), "3");
        } else if (a == 9) {
            selectByText(By.id("products-pagesize"), "9");
        } else if (a == 6) {
            selectByText(By.id("products-pagesize"), "6");
        }
    }

    // Reusable method for to check product is arrange in ascending or Low to High
    public static boolean ascendingOrLowToHighOrder(By by)
    {

        List<WebElement> productsNames_WebElement = driver.findElements(by);
        List<String> product_names = new ArrayList<String>();

        for (WebElement e : productsNames_WebElement) {
            String s = e.getText();
            product_names.add(s);
        }
        boolean isSorted = Ordering.natural().isOrdered(product_names);
        return isSorted;

    }

    // Reusable method for to check product is arrange in Descending or High to low
    public static boolean descendingOrHighToLowOrder(By by) {
        List<WebElement> productsNames_WebElement = driver.findElements(by);
        List<String> product_names = new ArrayList<String>();

        for (WebElement e : productsNames_WebElement) {
            String s = e.getText();
            product_names.add(s);
        }
        boolean isSorted = !(Ordering.natural().isOrdered(product_names));
        return isSorted;
    }

    // Method for Assert that products are display per page
    public static boolean assertDisplayPerPage(By by,int perPage)
    {   boolean isDisplay=false;
        List<WebElement> productsNames_WebElement = driver.findElements(by);
        List<String> product_names = new ArrayList<String>();

        for (WebElement e : productsNames_WebElement) {
            String s = e.getText();
            product_names.add(s);
        }
        if (perPage==product_names.size())
        {
            isDisplay=true;
        }
        return isDisplay ;
    }

    //Reusable method for alert accept
    public static void alertAccept() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    // Method for Assert True for boolean condition
    public static void assertTrueContains(String locator, String type, String contains, String message)
    {
        type = type.toLowerCase();
        if (type.equals("id")) {
            Assert.assertTrue(getText(By.id(locator)).contains(contains), message);
        } else if (type.equals("xpath")) {
            Assert.assertTrue(getText(By.xpath(locator)).contains(contains), message);
        } else if (type.equals("css")) {
            Assert.assertTrue(getText(By.cssSelector(locator)).contains(contains), message);
        } else if (type.equals("linktext")) {
            Assert.assertTrue(getText(By.linkText(locator)).contains(contains), message);
        } else if (type.equals("partiallinktext")) {
            Assert.assertTrue(getText(By.partialLinkText(locator)).contains(contains), message);
        } else if (type.equals("tag")) {
            Assert.assertTrue(getText(By.tagName(locator)).contains(contains), message);
        } else if (type.equals("name")) {
            Assert.assertTrue(getText(By.name(locator)).contains(contains), message);
        } else if (type.equals("class")) {
            Assert.assertTrue(getText(By.className(locator)).contains(contains), message);
        } else {
            System.out.println("Locator type not supported");
        }

    }

    // Assert True for IsSelected Method
    public static void assertTrueIsSelected(By by,String message)
    {
        Assert.assertTrue(driver.findElement(by).isSelected(),message);
    }

    // Method for Refresh the web Page
    public static void refresh()
    {
        driver.navigate().refresh();
    }



}