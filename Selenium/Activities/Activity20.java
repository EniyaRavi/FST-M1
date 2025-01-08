import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Activity20 {

	public static void main(String[] args) {
		   WebDriver driver=new FirefoxDriver();
		
	       driver.get("https://training-support.net/webelements/alerts");
			
		   String title=driver.getTitle();
		   System.out.println("Title of the page is: "+title);
		   
           driver.findElement(By.id("prompt")).click();
		   
		   Alert alert=driver.switchTo().alert();
		    
		   String alertText=alert.getText();
		   System.out.println("Text in Alert is: "+alertText);
		   
		   alert.sendKeys("Awesome!");
		   
		   alert.accept();
		   
		   String message=driver.findElement(By.id("result")).getText();
		   System.out.println("Message after accepting alert is: "+message);
		   
		   driver.quit();

	}

}
