package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day08_FileDownloadTest extends TestBase {

    @Test
    public void downloadTest() throws  InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/a[6]")).click();

        Thread.sleep(20000);

        String filepath=System.getProperty("user.home")+"/Downloads/sample.png";

        boolean isDownloaded=Files.exists(Paths.get(filepath));
        Assert.assertTrue(isDownloaded);

    }
}
