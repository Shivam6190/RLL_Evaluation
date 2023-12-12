package com.app.Base;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestBase {
	
	// Base class indicates the driver session and Application details
	// this base class will be called in every test class
	
	public static WebDriver driver;
	public static ExtentReports extentreports;
	public static ExtentTest extentTest;
	
	public static void openBrowser()
	{
	    driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");	
	}
	
	@BeforeTest
	public void getnameMethod(ITestContext context)
	{
		extentTest=	extentreports.createTest(context.getName());
	}
	
	@BeforeSuite  // this method will be excuted before suite begins its execution
	public void InitalizeExtentReport()
	{
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter("reportpom.html");
		extentreports = new ExtentReports();
		extentreports.attachReporter(sparkreporter);
		// on the report display more information about OS, browser, java etc
		extentreports.setSystemInfo("OS", System.getProperty("os.name"));
		extentreports.setSystemInfo("JAVA", System.getProperty("java.version"));
		
	}

	@AfterSuite
	public void generateReports() throws IOException
	{
		extentreports.flush();
		Desktop.getDesktop().browse(new File("reportpom.html").toURI());
	}
	
	
	@AfterMethod
	public void generateTestStatus(Method m,ITestResult result) throws InterruptedException, IOException
	{
		if(result.getStatus() == ITestResult.FAILURE )
		{
			
			Thread.sleep(2000);
			try {
				File src6File = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				File dest6File = new File("./Screenshots/Error123.png");
				FileUtils.copyFile(src6File, dest6File);
			} catch (Exception e) {
				System.out.println("Error in Capturing Screenshot");
			}
			extentTest.fail(result.getThrowable());
		}
		else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.pass(m.getName() + " is passed");
		}
	}
	


}