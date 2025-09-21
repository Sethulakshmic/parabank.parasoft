package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Registraton {

    public WebDriver driver;
    public WebDriverWait wait;


    @FindBy(id = "customer.firstName")
    public WebElement FirstName;

    @FindBy(id = "customer.lastName")
    public WebElement Lastname;

    @FindBy(id = "customer.address.street")
    public WebElement Address;

    @FindBy(id = "customer.address.city")
    public WebElement City;

    @FindBy(id = "customer.address.state")
    public WebElement State;

    @FindBy(id = "customer.address.zipCode")
    public WebElement ZipCode;

    @FindBy(id = "customer.phoneNumber")
    public WebElement PhoneNum;

    @FindBy(id = "customer.ssn")
    public WebElement SSN;

    @FindBy(id = "customer.username")
    public WebElement Username;

    @FindBy(id = "customer.password")
    public WebElement Password;

    @FindBy(id = "repeatedPassword")
    public WebElement ConfirmPass;



    public Registraton(WebDriver driver) {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }

    public void ClickRegisterButton(String buttonname){
        WebElement registerButton = driver.findElement(By.xpath("//input[@value='" + buttonname + "']"));
        registerButton.click();
    }

}
