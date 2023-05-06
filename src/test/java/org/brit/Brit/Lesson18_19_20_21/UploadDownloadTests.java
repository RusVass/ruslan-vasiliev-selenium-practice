package org.brit.Brit.Lesson18_19_20_21;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class UploadDownloadTests extends BaseTestClass {

    File fileToUpload = MyFileUtils.generateTestFile();
   // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    @Test
    public void uploadTest(){
        seleniumLib.goToUrl("http://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys(fileToUpload.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();
        By uploadFilePanel = By.id("uploaded-files");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.visibilityOfElementLocated(uploadFilePanel));
        Assert.assertEquals(driver.findElement(uploadFilePanel).getText().trim(), fileToUpload.getName());
        seleniumLib.goToUrl("http://the-internet.herokuapp.com/download");

        Assert.assertTrue(driver.findElement(By.linkText(fileToUpload.getName())).isDisplayed());


    }




}
