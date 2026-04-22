package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
        features ="C:\\Users\\Admin\\IdeaProjects\\Cura_HealthCare_Services_Web_Automation\\src\\test\\java\\Features\\Cure_Heath.feature",
        glue = {"Hooks","Steps"},
        tags = "@All",
        publish = true,
        plugin = {"pretty","html:target/CucumberReports/Cura_Health_report.html"}

)

public class TestRunner extends AbstractTestNGCucumberTests {



}

