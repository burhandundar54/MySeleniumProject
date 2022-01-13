package MySeleniumProject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Day02_VerifyTitle {
    /*
    2.Navigate to google homepage
    3.Verify if the title is “Google”
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }
        driver.close();
        //Verification - Validation - Assertion
        /*
        After Verification your test failed
        Expected and Actual aren't same
        Creating a bug ticket
        Bug tracking tools -- Jira
        Developer will fix the bug by debugging
         */
    }
}