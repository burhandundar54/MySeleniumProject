package com.myfirstproject;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.*;

public class Homework_2_1 {
        WebDriver driver;

        @Test
        public void dropdownTest() {

            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("http://amazon.com");

//Find the element of the dropdown element. HINT: By.id("searchDropdownBox")
            WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
            dropdown.click();
            //Print the first selected option and assert if it equals "All Departments
            Select selectDrop = new Select(dropdown);
            String firstChoice = selectDrop.getFirstSelectedOption().getText();
            System.out.println("firstChoice = " + firstChoice);
            Assert.assertEquals("All Departments", firstChoice);

            //Select the 4th option by index (index of 3) and assert if the name is "Amazon Devices".(after you
            //select you to need to use the get first selected option method)

            List<WebElement> options = selectDrop.getOptions();
            String actual = options.get(3).getText();
            Assert.assertNotEquals("NOT EQUAL ", "Amazon Devices", actual);
            System.out.println("actual = " + actual);


            //Print all of the dropdown options
            options = selectDrop.getOptions();
            for (WebElement eachOption : options) {
                System.out.println("each one : " + eachOption.getText());

            }

            // Print the total number of options in the dropdown
            int size = selectDrop.getOptions().size();
            System.out.println("size = " + size);

            //Check if Appliances is a drop-down option. Print true if "Appliances" is an option. Print false
            //otherwise.

            for (WebElement eachOption : options) {
                if(eachOption.equals("Appliances")){
                    Assert.assertTrue(true);
                    System.out.println(true);
                    break;
                }else{
                    Assert.assertFalse(false);
                    System.out.println(false);
                    break;
                }

            }
            //BONUS: Check if the dropdown is in Alphabetical Order

        }
    }

