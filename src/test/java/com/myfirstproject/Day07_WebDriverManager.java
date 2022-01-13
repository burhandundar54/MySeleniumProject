package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Day07_WebDriverManager {
    WebDriver driver;

    @Before
    public void setUp() {
   //     System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        //Below will run headless
       // driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test
    public void test(){
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
    }
}
