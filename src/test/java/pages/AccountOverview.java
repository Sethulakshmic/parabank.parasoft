package pages;

import context.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AccountOverview {

    public WebDriver driver;
    public WebDriverWait wait;
    public OpenNewAccount openNewAccount;


    @FindBy(xpath = "//a[@href='overview.htm']")
    WebElement sideBarAccountOverview;


    public AccountOverview(WebDriver driver) {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public String clickAccountOverview() {

        wait.until(ExpectedConditions.elementToBeClickable(sideBarAccountOverview)).click();
        System.out.println("Sidebar 'Account Overview' clicked");
        String expectedAccountId = (String) TestContext.get("accountId");
        System.out.println(expectedAccountId);
        System.out.println("ok");
        if(expectedAccountId == null){
            System.out.println("ERROR: Account ID is null! Check OpenNewAccount step.");
        }
        return expectedAccountId;


    }

    public void checkIdInTable(String expectedID) {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath("//table[@id='accountTable']/tbody/tr"), 0));

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='accountTable']/tbody/tr"));

        if (rows.isEmpty()) {
            System.out.println("The account overview table is empty!");
            return;
        }

        WebElement lastRow = rows.get(rows.size() - 2);

        String actualAccountId = lastRow.findElement(By.xpath("td[1]")).getText();

        if (expectedID.equals(actualAccountId)) {
            System.out.println("Table last row: " + actualAccountId);
        } else {
            System.out.println("Expected: " + expectedID + ", Actual: " + actualAccountId);
        }


    }
}




