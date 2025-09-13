    package stepdefinitions;

    import hooks.Hooks;
    import io.cucumber.java.en.Given;
    import io.cucumber.java.en.Then;
    import io.cucumber.java.en.When;
    import org.openqa.selenium.WebDriver;
    import pages.OpenNewAccount;


    public class StepOpenNewAccount {

        public OpenNewAccount openNewAccount;

        WebDriver driver = Hooks.driver;


        @Given("User navigates to Open New Account page")
        public void user_navigates_to_open_new_account_page() throws InterruptedException {
            openNewAccount = new OpenNewAccount(driver);
            Thread.sleep(5000);
            openNewAccount.sidebarOpenNewAccount.click();
        }
        @When("User selects account type {string}")
        public void user_selects_account_type(String string) {
            openNewAccount.SelectAccounttype(string);
        }
        @When("User selects an existing account to deposit a minimum amount at the time of opening")
        public void user_selects_an_existing_account_to_deposit_a_minimum_amount_at_the_time_of_opening() {
            openNewAccount.SelectFromAccount();
        }
        @When("clicks the open new account button")
        public void clicks_the_open_new_account_button() {
            openNewAccount.clickOpenNewAccountBtn();
        }
        @Then("It should be listed in Accounts Overview")
        public void it_should_be_listed_in_accounts_overview() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }


    }
