package org.brit.Brit.Lesson18_19_20_21;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitersTest extends BaseTestClass {
    @BeforeClass
    public void beforeClass(){
        seleniumLib.goToUrl("http://the-internet.herokuapp.com/dynamic_loading/1");
    }

    @Test
    public void waiterTest(){
        driver.findElement(By.id("start"))
                .findElement(By.xpath(".//button"))
                .click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loading")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));

        String text = driver.findElement(By.cssSelector("#finish>h4")).getText();
        Assert.assertEquals(text, "Hello World!");
    }
}

