package com.myfirstproject;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day06_NewWindowSel4 {

    @Test
    public void newWindowsTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1.open google in the window 1
        driver.get("https://www.google.com");
        String googleWindowHandle=driver.getWindowHandle();

        //1.open amazon in the window 2
        // creating a new empty window and switching it
        driver.switchTo().newWindow(WindowType.WINDOW); //WindowType.Window
        driver.get("https://www.amazon.com");
        String amazonWindowHandle=driver.getWindowHandle();

        //1.open linkedin in the window 3
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle=driver.getWindowHandle();

   //Switch back to google
        Thread.sleep(5000);
        driver.switchTo().window(googleWindowHandle);
        System.out.println("GOOGLE URL=>"+driver.getCurrentUrl());

        //Switch back to amazon
        Thread.sleep(5000);
        driver.switchTo().window(amazonWindowHandle);
        System.out.println("Amazon URL=>"+driver.getCurrentUrl());

        //Switch back to linkedin
        Thread.sleep(5000);
        driver.switchTo().window(linkedinWindowHandle);
        System.out.println("Linkedin url=>"+driver.getCurrentUrl());



    }
}
