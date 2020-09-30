package StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UpdateCustomer {
	
	WebDriver driver;
	
	@Given("^User in the home page$")
	public void user_in_the_home_page() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "F:\\chrome\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.get("http://localhost:4200/view-all-customers");
	    driver.manage().window().maximize();
		
	}

	@When("^User clicks on update button$")
	public void user_clicks_on_update_button() throws Throwable {
	   driver.findElement(By.xpath("//tbody/tr[1]/td[10]/button[1]")).click();
	}

	@When("^User will fill all the details on the update form$")
	public void user_will_fill_all_the_details_on_the_update_form() throws Throwable {
		
	    driver.findElement(By.id("Name")).clear();
	    driver.findElement(By.id("Name")).sendKeys("Dhanu Jai");
	    driver.findElement(By.id("Address")).clear();
	    driver.findElement(By.id("Address")).sendKeys("Vizag");
	    driver.findElement(By.id("Email")).clear();
	    driver.findElement(By.id("Email")).sendKeys("dhanunjaynaidu789@gmail.com");
	    driver.findElement(By.id("city")).clear();
	    driver.findElement(By.id("city")).sendKeys("Nellore");
	    driver.findElement(By.id("phone")).clear();
	    driver.findElement(By.id("phone")).sendKeys("8056743847");
	    driver.findElement(By.id("ZipCode")).clear();
	    driver.findElement(By.id("ZipCode")).sendKeys("537565");
	}

	@When("^User clicks on submit button$")
	public void user_clicks_on_submit_button() throws Throwable {
		
		
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		
		
	   
	}

	@Then("^User navigates to the home page and he will see all the updated details\\.$")
	public void user_navigates_to_the_home_page_and_he_will_see_all_the_updated_details() throws Throwable {
	    
		System.out.println("Hey order details submitted");
	}
	
	
	
	
	

}
