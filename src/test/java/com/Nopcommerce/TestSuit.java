package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @ author Jay Vaghani on 08/04/2017.
 * This is the Complete TestSuit
 */
public class TestSuit extends BaseTest
{
    Utils utils = new Utils();
    RegistrationPage registrationPage = new RegistrationPage();
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ComputerPage computerPage = new ComputerPage();
    ElectronicsPage electronicsPage = new ElectronicsPage();
    ApparelPage apparelPage = new ApparelPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    $25VirtualGiftCardPage virtualGiftCardPage = new $25VirtualGiftCardPage();
    ClothingPage clothingPage = new ClothingPage();
    CellPhonePage cellPhonePage = new CellPhonePage();
    NoteBookPage noteBookPage = new NoteBookPage();
    BooksPage booksPage = new BooksPage();
    CheckOutPage checkOutPage = new CheckOutPage();
    WelcomePleaseSignInPage welcomePleaseSignInPage = new WelcomePleaseSignInPage();
    CompareProductPage compareProductPage = new CompareProductPage();


    @Test
    public void userShouldRegisterSuccessfully()
    {
        // Click on Registration Button on Home page
        homePage.clickOnRegisterButton();

        // Register as a New User on Registration Page
        registrationPage.registration();

        // Verify That user should be register Successfully
        utils.assertTrueContains("result","class","Your registration completed","User is not register successfully");
    }

    @Test
    public void userShouldLogInSuccessfully()
    {
        // Login as Existing User on Login Page
        loginPage.loginAsExistingUser();

        // Verify that User should login Successfully
        utils.assertByGetAttribute(By.className("ico-account"), "innerText", "My account", "User is not Login ");

    }

    @Test
    public void userShouldNavigateToMyAccountPage()
    {
        // Login as Existing User on Login page
        loginPage.loginAsExistingUser();

        // Click on MyAccount Button on Registration Page
        registrationPage.clickOnMyAccount();

        // Verify that user should navigate to My Account page
        utils.assertByGetAttribute(By.id("FirstName"),"value","Jayendra","User should not login Successfully");
    }

    @Test
    public void userShouldSendEmailAFriendSuccessfully()
    {
        // Login as Existing User on login page
        loginPage.loginAsExistingUser();

        // Click on $25 Virtual Gift Card From Home Page
        homePage.clickOn$25VirtualGiftCard();

        // Email a Friend on Virtual Gift Card Page
        virtualGiftCardPage.emailAFriend();

        // Verify that user send email successfully
        utils.assertByGetText(By.className("result"),"Your message has been sent.","User is not send Email A Friend");
    }

    @Test
    public void userShouldAddProductCompareListAndClearCompareListSuccessfully()
    {
        // Click on Apparel Categories on Home Page
        homePage.clickOnApparel();

        // Click on Clothing button on apparel page
        apparelPage.clickOnClothingButton();

        // Add clothing in to Compare to wish list on Clothing Page
        clothingPage.clothing();

        //Clear the Compare list
        compareProductPage.clickOnClearList();

        // Verify that user should clear compare list successfully
        utils.assertTrueContains("//div[2]/div/div[2]/div","xpath","You have no items to compare.","Compare list not clear");


    }

    @Test
    public void userShouldAddProductIntoAddToCartFromCellPhonePageAndCompareTotalPriceOfProductWithCartTotal()
    {
        // Click on Electronics Categories on Home page
        homePage.clickOnElectronics();

        //Click on CellPhone Categories on Electronics Page
        electronicsPage.clickOnCellPhones();

        // Add first three cell phone ot cart
        cellPhonePage.cellPhone();

        // Total of shopping cart price
        shoppingCartPage.totalOfCartPrice();

        // Verify that Total price of cellphone and Total of cart is Equal
        utils.assertByStringVariable(cellPhonePage.totalPriceOfProduct,shoppingCartPage.totalOfCartPrice(),"Price are not matched");

    }

    @Test
    public void userShouldAddBookToAddToCartAndAddToWishListAndCheckOutAsAGuest()
    {
        // Click on Books Categories on Home Page
        homePage.clickOnBooks();

        // Add Fahrenheit By Ray Bradbury Book In to Add to Cart on Books Page
        booksPage.addToCartFahrenheitByRayBradburyBook();

        // Add Fahrenheit By Ray Bradbury Book In to Add to WishList on Books Page
        booksPage.addToWishListFahrenheitByRayBradburyBook();

        // Buy this Book on Books Page
        booksPage.goToShoppingCart();

        // Update the Shopping Cart by changing Qty on Shopping Cart Page
        shoppingCartPage.changeTheQuantityOfFahrenheit();

        // Accept the terms and Condition and Continue for Checkout
        shoppingCartPage.acceptTermsAndContinueForCheckout();

        // Click on Checkout As A Guest Button on Welcome to sign in Page
        welcomePleaseSignInPage.checkoutAaAGuest();

        // Check out as a Guest on Checkout Page
        checkOutPage.checkOutAsAGuest();
    }

    @Test
    public void userShouldSortProductOnNoteBookPageAtoZ()
    {
        // Click on Computer Categories on Home page
        homePage.clickOnComputers();

        // Click on NoteBooks Categories on Computer page
        computerPage.clickOnNotebooksCategory();

        // Click on Product sortBy and Select A to Z on note book page
        noteBookPage.sortNoteBookPageProductAtoZ();
        Assert.assertTrue(utils.ascendingOrLowToHighOrder(By.xpath("//h2")),"Product is not sorted");
    }

    @Test
    public void userShouldAddProductIntoAddToCartFromCellPhonePageAndChangeQtyInShoppingCartAndCheckoutSuccessfully()
    {
        // Click on Electronics Categories on Home page
        homePage.clickOnElectronics();

        //Click on CellPhone Categories on Electronics Page
        electronicsPage.clickOnCellPhones();

        // Add first three cell phone ot cart
        cellPhonePage.cellPhone();

        // Update Quantity of Cell phone in Shopping Cart
        shoppingCartPage.changeTheQtyOfCellPhone();

        // Accept terms and Continue for checkout
        shoppingCartPage.acceptTermsAndContinueForCheckout();

        // Check out as a new user
        welcomePleaseSignInPage.clickOnRegisterButton();

        // register as a new customer
        registrationPage.registration();

        // Click on continue Button on Registration Page
        registrationPage.clickOnContinueButton();

        // Accept terms and condition and continue
        shoppingCartPage.acceptTermsAndContinueForCheckout();

        // Continue for check out
        checkOutPage.checkOutAsNewUser();

        // Assert User Should Place Order Successfully
        utils.assertTrueContains("//div[@class='master-wrapper-page']/div[3]/div/div/div/div[2]/div/div/strong","xpath","Your order has been successfully processed!","Order not place Successfully");

    }

}
