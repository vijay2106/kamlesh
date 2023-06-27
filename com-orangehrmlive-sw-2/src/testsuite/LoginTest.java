package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginWithValidCredentials() {
        //Enter valid username
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        //Enter valid password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        //Click on login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Verify DashBoard text display
        String expectedText = "Dashboard";
        String actualText = driver.findElement(By.tagName("h6")).getText();
        Assert.assertEquals("Dashboard text not displayed", expectedText, actualText);

    }

    @After
    public void tearDown() {
      //  closeBrowser();
    }
}

