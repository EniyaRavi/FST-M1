package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {
	
    WebDriver driver;
    WebDriverWait wait;
	
	@BeforeClass 
	public void setUp() {
		driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/login-form");
	}
	
	@Test 
	@Parameters({ "username", "password", "message" })
	public void loginTestCase(String username, String password, @Optional("Login Success!") String message) {
		WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        
        wait.until(ExpectedConditions.titleContains("Login"));
        
        String loginMessage = driver.findElement(By.cssSelector("h2.text-center")).getText();
        Assert.assertEquals("Welcome Back, Admin!", loginMessage);
        
	}
	
	@AfterClass 
	public void tearDown() {
		driver.quit();
	}

}
