package com.app.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.app.Base.TestBase;

public class OpenMRSHomePage extends TestBase {
	
	Actions a = new Actions(driver);
	@FindBy(xpath="//input[@name='username']")
	WebElement Username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement Password;
	
	@FindBy(xpath="//li[@id='Inpatient Ward']")
	WebElement Location;
	
	@FindBy(xpath="//input[@class='btn confirm']")
	WebElement Submit;
	
	
	
	@FindBy(xpath="/html/body/div[1]/div[3]/div[3]/div/a[5]")
	WebElement AppointmentsSchedulling;
	
	@FindBy(xpath="/html/body/div[1]/div[3]/div/div[1]/a")
	WebElement ManageServices;
	
	@FindBy(xpath="/html/body/div/div[3]/div/div[1]/button")
	WebElement AddNewService;
	
	//constructor to initiate the elements
	public OpenMRSHomePage(WebDriver driver) {
		
	    PageFactory.initElements(driver, this);
	    // driver can now work with your elements and methods of this class
	   

	}
	
	public void login() {
		Username.sendKeys("admin");
		Password.sendKeys("Admin123");
		Location.click();
		Submit.click();
		
		SoftAssert sf = new SoftAssert();
		
		String expectedtitle ="Login";
		String actualtitle = driver.getTitle();
		sf.assertEquals(actualtitle, expectedtitle, "The title donot match");
	}
	
	public void AppointmentsSchedulling() {
		AppointmentsSchedulling.click();
	}
	
	public void ManageServices() {
		ManageServices.click();
	}
	
	public void AddNewService() {
		AddNewService.click();
	}
	

}
