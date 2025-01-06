import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();

		driver.get("https://training-support.net/webelements/login-form");
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
		driver.findElement(By.xpath("	")).click();

		String message = driver.findElement(By.xpath("//h1[contains(text(),'Success!')]")).getText();
		System.out.println("Message after login is: " + message);
		
		driver.quit();

		
//		  driver.get("https://training-support.net/");
//		  
//		  String title1=driver.getTitle();
//		  System.out.println("Title of the page is: "+title1);
//		
//		  driver.findElement(By.xpath("//a[text()='About Us']")).click(); String
//		  newTitle1=driver.getTitle();
//		  System.out.println("New Title of the page is: "+newTitle1);
//		  
//		  driver.quit();
		 

	}

}
