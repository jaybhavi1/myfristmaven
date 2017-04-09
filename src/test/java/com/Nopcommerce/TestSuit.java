package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by user on 08/04/2017.
 */
public class TestSuit extends BaseTest
{
    RegistrationPage registrationPage = new RegistrationPage();
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();


    @Test
    public void userShouldRegisterSuccessfully()
    {
        homePage.clickOnRegisterButton();
        registrationPage.registration();
        // Verify That user should be register Successfully
        Utils.assertByGetText(By.className("result"),"Your registration completed","User is not register successfully");

    }
    @Test
    public void userCanLogInSuccessfully()
    {
        loginPage.loginAsExistingUser();
        Utils.assertByGetAttribute(By.className("ico-account"),"innerText","My account","User is not LogIn ");
//        registrationPage.clickOnMyAccount();
//
//        // Verify that User should login Successfully
//        Utils.assertByGetAttribute(By.id("FirstName"),"value","Jayendra","User should not login Successfully");
    }

}
