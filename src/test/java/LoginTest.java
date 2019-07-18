import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
        WebElement buttonAuthorization = driver.findElement(By
                .xpath("//*[contains(text(),'Вход')]"));
        buttonAuthorization.click();
        WebElement login = driver.findElement(By.name("username"));
        login.sendKeys("Ксения00788");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("zadanie");
        WebElement buttonLogin =driver.findElement(By.className("mainoption"));
        buttonLogin.click();
        Boolean isPresent = driver.findElements(By
               .xpath("//*[contains(text(),'Выход [ Ксения00788 ]')]")).size()>0;
        if (isPresent == true){
            System.out.println("Вход на сайт был успешным");
        }else {
            System.out.println("Вход на сайт не был успешным");
        }
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
