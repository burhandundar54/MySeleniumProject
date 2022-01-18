package com.myfirstproject;
import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
public class Day08_JavaScriptExecutor extends TestBase {
    /*
What is javascript executor
It is an interface. A selenium api that is used to handle some actions.
Click and scrolling actions can be handled with is easier.
It is more powerful than selenium clicks.
It can communicate with web pages better.
I use it for the elements that can't be clicked with Selenium methods.
I use it to handle scrolling issues like scroll until an element and scroll to the bottom.
I careate an object to use it from JavaScriptExecutor class

 */
    @Test
    public void scrollIntoView() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://www.carettahotel.com/");
        Thread.sleep(3000);
        WebElement textToSee = driver.findElement(By.xpath("//*[.='Our Rooms']"));
        js.executeScript("arguments[0].scrollIntoView(true);",textToSee);
        Thread.sleep(5000);
    }
    @Test
    public void clickWithJS() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Bad email or password.
        driver.get("https://a.testaddressbook.com/sign_in");
        WebElement advancedButton = driver.findElement(By.id("details-button"));
        advancedButton.click();
        WebElement proceedLink = driver.findElement(By.id("proceed-link"));
        proceedLink.click();
        Thread.sleep(3000);
        WebElement signInButton = driver.findElement(By.xpath("//input[@type='submit']"));
        js.executeScript("arguments[0].click();",signInButton); // Click Method
        Thread.sleep(5000);
        Assert.assertTrue(driver.getPageSource().contains("Bad email or password."));
    }
    @Test
    public void scrollDownWithJS() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://www.carettahotel.com/");
        Thread.sleep(3000);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(3000);
    }
}
