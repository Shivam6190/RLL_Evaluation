package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewServiceTest {

	public static WebDriver driver;
	
	@Given("I open the chrome browser")
	public void i_open_the_chrome_browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}

	@Then("I open the OpenMRS Health Page")
	public void i_open_the_open_mrs_health_page() {
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
	}

	@Then("I enter the usernamme as admin and password as Admin123")
	public void i_enter_the_usernamme_as_admin_and_password_as_admin() {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Admin123");
		
	}

	@When("I enter the location")
	public void i_enter_the_location() {
	    driver.findElement(By.xpath("//li[@id='Inpatient Ward']")).click();
	}

	@Then("I click on login button")
	public void i_click_on_login_button() {
	    driver.findElement(By.xpath("//input[@class='btn confirm']")).click();
	}

	@Then("I click on AppointmentSchedulling block")
	public void i_click_on_appointment_schedulling_block() {
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div/a[5]")).click();
	}

	@When("I click on ManageServiceType block")
	public void i_click_on_manage_service_type_block() {
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/a")).click();
	}

	@Then("I click on NewServiceType button")
	public void i_click_on_new_service_type_button() {
		driver.findElement(By.xpath("/html/body/div/div[3]/div/div[1]/button")).click();
	}

	@And("I enter name as {string} on the page")
	public void i_enter_name_as_general_health_and_duration_as(String Name) {
		driver.findElement(By.xpath("//input[@id='name-field']")).clear();
		driver.findElement(By.xpath("//input[@id='name-field']")).sendKeys(Name);
	    
	}
	
	@And("I enter duration as {string} on the page")
	public void duration (String duration) {
		driver.findElement(By.xpath("//input[@id='duration-field']")).sendKeys(duration);
	}

	@When("I click on save button")
	public void i_click_on_save_button() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='save-button']")).click();
		Thread.sleep(2000);
	}
	
	@Then("I verify")
	public void verify() {
		driver.findElement(By.xpath("//td[contains(text(),'General Health')]")).isDisplayed();
	}
	
	@And("I close the browser")
	public void i_close_the_browser() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	   
	}

	
	
	
	
	
	
	
	
	
}
