package alchemyJobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
	    driver=new FirefoxDriver();
	    driver.get("https://alchemy.hguy.co/jobs/");
	    WebElement jobsPage=driver.findElement(By.xpath("//a[text()='Jobs']"));
	    jobsPage.click();
	}
	
	@Test
	public void verifyJobsPage() {
		String jobsTitle=driver.getTitle();
		System.out.println("Title of the job page is:"+jobsTitle);
		Assert.assertEquals(jobsTitle, "Jobs – Alchemy Jobs", "Page heading is incorrect");
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
