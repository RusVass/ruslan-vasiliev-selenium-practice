package org.brit.Brit.Lesson20.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginLib {


    private WebDriver driver;

    public LoginLib(WebDriver driver) {
        this.driver = driver;

    }

    // код без пояснень
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

    /*

    // перший єтап теста робимо ПРОСТІ методи для name and password
//    public void  enterName (String name) {
//        driver.findElement(By.id("username")).sendKeys(name);
//    }
//    public void enterPassWord (String pass){
//        driver.findElement(By.id("password'")).sendKeys(pass);
//
//    }



// другий етап робимо методи на name and password  ще простіше
    public void  enterName (String name) {
       enterTextToElement("username",name);
    }
    public void enterPassword (String pass){
        enterTextToElement("password",pass);

    }
    private void  enterTextToElement(String elementName, String value){
        driver.findElement(By.id(elementName)).sendKeys(value);

    }
    // третій етап робимо методи на name and password  and click ще простіше
    public void login(String name, String pass){
        enterName(name);
        enterPassword(pass);
        clickLoginButton();
    }


    // наступний єтап робимо метод для пошуку елемента та клікаєм
    //  driver.findElement(By.cssSelector("button.radius[type='submit']")).click();


// загальний метод на пошук та клик
    private void clickOnButton (By by) {
        driver.findElement(by).click();
    }
    // конкретний метод на пошук та клік Login

    public void clickLoginButton(){
        clickOnButton(By.cssSelector("button.radius[type='submit']"));
    }
    // конкретний метод на клік Logout

    public void clickLogoutButton() {
        clickOnButton(By.cssSelector("//a[contains(@class,'button')]"));
    }
    // метод для пошуку PageTitle
    //     element = driver.findElement(By.cssSelector(".example > h2"));
    //        Assert.assertEquals(element.getText(), "Login Page");

    public String getPageTitle(){
        return driver.findElement(By.cssSelector(".example > h2")).getText();

    }
    // метод для пошуку isSuccessMessageVisible
    //   driver.findElement(By.cssSelector("#flesh.success"));
    //        Assert.assertTrue(element.isDisplayed());

    public boolean isSuccessMessageVisible(){
        return driver.findElement(By.cssSelector("#flesh.success")).isDisplayed();
    }





/*


*/
}

