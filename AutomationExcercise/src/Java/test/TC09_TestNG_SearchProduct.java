package Project_TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC09_TestNG_SearchProduct 
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
		
		//enter menttshirt in search & click search icon
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Men Tshirt");
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 3)
	public void verifySearchedProductsVisible() throws InterruptedException
	{
		//verify search products are visible
		boolean Searchedproducts = driver.findElement(By.xpath("(//div/h2)[3]")).isDisplayed();
		assertTrue(Searchedproducts, "SEARCHED PRODUCTS Not Visible");
		Thread.sleep(2000);
	}
	
	@Test(priority = 4)
	public void verifyProductsRelatedtoSearchvisible()
	{
		boolean AllSearchedProd = driver.findElement(By.xpath("//div[@class='product-image-wrapper']")).isDisplayed();
		assertTrue(AllSearchedProd, "All Products Related to Searched Not Visible");	
	}
	
	@AfterClass
	public void CloseBrowser()
	{
		driver.close();
	}

}
