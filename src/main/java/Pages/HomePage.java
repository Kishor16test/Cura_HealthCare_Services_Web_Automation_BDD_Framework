package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    @FindBy(xpath="//a[text()='Make Appointment']")
    private WebElement makeAppointment;

    @FindBy(xpath="//h1[text()='CURA Healthcare Service']")
    private WebElement verifyHM;

    private WebDriver driver;
    private Wait<WebDriver> wait;

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    public void verifyHomePage()
    {
        wait.until(ExpectedConditions.visibilityOf(verifyHM));
        boolean result=verifyHM.isDisplayed();

        if(result)
        {
            System.out.println("Land on Home Page");
        }
        else
        {
            System.err.println("Not Land on Home Page");
        }
    }


    public void clickOnMakeAppointment()
    {
        wait.until(ExpectedConditions.elementToBeClickable(this.makeAppointment));
        this.makeAppointment.click();
    }
}


