package com.myfirstproject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day06_IFrameTest {
    WebDriver driver;

    @Before
    public void setUp (){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to http://automationpractice.com/index.php
        driver.get("http://the-internet.herokuapp.com/iframe");
    }
    @Test
    public void iframeTest(){

        String boldedText= driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(boldedText.contains("Editor"));



        //We must switch to the iframe to locate the elements inside the iframe
        //there are 3 ways to switch to iframe
        //1. index. index start from 0
     //   driver.switchTo().frame(0);//
//     2.ID or name
  //      driver.switchTo().frame("mce_0ifr");

        //3.WebElement
        WebElement iframeElement=driver.findElement(By.xpath("//*[@id=\"mce_0_ifr\"]"));
        driver.switchTo().frame(iframeElement);

        WebElement textBox= driver.findElement(By.xpath("//p"));
        textBox.clear();

        textBox.sendKeys("This text box is inside the iframe");

        driver.switchTo().parentFrame();
        WebElement elementalSelenium= driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementalSelenium.isDisplayed());





    }
}
