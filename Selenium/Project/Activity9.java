package alchemyJobs;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity9 {
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
	public void verifyJobListing() {
	    WebElement login=driver.findElement(By.id("user_login"));
		login.sendKeys("root");
		WebElement password=driver.findElement(By.id("user_pass"));
		password.sendKeys("pa$$w0rd");
		driver.findElement(By.id("wp-submit")).click();
		
		String header = driver.findElement(By.tagName("h1")).getText();
		System.out.println(header + " You have logged in successfully");
		
		driver.findElement(By.xpath("//*[@id=\"menu-posts-job_listing\"]/a/div[3]")).click();  
		
		
		driver.findElement(By.xpath("//a[@class='page-title-action']")).click();
		driver.findElement(By.xpath("//button[@class='components-button has-icon' and @aria-label='Close dialog']")).click();
		
		WebElement position=driver.findElement(By.xpath("//textarea[@id='post-title-0']"));
		position.click();
		position.sendKeys("Analyst");
		
		driver.findElement(By.xpath("//button[text()='Publish…']")).click();
		
		driver.findElement(By.xpath("//button[text()='Publish']")).click();
		
		String job=driver.findElement(By.xpath("//textarea[@id='post-title-0']")).getText();
		System.out.println("Posted job: "+job);
	}
		
		
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}


}
