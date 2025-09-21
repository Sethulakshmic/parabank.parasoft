package pages;

import context.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OpenNewAccount {

    public WebDriver driver;
    public WebDriverWait wait;
    public TestContext context;

    @FindBy(xpath = "//a[@href='openaccount.htm']")
    public WebElement sidebarOpenNewAccount;

    @FindBy(id = "type")
    WebElement accountType;

    @FindBy(id="fromAccountId")
    WebElement FromAccount;

    @FindBy(xpath="//input[@value='Open New Account']")
    WebElement OpenNewAccountBtn;

    @FindBy(id = "newAccountId")
    WebElement AccountId;


    public OpenNewAccount(WebDriver driver) {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void SelectAccounttype(String savings){
        Select acnt = new Select(accountType);
        acnt.selectByVisibleText(savings);

    }

    public void SelectFromAccount() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(FromAccount));

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//select[@id='fromAccountId']/option")));
        Select From = new Select(FromAccount);
        From.selectByIndex(0);
    }
    public void clickOpenNewAccountBtn(){
        OpenNewAccountBtn.click();
        System.out.println("account created");
    }
    public String getAccountNumber(){
        wait.until(ExpectedConditions.visibilityOf(AccountId));

        String accountid= AccountId.getText();
        TestContext.set("accountId", accountid);
        return accountid;
    }


}
