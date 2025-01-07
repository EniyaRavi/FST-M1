import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        WebDriver driver=new FirefoxDriver();
		
        driver.get("https://training-support.net/webelements/drag-drop");
		
		String title=driver.getTitle();
		System.out.println("Title of the page is: "+title);
		
		Actions builder=new Actions(driver);
		
		WebElement ball=driver.findElement(By.id("ball"));
		WebElement dropZone1=driver.findElement(By.id("dropzone1"));
		WebElement dropZone2=driver.findElement(By.id("dropzone2"));
		
		builder.dragAndDrop(ball, dropZone1).build().perform();
		if(driver.findElement(By.className("dropzone-text")).getText().equals("Dropped!")) {
			System.out.println("Ball is dropped in DropZone 1!!");
		}
		
		builder.dragAndDrop(dropZone1, dropZone2).build().perform();
		if(driver.findElement(By.className("dropzone-text")).getText().equals("Dropped!")) {
			System.out.println("Ball is dropped in DropZone 2!!");
		}
		
		driver.quit();		

	}

}
