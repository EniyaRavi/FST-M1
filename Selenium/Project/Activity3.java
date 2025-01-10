package alchemyJobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	    driver.get("https://alchemy.hguy.co/jobs/");
	}
	
	@Test
	public void verifyHeaderImageUrl() {
		WebElement imageElement=driver.findElement(By.xpath("//img[contains(@class,'attachment-large size-large wp-post-image')]"));
		String imageUrl=imageElement.getAttribute("src");
		System.out.println("Image URL is: "+imageUrl);
		
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}


}
