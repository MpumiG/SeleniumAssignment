package assignment_3;

import org.openqa.selenium.By;
//Imports By
import org.openqa.selenium.WebDriver;
//Imports WebDriver
import org.openqa.selenium.WebElement;
//Imports WebElement
import java.util.List;
//Imports list
import java.util.concurrent.TimeUnit;
//Imports TimeUnit
import org.openqa.selenium.chrome.ChromeDriver;
//Imports ChromeDriver

public class Assignment_3 
{
	
	WebDriver driver;
	// Declares driver as type: WebDriver
	String flipkartURL = "https://www.flipkart.com";
	// declares the string URL of the Flipkart website 
	String otherURL = "";
	// declares the string of another website
	int linkCount;
	// declares linkCount as an integer
	
	
	public void invokeBrowser()
	{	
		System.setProperty("webdriver.chrome.driver", "C://Users/User/workspace_1/chromedriver.exe");
		// Sets the path of the chromedriver
		
		driver = new ChromeDriver();
		// assigns driver to ChromeDriver
		
		driver.manage().window().maximize(); 
		// Maximizes the browser window
		
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS); 
		//Gives webpage 50 seconds to load.
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//implicitly waits 10 seconds to solve any sync issues
		
		driver.get(flipkartURL);
		// loads the URL of Flipkart.com
	}
	
	public void linkCount()
	{
		List <WebElement> linkCounter =  driver.findElements(By.xpath("//*"));
	    // Identifies the number of links on the whole webpage and assigns them into WebElement List
		
		linkCount = linkCounter.size();
		// Counts the total link list on the Web Page	
		
		System.out.println("Total Number of links on the Webpage = " + linkCount);
	}

	public static void main(String[] args) 
	{
		Assignment_3 assignment = new Assignment_3();
		// assigns class Assignment_3 as "assignment"
		assignment.invokeBrowser();
		// executes the invokeBrowser() method
		assignment.linkCount();
		// executes the linkCount() method	
	}

}
