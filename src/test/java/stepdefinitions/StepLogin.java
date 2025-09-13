package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;

public class StepLogin {
    public WebDriver driver;
    public WebDriverWait wait;
    public LoginPage loginpage;

    @Given("User on the login page")
    public void user_on_the_login_page() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        loginpage = new LoginPage(driver);
    }
    @When("User enter username {string} and password {string}")
    public void user_enter_username_and_password(String username, String password) {
        loginpage.setcredentials(username, password);


    }
    @When("click the {string} button")
    public void click_the_button(String string) {
        loginpage.loginbtnclick();
    }
    @Then("user should redirected to homepage")
    public void user_should_redirected_to_homepage() throws InterruptedException {
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl != null;
        if (!currentUrl.contains("overview.htm")) {
            throw new AssertionError("Login failed! Current URL: " + currentUrl);
        }
        Thread.sleep(5000);
        driver.quit();

    }

}
