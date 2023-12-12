package com.app.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class OpenMRSAddNewService {
	
	@FindBy(xpath="//input[@id='name-field']")
	WebElement emt;
	
	@FindBy(xpath="//input[@id='name-field']")
	WebElement nameinput;
	
	@FindBy(xpath="//input[@id='duration-field']")
	WebElement duration;
	
	@FindBy(xpath="//input[@id='save-button']")
	WebElement save;
	
	@FindBy(xpath="//h1[contains(text(),'Manage Service Types')]")
	WebElement verify;
	
	
	public OpenMRSAddNewService(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void AddingNewService(String name, String time) throws InterruptedException {
		
		emt.clear();
		nameinput.sendKeys(name);
		duration.sendKeys(time);
		save.click();
		Thread.sleep(2000);
		
		String expected = "Manage Service Types";
		String actual = verify.getText();
		Assert.assertEquals(expected, actual);

//		SoftAssert sf = new SoftAssert();
//		boolean Added = verify.isDisplayed();
//		sf.assertTrue(Added);
//		sf.assertAll();
	}

	
	
	
	

}
