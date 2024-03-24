package Project_TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC12_TestNG_AddProducts_InCart 
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
		
		//click on product
		driver.findElement(By.xpath("(//li/a)[2]")).click();
				
		//click on add to cart & click continue shopping
		Thread.sleep(5000);
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("(//div[@class='product-overlay'])[1]"))).build().perform();
		driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
		Thread.sleep(2000);
		a.moveToElement(driver.findElement(By.xpath("(//div[@class='product-overlay'])[2]"))).build().perform();
		driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[3]")).click();
				
		//click on view cart link
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a/u")).click();
	}
	
	@Test(priority = 2)
	public void verifyBothProductsAdded()
	{
		boolean ProductsAdded = driver.findElement(By.xpath("//tbody")).isDisplayed();
		assertTrue(ProductsAdded, "Both the Products Not Added In Cart");
	}
	
	@Test(priority = 3)
	public void verifyPricesQuantityTotalPrice()
	{
		List<WebElement> product = driver.findElements(By.xpath("//tbody/tr"));
		System.out.println(product.size());

		for(WebElement s1: product)
		{
			System.out.println(s1.getText());
		}
	}
	
	@AfterClass
	public void CloseBrowser()
	{
		driver.close();
	}
}
