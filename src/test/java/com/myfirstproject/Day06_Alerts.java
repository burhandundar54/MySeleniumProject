package com.myfirstproject;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day06_Alerts {
    WebDriver driver;

    @Before
    public void setUp (){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to http://automationpractice.com/index.php
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void acceptAlert(){

        WebElement button1=driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
        button1.click();
       String alertText= driver.switchTo().alert().getText();
        Assert.assertEquals("TEXT DOESN'T MATCH","I am a JS Alert",alertText);

        driver.switchTo().alert().accept();

        String actualResult=driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You successfully clicked an alert",actualResult);

    }
    @Test
    public void dismissAlert(){
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();

        String actualAlertText=driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS Confirm",actualAlertText);

        driver.switchTo().alert().dismiss();

        String actualResult=driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You clicked: Cancel",actualResult);
    }
    @Test
    public void sendKeysAlert(){
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();

        String actualText=driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS prompt",actualText);

        driver.switchTo().alert().sendKeys("Hello World");

        driver.switchTo().alert().accept();

        String actualResult=driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You entered: Hello World",actualResult);


    }

}
