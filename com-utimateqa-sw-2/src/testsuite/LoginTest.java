package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //Click on sign in link
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        Assert.assertEquals("Welcome back text not displayed",expectedText,actualText);
    }
    @Test
    public void verifyTheErrorMessage(){
        //Click on sign in link
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();
        //Enter invalid username
        driver.findElement(By.xpath("//input[@id='user[email]']")).sendKeys("hbjk@gmail");
        //Enter invalid password
        driver.findElement(By.xpath("//input[@id='user[password]']")).sendKeys("210506");
        // Verify the error message
        String expectedResult = "Please enter a valid email address";
        String actualResult = driver.findElement(By.xpath("//p[@id='user[email]-error']")).getText();
        Assert.assertEquals("Error not displayed",expectedResult,actualResult);
    }
    @After
    public void tearDown(){
        //closeBrowser();
    }
}
