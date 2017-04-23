package com.Nopcommerce;

import org.openqa.selenium.By;

/**
 * @ author Jay Vaghani on 13/04/2017.
 * This is $25 Virtual Gift Card Page
 */

public class $25VirtualGiftCardPage extends Utils
{

    // Email a Friend
    public void emailAFriend()
    {
        typeText(By.id("giftcard_43_RecipientName"),"Kavita");
        typeText(By.id("giftcard_43_RecipientEmail"),"kesah_2004@yahoo.com");
        typeText(By.id("giftcard_43_Message"),"Hi Mini Ratan");
        clickOnElement(By.xpath("//div[@class='email-a-friend']"));
        typeText(By.id("FriendEmail"),"kesah_2004@yahoo.com");
        typeText(By.id("PersonalMessage"),"Hi It gift for you");
        clickOnElement(By.xpath("//div[@class='buttons']"));
    }

}
