package assignment_2;

import java.util.concurrent.TimeUnit;
//importing TimeUnit
import org.openqa.selenium.By;
//importing "By" for the location of the attributes
import org.openqa.selenium.chrome.ChromeDriver;
//importing ChromeDriver

public class Assignment2 
{
	ChromeDriver driver;
	//assigning ChromeDrive to "driver"
	String facebookURL = "http://www.fb.com";
	
	public void invokeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users/User/workspace_1/chromedriver.exe");
		//Sets the path of the chromedriver
		
		driver = new ChromeDriver();
		// assigns the ChromeDriver to driver
		
		driver.manage().window().maximize();
		//maximizes browser window
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//implicitly waits 10 seconds to solve any sync issues
		
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS); 
		//Gives webpage 50 seconds to load.
		
		driver.get(facebookURL);
		//loads the URL of facebook
		
		
		if(facebookURL.equals("http://www.fb.com"))
		{
			driver.navigate().to("https://facebook.com");
		}		
	}
	
	public void fbSignUp()
	{
		driver.findElement(By.name("firstname")).sendKeys("Paul");	
		// finds the 'First Name' element by name and enters the text "Selenium" in the text box
		
		driver.findElement(By.name("lastname")).sendKeys("Tracey");
		// finds the 'Surname' element by name and enters the text "Test"
		
		driver.findElement(By.name("reg_email__")).sendKeys("selTester@hotmail.com");
		// finds the 'Email address / Mobile number' element by name and enters the text "selTester@hotmail.com"
		
		driver.findElement(By.name("reg_passwd__")).sendKeys("p@$sW0rD_1^6");
		// finds the Password element by name and enters the text "p@$sW0rD_1^6"
		
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("selTester@hotmail.com");
		// finds the 'Re-enter Email Address' element and enters the same email text under email
		
		driver.findElement(By.id("day")).sendKeys("16");
		// finds the day of the Birthday element by id and enters "23"
		
		driver.findElement(By.id("month")).sendKeys("Feb");
		// finds the month of the Birthday element by id and enters "Feb"
		
		driver.findElement(By.id("year")).sendKeys("1984");
		// finds the year of the Birthday element by id and enters "1984"
		
		driver.findElement(By.xpath("//input [@value='2']")).click();
		// finds the xpath of the radio button and looks for "value='2' if found, it the program clicks the radio button"
		
		driver.findElement(By.name("websubmit")).click();
		// finds the element of the "Sign Up" button and clicks it
	}

	public static void main(String[] args) 
	{
		Assignment2 assignment = new Assignment2();
		// assigns class Assignment2 as "assignmemt"
		assignment.invokeBrowser();
		//executes the invokeBrowser method
		assignment.fbSignUp();
		//executes the fbSignUp method	
	}
}
