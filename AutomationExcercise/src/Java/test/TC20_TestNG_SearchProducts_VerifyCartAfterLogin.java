package Project_TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC20_TestNG_SearchProducts_VerifyCartAfterLogin 
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
		
		//Enter product name in search input and click search button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Men Tshirt");
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(2000);
		
	}
	
	@Test(priority = 2)
	public void VerifySearchedProductsVisible() throws InterruptedException
	{
		boolean Searchedproducts = driver.findElement(By.xpath("(//div/h2)[3]")).isDisplayed();
		assertTrue(Searchedproducts, "SEARCHED PRODUCTS Not Visible");
		Thread.sleep(2000);
	}
	
	@Test(priority = 3)
	public void VerifyAllProductsRelatedtoSearchVisible() throws InterruptedException
	{
		boolean AllSearchedProd = driver.findElement(By.xpath("//div[@class='product-image-wrapper']")).isDisplayed();
		assertTrue(AllSearchedProd, "All Products Related to Searched Not Visible");
		
		//click on add to cart
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]")).click();
		//click on continue shopping
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
		//click on cart button
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//li/a)[3]")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 4)
	public void VerifyProductsareVisibleinCart() throws InterruptedException
	{
		boolean products = driver.findElement(By.xpath("//tbody/tr")).isDisplayed();
		assertTrue(products, "Products Not Visible in Cart");
		
		//click on login/signup button
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//li/a)[4]")).click();
				
		Thread.sleep(2000);
		//Fill Login Details & Click Login Button
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("pratik12345@gmail.com");
		driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("pratik12345");
		driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
				
		//click on cart button
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//li/a)[3]")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 5)
	public void VerifyProductsVisibleinCartAfterLogin()
	{
		boolean products2 = driver.findElement(By.xpath("//tbody/tr")).isDisplayed();
		assertTrue(products2, "products not visible in cart after login");
	}
	
	@AfterClass
	public void CloseBowser()
	{
		driver.close();
	}

}
