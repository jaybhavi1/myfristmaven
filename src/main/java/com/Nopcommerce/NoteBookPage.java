package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * @ author Jay Vaghani on 14/04/2017.
 * This is the NoteBooks page
 */
public class NoteBookPage extends Utils
{
    public void sortNoteBookPageProductAtoZ()
    {
        sortByPosition("Name: A to Z");
        assertTrueIsSelected(By.xpath("//select[@id='products-orderby']/option[2]"),"Position A to Z is not selected");
    }
}
