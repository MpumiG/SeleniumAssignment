package assignment_7;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment7 
{
	WebDriver driver;
	String jQueryUi = "http://jqueryui.com/droppable/";
	
	public void invokeBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "C://Users/User/workspace_1/geckodriver-v0.24.0-win64/geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get(jQueryUi);		
	}
	
	public void dragDrop()
	{
		WebElement newFrame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(newFrame);
		// switches to the iframe with the className - "demo-frame"
		
		WebElement elementSource = driver.findElement(By.xpath("//*[@id='draggable']"));
				// gets the source locator and stores it in 'elementSource'
		
		WebElement elementTarget = driver.findElement(By.xpath("//*[@id='droppable']"));
		// gets the target locator and stores it in 'elementTarget'
		
		Actions action = new Actions(driver);
		// create object 'action' of Actions class. The constructor is defined by 'driver' 
		
		action.dragAndDrop(elementSource, elementTarget).build().perform();
		// uses the 'dragAndDrop() method.' It accepts two parameters: 'source' and 'target'. 
		// Then the methods, build() and perform() perform the drag and drop action	
	}
	
	public void assertion()
	{
		
	}
	
	public static void main(String[] args) 
	{
		Assignment7 assignment = new Assignment7();
		
		assignment.invokeBrowser();
		assignment.dragDrop();	
	}
}
