import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Activity15 {

	public static void main(String[] args) {
		   WebDriver driver=new FirefoxDriver();
		
	       driver.get("https://training-support.net/webelements/dynamic-attributes");
			
		   String title=driver.getTitle();
		   System.out.println("Title of the page is: "+title);
		   
		   driver.findElement(By.xpath("//input[starts-with(@id,'full-name-')]")).sendKeys("Nethra S");
		   driver.findElement(By.xpath("//input[contains(@id,'-email')]")).sendKeys("nethras@abc.com");
		   driver.findElement(By.xpath("//input[contains(@name,'-event-date-')]")).sendKeys("2025-01-08");
		   driver.findElement(By.xpath("//textarea[contains(@id,'-additional-details-')]")).sendKeys("Selenium Training");
		   driver.findElement(By.xpath("//button[text()='Submit']")).click();
		   
		   String message=driver.findElement(By.id("action-confirmation")).getText();
		   System.out.println("Message is: "+message);
		   
		   driver.quit();
		   
		

	}

}
