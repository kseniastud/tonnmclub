import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    @BeforeTest
    public void createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void enterToTheSiteAndAssertion(){
        driver.get("http://nnmclub.to");

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
