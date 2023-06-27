package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void openBrowser(String baseUrl) {
        // Launch the browser
        driver = new ChromeDriver();
        // Open the URL into browser
        driver.get(baseUrl);
        //Maximise the  browser
        driver.manage().window().maximize();
        // Give implicit wait to browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser() {
        // Close the browser
        driver.close();

}
}
