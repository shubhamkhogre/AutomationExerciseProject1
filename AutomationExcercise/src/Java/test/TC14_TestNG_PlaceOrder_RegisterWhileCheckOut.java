package Project_TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC14_TestNG_PlaceOrder_RegisterWhileCheckOut 
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
		
		//Adding Products to Cart
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
		
		//click on cart button
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//li/a)[3]")).click();
	}
	
	@Test(priority = 2)
	public void VerifyCartPageisDisplayed() throws InterruptedException
	{
		String cartpage=driver.getTitle();
		assertEquals(cartpage, "Automation Exercise - Checkout", "Cart Page Not Displayed");
		
		Thread.sleep(1000);
		//click on proceed to checkout
		driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
		Thread.sleep(1000);
		//Click 'Register / Login' button
		driver.findElement(By.xpath("(//a/u)[1]")).click();
		Thread.sleep(2000);
		//fill signup details
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("sonusood");
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("ssood000@gmail.com");
		driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
		Thread.sleep(2000);
		
		//register to create account by filling all details
		driver.findElement(By.xpath("//input[@type='radio']")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("ssood@1111");
		
		WebElement day = driver.findElement(By.xpath("//select[@data-qa='days']"));
		Select s=new Select(day);
		s.selectByValue("8");
		
		WebElement month = driver.findElement(By.xpath("//select[@data-qa='months']"));
		Select s1=new Select(month);
		s1.selectByVisibleText("October");
		
		WebElement year = driver.findElement(By.xpath("//select[@data-qa='years']"));
		Select s2=new Select(year);
		s2.selectByValue("1998");
		
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		
		driver.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys("sonusood");
		driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("Jeeet");
		driver.findElement(By.xpath("//input[@data-qa='company']")).sendKeys("Airplane");
		driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("bbb chowk");
		driver.findElement(By.xpath("//input[@data-qa='address2']")).sendKeys("old gate");
		
		WebElement country = driver.findElement(By.xpath("//select[@data-qa='country']"));
		Select ss=new Select(country);
		ss.selectByValue("India");
		
		driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys("Maharashtra");
		driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys("Pune");
		driver.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys("411046");
		driver.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys("8888907214");
		driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 3)
	public void VerifyAccountisCreated() throws InterruptedException
	{
		String AccountCreated=driver.getTitle();
		assertEquals(AccountCreated, "Automation Exercise - Account Created", "'ACCOUNT CREATED!' Not Visible");
		
		//click on continue button
		driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 4)
	public void VerifyLoginasUsernameVisible() throws InterruptedException
	{
		boolean LoginasUN = driver.findElement(By.xpath("//*[text()='sonusood']")).isDisplayed();
		assertTrue(LoginasUN, "Login as username Not Visible");
		//click on cart
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//li/a)[3]")).click(); //Cart
		Thread.sleep(2000);
		//proceed to checkout
		driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 5)
	public void verifyAddressReviewDetails() throws InterruptedException
	{
		String AddReview=driver.getTitle();
		assertEquals(AddReview, "Automation Exercise - Checkout", "Address & Review Not Verified");
		
		Thread.sleep(1000);
		//enter text in comment field
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("I have review the address & order details both are correct");
		Thread.sleep(1000);
		//click on place order
		driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
		Thread.sleep(5000);
		//entering details in the payment field
		driver.findElement(By.xpath("//input[@data-qa='name-on-card']")).sendKeys("sonusood");
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@data-qa='card-number']")).sendKeys("1234567885412365");
		driver.findElement(By.xpath("//input[@data-qa='cvc']")).sendKeys("231");
		driver.findElement(By.xpath("//input[@data-qa='expiry-month']")).sendKeys("12");
		driver.findElement(By.xpath("//input[@data-qa='expiry-year']")).sendKeys("2028");
		//Thread.sleep(1000);T
		//click on Pay and Confirm Order
		driver.findElement(By.xpath("//button[@class='form-control btn btn-primary submit-button']")).click();
		//Thread.sleep(2000);
	}
	
	@Test(priority = 6)
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
	
	@Test(priority = 7)
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
