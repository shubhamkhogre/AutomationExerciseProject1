package Project_TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC07_TestNG_VerifyTestCases_Page 
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
		//click on TestCases button
		driver.findElement(By.xpath("(//li/a)[5]")).click();
	}
	
	@Test(priority = 2)
	public void verifynavigatedtoTestCasesPage()
	{
		//verify navigated to tc page
		boolean TestCasesPage = driver.findElement(By.xpath("(//div/h2)[1]")).isDisplayed();
		assertTrue(TestCasesPage, "Not Navigated to TestCases Page");	
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	

}
