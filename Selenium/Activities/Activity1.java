import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://training-support.net/");
		
		String title=driver.getTitle();
		System.out.println("Title of the page is: "+title);
		
		driver.findElement(By.linkText("About Us")).click();
		
		String newTitle=driver.getTitle();
		System.out.println("New Title is: "+newTitle);
		
		driver.quit();

	}

}
