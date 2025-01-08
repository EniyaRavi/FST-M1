import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Activity22 {

	public static void main(String[] args) {
		   WebDriver driver=new FirefoxDriver();
		
	       driver.get("https://training-support.net/webelements/popups");
			
		   String title=driver.getTitle();
		   System.out.println("Title of the page is: "+title);
		   
		   driver.findElement(By.id("launcher")).click();
		   
		   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		   wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
		   
		   WebElement username=driver.findElement(By.id("username"));
		   WebElement password=driver.findElement(By.id("password"));
		   
		   username.sendKeys("admin");
		   password.sendKeys("password");
		   
		   driver.findElement(By.xpath("//button[text()='Submit']")).click();
		   
		   System.out.println("Message is: "+driver.findElement(By.cssSelector("h2.mt-5")).getText());
		   
		   driver.quit();

	}

}
