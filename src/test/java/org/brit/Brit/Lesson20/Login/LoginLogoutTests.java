package org.brit.Brit.Lesson20.Login;

import org.brit.Brit.Lesson18_19_20_21.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class LoginLogoutTests extends BaseTestClass {


    private String userName = "tomsmith";
    private String pass = "SuperSecretPassword!";



    LoginLib loginLib;
    @BeforeClass
    public void beforeThisClass() {
        seleniumLib.goToUrl("http://the-internet.herokuapp.com/login");
        loginLib = new LoginLib(driver);
    }

    @Test
    public void loginSuccess() {
        loginLib.login(userName, pass);

        Assert.assertTrue(loginLib.isSuccessMessageVisible());

        loginLib.clickLogoutButton();

        Assert.assertEquals(loginLib.getPageTitle(), "Login Page");
    }


    @Test(dataProvider = "getData")
    public void loginUnsuccess(String name, String password, String text) {
        loginLib.login(name, password);
        Assert.assertTrue(loginLib.isUnSuccessMessageVisible());
        Assert.assertTrue(loginLib.getMessageText().contains(text));
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {userName + "1", pass, "Your username is invalid!"},
                {userName, pass + "1", "Your password is invalid!"},
                {"", pass, "Your username is invalid!"},
                {"", "", "Your username is invalid!"},
                {userName, "", "Your password is invalid!"}
        };
    }

/*
    public class LoginLogoutTests extends BaseTestClass {
        private String userName = "tomsmith";
        private String pass = "SuperSecretPassword!";

       LoginLib loginLib;


        @BeforeClass
        public void beforeThisClass() {
            seleniumLib.goToUrl("http://the-internet.herokuapp.com/login");
            loginLib = new LoginLib(driver);
        }


    @Test
    public void loginSuccess(WebElement element) {

        loginLib.login(userName, pass);
//        loginLib.enterName(userName);
//        loginLib.enterPassword(pass);
//        loginLib.clickLoginButton();

        Assert.assertTrue(loginLib.isSuccessMessageVisible());

        loginLib.clickLogoutButton();

        Assert.assertEquals(loginLib.getPageTitle(), "Login Page");
    }



/*  // поганий тест
    @Test
    public void loginSuccess(WebElement element) {
    driver.findElement(By.id("username")).sendKeys(userName);
    driver.findElement(By.xpath("//input[@name= 'password']")).sendKeys(pass);
    driver.findElement(By.cssSelector("button.radius[type='submit']")).click();

    driver.findElement(By.cssSelector("#flesh.success"));
    Assert.assertTrue(element.isDisplayed());

    driver.findElement(By.xpath("//a[contains(@class,'button')]")).click();

    element = driver.findElement(By.cssSelector(".example > h2"));
    Assert.assertEquals(element.getText(),"Login Page");
*/

}
