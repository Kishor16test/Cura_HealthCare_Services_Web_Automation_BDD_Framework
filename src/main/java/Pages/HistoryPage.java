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

public class HistoryPage {

    @FindBy(xpath="//h2[text()='History']")
    private WebElement dataPage;

    @FindBy(css="#menu-toggle")
    private WebElement toggleMenu;

    @FindBy(xpath="//a[text()='History']")
    private WebElement history;

    @FindBy(xpath="//div[@class='panel panel-info']")
    private WebElement appointmentData;

    @FindBy(xpath="//a[text()='Go to Homepage']")
    private WebElement backToHomepage;


    private WebDriver driver;

    private Wait<WebDriver> wait;

    public HistoryPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void verifyHistoryPage()
    {
        boolean result=dataPage.isDisplayed();

        if(result)
        {
            System.out.println("Land on dataPage Page");
        }
        else
        {
            System.err.println("Not Land on dataPage Page");
        }

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


    public void clickOnHistory()
    {
        try
        {
            this.history.click();
        }
        catch(Exception e)
        {
            JavascriptExecutor javaScript=(JavascriptExecutor)driver;
            javaScript.executeScript("arguments[0].click()", history);
        }

    }


    public void checkAppointmentData()
    {
        String data=this.appointmentData.getText();
        System.out.println(data);
    }


    public void ClickOnGoToHomePage()
    {
        try
        {
            this.backToHomepage.click();
        }
        catch(Exception ep)
        {
            JavascriptExecutor javaScript=(JavascriptExecutor)driver;
            javaScript.executeScript("arguments[0].click()", backToHomepage);
        }
    }



}








