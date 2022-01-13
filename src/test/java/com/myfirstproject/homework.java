package com.myfirstproject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class homework {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void signIn() {
        WebElement signInButton = driver.findElement(By.xpath("//a[@class='login']"));
        signInButton.click();

        WebElement email =  driver.findElement(By.xpath("//input[@id='email_create']"));
        email.sendKeys("burhandundar@gmail.com");
        WebElement createAccount = driver.findElement(By.xpath("//i[@class='icon-user left']"));
        createAccount.click();
        driver.findElement(By.xpath("//*[@id=\"noSlide\"]/h1")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/h3")).isDisplayed();
        WebElement femaleRadioButton = driver.findElement(By.xpath("//*[@id=\"id_gender1\"]"));
        femaleRadioButton.click();
        driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]")).sendKeys("Burhan");
        driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]")).sendKeys("Dundar");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Burhan1234");
        Select selectDay = new Select(driver.findElement(By.id("days")));
        Select selectMonth = new Select(driver.findElement(By.id("months")));
        Select selectYear = new Select(driver.findElement(By.id("years")));
        selectDay.selectByValue("2");
        selectMonth.selectByValue("1");
        selectYear.selectByValue("1980");
        driver.findElement(By.xpath("//div[@id='uniform-optin']")).click();

        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Techproed");

        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Techproed, Oneway Street No: 25, 12356");

        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Virginia");

        Select selectState = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));

        selectState.selectByVisibleText("Virginia");

        driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("12356");

        driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys("I want to be a member.");

        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("+1 8995 8775");

        driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("+1 9945 8875");

        driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("My address");

        driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
    }
    @Test
    public void isDisplayed(){

        //verify MY ACCOUNT is displayed on the home page

        WebElement signIn = driver.findElement(By.partialLinkText("Sign in"));
        signIn.click();
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("burhandun@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='passwd']"));
        password.sendKeys("Burhan1234");

        WebElement signInButton = driver.findElement(By.xpath("//button[@id='SubmitLogin']"));
        signInButton.click();

        WebElement myAccount = driver.findElement(By.xpath("//h1[@class='page-heading']"));

        Boolean isMyAccountDisplayed = myAccount.isDisplayed();
        System.out.println(isMyAccountDisplayed);
        Assert.assertTrue(isMyAccountDisplayed);

    }
    @After
    public void tearDown(){
        driver.quit();
    }
}

