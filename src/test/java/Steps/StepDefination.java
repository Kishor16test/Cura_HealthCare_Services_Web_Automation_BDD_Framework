package Steps;

import LibraryFiles.DriverFactory;
import LibraryFiles.UtilityClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Pages.AppointmentPage;
import Pages.HistoryPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfileAndLogoutPage;

import java.io.IOException;

import static LibraryFiles.DriverFactory.driver;

public class StepDefination extends DriverFactory {

    // WebDriver driver=DriverFactory.driver;

    private HomePage homePage;
    private LoginPage loginPage;
    private AppointmentPage appointmentPage;
    private HistoryPage historyPage;
    private ProfileAndLogoutPage profileAndLogoutPage;

    @Given("User on the home page")
    public void userOnHomePage() throws IOException {
        String urlValue = UtilityClass.getPFData("URL");
        DriverFactory.driver.get(urlValue);
        homePage=new HomePage(DriverFactory.driver);
        homePage.verifyHomePage();
    }

    @When("User click on Make Appointment button")
    public void user_Click_On_Make_Appointment_Button()

    {
        homePage.clickOnMakeAppointment();
    }

    @Then("Verify User should land on login page")
    public void verify_user_should_land_on_login_page()
    {
        loginPage=new LoginPage(DriverFactory.driver);
        loginPage.verifyLoginPage();
    }

    @When("User enter valid username{string} and  User enter valid password{string}")
    public void user_Enter_Username_And_Password(String username,String password)
    {
        loginPage=new LoginPage(DriverFactory.driver);
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
    }

    @When("User click on login button")
    public void user_Click_On_Login_Button()
    {
        loginPage=new LoginPage(DriverFactory.driver);
        loginPage.clickOnLoginBtn();
    }

    @Then("Verify User should  successfully login and redirect to make appointment form page")
    public void verify_Successfully_Login_And_Redirect_On_AppointmentPage()
    {
        appointmentPage=new AppointmentPage(DriverFactory.driver);
        appointmentPage.verifyAppointmentPageForm();
    }

    @When("User fill the appointment form")
    public void user_Fill_AppointmentForm()
    {
        appointmentPage=new AppointmentPage(DriverFactory.driver);
        appointmentPage.selectFacility();
        appointmentPage.applyReadmission();
        appointmentPage.selectHealthCareProgram();
        appointmentPage.enterVisitDate();
        appointmentPage.enterComment();
    }

    @When("User click on book appointment button")
    public void user_click_on_appointment_button()
    {
        appointmentPage=new AppointmentPage(DriverFactory.driver);
        appointmentPage.clickOnBookAppoinment();
    }

    @Then("Verify User successfully book appointment and redirect to appointment confirmation page")
    public void verify_User_Successfully_BookAppointment_And_Redirect_On_ConfirmationPage()
    {
        appointmentPage=new AppointmentPage(DriverFactory.driver);
        appointmentPage.verifyConfirmationPage();
    }

    @When("User can see  history of appointment data")
    public void user_See_History()
    {
        historyPage=new HistoryPage(DriverFactory.driver);
        historyPage.menuBar();
        historyPage.clickOnHistory();
    }


    @Then("Verify User should redirect to history page and check appointment data")
    public void user_On_HistoryPage_And_Check_Data()
    {
        historyPage=new HistoryPage(DriverFactory.driver);
        historyPage.verifyHistoryPage();
        historyPage.checkAppointmentData();
    }

    @Then("Verify User should back to home page")
    public void user_Click_On_Go_To_HomePage()
    {
        historyPage=new HistoryPage(DriverFactory.driver);
        historyPage.ClickOnGoToHomePage();
    }

    @When("User can check profile page")
    public void user_Check_Profile_And_Click_On_Logout_Button()
    {
        profileAndLogoutPage=new ProfileAndLogoutPage(DriverFactory.driver);
        profileAndLogoutPage.menuBar();
        profileAndLogoutPage.clickOnProfile();
    }

    @Then("Verify User check profile page and successfully logout")
    public void verify_User_Check_Profile_And_Logout()
    {
        profileAndLogoutPage=new ProfileAndLogoutPage(DriverFactory.driver);
        profileAndLogoutPage.clickOnLogoutButton();
    }
}

