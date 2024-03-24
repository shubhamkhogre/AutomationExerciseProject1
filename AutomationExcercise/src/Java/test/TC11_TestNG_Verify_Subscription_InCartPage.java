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

public class TC11_TestNG_Verify_Subscription_InCartPage 
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
		//click on cart page
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//li/a)[3]")).click();
		
		Thread.sleep(2000);
		//scroll to bottom of page
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,8500)");
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void verifySubscriptiontextDisplayedinCart() throws InterruptedException
	{
		//verify subscription is displayed in cart
		boolean subscart = driver.findElement(By.xpath("//div/h2")).isDisplayed();
		assertTrue(subscart, "SUBSCRIPTION Not Visible in Cart");
		
		//enter email & click on submit button
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("www@gmail.com");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@Test(priority = 3)
	public void verifySuccessMessageDisplayedInCart()
	{
		//verify success messg displayed in cart
		boolean successcart = driver.findElement(By.xpath("//div[@class='alert-success alert']")).isDisplayed();
		assertTrue(successcart, "'You have been successfully subscribed!' is Not Visible in Cart");
	}
	
	@AfterClass
	public void CloseBrowser()
	{
		driver.close();
	}

}
