package com.myfirstproject;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
public class Day05_JavaFakerTest {
    WebDriver driver;
    Faker faker = new Faker();
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.facebook.com");
    }
    @Test
    public void radioButtonTest() throws InterruptedException {
        driver.findElement(By.linkText("Create New Account")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(faker.name().firstName());
       // firstName.sendKeys(faker.name().firstName());
        Thread.sleep(3000);
        // lastname
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(faker.name().lastName());
        Thread.sleep(3000);
        ////input[@name='reg_email__']
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(faker.phoneNumber().cellPhone());
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(faker.internet().password());
        Thread.sleep(3000);
        // Selecting from dropdown
        WebElement dayDropDown = driver.findElement(By.id("day"));
        Select selectDay = new Select(dayDropDown);
        WebElement monthDropDown = driver.findElement(By.id("month"));
        Select selectMonth = new Select(monthDropDown);
        WebElement yearDropDown = driver.findElement(By.id("year"));
        Select selectYear = new Select(yearDropDown);
        // 10 Jan 2000
        // Select the day
        selectDay.selectByVisibleText("10");
        Thread.sleep(5000);
        // Select the month
        selectMonth.selectByVisibleText("Jan");
        Thread.sleep(5000);
        // Select year
        selectYear.selectByVisibleText("2000");
        Thread.sleep(5000);
        WebElement femaleRadioButton = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        femaleRadioButton.click();
        Thread.sleep(5000);
        WebElement signUpButton = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        signUpButton.click();
    }
//     @After
//    public void tearDown(){
//       driver.quit();
//     }
}
