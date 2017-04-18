package com.Nopcommerce;

import org.openqa.selenium.By;

/**
 * Created by user on 09/04/2017.
 * This is the Login Page
 */
public class LoginPage extends Utils
{
    public void loginAsExistingUser()
    {
        new HomePage().clickOnRegisterButton();
        new RegistrationPage().registration();
        new RegistrationPage().clickOnLogoutButton();
        new HomePage().clickOnLoginButton();

        typeText(By.id("Email"),RegistrationPage.userName);
        typeText(By.id("Password"),"205madhav");
        clickOnElement(By.cssSelector("input.button-1.login-button"));

        // Assert user log in successfully
        assertTrueContains("//a[contains(text(),'Log out')]","xpath","Log out","User not log in successfully");
    }

}
