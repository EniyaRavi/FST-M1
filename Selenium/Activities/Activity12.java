import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Activity12 {

	public static void main(String[] args) {
		
        WebDriver driver=new FirefoxDriver();
		
        driver.get("https://training-support.net/webelements/dynamic-content");
		
		String title=driver.getTitle();
		System.out.println("Title of the page is: "+title);
		
		driver.findElement(By.xpath("//button[text()='Click me!']")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("word"), "release"))) {
		System.out.println("Word is: "+driver.findElement(By.id("word")).getText());
		}
		
		driver.quit();

	}

}
