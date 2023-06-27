package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class ForgotPasswordTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);

    }
    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){
        //Click on forgot your password button
        driver.findElement(By.xpath("//p[contains(@class,'forgot-header')]")).click();
        //Very Reset password text display
        String expectedText = "Reset Password";
        String actualTeax = driver.findElement(By.xpath("//h6[contains(@class,'password-title')]")).getText();
        Assert.assertEquals("Dasebord text not displayed",expectedText,actualTeax);
    }
    @After
    public void tearDown(){
        //closeBrowser();
    }
}
