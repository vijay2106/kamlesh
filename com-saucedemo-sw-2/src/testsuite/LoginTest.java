package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginWithValidCredentials() {
        //Enter valid username
        driver.findElement(By.xpath("//input[@name='user-name']")).sendKeys("standard_user");
        //Enter valid password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("secret_sauce");
        // Click on login button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        // Verify Products text display
        String expectedText = "Products";
        String actualText = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals("Product text not displayed",expectedText,actualText);

    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Enter valid username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        //Enter valid password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("secret_sauce");
        //Click on login button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        //Verify 6 Products are displayed on page
        List<WebElement>productList = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        System.out.println("Total product are : " + productList.size());
        //Verify the number of product are 6
        int expectedSize = 6;
        int actualSize = productList.size();
        Assert.assertEquals("Products size is not match",expectedSize,actualSize);
    }
    @After
    public void tearDown(){
        //closeBrowser();
    }
}