import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
public class Activity8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		
        driver.get("https://training-support.net/webelements/mouse-events");
		
		String title=driver.getTitle();
		System.out.println("Title of the page is: "+title);
		
		Actions builder= new Actions(driver);
		WebElement cargoLock=driver.findElement(By.xpath("//h1[text()='Cargo.lock']"));
		WebElement cargoToml=driver.findElement(By.xpath("//h1[text()='Cargo.toml']"));
		WebElement src=driver.findElement(By.xpath("//h1[text()='src']"));
		WebElement target=driver.findElement(By.xpath("//h1[text()='target']"));
		
		builder.click(cargoLock).moveToElement(cargoToml).click().build().perform();
		String message=driver.findElement(By.id("result")).getText();
		System.out.println("Message is: "+message);
		
		builder.doubleClick(src).contextClick(target).build().perform();
		
		//WebElement openTarget=driver.findElement(By.xpath("//div[@id='menu']/div/ul/li[1]"));
		
		builder.click(driver.findElement(By.xpath("//div[@id='menu']/div/ul/li[1]"))).build().perform();
		
		String message1=driver.findElement(By.id("result")).getText();
		System.out.println("Message is: "+message1);
		
		driver.quit();

	}

}
