package alchemyJobs;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.JavascriptExecutor;

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

public class Activity7 {
	
	WebDriver driver;
	
	Random random=new Random();
	
	@BeforeClass
	public void setUp() {
	    driver=new FirefoxDriver();
	    driver.get("https://alchemy.hguy.co/jobs/");
	    WebElement jobsPage=driver.findElement(By.xpath("//a[text()='Post a Job']"));
	    jobsPage.click();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void verifyNewJobListing() {
		
		
		
		
		
		
		WebElement email=driver.findElement(By.id("create_account_email"));
		email.sendKeys("test26@xyz.com");
		
		
		WebElement title=driver.findElement(By.id("job_title"));
		title.sendKeys("Analyst");
		
		WebElement jobType=driver.findElement(By.id("job_type"));
		Select select=new Select(jobType);
		select.selectByValue("2");
		
		WebElement frame=driver.findElement(By.xpath("//iframe[@id='job_description_ifr']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", frame);
		driver.switchTo().frame(0);
		WebElement description=driver.findElement(By.xpath("//body[@id='tinymce']"));
		description.click();
		description.sendKeys("This is for Selenium Project");
		driver.switchTo().defaultContent();
		
		WebElement application=driver.findElement(By.xpath("//input[@id='application']"));
		application.sendKeys("test26@xyz.com");
		WebElement companyName=driver.findElement(By.id("company_name"));
		companyName.sendKeys("IBM");
		driver.findElement(By.xpath("//input[@type='submit' and @value='Preview']")).click();
		
		driver.findElement(By.xpath("//input[@value='Submit Listing']")).click();
	
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
