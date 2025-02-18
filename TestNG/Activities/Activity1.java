package activities;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver=new FirefoxDriver();
		driver.get("https://training-support.net");
	}
	
	@Test (priority=1)
	public void homePageTest() {
		String Title=driver.getTitle();
		System.out.println("Title of the home page is: "+Title);
		Assert.assertEquals(Title, "Training Support");
		
		driver.findElement(By.linkText("About Us")).click();
	}
	
	@Test (priority=2)
	public void aboutPageTest() {
		String Title=driver.getTitle();
		System.out.println("Title of About Us page is: "+Title);
		Assert.assertEquals(Title, "About Training Support");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	

}
