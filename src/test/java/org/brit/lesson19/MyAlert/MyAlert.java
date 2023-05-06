package org.brit.lesson19.MyAlert;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MyAlert {

    WebDriver driver;
    SeleniumLib seleniumLib;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        seleniumLib = new SeleniumLib(driver);

    }

    @AfterClass
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        seleniumLib.goToUrl("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void clickMyJSAlert() {

       seleniumLib.clickOnJSAlertButton();
        String alertText = seleniumLib.workWithAlertAndClose(true);
        String resultText = seleniumLib.getResultString();
//        WebElement result = driver.findElement(By.id("result"));
//        String resultText = result.getText();
        Assert.assertEquals(alertText, "I am a JS Alert");
        Assert.assertEquals(resultText, "You successfully clicked an alert");


    }

    @Test
    public void clickMyJSConfirmOk() {

        seleniumLib.clickOnJSConfirmButton();
        String alertText = seleniumLib.workWithAlertAndClose(true);
        String resultText = seleniumLib.getResultString();
        Assert.assertEquals(alertText, "I am a JS Confirm");
        Assert.assertEquals(resultText, "You clicked: Ok");


    }

    @Test
    public void clickMyJSConfirmCancel() {

       seleniumLib.clickOnJSConfirmButton();
        String alertText = seleniumLib.workWithAlertAndClose(false);
        String resultText = seleniumLib.getResultString();
        Assert.assertEquals(alertText, "I am a JS Confirm");
        Assert.assertEquals(resultText, "You clicked: Cancel");
    }

    @Test
    public void clickMyJSPromptCancel() {
        seleniumLib.clickOnJSPromptButton();

        String alertText = seleniumLib.workWithAlertAndClose(false);
        String resultText = seleniumLib.getResultString();
        Assert.assertEquals(alertText, "I am a JS prompt");
        Assert.assertEquals(resultText, "You entered: null");

    }

    @Test
    public void clickMyJSPromptOk() {
        seleniumLib.clickOnJSPromptButton();
        String alertText = seleniumLib.workWithAlertAndClose(true);

        String resultText = seleniumLib.getResultString();

        Assert.assertEquals(alertText, "I am a JS prompt");
        Assert.assertEquals(resultText, "You entered:");

    }


}
