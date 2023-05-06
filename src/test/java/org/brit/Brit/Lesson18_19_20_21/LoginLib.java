package org.brit.lesson18_19_20_21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginLib {
    private WebDriver driver;

    public LoginLib(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        enterTextToElement("username", name);
    }

    public void enterPassword(String pass) {
        enterTextToElement("password", pass);
    }

    public void login(String name, String pass){
        enterName(name);
        enterPassword(pass);
        clickLoginButton();
    }


    public void clickLoginButton(){
        clickOnButton(By.cssSelector("button.radius[type='submit']"));
    }

    public void clickLogoutButton(){
        clickOnButton(By.xpath("//a[contains(@class, 'button')]"));
    }

    private void clickOnButton(By by){
        driver.findElement(by).click();
    }

    private void enterTextToElement(String elementName, String value) {
        driver.findElement(By.id(elementName)).sendKeys(value);
    }

    public String getPageTitle(){
        return driver.findElement(By.cssSelector(".example > h2")).getText();
    }

    public boolean isSuccessMessageVisible(){
        return driver.findElement(By.cssSelector("#flash.success")).isDisplayed();
    }

    public boolean isUnSuccessMessageVisible(){
        return driver.findElement(By.cssSelector("#flash.error")).isDisplayed();
    }

    public String getMessageText(){
        return driver.findElement(By.cssSelector("#flash")).getText();
    }

}

