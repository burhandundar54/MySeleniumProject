package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Homework2Burhan extends TestBase {

    @Test
    public void homework2() throws InterruptedException {

        driver.get("https://www.saucedemo.com");
        Thread.sleep(4000);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(3000);

        WebElement product = driver.findElement(By.xpath("//*[.='Products']"));
        Assert.assertTrue(product.isDisplayed());
        Thread.sleep(3000);
        List<WebElement> prices = driver.findElements(By.xpath("//*[@class='inventory_item_price']"));
        List<String> allPrices = new ArrayList<String>();
        for(WebElement w : prices){
            allPrices.add(w.getText());
        }

        List<Double> allDouble = new ArrayList<Double>();
        for(String w : allPrices){
            w = w.substring(1);
            allDouble.add(Double.valueOf(w));
        }
        Collections.sort(allDouble);
        Thread.sleep(3000);

        Assert.assertTrue(allDouble.get(0)>5);
        Assert.assertTrue(allDouble.get(allDouble.size()-1)<50);

    }

}