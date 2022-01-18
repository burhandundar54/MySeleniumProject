package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day08_FileUploadTest extends TestBase {

    @Test
    public void fileUploadTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/upload");

Thread.sleep(10000);
        String pathOfImage= System.getProperty("user.home")+"/Desktop/download.png";
        Thread.sleep(3000);
        WebElement chooseFileButton=driver.findElement(By.id("file-upload"));
        chooseFileButton.sendKeys(pathOfImage);

        WebElement submitButton=driver.findElement(By.id("file-submit"));
        submitButton.click();

Thread.sleep(3000);

String actualSuccessMessage=driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("File Uploaded",actualSuccessMessage);







    }
}
