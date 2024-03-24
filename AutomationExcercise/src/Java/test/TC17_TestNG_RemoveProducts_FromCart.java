package Project_TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC17_TestNG_RemoveProducts_FromCart 
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
	public void homepagetitleVerification() throws InterruptedException
	{
		//verify homepage visible successfully
		String title=driver.getTitle();
		assertEquals(title, "Automation Exercise", "HomePage is not Visible");
		
		Thread.sleep(2000);
		//Adding products to cart
		driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
		Thread.sleep(2000);
				
				
		//click on cart button
		driver.findElement(By.xpath("(//li/a)[3]")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void VerifyCartPageisDisplayed() throws InterruptedException
	{
		String cartpage=driver.getTitle();
		assertEquals(cartpage, "Automation Exercise - Checkout", "Cart Page Not Displayed");
		
		//Click 'X' button corresponding to particular product
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 3)
	public void VerifyProductRemovedfromCart()
	{
		boolean emptycart = driver.findElement(By.xpath("//span[@id='empty_cart']//b")).isDisplayed();
		assertTrue(emptycart, "Product Not Removed from Cart");
	}
	
	@AfterClass
	public void CloseBrowser()
	{
		driver.close();
	}

}
