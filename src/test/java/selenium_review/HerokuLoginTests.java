package selenium_review;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HerokuLoginTests {
    String loginUrl = "https://the-internet.herokuapp.com/login";
    WebDriver driver;
    /*
    Use @BeforeMethod tag and add code to open chrome browser, set implicit wait, and navigate to url
     */
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void validCredentialsLoginTest() {
        driver.get(loginUrl);
        System.out.println("Title = " + driver.getTitle());
        //verify correct page by checking the title "The Internet"

    }
}
