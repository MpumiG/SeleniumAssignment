package assignment_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;

public class Assigment6 
{
	WebDriver driver;
	String flipkartURL = "http://www.flipkart.com";
	// declares driver as WebDriver and declares flipkartURL as String
	
	public void invokeBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "C://Users/User/workspace_1/geckodriver-v0.24.0-win64/geckodriver.exe");
		// sets the property the Firefox Browser
		
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get(flipkartURL);	
	}
	
	public void browserNavigation()
	{
		//Actions action = new Actions(driver);
		
		WebElement email_Number = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input"));
		email_Number.sendKeys("selenium@hongpress.com");
		// Locates the element and inputs the email address into it.
		
		WebElement password = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input"));
		password.sendKeys("Jeff0045");
		// Locates the element and inputs the password into it.
		
		WebElement loginButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button"));
		loginButton.click();
		// Locates the button and clicks it.
	}

	public static void main(String[] args)
	{
		Assigment6 assignment = new Assigment6();
		
		assignment.invokeBrowser();
		assignment.browserNavigation();
	}

}
