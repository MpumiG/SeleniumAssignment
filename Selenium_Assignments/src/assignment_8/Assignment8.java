package assignment_8;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 
{

	WebDriver driver;
	String gmailURL = "https://www.gmail.com";
	
	public void invokeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users/User/workspace_1/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get(gmailURL);
	}
	
	public void signIn()
	{
		WebElement emailSignIn = driver.findElement(By.xpath("//input[@type='email']"));
		emailSignIn.sendKeys("blur77.mg@gmail.com");
		// Locates the element for typing in the email, and send the text to it.
		
		driver.findElement(By.xpath("//*[@id='identifierNext']/span/span")).click();
		// clicks the next button
		
		WebElement passwordSignIn = driver.findElement(By.name("password"));
		passwordSignIn.sendKeys("NeoBlur#21");
		// Locates the element for the password input box, then types the password.
		
		driver.findElement(By.xpath("//*[@id='passwordNext']/span/span")).click();
		// clicks the next button
	}
	
	public void emailNavigation()
	{
		driver.findElement(By.className("z0")).click();
		// after login, it clicks the compose button and opens the box to send an email.
	}
	
	public void composeWindow()
	{
		WebElement emailRecipient = driver.findElement(By.cssSelector(".oj div textarea"));
		emailRecipient.sendKeys("mpumigugushe@ymail.com");
		// Find the email To element through the CSS selector. After which it puts in the recipient email address
		
		WebElement emailSubject = driver.findElement(By.name("subjectbox"));
		emailSubject.sendKeys("Test Mail");
		// Types the text "Test Mail" in the subject line
		
		WebElement emailTextBox = driver.findElement(By.cssSelector(".Ar.Au div"));
		// Finds the element for the email
		emailTextBox.sendKeys("Hey" + Keys.ENTER + Keys.ENTER + "Don't Worry" + Keys.ENTER + Keys.ENTER + "This is a Test email" + 
							  Keys.ENTER + Keys.ENTER + "Regards," + Keys.ENTER + "Me");
		
		driver.findElement(By.cssSelector(".dC div")).click();
		// locates the send button and sends the email
	}
	
	public static void main(String[] args) 
	{
		Assignment8 assignment = new Assignment8();
		
		assignment.invokeBrowser();
		assignment.signIn();
		assignment.emailNavigation();
		assignment.composeWindow();
	}

}
