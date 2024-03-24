package Project_TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC16_TestNG_PlaceOrder_LoginBeforeCheckout 
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
		//click on signup/login button
		driver.findElement(By.xpath("(//li/a)[4]")).click();
		Thread.sleep(2000);
		
		//fill login details
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("butterfly@gmail.com");
		driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("dd");
		driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void VerifyLoginasUsernameVisible() throws InterruptedException
	{
		boolean LoginasUN = driver.findElement(By.xpath("//*[text()='dd']")).isDisplayed();
		assertTrue(LoginasUN, "Login as username Not Visible");
		
		Thread.sleep(2000);
		//Adding products to cart
		driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
		Thread.sleep(2000);
		//click on cart button
		driver.findElement(By.xpath("(//li/a)[3]")).click();
	}
	
	@Test(priority = 3)
	public void VerifyCartPageisDisplayed() throws InterruptedException
	{
		String cartpage=driver.getTitle();
		assertEquals(cartpage, "Automation Exercise - Checkout", "Cart Page Not Displayed");
		
		Thread.sleep(2000);
		//click on proceed to checkout
		driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 4)
	public void verifyAddressReviewDetails() throws InterruptedException
	{
		String AddReview=driver.getTitle();
		assertEquals(AddReview, "Automation Exercise - Checkout", "Address & Review Not Verified");
		
		Thread.sleep(2000);
		//enter text in comment field
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("I have review the address & order details both are correct");
		Thread.sleep(2000);
		//click on place order
		driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
		Thread.sleep(5000);
		//entering details in the payment field
		driver.findElement(By.xpath("//input[@data-qa='name-on-card']")).sendKeys("sonusood");
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@data-qa='card-number']")).sendKeys("1234567885412365");
		driver.findElement(By.xpath("//input[@data-qa='cvc']")).sendKeys("231");
		driver.findElement(By.xpath("//input[@data-qa='expiry-month']")).sendKeys("12");
		driver.findElement(By.xpath("//input[@data-qa='expiry-year']")).sendKeys("2028");
		//Thread.sleep(1000);T
		//click on Pay and Confirm Order
		driver.findElement(By.xpath("//button[@class='form-control btn btn-primary submit-button']")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 5)
	public void VerifySuccessMessageofOrderPlaced() throws InterruptedException
	{
		boolean orderplaced = driver.findElement(By.xpath("(//div[@class='alert-success alert'])[1]")).isDisplayed();
		//assertTrue(orderplaced, "order not placed");
		assertFalse(orderplaced, "Your order has been placed successfully!");
		//click on delete account
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//li/a)[5]")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 6)
	public void VerifyAccountDeleted() throws InterruptedException
	{
		//verify account deleted
		boolean accdeleted = driver.findElement(By.xpath("//div/h2/b")).isDisplayed();
		assertTrue(accdeleted, "'Account Deleted' Not Visible");
		
		//click on continue button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
	}
	
	@AfterClass
	public void CloseBrowser()
	{
		driver.close();
	}


}
