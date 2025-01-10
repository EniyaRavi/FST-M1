package alchemyJobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 {

	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
	    driver=new FirefoxDriver();
	    driver.get("https://alchemy.hguy.co/jobs/");
	}
	
	@Test
	public void verifyHeading() {
		String secondHeading=driver.findElement(By.tagName("h2")).getText();
		System.out.println("Second Heading is:"+secondHeading);
		Assert.assertEquals(secondHeading, "Quia quis non", "Page heading is incorrect");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
