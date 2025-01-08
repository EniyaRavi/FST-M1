import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Activity18 {

	public static void main(String[] args) {
		   WebDriver driver=new FirefoxDriver();
		
	       driver.get("https://training-support.net/webelements/alerts");
			
		   String title=driver.getTitle();
		   System.out.println("Title of the page is: "+title);
		   
		   driver.findElement(By.id("simple")).click();
		   
		   Alert alert=driver.switchTo().alert();
		   
		   System.out.println("Text in Alert is: "+alert.getText());
		   
		   alert.accept();
		   
		   System.out.println("Message is: "+driver.findElement(By.id("result")).getText());
		   
		   driver.quit();

	}

}
