package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	
WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/login-form/");
	}
	
	@Test
	public void testCase1() {
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		String message=driver.findElement(By.cssSelector("h2.text-center")).getText();
		System.out.println("Successful message is: "+message);
		Assert.assertEquals("Welcome Back, Admin!", message);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
