import org.apache.poi.ddf.EscherColorRef.SysIndexProcedure;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
public class Activity9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
WebDriver driver=new FirefoxDriver();
		
        driver.get("https://training-support.net/webelements/keyboard-events");
		
		String title=driver.getTitle();
		System.out.println("Title of the page is: "+title);
		
		Actions builder=new Actions(driver);
		
		builder.sendKeys("This is coming from Selenium").build().perform();
		
		String pageTitle=driver.findElement(By.cssSelector("h1.mt-3")).getText();
		System.out.println("Text is: "+pageTitle);
		
		driver.quit();

	}

}
