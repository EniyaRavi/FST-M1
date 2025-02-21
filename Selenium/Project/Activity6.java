package alchemyJobs;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 {
	
	WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	Random random=new Random();
	
	@BeforeClass
	public void setUp() {
	    driver=new FirefoxDriver();
	    driver.get("https://alchemy.hguy.co/jobs/");
	    WebElement jobsPage=driver.findElement(By.xpath("//a[text()='Jobs']"));
	    jobsPage.click();
	}
	
	@Test
	public void verifySearchJob() {
		WebElement searchBar=driver.findElement(By.xpath("//input[@id='search_keywords']"));
		searchBar.click();
		searchBar.sendKeys("Banking");
		WebElement searchButton=driver.findElement(By.xpath("//input[@type='submit' and @value='Search Jobs']"));
		searchButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//h3[contains(text(),'Banking')]")).click();
		driver.findElement(By.xpath("//input[@type='button']")).click();
		String email=driver.findElement(By.className("job_application_email")).getText();
		System.out.println("Email is: "+email);
		
		
		
//		List<WebElement> suggestions= wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@class='job_listings']")));
//		
//		WebElement randomOption=suggestions.get(random.nextInt(suggestions.size()));
//		randomOption.click();
		
		
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}


}
