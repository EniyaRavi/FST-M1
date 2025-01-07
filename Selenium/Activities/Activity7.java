import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
public class Activity7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		
        driver.get("https://training-support.net/webelements/dynamic-controls");
		
		String title=driver.getTitle();
		System.out.println("Title of the page is: "+title);
		
		WebElement inputField=driver.findElement(By.id("textInput"));
		
		//driver.findElement(By.id("textInputButton")).click();
		System.out.println("Is Input field enabled: "+inputField.isEnabled());
		
		driver.findElement(By.id("textInputButton")).click();
		System.out.println("Is Input field enabled: "+inputField.isEnabled());
		
		driver.quit();

	}

}
