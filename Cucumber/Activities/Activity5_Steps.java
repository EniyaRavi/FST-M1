package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity5_Steps extends BaseClass{
	
	@Given("the user is on login page")
	public void the_user_is_on_login_page(){
		driver.get("https://training-support.net/webelements/login-form");
        
        Assertions.assertEquals("Selenium: Login Form", driver.getTitle());
	}
	
	@When("the user enters {string} and {string}")
	public void the_user_enters_and(String username, String password) {
		WebElement userNameField=driver.findElement(By.id("username"));
		WebElement passwordField=driver.findElement(By.id("password"));
		userNameField.clear();
		passwordField.clear();
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
	}
	
	@And("click on the submit button")
	public void click_on_the_submit_button() {
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}
	
	@Then("get the confirmation text and verify message as {string}")
	public void get_the_confirmation_text_and_verify_message_as(String expectedMessage) {
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h2.mt-5"), "Welcome"));
        String message = driver.findElement(By.cssSelector("h2.mt-5")).getText();
        Assertions.assertEquals(expectedMessage, message);
        
	}

}
