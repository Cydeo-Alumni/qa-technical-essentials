package selenium_review;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }

    @Test(priority = 1)
    public void validCredentialsLoginTest() {
        driver.get(loginUrl);
        System.out.println("Title = " + driver.getTitle());
        //verify correct page by checking the title "The Internet"
        Assert.assertEquals(driver.getTitle(), "The Internet");
        //locate username field and enter "tomsmith"
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        //locate password field and enter "SuperSecretPassword!"
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        //click on login button
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();

        // Verify "You logged into a secure area!" banner is visible
        WebElement loggedInBanner = driver.findElement(By.xpath("//div[@id='flash']"));
        Assert.assertTrue(loggedInBanner.isDisplayed());

        //click on logout button:
        WebElement logoutBtn = driver.findElement(By.xpath("//a[.=' Logout']"));
        logoutBtn.click();
    }

    /*
    Enter omsmith  | SuperSecretPasswo
    and verify "Your password is invalid!" is displayed
     */
    @Test(priority = 2)
    public void invalidUsernameTest() {
        driver.get(loginUrl);
        System.out.println("Title = " + driver.getTitle());
        //verify correct page by checking the title "The Internet"
        Assert.assertEquals(driver.getTitle(), "The Internet");
        //locate username field and enter "tomsmith"
        driver.findElement(By.id("username")).sendKeys("omsmith");

        //locate password field and enter "SuperSecretPassword!"
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPasswo");

        //click on login button
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();

        WebElement invalidUsernameElem = driver.findElement(By.id("flash"));
        System.out.println(invalidUsernameElem.getText());
        Assert.assertTrue(invalidUsernameElem.isDisplayed());
        Assert.assertTrue(invalidUsernameElem.getText().contains("Your username is invalid!"));
    }

    //| tomsmith  | SupersecretPassword!   | Your password is invalid!
    @Test(priority = 3)
    public void invalidPasswordTest() {
        driver.get(loginUrl);
        System.out.println("Title = " + driver.getTitle());
        //verify correct page by checking the title "The Internet"
        Assert.assertEquals(driver.getTitle(), "The Internet");
        //locate username field and enter "tomsmith"
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        //locate password field and enter "SuperSecretPassword!"
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SupersecretPassword!");

        //click on login button
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();

        WebElement invalidPasswordElem = driver.findElement(By.xpath("//div[@class='flash error']"));
        System.out.println(invalidPasswordElem.getText());
        Assert.assertTrue(invalidPasswordElem.isDisplayed());
        Assert.assertTrue(invalidPasswordElem.getText().contains("Your password is invalid!"));
    }
}
