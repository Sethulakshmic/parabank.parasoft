package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OpenNewAccount {

    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(xpath = "//a[@href='openaccount.htm']")
    public WebElement sidebarOpenNewAccount;

    @FindBy(id = "type")
    WebElement accountType;

    @FindBy(id="fromAccountId")
    WebElement FromAccount;

    @FindBy(xpath="//input[@value='Open New Account']")
    WebElement OpenNewAccountBtn;

    public OpenNewAccount(WebDriver driver) {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void SelectAccounttype(String savings){
        Select acnt = new Select(accountType);
        acnt.selectByVisibleText(savings);
    }

    public void SelectFromAccount(){
        Select From = new Select(FromAccount);
        From.selectByVisibleText("20670");
    }
    public void clickOpenNewAccountBtn(){
        OpenNewAccountBtn.click();
    }


}
