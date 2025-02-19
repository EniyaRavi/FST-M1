package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity1_Steps extends BaseClass {

	@Given("User is on Google Home Page")
	public void user_is_on_google_home_page() {
	    driver.get("https://www.google.com/");
	}

	@When("User types in Cheese and hits ENTER")
	public void user_types_in_cheese_and_hits_enter() {
	    driver.findElement(By.id("APjFqb")).sendKeys("Cheese",Keys.ENTER);
	}

	@Then("Show how many search results were shown")
	public void show_how_many_search_results_were_shown() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("hdtb-tls"))).click();
		String resultStats=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats"))).getText();
		System.out.println("Result is: "+resultStats);
	    
	}

	
}
