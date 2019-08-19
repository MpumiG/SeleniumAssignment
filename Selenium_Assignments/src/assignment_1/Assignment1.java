package assignment_1;


import java.util.concurrent.TimeUnit; 
//Importing TimeUnit

import org.openqa.selenium.firefox.FirefoxDriver; 
//Importing FirefoxDriver


public class Assignment1 
{
	
	FirefoxDriver driver;
	// Creating an instance of Firefox Browser
	
	String qatechhubURL = "http://qatechhub.com";
	String facebookURL = "https://facebook.com";
	
	public void invokeBrowser()
	{
		System.setProperty("webdriver.gecko.driver","C://Users/User/workspace_1/geckodriver-v0.24.0-win64/geckodriver.exe"); 
		//Setting the path of the gekkodriver
		
		driver = new FirefoxDriver(); 
		// assigns the FirefoxDriver into driver
		
		driver.manage().window().maximize(); 
		// Maximizes the browser window
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); 
		//Gives webpage 20 seconds to load.
		
		driver.get(qatechhubURL); 
		//loads the URL of qatechhub 
		
		String pageTitle = driver.getTitle(); 
		//gets the title of the webpage
		
		
		if(pageTitle.equals ("QA Automation Tools Trainings and Tutorials | QA Tech Hub")) 
			// If the title of the webpage is "QA Automation Tools Trainings and Tutorials" or "QA Tech Hub"...
		{
			System.out.println("Test Case: PASS"); 
			//print PASS if the statement is true 
		} 
		else
		{
			System.out.println("Test Case: FAIL"); 
			//print FAIL is statement is false
		}
		
	}
	
	public void navigateCommands()
	{
		driver.navigate().to(facebookURL);
		//after the execution of the last test, the browser navigates to facebook.
		
		String currentURL = driver.getCurrentUrl(); 
		//gets the URL of the currently opened page in the browser, then declares the method as "currentURL"
		
		driver.navigate().back();
		// navigates back to the QA Tech Hub website
		
		System.out.println ("Current URL :: " + currentURL);
		// prints the URL of the current site
		
		driver.navigate().forward();
		//navigates the page forward
		
		driver.navigate().refresh();
		// refreshes the page
		
	}
	
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("Status :: " + "Browser is Closed");
	}
		
	
	public static void main(String[] args) 
	{
		Assignment1 assignment = new Assignment1();
		// assigns class Assignment1 as "assignmemt"
		assignment.invokeBrowser();
		//executes the invokeBrowser method
		assignment.navigateCommands();
		//executes the navigateCommands method
		assignment.closeBrowser();
		//closes the browser
	}

}
