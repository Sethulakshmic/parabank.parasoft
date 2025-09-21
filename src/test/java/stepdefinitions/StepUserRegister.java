package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import hooks.Hooks;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Registraton;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class StepUserRegister {

    WebDriver driver = Hooks.driver;
    public Registraton reg;
    WebDriverWait wait;

    @Given("User navigates to the registration page")
    public void user_navigates_to_registration_page() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
    }

    @When("User enters registration details:")
    public void user_enters_registration_details(DataTable dataTable) {
        reg = new Registraton(driver);
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : data) {
            reg.FirstName.sendKeys(row.get("FirstName"));
            reg.Lastname.sendKeys(row.get("LastName"));
            reg.Address.sendKeys(row.get("Address"));
            reg.City.sendKeys(row.get("City"));
            reg.State.sendKeys(row.get("State"));
            reg.ZipCode.sendKeys(row.get("ZipCode"));
            reg.PhoneNum.sendKeys(row.get("Phone"));
            reg.SSN.sendKeys(row.get("SSN"));
            reg.Username.sendKeys(row.get("Username"));
            reg.Password.sendKeys(row.get("Password"));
            reg.ConfirmPass.sendKeys(row.get("ConfirmPassword"));
        }
    }

    @When("User clicks the {string} button")
    public void user_clicks_button(String buttonName) {
        reg.ClickRegisterButton(buttonName);
    }

    @Then("User should see a registration success message")
    public void user_should_see_success_message() {
        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//p[text()='Your account was created successfully. You are now logged in.']")
                )
        );
        assertTrue(message.isDisplayed());
        System.out.println("Registration success message displayed: " + message.getText());
    }
}
