package assignment_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment5 
{
	WebDriver driver;
	String snapdealURL = "https://www.snapdeal.com/";
	// declaring the driver and the URL of Snapdeal
	
	String status;
	
	public void invokeBrowser()
	{	
		System.setProperty("webdriver.chrome.driver", "C://Users/User/workspace_1/chromedriver.exe");
		// sets the ChromeDriver
		
		driver = new ChromeDriver();
		// assigns driver to the ChromeDriver
		
		driver.get(snapdealURL);
		// loads the URL
		
		driver.manage().window().maximize();
	}
	
	
	public void siteNavigation()
	{
		Actions action = new Actions(driver);
		// Instantiating an object of Action class
		
		WebElement signIn = driver.findElement(By.className("accountInner"));
		// Locates the element and assigns it to "signIn" of the WebElement class
				
		action.moveToElement(signIn).perform();
		// Pass the WebElement to be mouse hovered as parameter.
		// Then call the perform() method to perform the generated action.
		
		driver.findElement(By.xpath("//*[@id='sdHeader']/div[4]/div[2]/div/div[3]/div[3]/div/div/div[2]/div[2]/span[2]/a")).click();
		// clicks the login button		
	}
	
	
	public void newFrame()
	{
		WebElement signInFrame = driver.findElement(By.id("loginIframe"));
		// locates the frame and stores it in "signInFrame"
		
		driver.switchTo().frame(signInFrame);
		// switches to the frame so the statements below can execute
		
		driver.findElement(By.className("col-xs-24")).sendKeys("selenium@hongpress.com");
		// type the email in the empty box
		
		driver.findElement(By.id("checkUser")).click();
		// clicks the 'continue' button
	}
	
	public static void main(String[] args)
	{
		Assignment5 assignment = new Assignment5();
		
		assignment.invokeBrowser();
		assignment.siteNavigation();
		assignment.newFrame();
	}

}
