package assignment_4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment4 
{

	WebDriver driver;
	// declares driver as type WebDriver
	
	String ebayURL = "https://in.ebay.com";
	String interEbayURL = "https://https://www.ebay.com";
	// delaring the URLs of Ebay
	
	public void invokeBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "C://Users/User/workspace_1/geckodriver-v0.24.0-win64/geckodriver.exe");
		// sets the path of the geckodriver
		
		driver = new FirefoxDriver();
		// assigns driver to FirefoxDriver
		
		driver.manage().window().maximize();
		// maximizes the browser window
		
		driver.get(ebayURL);	
	}
	
	public void browserActions()
	{
		driver.findElement(By.name("_nkw")).sendKeys("Apple Watches");
		// finds the search box element by name and types in "Apple Watches"
		
		Select drpItems = new Select (driver.findElement(By.name("_sacat")));
		// declares the drop-down element as an instance of the Select class, and finds the dropdown by name
		
		drpItems.selectByVisibleText("Jewelry & Watches");
		// selects "Jewelry & Watches" from the dropdown
			
		driver.findElement(By.id("gh-btn")).click();
		// clicks the search button
		
	}
	
	public void printProductResult()
	{
		String product = new String (driver.findElement(By.xpath("//*[@data-view='mi:1686|iid:3']"))
			                               .findElement(By.className("s-item__link")).getText());
		// locates the element with a certain iid by xpath, then locates the element of the link by className
		
		System.out.println("Product is --> " + product);
		// returns the text of the product
		
		System.out.println("");
	}
	
	public void printAllProducts()
	{
		List <WebElement> productPage = driver.findElement(By.id("srp-river-main"))
		                                      .findElements(By.className("s-item__link"));
		// locates the entire element that holds all the products on that page by id, then locates the multiple elements on that page by className
		
		System.out.println("These are all the products on the page -->");
		
		for (int i=0; i<productPage.size();i++)
		// loops the process of finding the element until it reaches the end of the list	
		{
			System.out.println(productPage.get(i).getText());
			// returns the text of the elements using '.getText'
		}	
	}	
	
	
	public void printAllProductsScrollDown()
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		
		List <WebElement> productPage = driver.findElement(By.id("srp-river-main"))
				                              .findElements(By.className("s-item__link"));
	    // locates the entire element that holds all the products on that page by id, then locates the multiple elements on that page by className
		
		System.out.println("These are all the products on the page -->");

		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		// This scrolls down to the bottom of the page
		// Javascript method "scrollTo()" is used to scroll till the end of the page
		// "document.body.scrollHeight" returns the complete height of the body i.e web page
		
		//// jse.executeScript("arguments[60].scrollIntoView();", productPage); - Another way to scroll down.
		
		for (int i=0; i<productPage.size();i++)
		// loops the process of finding the element until it reaches the end of the list	
		{
			System.out.println(productPage.get(i).getText());
			// returns the text of the elements using '.getText'
		}		
	}
	
	public static void main(String[] args) 
	{
		Assignment4 assignment = new Assignment4();
		// assigns Assignment_4 as "assignment"
		
		assignment.invokeBrowser();
		// executes the invokeBrowser method
		
		assignment.browserActions();
		// executes the browserActions method
		
		assignment.printProductResult();
		// executes the printProductResult method
		
		////assignment.printAllProducts();
		// executes the printAllProducts method
		
		assignment.printAllProductsScrollDown();
		// executes the printAllPageProductsScrollDown method
	}
}
