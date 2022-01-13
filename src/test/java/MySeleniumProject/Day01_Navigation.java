package MySeleniumProject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Day01_Navigation {

    public static void main(String[] args) throws InterruptedException {
        //Set Path
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //open google home page
        driver.get("http://google.com");
        //This is a kind of wait
        //In automation waits are used widely
        Thread.sleep(5000);


        //navigate to amazon homepage
        // driver.get("http://amazon.com"); //the first way

        //navigate.to() is also go to a webpage
        driver.navigate().to("http://amazon.com");
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
}