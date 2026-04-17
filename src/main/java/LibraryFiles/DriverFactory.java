package LibraryFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver driver;

    public static void initializeBrowser(String browserName)
    {
        if(browserName.equalsIgnoreCase("chrome"))
        {
            driver=new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("edge"))
        {
            driver=new EdgeDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox"))
        {
            driver=new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

}

