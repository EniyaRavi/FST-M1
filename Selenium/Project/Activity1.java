package alchemyJobs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
	    driver=new FirefoxDriver();
	    driver.get("https://alchemy.hguy.co/jobs/");
	}
	
	@Test
	public void verifyTitle() {
		String title=driver.getTitle();
		Assert.assertEquals(title, "Alchemy Jobs – Job Board Application","Page title is incorrect");	
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	

}
