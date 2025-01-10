package alchemyJobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity2 {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
	    driver=new FirefoxDriver();
	    driver.get("https://alchemy.hguy.co/jobs/");
	}
	
	@Test
	public void verifyHeading() {
		String heading=driver.findElement(By.className("entry-title")).getText();
		Assert.assertEquals(heading, "Welcome to Alchemy Jobs", "Page heading is incorrect");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
