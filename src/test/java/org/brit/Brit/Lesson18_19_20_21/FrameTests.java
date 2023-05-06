package org.brit.lesson18_19_20_21;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FrameTests extends BaseTestClass {
    @BeforeClass
    public void beforeClass(){
        seleniumLib.goToUrl("http://the-internet.herokuapp.com/nested_frames");
    }
    @Test
    public void frameTest() throws InterruptedException {
        String frameName = "frame-middle";
        String frameName1 = "frame-bottom";
        Thread.sleep(2000);
        driver.switchTo()
                .frame("frame-top")
                .switchTo()
                .frame(frameName);
        String content = driver.findElement(By.id("content")).getText();
        Assert.assertEquals(content, "MIDDLE");

        driver.switchTo().defaultContent();
        driver.switchTo().frame(frameName1);
        content = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(content, "BOTTOM");
    }


}


