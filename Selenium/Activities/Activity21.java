import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Activity21 {

	public static void main(String[] args) {
		   WebDriver driver=new FirefoxDriver();
		
	       driver.get("https://training-support.net/webelements/tabs");
			
		   String title=driver.getTitle();
		   System.out.println("Title of the page is: "+title);
		   System.out.println("Current Tab is: "+driver.getWindowHandle());
		   
		   driver.findElement(By.xpath("//button[text()='Open A New Tab']")).click();
		   
		   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		   wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		   
		   Set<String> handles=driver.getWindowHandles();
		   
		   for(String handle: handles) {
				   driver.switchTo().window(handle);
			   
		   }
		   
		   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='Open Another One']"))));
		   
		   System.out.println("Newly Opened tab is: "+driver.getWindowHandle());
		   
		   System.out.println("New Page Title is: "+driver.getTitle());
		   System.out.println("Message in Newly Opened tab is: "+driver.findElement(By.cssSelector("h2.mt-5")).getText());
		   
		   driver.findElement(By.xpath("//button[text()='Open Another One']")).click();
		   wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		   for(String handle: handles) {
			   driver.switchTo().window(handle);
		    }
		   
           System.out.println("2nd Newly Opened tab is: "+driver.getWindowHandle());
		   
		   System.out.println("2nd New Page Title is: "+driver.getTitle());
		   System.out.println("Message in 2nd Newly Opened tab is: "+driver.findElement(By.cssSelector("h2.mt-5")).getText());
           
		   
		   driver.quit();
		   
		   
		   

	}

}
