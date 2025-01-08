import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
public class Activity16 {

	public static void main(String[] args) {
		
		   WebDriver driver=new FirefoxDriver();
		
	       driver.get("https://training-support.net/webelements/selects");
			
		   String title=driver.getTitle();
		   System.out.println("Title of the page is: "+title);
		   
		   WebElement dropdown= driver.findElement(By.cssSelector("select.h-10"));
		   
		   Select select=new Select(dropdown);
		   
		   select.selectByVisibleText("Two");
		   System.out.println("Second option is: "+select.getFirstSelectedOption().getText());
		   
		   select.selectByIndex(3);
		   System.out.println("Third option is: "+select.getFirstSelectedOption().getText());
		   
		   select.selectByValue("four");
		   System.out.println("Fourth option is: "+select.getFirstSelectedOption().getText());
		   
		   List<WebElement> options=select.getOptions();
		   System.out.println("Options in dropdown:");
		   for(WebElement option: options) {
			   System.out.println(option.getText());   
		   }
		   
		   driver.quit();
		   

	}

}
