package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity2_Steps extends BaseClass{
	
	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
		driver.get("https://training-support.net/webelements/login-form");
		Assertions.assertEquals("Selenium: Login Form", driver.getTitle());	   
	}
	
	@When("the user enters username and password")
	public void the_user_enters_username_and_password() {
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
	}
	
	@When("clicks the submit button")
	public void clicks_the_submit_button() {
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}
	
	@Then("get the confirmation message and verify it")
	public void get_the_confirmation_message_and_verify_it() {
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h2.mt-5"), "Welcome"));
        String message = driver.findElement(By.cssSelector("h2.mt-5")).getText();
      
        Assertions.assertEquals("Welcome Back, Admin!", message);
	}

}
