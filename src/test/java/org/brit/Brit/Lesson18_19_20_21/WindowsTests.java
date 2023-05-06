package org.brit.Brit.Lesson18_19_20_21;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class WindowsTests extends BaseTestClass {
    @BeforeClass
    public void beforeClass() {
        seleniumLib.goToUrl("http://the-internet.herokuapp.com/windows");
    }
    @Test
    public void windowsTest(){
        driver.findElement(By.linkText("Click Here")).click();
        List<String> handles = new ArrayList<String>(driver.getWindowHandles());
        String s = handles.get(1);
        driver.switchTo().window(s);
        String text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(text, "New Window");
        driver.close();
        driver.switchTo().window(handles.get(0));
        text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(text, "Opening a new window");


    }
}


