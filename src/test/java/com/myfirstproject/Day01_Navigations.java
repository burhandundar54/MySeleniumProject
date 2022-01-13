package com.myfirstproject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Day01_Navigations {
    public static void main(String[] args) throws InterruptedException {
        // Set Path           //driver's name        // path
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
        // Creating driver object
        WebDriver driver = new ChromeDriver();
        // Maximize the window
        driver.manage().window().maximize();
        // Open google home page
        driver.get("https://www.google.com");
        // This is a kind of wait
        // In automation waits are used widely.
        Thread.sleep(5000);
        //Navigate to amazon home page https://www.amazon.com/
        //   driver.get("https://wwww.amazon.com");  // The first way
        // navigate.to() is also go to a webpage
        driver.navigate().to("https://www.amazon.com");
        Thread.sleep(5000);
        // Navigate back to google
        driver.navigate().back();
        Thread.sleep(5000);
        // Navigate forward to amazon
        driver.navigate().forward();
        Thread.sleep(5000);
        //Refresh the page
        driver.navigate().refresh();
        Thread.sleep(5000);
        //Close/Quit the browser
        // close only closes the current browser
        //driver.close();
        // quit closes all the browsers
        driver.quit();


         /*
          get and navigate() methods
          What are the differencies between get and navigate()
          1. get is easier and faster
          2. navigate has some other functions like back -forward and refresh but get doesn't
          3. navigate uses both string and URL data type Url but get only uses string Url.
          */
    }
    /*
    Create a new class under : BasicNavigations Create main method
    Set Path
    Create chrome driver
    Maximize the window
    Open google home page https://www.google.com/.
    On the same class, Navigate to amazon home page https://www.amazon.com/ Navigate back to google
    Navigate forward to amazon
     Refresh the page
   Close/Quit the browser
     */
}
