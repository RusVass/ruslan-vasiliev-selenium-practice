package org.brit.Brit.Lesson18_19_20_21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SelectTests extends BaseTestClass {

    @BeforeClass
    public void beforeClass(){
        seleniumLib.goToUrl("http://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void selectTest(){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);

        select.selectByIndex(1);
        String text = select.getFirstSelectedOption().getText();
        Assert.assertEquals(text, "Option 1");

        select.selectByValue("2");
        text = select.getFirstSelectedOption().getText();
        Assert.assertEquals(text, "Option 2");
    }
}

