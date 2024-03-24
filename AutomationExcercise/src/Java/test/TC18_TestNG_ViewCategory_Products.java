package Project_TestNG;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC18_TestNG_ViewCategory_Products 
{
	WebDriver driver;
	
	@BeforeClass
	public void OpenBrowserSetup() throws InterruptedException
	{
		//launch browser
		System.setProperty("webdriver.driver.chrome", "C:\\July21B_Selenium2023\\chromedriver 122\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//navigate to url
		driver.get("https://automationexercise.com/");
		Thread.sleep(2000);
		
	}
	
	@Test(priority = 1)
	public void VerifyCategoriesVisible() throws InterruptedException
	{
		boolean categories = driver.findElement(By.xpath("//div[@class='panel-group category-products']")).isDisplayed();
		assertTrue(categories, "Categories Not Visible on Left Bar");
		//click on Women Category
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@href,'Women')]")).click();
		//click on Sub Category Dress 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(@href,'1') and text()='Dress ']")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority = 2)
	public void VerifyDressProductsCategoryPage() throws InterruptedException
	{
		boolean WomenDressProd = driver.findElement(By.xpath("//h2[text()='Women - Dress Products']")).isDisplayed();
		assertTrue(WomenDressProd, "Women - Dress Products is Not Displayed");
		//click on Men Category
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@href,'Men')]")).click();
		//click on sub category Jeans
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(@href,'6') and text()='Jeans ']")).click();
		Thread.sleep(5000);	
	}
	
	@Test(priority = 3)
	public void VerifyNavigatedtoMenSubCategory()
	{
		boolean text2 = driver.findElement(By.xpath("//h2[text()='Men - Jeans Products']")).isDisplayed();
		assertTrue(text2, "Not Navigated to Men Sub-Category");
	}
	
	@AfterClass
	public void CloseBrowser()
	{
		driver.close();
	}

}
