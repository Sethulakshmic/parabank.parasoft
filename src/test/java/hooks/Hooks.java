package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import java.time.Duration;

public class Hooks {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://parabank.parasoft.com/parabank/index.htm");


        LoginPage loginPage = new LoginPage(driver);
        loginPage.setcredentials("user", "asd");
        System.out.println("before clicking");
        loginPage.loginbtnclick();
        System.out.println("button clicked");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

