package Project_TestNG;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC08_TestNG_Verify_AllProducts_ProductDetailPage 
{
	WebDriver driver;
	
	@BeforeClass
	public void openbrowerSetup()
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
		//click on Products button
		driver.findElement(By.xpath("(//li/a)[2]")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority = 2)
	public void verifynavigatedtoAllProductsPage() throws InterruptedException
	{
		//verify navigated to AllProducts page successfully
		String AllProductsPage=driver.getTitle();
		assertEquals(AllProductsPage, "Automation Exercise - All Products", "Not Navigated to AllProducts Page");
		
		//click on view product
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li/a)[24]")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 3)
	public void verifyProductDetailPage()
	{
		String ProdDetailpage=driver.getTitle();
		assertEquals(ProdDetailpage, "Automation Exercise - Product Details", "Product Details Page Not Visible");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();	
	}

}
