package Hooks;

import LibraryFiles.DriverFactory;
import LibraryFiles.UtilityClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class CoreHooks extends DriverFactory {

    @Before
    public void openBrowser() throws IOException {
//        DriverFactory.initializeBrowser("chrome");
        	String browserName=UtilityClass.getPFData("Browser");
        	DriverFactory.initializeBrowser(browserName);
    }

    @After
    public void closeBrowser(Scenario sce) throws IOException {
        if(sce.isFailed())
        {
            UtilityClass.captureScreenshot(sce);
        }
        DriverFactory.driver.quit();
    }

}
