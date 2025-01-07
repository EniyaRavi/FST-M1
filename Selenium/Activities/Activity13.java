import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Activity13 {

	public static void main(String[] args) {
	       WebDriver driver=new FirefoxDriver();
			
	       driver.get("https://training-support.net/webelements/tables");
			
		   String title=driver.getTitle();
		   System.out.println("Title of the page is: "+title);
		   
		   List<WebElement> rows=driver.findElements(By.xpath("//table/tbody/tr"));
		   System.out.println("No. of Rows: "+rows.size());
		   
		   List<WebElement> columns=driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
		   System.out.println("No. of Columns: "+columns.size());
		   
		   List<WebElement> thirdRow=driver.findElements(By.xpath("//table/tbody/tr[3]/td"));
		   System.out.println("Third Row cell values:");
		   for(WebElement cell:thirdRow) {
		   System.out.println(cell.getText());
		   }
		   
		   WebElement value=driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
		   System.out.println("Second Row Second Column value is: "+value.getText());
		   
		   driver.quit();
		   
	}

}
