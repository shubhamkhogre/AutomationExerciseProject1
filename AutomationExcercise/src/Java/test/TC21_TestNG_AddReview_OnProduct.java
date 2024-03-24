package Project_TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC21_TestNG_AddReview_OnProduct 
{
	WebDriver driver;
	
	@BeforeClass
	public void OpenBrowserSetup()
	{
		//launch browser
		System.setProperty("webdriver.driver.chrome", "C:\\July21B_Selenium2023\\chromedriver 122\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//navigate to url
		driver.get("https://automationexercise.com/");
	}
	
	@Test(priority = 1)
	public void VerifyNavigatedtoAllProductsPage() throws InterruptedException
	{
		//click on products button
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//li/a)[2]")).click();
		
		//verify user navigated to All Product Page
		Thread.sleep(5000);
		String Productpage=driver.getTitle();
		assertEquals(Productpage, "Automation Exercise - All Products", "Not Navigated to All Products Page");
		
		//click on view product
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='View Product'])[1]")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void VerifyWriteYourReviewVisible() throws InterruptedException
	{
		boolean text = driver.findElement(By.xpath("//a[contains(@href,'reviews')]")).isDisplayed();
		assertTrue(text, "Write Your Review Not Visible");
		
		//enter name, email and review & click on submit
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Shubhamk");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("shuprakho@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//textarea[@placeholder='Add Review Here!']")).sendKeys("products are very good!");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
	}
	
	@Test(priority = 3)
	public void VerifyReviewSuccessMessageDisplayed()
	{
		boolean review = driver.findElement(By.xpath("(//div[@class='alert-success alert'])[1]")).isDisplayed();
		assertTrue(review, "review message not displayed");
	}
	
	@AfterClass
	public void CloseBrowser()
	{
		driver.close();
	}
}
