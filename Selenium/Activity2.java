import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/login-form");
		String title=driver.getTitle();
		System.out.println("Title of the page is: "+title);
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		String message=driver.findElement(By.tagName("h1")).getText();
		System.out.println("Message after login is: "+message);
		
		driver.quit();
		

	}

}
