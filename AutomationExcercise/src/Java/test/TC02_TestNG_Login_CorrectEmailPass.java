package Project_TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC02_TestNG_Login_CorrectEmailPass 
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
	}
	
	@Test(priority = 2)
	public void loginText()
	{
		//click on ' Signup / Login' button
		driver.findElement(By.xpath("//a[contains(text(),' Signup / Login')]")).click();
		
		// Verify 'Login to your account' is visible
		boolean loginText = driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed();
		assertTrue(loginText, "LoginIn to your Account Not visible");
		//enter login details & click login button
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("sraina@gmail.com");
		driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("sraina");
		driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
	}
	
	@Test(priority = 3)
	public void loginasusernameVisible() throws InterruptedException
	{
		//verify login as username vivible
		boolean loginasUN = driver.findElement(By.xpath("//a[text()=' Logged in as ']/b[text()='sraina']")).isDisplayed();
		assertTrue(loginasUN, "Logged in as UserName Not Visible");
				
		//click on delete account
		driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 4)
	public void verifyaccountDeleted()
	{
		//verify acc deleted
		boolean accdeleted = driver.findElement(By.xpath("//b[text()='Account Deleted!']")).isDisplayed();
		assertTrue(accdeleted, "Account Deleted Not Vissible");
				
		//click on continue button
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		//close the browser
		driver.close();
	}

}
