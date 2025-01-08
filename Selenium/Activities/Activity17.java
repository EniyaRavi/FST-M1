import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
public class Activity17 {

	public static void main(String[] args) {
		   WebDriver driver=new FirefoxDriver();
		
	       driver.get("https://training-support.net/webelements/selects");
			
		   String title=driver.getTitle();
		   System.out.println("Title of the page is: "+title);
		   
		   WebElement dropdown= driver.findElement(By.cssSelector("select.h-80"));
		   Select select=new Select(dropdown);
		   //List<WebElement> options=select.getOptions();
		   
		   select.selectByVisibleText("HTML");
		   for(int i=3;i<=5;i++) {
			   select.selectByIndex(i);
		   }
		   
		   select.selectByValue("nodejs");
		  
		   List<WebElement> selectedOptions=select.getAllSelectedOptions();
		   System.out.println("Selected Options are:");
		   for(WebElement selectedOption:selectedOptions) {
		   System.out.println(selectedOption.getText());
		   }
		   
		   select.deselectByIndex(4);
		   selectedOptions=select.getAllSelectedOptions();
		   System.out.println("Selected Options are:");
		   for(WebElement selectedOption:selectedOptions) {
		   System.out.println(selectedOption.getText());
		   }
		   
		   
		   driver.quit();
	}

}
