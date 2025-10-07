package selenium_review;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SearchForProductTest {
    @Test
    public void searchForTShirt() {
        //Men Tshirt
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertEquals(driver.getTitle(), "Automation Exercise");

        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertEquals(driver.getTitle(), "Automation Exercise - All Products");

        //6. Enter product name in search input and click search button
        driver.findElement(By.id("search_product")).sendKeys("Men Tshirt");
        driver.findElement(By.id("submit_search")).click();

        //7. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Searched Products']")).isDisplayed());

        //8. Verify all the products related to search are visible
        List<WebElement> allProducts = driver.findElements(By.xpath("//div[@class='productinfo text-center']"));
        Assert.assertTrue(allProducts.size() > 0);

        driver.quit();
    }
}
