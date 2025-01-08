import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Activity19 {

	public static void main(String[] args) {
		   WebDriver driver=new FirefoxDriver();
		
	       driver.get("https://training-support.net/webelements/alerts");
			
		   String title=driver.getTitle();
		   System.out.println("Title of the page is: "+title);
		   
		   driver.findElement(By.id("confirmation")).click();
		   
		   Alert alert=driver.switchTo().alert();
		    
		   String alertText=alert.getText();
		   System.out.println("Text in Alert is: "+alertText);
		   
//		   alert.accept();
//		   String acceptMessage=driver.findElement(By.id("result")).getText();
//		   System.out.println("Message after accepting alert is: "+acceptMessage);
		   
		   alert.dismiss();
		   String dismissMessage=driver.findElement(By.id("result")).getText();
		   System.out.println("Message after accepting alert is: "+dismissMessage);
		   
		   
		   driver.quit();
	}

}
