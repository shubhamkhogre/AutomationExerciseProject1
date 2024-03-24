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

public class TC25_TestNG_Verify_ScrollUp_ArrowButton_And_ScrollDown 
{
	WebDriver driver;
	@BeforeClass
	public void OpenBrowserSetup()
	{
		//launch browser and open site
		System.setProperty("webdriver.driver.chrome", "C:\\July21B_Selenium2023\\chromedriver 122\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/");
	}
	
	@Test
	public void VerifyHomePageVisible() throws InterruptedException
	{
		String Homepage=driver.getTitle();
		assertEquals(Homepage, "Automation Exercise", "Homepage not Visible");
		
		Thread.sleep(2000);
		
		//scroll to bottom of page
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,8500)");
		Thread.sleep(2000);
	}
	
	@Test
	public void VerifySubscriptiontextVisible() throws InterruptedException
	{
		boolean Substext = driver.findElement(By.xpath("(//div/h2)[82]")).isDisplayed();
		assertTrue(Substext, "SUBSCRIPTION is Not Visible");
		
		//click on scroll up arrow 
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='scrollUp']")).click();
	}
	
	@Test
	public void VerifypageisScrolledupandTextisDisplayed()
	{
		boolean text = driver.findElement(By.xpath("//*[@id=\"slider-carousel\"]/div/div[2]/div[1]/h2")).isDisplayed();
		assertTrue(text, "page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is not visible");	
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}

}
