package Project_TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC10_TestNG_Verify_SubscriptionIn_Homepage 
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
		
		//scroll to bottom of page
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,8500)");
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void verifySubscriptionTextDisplayed() throws InterruptedException
	{
		boolean Substext = driver.findElement(By.xpath("(//div/h2)[82]")).isDisplayed();
		assertTrue(Substext, "'SUBSCRIPTION' Not Visible");
		
		Thread.sleep(5000);
		//enter email & click on submit
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("kkk@gmail.com");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@Test(priority = 3)
	public void verifySuccessMessageDisplayed()
	{
		//verify success message is displayed
		boolean message = driver.findElement(By.xpath("//div[@class='alert-success alert']")).isDisplayed();
		assertTrue(message, "'You have been successfully subscribed!' is Not Visible");
	}
	
	@AfterClass
	public void CloseBrowser()
	{
		driver.close();
	}

}
