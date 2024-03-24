package Project_TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC13_TestNG_Verify_ProductQuantity_InCart 
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
		
		//Click 'View Product' for any product on home page
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li/a)[24]")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority = 2)
	public void VerifyProductDetailsisOpened() throws InterruptedException
	{
		//verify prod detail page is opened
		String ProdDetailpage=driver.getTitle();
		assertEquals(ProdDetailpage, "Automation Exercise - Product Details", "Product Detail Page Not Opened");
		
		//increase qualtity to 4 after clearing it & click add to cart button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='quantity']")).clear();
		driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys("4");
		driver.findElement(By.xpath("//button[@type='button']")).click();
		
		//click view cart button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a/u")).click();
	}
	
	@Test(priority = 3)
	public void VerifyProductDisplayedInCartPageExactquantity()
	{
		//String Quantity = driver.findElement(By.xpath("//td[@class='cart_quantity']")).getText();
		//System.out.println(Quantity);
		
		boolean ExactQuantity = driver.findElement(By.xpath("//td[@class='cart_quantity']")).isDisplayed();
		assertTrue(ExactQuantity, "product is displayed in cart page is Not with exact quantity");
	}
	
	@AfterClass
	public void CloseBrowser()
	{
		driver.close();
	}

}
