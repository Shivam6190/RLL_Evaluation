package com.app.TestPages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.Base.TestBase;
import com.app.Pages.OpenMRSHomePage;

public class OpenMRSHomePageTest extends TestBase {
	OpenMRSHomePage hp;

	// Initialize the OpenMRSPage object in the @BeforeMethod or @BeforeClass method
	@BeforeMethod
	public void setUp() throws InterruptedException {
		openBrowser();
		hp = new OpenMRSHomePage(driver);
	}
	
	@AfterMethod
	public void CloseApp()
	{
		driver.quit();
	}
	
	
	@Test(priority = '1')
	public void login() {
		hp.login();
		hp.AppointmentsSchedulling();
		hp.ManageServices();
		hp.AddNewService();
	}

	


}
