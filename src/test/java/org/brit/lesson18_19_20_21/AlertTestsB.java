package org.brit.lesson18_19_20_21;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTestsB extends BaseTestClass {

    @BeforeMethod
    public void beforeMethod() {
        seleniumLib.goToUrl("http://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void clickJSAlert() {
        seleniumLib.clickOnJSAlertButton();
        String alertText = seleniumLib.workWithAlertAndClose(true);
        String resultText = seleniumLib.getResultString();

        Assert.assertEquals(alertText, "I am a JS Alert");
        Assert.assertEquals(resultText, "You successfully clicked an alert");
    }
    @Test
    public void clickJSConfirmOk() {
        seleniumLib.clickOnJSConfirmButton();
        String alertText = seleniumLib.workWithAlertAndClose(true);
        String resultText = seleniumLib.getResultString();
        Assert.assertEquals(resultText, "You clicked: Ok");
    }

    @Test
    public void clickJSConfirmCancel() {
        seleniumLib.clickOnJSConfirmButton();
        String alertText = seleniumLib.workWithAlertAndClose(false);
        String resultText = seleniumLib.getResultString();
        Assert.assertEquals(resultText, "You clicked: Cancel");
    }

    @Test
    public void clickJSAlertWithJS() {
        seleniumLib.clickOnJSAlertButtonJS();
        String alertText = seleniumLib.workWithAlertAndClose(true);
        String resultText = seleniumLib.getResultString();

        Assert.assertEquals(alertText, "I am a JS Alert");
        Assert.assertEquals(resultText, "You successfully clicked an alert");
    }

    @Test
    public void clickJSAlertWithJS1() {
        seleniumLib.clickOnJSAlertButtonJS1();
        Assert.assertEquals(seleniumLib.workWithAlertAndClose(true), "I am a JS Alert");
        Assert.assertEquals(seleniumLib.getResultStringJS(), "You successfully clicked an alert");
    }



}
