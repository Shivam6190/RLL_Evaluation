package com.app.TestPages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.app.Base.TestBase;
import com.app.Pages.OpenMRSAddNewService;
import com.app.Pages.OpenMRSHomePage;

import com.app.Utilities.XLS_DataProvider;

public class OpenMRSAddNewServicePageTest extends TestBase {
	
	OpenMRSHomePage hp;
	OpenMRSAddNewService ad;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		openBrowser();
		hp = new OpenMRSHomePage(driver);
		ad = new OpenMRSAddNewService(driver);
	}
	
	@AfterMethod
	public void CloseApp()
	{
		driver.quit();
	}
	
	@Test(priority='1' , dataProvider="testdata")
	public void AddNewService(String name,String time) throws InterruptedException {
		hp.login();
		hp.AppointmentsSchedulling();
		hp.ManageServices();
		hp.AddNewService();
		ad.AddingNewService(name,time);
	}
	
	
	
	
	@DataProvider(name="testdata")
	public Object [][] datasupplier() throws EncryptedDocumentException, IOException{
		Object[] [] input = XLS_DataProvider.getTestData("Sheet1");
		return input;
	}
	
	
	
	

}
