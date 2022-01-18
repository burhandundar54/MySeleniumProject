package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Day08_AuthenticationTest extends TestBase {

    @Test
    public void basicAuth() throws InterruptedException {

     driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
  Thread.sleep(10000);
  String congratsMessage=driver.findElement(By.xpath("//p")).getText();
  Thread.sleep(10000);
        Assert.assertTrue(congratsMessage.contains("Conguratulations!"));


    }
}
