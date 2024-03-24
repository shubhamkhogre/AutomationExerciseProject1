package Project_TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC03_TestNG_Login_IncorrectEmailPass 
{
	WebDriver driver;
	
	@BeforeClass
	public void openbrowserSetup()
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
		assertTrue(loginText, "'LoginIn to your Account' Not visible");
		//enter login details & click login button
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("sssraina@gmail.com");
		driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("sraina");
		driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
	}
	
	@Test(priority = 3)
	public void verifyErrorMessage()
	{
		boolean errormessg = driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']")).isDisplayed();
		assertTrue(errormessg, "'Your email or password is incorrect!' is visible");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		//close the browser
		driver.close();
	}
	
	

}
