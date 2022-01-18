package com.myfirstproject;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day04_RadioButton {
    WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void radioButton () {
        driver.get("https://www.facebook.com");
        //allowing cookies
        WebElement cookiesAcceptButton=driver.findElement(By.xpath("//button[contains(text(),'AllowAllCookies')]"));
        cookiesAcceptButton.click();
        driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
        //clicking on the create new account link
        driver.findElement(By.xpath("(//div[@class='_6ltg'])[2]")).click();
        //first name
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("MYNAME");
        //last name
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("LASTNAME");
        //phone
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("1111111");
        //password
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("secretpass1!");
        //gender
        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
        //NOTE: some ids might be DYNAMIC if id has NUMBER
        // It means id values can change after the next usage
        // For this reason, we need to avoid using dynamic ids
        // Interview Question: How do you handle dynamic ID?
        // --> Dynamic id means id value can change. In this case, I don't prefer to use it
        // If I have to use it I WRITE DYNAMIC XPATH!
        // I find what is the same every single time then write dynamic xpath
        // I can use contains, start-with or ends-with dynamic xpath

        //tag[contains(@attribute,’value’)]     => (//input[contains(@id,'u_')])[1]
        //tag[starts-with(@attribute,’value’)]   => (//input[starts-with(@id,’u_')])[1]  Returns the first input whose id starts with u_
        //tag[ends-with(@attribute,’value’)]    => //input[ends-with(@id,’P7’)] Returns the input elements who ends with P7
    }
}