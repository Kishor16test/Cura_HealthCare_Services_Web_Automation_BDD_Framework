package Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfileAndLogoutPage {

    @FindBy(css="#menu-toggle")
    private WebElement toggleMenu;

    @FindBy(xpath="//a[text()='Profile']")
    private WebElement profile;

    @FindBy(xpath="//a[text()='Logout']")
    private WebElement logout;

    private WebDriver driver;

    private Wait<WebDriver> wait;

    public ProfileAndLogoutPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    public void menuBar()
    {
        wait.until(ExpectedConditions.elementToBeClickable(this.toggleMenu));
        try
        {
            this.toggleMenu.click();
        }
        catch(Exception e)
        {
            JavascriptExecutor javaScript=(JavascriptExecutor)driver;
            javaScript.executeScript("arguments[0].click()", toggleMenu);
        }
    }


    public void clickOnProfile()
    {
        try
        {
            this.profile.click();
        }
        catch(Exception e)
        {
            JavascriptExecutor javaScript=(JavascriptExecutor)driver;
            javaScript.executeScript("arguments[0].click()", profile);
        }

    }


    public void clickOnLogoutButton()
    {
        try
        {
            this.logout.click();
        }
        catch(Exception e)
        {
            JavascriptExecutor javaScript=(JavascriptExecutor)driver;
            javaScript.executeScript("arguments[0].click()", logout);
        }

    }

}


