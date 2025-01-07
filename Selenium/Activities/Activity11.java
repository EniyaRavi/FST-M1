import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11 {

	public static void main(String[] args) {
		
        WebDriver driver=new FirefoxDriver();
		
        driver.get("https://training-support.net/webelements/dynamic-controls");
		
		String title=driver.getTitle();
		System.out.println("Title of the page is: "+title);

		
		WebElement checkbox=driver.findElement(By.id("checkbox"));
		System.out.println("Is Checkbox visible: "+checkbox.isDisplayed());
		
		driver.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(checkbox));
		
		driver.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();    	
		
		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
		
		System.out.println("Is Checkbox selected: "+checkbox.isSelected());
		
		driver.quit();
		

	}

}
