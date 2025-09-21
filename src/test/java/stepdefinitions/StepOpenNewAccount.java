    package stepdefinitions;

    import hooks.Hooks;
    import io.cucumber.java.en.And;
    import io.cucumber.java.en.Given;
    import io.cucumber.java.en.Then;
    import io.cucumber.java.en.When;
    import org.openqa.selenium.WebDriver;
    import pages.AccountOverview;
    import pages.LoginPage;
    import pages.OpenNewAccount;


    public class StepOpenNewAccount {

        public OpenNewAccount openNewAccount;
        public AccountOverview accountOverview;

        WebDriver driver = Hooks.driver;

        String accountId;

        @Given("User navigates to Open New Account page")
        public void user_navigates_to_open_new_account_page() throws InterruptedException {

            driver.get("https://parabank.parasoft.com/parabank/index.htm");


            LoginPage loginPage = new LoginPage(driver);
            loginPage.setcredentials("user", "Password123");
            loginPage.loginbtnclick();
            System.out.println("Login clicked");
            openNewAccount = new OpenNewAccount(driver);
            openNewAccount.sidebarOpenNewAccount.click();
        }
        @When("User selects account type {string}")
        public void user_selects_account_type(String string) {
            openNewAccount.SelectAccounttype(string);
        }
        @When("User selects an existing account to deposit a minimum amount at the time of opening")
        public void user_selects_an_existing_account_to_deposit_a_minimum_amount_at_the_time_of_opening() throws InterruptedException {
            openNewAccount.SelectFromAccount();
        }
        @When("clicks the open new account button")
        public void clicks_the_open_new_account_button() throws InterruptedException {
            openNewAccount.clickOpenNewAccountBtn();

        }

        @Then("Account should be created successfully with new account number")
        public void accountShouldBeCreatedSuccessfullyWithNewAccountNumber() {

            accountId = openNewAccount.getAccountNumber();
            System.out.println("captured account id is "+ accountId);

        }

        @And("it should be reflected in account overview section")
        public void itShouldBeReflectedInAccountOverviewSection() {
            accountOverview =new AccountOverview(driver);
            String expectedID=accountOverview.clickAccountOverview();

            accountOverview.checkIdInTable(expectedID);

        }
    }
