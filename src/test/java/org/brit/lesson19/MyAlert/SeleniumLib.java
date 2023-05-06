package org.brit.lesson19.MyAlert;

import org.brit.Brit.Lesson18_19_20_21.MyButtons;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumLib {

    WebDriver driver;

    public SeleniumLib(WebDriver driver) {
        this.driver = driver;
    }

    protected String getResultString() {
        WebElement result = driver.findElement(By.id("result"));
        return result.getText();
    }
    public void goToUrl(String url) {
        driver.get(url);
    }

    public WebElement clickOnJSAlertButton() {
        return clickOnButtonWithText(MyButtons.ALERT.getTextOnButton());
    }
    public WebElement clickOnJSConfirmButton() {
        return clickOnButtonWithText(MyButtons.CONFIRM.getTextOnButton());
    }
    public WebElement clickOnJSPromptButton() {
        return clickOnButtonWithText(MyButtons.PROMPT.getTextOnButton());
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
