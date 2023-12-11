package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\SHIVAM SINGH\\eclipse-workspace\\RLL_Cucumber\\src\\test\\java\\features\\AddNewService.feature",
				 glue= {"steps"},
				 dryRun=false,
				 plugin = {"pretty",
						 "html:target/cucumberreport.html",
						 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						 "timeline:test-output-thread/"},
				 
				 monochrome = true
		
					
		)


public class TestRunner {

	
}
