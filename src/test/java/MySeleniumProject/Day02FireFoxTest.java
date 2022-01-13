package MySeleniumProject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Day02FireFoxTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        //System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com/");
        WebDriver driver1=new ChromeDriver();
        driver1.get("https://www.google.com");
        driver1.quit();




    }
}