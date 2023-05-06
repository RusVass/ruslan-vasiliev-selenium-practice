package org.brit.lesson18.MyAlert;





import org.junit.AfterClass;
import org.junit.Assert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MyAlert  {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
       driver = new ChromeDriver();
       driver.manage().window().maximize();

    }

    @AfterClass
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeMethod
    public void beforeMethod(){
       driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public   void clickMyJSAlert() {

        clickOnButtonWithText("Click for JS Alert");
        String alertText = workWithAlertAndClose(true);
        String resultText = getResultString ();
//        WebElement result = driver.findElement(By.id("result"));
//        String resultText = result.getText();
        Assert.assertEquals(alertText,"I am a JS Alert");
        Assert.assertEquals(resultText, "You successfully clicked an alert");


    }
    @Test
    public   void clickMyJSConfirmOk() {

        clickOnButtonWithText("Click for JS Confirm");
        String alertText = workWithAlertAndClose(true);
        String resultText = getResultString ();
        Assert.assertEquals(alertText,"I am a JS Confirm");
        Assert.assertEquals(resultText, "You clicked: Ok");


    }
    @Test
    public   void clickMyJSConfirmCancel() {

        clickOnButtonWithText("Click for JS Confirm");
        String alertText = workWithAlertAndClose(false);
        String resultText = getResultString ();
        Assert.assertEquals(alertText,"I am a JS Confirm");
        Assert.assertEquals(resultText, "You clicked: Cancel");
    }

    @Test
    public   void clickMyJSPromptCancel(){
        clickOnButtonWithText("Click for JS Prompt");

        String alertText = workWithAlertAndClose(false);
        String resultText = getResultString ();
        Assert.assertEquals(alertText,"I am a JS prompt");
        Assert.assertEquals(resultText, "You entered: null");

    }
    @Test
    public   void clickMyJSPromptOk(){
        clickOnButtonWithText("Click for JS Prompt");
        String alertText = workWithAlertAndClose(true);

        String resultText = getResultString ();

        Assert.assertEquals(alertText,"I am a JS prompt");
        Assert.assertEquals(resultText, "You entered:");

    }
    private String getResultString(){
        WebElement result = driver.findElement(By.id("result"));
        return result.getText();
    }

    private WebElement clickOnButtonWithText(String textOnButton) {
        WebElement button = driver
                .findElement(By.xpath("//button[text()='%s']".formatted(textOnButton)));
        button.click();
        return button;
    }

//    public String  workWithAlertAndClose (){
//        Alert alert = driver.switchTo().alert();
//        String alertText = alert.getText();
//        alert.accept();
//        return alertText;
//    }

    public String workWithAlertAndClose(boolean accept, String... text) {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();

        if (text.length > 0) {
            alert.sendKeys(text[0]);
        }

        if (accept) {
            alert.accept();
        } else {
            alert.dismiss();
        }
        return alertText;
    }

}
