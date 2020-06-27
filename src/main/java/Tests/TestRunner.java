package Tests;
import java.io.*;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
import com.cucumber.listener.*;

@RunWith(Cucumber.class)
@CucumberOptions(
		// dryRun= true,
		monochrome = true, // For More Readable format
		features = "C:\\Users\\Sourav\\eclipse-workspace\\Propine-Assignment\\src\\test\\java\\Feature", 
		glue = { "Stepdefination" }, 
		plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"})

public class TestRunner 
   {
	@AfterClass
	public static void writeExtentReport() {
		String reportConfigPath="C:\\Users\\Sourav\\eclipse-workspace\\Propine-Assignment\\src\\test\\java\\extent-config.xml";
		Reporter.loadXMLConfig(new File(reportConfigPath));
	}
}              