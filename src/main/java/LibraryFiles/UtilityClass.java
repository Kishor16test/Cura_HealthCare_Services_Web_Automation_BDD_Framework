package LibraryFiles;


import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class UtilityClass {

    public static void captureScreenshot(Scenario sce) throws IOException {

        File src = ((TakesScreenshot) DriverFactory.driver).getScreenshotAs(OutputType.FILE);

        String dateTime = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

        String scenarioName = sce.getName().replaceAll(" ", "_");

        String ssFilePath = "./screenshotImages/" + scenarioName + "_" + dateTime + ".png";
        File dest = new File(ssFilePath);

        FileHandler.copy(src, dest);


    }


    public static String getPFData(String key) throws IOException {

        FileInputStream file = new FileInputStream("C:\\Users\\Admin\\IdeaProjects\\Cura_HealthCare_Services_Web_Automation\\src\\main\\java\\LibraryFiles\\PropertyFile.properties");

        Properties p=new Properties();
        p.load(file);

        String value = p.getProperty(key);
        return value;
    }




}

