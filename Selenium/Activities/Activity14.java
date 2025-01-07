import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Activity14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		
	       driver.get("https://training-support.net/webelements/tables");
			
		   String title=driver.getTitle();
		   System.out.println("Title of the page is: "+title);
		   
		   List<WebElement> rows=driver.findElements(By.xpath("//table/tbody/tr"));
		   System.out.println("No. of Rows: "+rows.size());
		   
		   List<WebElement> columns=driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
		   System.out.println("No. of Columns: "+columns.size());
		   
		   WebElement value=driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
		   System.out.println("Book Name in 5th Row before sorting: "+value.getText());
		   
		   driver.findElement(By.xpath("//table/thead/tr/th[5]")).click();
		   
		   WebElement sortedValue=driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
		   System.out.println("Book Name in 5th Row after sorting: "+sortedValue.getText());
		   
		   driver.quit();
		   
		   
		   driver.quit();
		   

	}

}
