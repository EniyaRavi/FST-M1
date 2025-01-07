import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
public class Activity6 {

	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		
        driver.get("https://training-support.net/webelements/dynamic-controls");
		
		String title=driver.getTitle();
		System.out.println("Title of the page is: "+title);
		
		WebElement checkbox=driver.findElement(By.id("checkbox"));
		System.out.println("Is Checkbox displayed: "+checkbox.isSelected());
		
		checkbox.click();
		System.out.println("Is Checkbox displayed: "+checkbox.isSelected());
		
		driver.quit();
	}

}
