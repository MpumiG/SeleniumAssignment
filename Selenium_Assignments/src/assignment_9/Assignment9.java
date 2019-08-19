package assignment_9;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment9 
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
		
		driver.findElement(By.xpath("//*[@id='identifierNext']/span/span")).click();
		
		WebElement passwordSignIn = driver.findElement(By.name("password"));
		passwordSignIn.sendKeys("NeoBlur#21");
		
		driver.findElement(By.xpath("//*[@id='passwordNext']/span/span")).click();
	}
	
	public void emailCount()
	{
		WebElement emailList = driver.findElement(By.xpath("//*[@id=':kz']/span/span[2]"));
		System.out.println("");
		System.out.println("Total Emails in Primary tab: " + emailList.getText());
		System.out.println("");
	}
	
	public void getNthSenderSubject()
	{
		WebElement nthEmail = driver.findElement(By.xpath("//*[@id=':54']"));
		
		String nthSender = nthEmail.findElement(By.xpath("//*[@class='yW']/span/span")).getText();
		//Selecting the Nth email sender
		
		String nthSubject = nthEmail.findElement(By.xpath("//*[@class='bog']/span")).getText();
		//Selecting the Nth email subject
		
		System.out.println("Sender of the mail: " + nthSender);
		System.out.println("Subject of the mail: " + nthSubject);
		System.out.println("");
	}
	
	public void getSenderSubject()
	{
		String sender = driver.findElement(By.xpath("//*[@id=':34']/span/span")).getText(); 
		// gets the name of the sender
		
		String subject = driver.findElement(By.xpath("//*[@id=':37']/span")).getText();
		// gets the subject of the email
		
		System.out.println("Sender of the mail: " + sender);
		System.out.println("Subject of the mail: " + subject);
	}
	
	public static void main(String[] args) 
	{
		Assignment9 assignment = new Assignment9();
		assignment.invokeBrowser();
		assignment.signIn();
		assignment.emailCount();
		assignment.getNthSenderSubject();
		assignment.getSenderSubject();
	} 

}
