package Project_TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC05_TestNG_RegUser_WithExistingEmail 
{
WebDriver driver;
	
	@BeforeClass
	public void openbrowserSetup()
	{	//launch browser
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
	public void signupText() throws InterruptedException
	{
		//click on ' Signup / Login' button
		driver.findElement(By.xpath("//a[contains(text(),' Signup / Login')]")).click();
		//verify 'New User Signup!' Visible
		boolean signUpText = driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed();
		assertTrue(signUpText, "New User Signup! Not Visible");
		Thread.sleep(2000);
		
		//enter name & email address
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("kailas");
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("kailas1234@gmail.com");
		//click on signup button
		driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
	}
	
	@Test(priority = 3)
	public void verifyErrorMessage()
	{
		boolean errormessg = driver.findElement(By.xpath("//p[text()='Email Address already exist!']")).isDisplayed();
		assertTrue(errormessg, "'Email Address already exist!' is Not Visible");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		//close the browser
		driver.close();
	}
	

}
