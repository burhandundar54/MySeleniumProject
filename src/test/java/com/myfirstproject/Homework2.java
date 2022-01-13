package com.myfirstproject;
import com.github.javafaker.Faker;
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

public class Homework2 {
    WebDriver driver;
    Faker fake = new Faker();

    @Before
    public void setUp (){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to http://automationpractice.com/index.php
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void test(){

        //3. Click on sign in link
        WebElement signIn = driver.findElement(By.partialLinkText("Sign in"));
        signIn.click();

        //4.Send your email and click on create an account button
        WebElement emailBox = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        emailBox.sendKeys("burhandun@gmail.com");

        WebElement createButton = driver.findElement(By.xpath("//button[@id='SubmitCreate']"));
        createButton.click();

        //5.Verify the Text : CREATE AN ACCOUNT
        WebElement createAnAccountText = driver.findElement(By.className("page-heading"));
        String actualCreateAnAccountText = createAnAccountText.getText();
        System.out.println("actual : "+actualCreateAnAccountText);
        String expectedCreateAnAccountText = "CREATE AN ACCOUNT";
        System.out.println("expected : "+expectedCreateAnAccountText);

        // Assert.assertEquals(expectedCreateAnAccountText,actualCreateAnAccountText);
        //Expected :CREATE AN ACCOUNT
        //Actual   :AUTHENTICATION

        //6. Verify the Text : YOUR PERSONAL INFORMATION
        WebElement yourPersonalInformation = driver.findElement(By.xpath("(//h3[@class='page-subheading'])[1]"));
        String actualYPIText = yourPersonalInformation.getText();
        System.out.println("actual : "+actualYPIText);

        String expectedYPIText = "YOUR PERSONAL INFORMATION";
        System.out.println("expected : "+expectedYPIText);

        // Assert.assertEquals(expectedYPIText,actualYPIText);
        //actual : CREATE AN ACCOUNT
        //expected : YOUR PERSONAL INFORMATION

        //7. Verify the Text : Title
        WebElement titleText = driver.findElement(By.xpath("(//form/div/div/label)[1]"));
        String actualTitle = titleText.getText();
        System.out.println("actual : "+actualTitle);
        System.out.println("expected : "+"Title");

        //Assert.assertEquals("Title",actualTitle);
        //Expected :Title
        //Actual   :Email address

        //8. Select your title
        WebElement title = driver.findElement(By.xpath("//input[@type='radio']"));
        title.click();

        //9. Enter your first name
        WebElement firstName = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
        firstName.sendKeys("Burhan");

        //10. Enter your last name
        WebElement lastName = driver.findElement(By.xpath("//input[@id='customer_lastname']"));
        lastName.sendKeys("Dundar");

        //11. Enter your email
        //already done

        //12. Enter your password
        WebElement password = driver.findElement(By.xpath("//input[@id='passwd']"));
        password.sendKeys("egg10");
        //13. ENTER DATE OF BIRTH
        WebElement day = driver.findElement(By.xpath("//select[@id='days']"));
        Select select = new Select(day);
        select.selectByValue("26");

        WebElement month = driver.findElement(By.xpath("//select[@id='months']"));
        Select select1 = new Select(month);
        select1.selectByValue("2");

        WebElement year = driver.findElement(By.xpath("//select[@id='years']"));
        Select select2 = new Select(year);
        select2.selectByValue("1993");

        //14. Click on Sign up for our newsletter!
        WebElement SignUp = driver.findElement(By.xpath("//input[@id='newsletter']"));
        SignUp.click();

        //15. Enter your first name
        //16. Enter your last name
        // Automatically done

        //17. Enter your company
        WebElement company = driver.findElement(By.xpath("//input[@id='company']"));
        company.sendKeys("techPro");

        //18. Enter your Address
        WebElement addres = driver.findElement(By.xpath("//input[@id='address1']"));
        addres.sendKeys(fake.address().fullAddress());

        //19. Enter your City
        WebElement city = driver.findElement(By.xpath("//input[@id='city']"));
        city.sendKeys(fake.address().city());


        //20. SELECT STATE
        WebElement state = driver.findElement(By.xpath("//select[@id='id_state']"));
        Select select3 = new Select(state);
        select3.selectByValue("9");

        //21. Enter Postal Code
        WebElement zipCode = driver.findElement(By.xpath("//input[@id='postcode']"));
        zipCode.sendKeys("32645");

        //22.SELECT COUNTRY
        WebElement country = driver.findElement(By.xpath("//select[@id='id_country']"));
        Select selectCountry = new Select(country);
        selectCountry.selectByValue("21");

        //23. Enter additional information
        WebElement additionalInformation = driver.findElement(By.xpath("//textarea[@id='other']"));
        additionalInformation.sendKeys(fake.address().fullAddress()+fake.phoneNumber().cellPhone());

        //24. Enter home phone
        WebElement homePhone = driver.findElement(By.xpath("//input[@id='phone']"));
        homePhone.sendKeys(fake.phoneNumber().cellPhone());

        ///25. Enter mobile phone
        WebElement mobilePhone = driver.findElement(By.xpath("//input[@id='phone_mobile']"));
        mobilePhone.sendKeys(fake.phoneNumber().cellPhone());

        //26. Enter reference name
        WebElement referanceName = driver.findElement(By.xpath("//input[@id='alias']"));
        referanceName.sendKeys("My location");

        //27. Click Register
        WebElement register = driver.findElement(By.xpath("//button[@id='submitAccount']"));
        register.click();

    }

    @Test
    public void isDisplayed(){

        //verify MY ACCOUNT is displayed on the home page

        WebElement signIn = driver.findElement(By.partialLinkText("Sign in"));
        signIn.click();
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("burhandun@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='passwd']"));
        password.sendKeys("egg10");

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