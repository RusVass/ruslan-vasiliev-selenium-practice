package org.brit.Brit.Lesson20.Login;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class MyBaseTestClass {
    protected WebDriver driver;
    protected SeleniumLib seleniumLib;

    @BeforeSuite
    public void beforeSuite() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        seleniumLib = new SeleniumLib(driver);
    }

    @AfterSuite
    public void afterSuite() {
        if (driver != null) {
            driver.quit();
        }
    }

}
