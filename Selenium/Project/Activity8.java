package alchemyJobs;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity8 {
	
	WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	Random random=new Random();
	
	@BeforeClass
	public void setUp() {
	    driver=new FirefoxDriver();
	    driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	    String title=driver.getTitle();
	    System.out.println("Title of the page is: "+title);
	}
	
	@Test
	public void verifyBackendLogin() {
		WebElement login=driver.findElement(By.id("user_login"));
		login.sendKeys("root");
		WebElement password=driver.findElement(By.id("user_pass"));
		password.sendKeys("pa$$w0rd");
		driver.findElement(By.id("wp-submit")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='root']")));
		
		WebElement userName=driver.findElement(By.xpath("//*[text()='root']"));
		if(userName.getText().equals("root")) {
			System.out.println("Login Suceessful");
		}
		else {
			System.out.println("Login Failed");
		}
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
