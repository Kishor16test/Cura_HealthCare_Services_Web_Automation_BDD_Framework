package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    @FindBy(xpath="//h2[text()='Login']")
    private WebElement verifyLP;

    @FindBy(xpath="//input[@name='username']")
    private WebElement username;

    @FindBy(xpath="//input[@name='password']")
    private WebElement password;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement login;

    private WebDriver driver;
    private Wait<WebDriver> wait;

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    public void verifyLoginPage()
    {
        wait.until(ExpectedConditions.visibilityOf(verifyLP));
        boolean result=verifyLP.isDisplayed();

        if(result)
        {
            System.out.println("Land on Login Page");
        }
        else
        {
            System.err.println("Not Land on Login Page");
        }
    }


    public void enterUserName(String user)
    {
        wait.until(ExpectedConditions.visibilityOf(this.username));
        this.username.sendKeys(user);
    }


    public void enterPassword(String pass)
    {
        wait.until(ExpectedConditions.visibilityOf(this.password));
        this.password.sendKeys(pass);
    }

    public void clickOnLoginBtn()
    {
        wait.until(ExpectedConditions.elementToBeClickable(this.login));
        this.login.click();
    }

}

