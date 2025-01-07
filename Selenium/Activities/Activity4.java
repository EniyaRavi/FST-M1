import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver =new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/target-practice");
		String title=driver.getTitle();
		System.out.println("Title of the page is: "+title);
		
		String thirdHeaderText=driver.findElement(By.xpath("//h3[contains(text(),'#3')]")).getText();
		System.out.println("3rd Header is: "+thirdHeaderText);
		
		String fifthHeaderColor=driver.findElement(By.xpath("//h5[contains(text(), '#5')]")).getCssValue("color");
		System.out.println("5th Header color is: "+fifthHeaderColor);
		
		driver.quit();

	}

}
