package activities;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
	
	WebDriver driver;
	
	@BeforeClass (alwaysRun=true)
	public void setUp() {
		driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice");
	}
	
	@Test (groups= {"HeaderTest", "ButtonTest"})
	public void pageTitleTest() {
		String title=driver.getTitle();
		System.out.println("Page title is: "+title);
		Assert.assertEquals("Selenium: Target Practice", title);
	}
	
	@Test (dependsOnMethods={"pageTitleTest"}, groups= {"HeaderTest"})
	public void headerTest1() {
		WebElement header3=driver.findElement(By.xpath("//h3[contains(@class,'orange')]"));
		Assert.assertEquals("Heading #3", header3);
	}
	
	@Test (dependsOnMethods={"pageTitleTest"}, groups= {"HeaderTest"})
	public void headerTest2() {
		Color header5Color = Color.fromString(driver.findElement(By.cssSelector("h5.text-purple-600")).getCssValue("color"));
        Assert.assertEquals(header5Color.asHex(), "#9333ea");
	}
	
	@Test (dependsOnMethods={"pageTitleTest"}, groups= {"ButtonTest"})
	public void buttonTest1() {
		WebElement button1 = driver.findElement(By.xpath("//button[contains(@class, 'emerald')]"));
        Assert.assertEquals(button1.getText(), "Emerald"); 
	}
	
	@Test (dependsOnMethods={"pageTitleTest"}, groups= {"ButtonTest"})
	public void ButtonTest2() {
        Color button2Color = Color.fromString(driver.findElement(By.xpath("//button[contains(@class, 'purple')]")).getCssValue("color"));
        Assert.assertEquals(button2Color.asHex(), "#581c87");
    }
	
	
	@AfterClass (alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}

}
