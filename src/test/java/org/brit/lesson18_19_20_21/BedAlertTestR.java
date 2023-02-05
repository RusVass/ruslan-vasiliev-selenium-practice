package org.brit.lesson18_19_20_21;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BedAlertTestR {
    @Test
    public void  clickJSAlert(){
//  відкриває Chrome + на весь екран + по ссилці
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//  знаходить кнопку з текстом  "Click for JS Alert"
        WebElement jsButton =  driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
//  клік на кнопку
        jsButton.click();
//  переключеє на Аlert Popup, повертає обєкт типу Alert
        Alert alert = driver.switchTo().alert();
//  вичитує з Alert  текст
        String alertText = alert.getText();
//  приймає
        alert.accept();
//  знаходить id "result"
        WebElement result = driver.findElement(By.id("result"));
//  вичитує  з result текст
        String resultText = result.getText();
//  верифікує  alertText та resultText
        Assert.assertEquals(alertText, "I am a JS Alert");
        Assert.assertEquals(resultText,"You successfully clicked an alert");
//  закриває додаток
        driver.quit();
    }



}
