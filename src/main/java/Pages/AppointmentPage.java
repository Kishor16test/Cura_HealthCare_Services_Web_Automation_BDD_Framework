package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppointmentPage {

    @FindBy(xpath="//h2[text()='Make Appointment']")
    private WebElement verifyAppForm;

    @FindBy(xpath="//select[@name='facility']")
    private WebElement Facility;

    @FindBy(css="#chk_hospotal_readmission")
    private WebElement checkBox;

    @FindBy(css="#radio_program_medicaid")
    private WebElement mediCaid;

    @FindBy(xpath="//input[@placeholder='dd/mm/yyyy']")
    private WebElement calenderInputbox;

    @FindBy(xpath="(//table[@class='table-condensed']//th[@class='datepicker-switch'])[1]")
    private WebElement calenderHeader;

    @FindBy(xpath="(//th[@class='next'])[1]")
    private WebElement calenderNextBtn;

    @FindBy(xpath="//td[text()='16']")
    private WebElement calenderDate;

    @FindBy(xpath="//textarea[@name='comment']")
    private WebElement comment;

    @FindBy(css="#btn-book-appointment")
    private WebElement bookAppointmentBtn;

    @FindBy(xpath="//h2[text()='Appointment Confirmation']")
    private WebElement confirmation;

    private WebDriver driver;

    private Wait<WebDriver> wait;

    public AppointmentPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    public void verifyAppointmentPageForm()
    {
        boolean result=verifyAppForm.isDisplayed();

        if(result)
        {
            System.out.println("Land on Appointment Form");
        }
        else
        {
            System.err.println("Not Land on Appointment Form");
        }
    }



    public void selectFacility()
    {
        wait.until(ExpectedConditions.elementToBeClickable(this.Facility));
        Select select=new Select(Facility);
        try
        {
            select.selectByValue("Hongkong CURA Healthcare Center");   //value
        }
        catch(Exception e)
        {
            try
            {
                select.selectByIndex(0);      //index
            }
            catch(Exception ep)
            {
                select.selectByVisibleText("Seoul CURA Healthcare Center");   //text
            }
        }
    }



    public void applyReadmission()
    {
        wait.until(ExpectedConditions.elementToBeClickable(this.checkBox));
        try
        {
            JavascriptExecutor javaScript=(JavascriptExecutor)driver;
            javaScript.executeScript("arguments[0].click()", checkBox);
        }
        catch(Exception e)
        {
            this.checkBox.click();

        }
    }



    public void selectHealthCareProgram()
    {
        wait.until(ExpectedConditions.elementToBeClickable(this.checkBox));
        try
        {
            JavascriptExecutor javaScript=(JavascriptExecutor)driver;
            javaScript.executeScript("arguments[0].click()", mediCaid);

        }
        catch(Exception e)
        {
            this.mediCaid.click();
        }
    }


    public void enterVisitDate()
    {
        String year="2028";
        String month="February";
        //String date="16";

        JavascriptExecutor javaScript=(JavascriptExecutor)driver;
        javaScript.executeScript("arguments[0].click()", calenderInputbox);

        //this.calenderInputbox.click();

        while(true)
        {
            String monthYear=this.calenderHeader.getText();

            String arr[]=monthYear.split(" ");
            String mon=arr[0];
            String yr=arr[1];

            if(mon.equals(month)&&yr.equals(year))
                break;
            else
                this.calenderNextBtn.click();

        }


        this.calenderDate.click();


    }



    public void enterComment()
    {
        wait.until(ExpectedConditions.visibilityOf(this.comment));
        this.comment.sendKeys("Hi my name is kishor pawar.i am from nilwande");
    }


    public void clickOnBookAppoinment()
    {
        wait.until(ExpectedConditions.elementToBeClickable(this.bookAppointmentBtn));
        this.bookAppointmentBtn.click();
    }

    public void verifyConfirmationPage()
    {
        boolean result=confirmation.isDisplayed();

        if(result)
        {
            System.out.println("Land on confirmation Page");
        }
        else
        {
            System.err.println("Not Land on confirmation Page");
        }
    }

}

