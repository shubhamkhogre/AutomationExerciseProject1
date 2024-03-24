package Project_TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC19_TestNG_View_Brand_Products 
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
	public void VerifyBrandsVisibleonLeftBar() throws InterruptedException
	{
		//click on products button
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//li/a)[2]")).click();
		
		//verify brands visible on left side bar
		Thread.sleep(2000);
		boolean brands = driver.findElement(By.xpath("//div[@class='brands-name']")).isDisplayed();
		assertTrue(brands, "Brands Not Visible");
		
		//click on sub brand - polo
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@href,'Polo')]")).click();
		Thread.sleep(5000);	
	}
	
	@Test(priority = 2)
	public void VerifyUserNavigatedtoSubBrandPage() throws InterruptedException
	{
		//verify navigated to sub brand page
		String SubbrandPage=driver.getTitle();
		assertEquals(SubbrandPage, "Automation Exercise - Polo Products", "Not Navigated to sub brand page");
		
		Thread.sleep(2000);
	}
	
	@Test(priority = 3)
	public void VerifySubBrandProductsDisplayed() throws InterruptedException
	{
		//verify sub brand products are displayed
		boolean subbrandproducts = driver.findElement(By.xpath("//div[@class='features_items']")).isDisplayed();
		assertTrue(subbrandproducts, "Sub Brand Products Not Displayed");
		//click on sub brand - H&M
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@href,'H&M')]")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 4)
	public void VerifyNavigatedtoOtherBrandPageandProductsDisplayed()
	{
		boolean brand2 = driver.findElement(By.xpath("//div[@class='features_items']")).isDisplayed();
		assertTrue(brand2, "user not navigated & cannot see products");
	}
	
	@AfterClass
	public void BrowserClose()
	{
		driver.close();
	}
	
	

}
