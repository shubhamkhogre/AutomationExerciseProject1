package Project_TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC06_TestNG_ContactUs_Form 
{
	WebDriver driver;
	
	@BeforeClass
	public void openBrowserSetup()
	{
		//launch browser
		System.setProperty("webdriver.driver.chrome", "C:\\July21B_Selenium2023\\chromedriver 122\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//navigate to url
		driver.get("https://automationexercise.com/");
	}
	
	@Test(priority = 1)
	public void homepagetitleVerification() throws InterruptedException
	{
		//verify homepage visible successfully
		String title=driver.getTitle();
		assertEquals(title, "Automation Exercise", "HomePage is not Visible");
		Thread.sleep(2000);
		//click on contact us button
		driver.findElement(By.xpath("(//li/a)[8]")).click();
	}
	
	@Test(priority = 2)
	public void verifyGetInTouchVisible() throws InterruptedException
	{
		//verify 'GET IN TOUCH' is Not visible
		boolean text = driver.findElement(By.xpath("(//div/h2)[2]")).isDisplayed();
		assertTrue(text, "'GET IN TOUCH' is Not visible");
		
		//Enter name, email, subject and message & Upload file
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@data-qa='name']")).sendKeys("sk");
		driver.findElement(By.xpath("//input[@data-qa='email']")).sendKeys("shuprakho@gmail.com");
		driver.findElement(By.xpath("//input[@data-qa='subject']")).sendKeys("Funny Experience with Customer Service: Unbelievable!");
		driver.findElement(By.xpath("//div/textarea[@data-qa='message']")).sendKeys("The subject line piques curiosity with the mention of a funny experience with customer service. The use of \"Unbelievable!\" adds an element of surprise, increasing the recipient's interest. Overall, it creates intrigue and entices the reader to open the email.");
		driver.findElement(By.name("upload_file")).sendKeys("C:\\Users\\DELL\\Downloads\\pxfuel.jpg");
		//click on submit button
		driver.findElement(By.xpath("//input[@data-qa='submit-button']")).click();
		//Click OK button
		Alert alt = driver.switchTo().alert();
		alt.accept();
		Thread.sleep(2000);	
	}
	
	@Test(priority = 3)
	public void verifySuccessMessage() throws InterruptedException
	{
		boolean success = driver.findElement(By.xpath("(//div[text()='Success! Your details have been submitted successfully.'])[1]")).isDisplayed();
		assertTrue(success, "'Success! Your details have been submitted successfully.' is Not Visible");
		
		//click on Home Page
		driver.findElement(By.xpath("//a/span")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority = 4)
	public void verifyhomepageLanded()
	{
		//verify homepage visible successfully
		String title1=driver.getTitle();
		assertEquals(title1, "Automation Exercise", "Not Landed to HomePage Successfully");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		//close the browser
		driver.close();
	}
	
	

}
