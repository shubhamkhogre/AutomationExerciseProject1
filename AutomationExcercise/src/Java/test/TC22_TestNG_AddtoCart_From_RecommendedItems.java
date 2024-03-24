package Project_TestNG;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC22_TestNG_AddtoCart_From_RecommendedItems 
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
	public void VerifyRecommendedItemsVisible() throws InterruptedException
	{
		Thread.sleep(2000);
		//scroll to bottom of page
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,7650)");
		
		//Verify 'RECOMMENDED ITEMS' are visible
		Thread.sleep(1000);
		boolean ritems = driver.findElement(By.xpath("//div[@class='recommended_items']")).isDisplayed();
		assertTrue(ritems, "RECOMMENDED ITEMS Not Visible");
		
		//Click on 'Add To Cart' on Recommended product
		driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[73]")).click();
		
		//Click on 'View Cart' button
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a/u")).click();
		Thread.sleep(1000);
	}
	
	@Test(priority = 2)
	public void VerifythatProductisDisplayedinCartPage()
	{
		boolean ProdinCart = driver.findElement(By.xpath("//tr[@id='product-5']")).isDisplayed();
		assertTrue(ProdinCart, "Recommended product is Not displayed in cart page");
		
	}
	
	@AfterClass
	public void CloseBrowser()
	{
		driver.close();
	}

}
