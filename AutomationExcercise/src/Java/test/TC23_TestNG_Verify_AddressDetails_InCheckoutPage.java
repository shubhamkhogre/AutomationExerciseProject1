package Project_TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC23_TestNG_Verify_AddressDetails_InCheckoutPage 
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
				
				//click on signup/login button
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[contains(text(),' Signup / Login')]")).click();
				
				//enter signup details & click signup button
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Ram4712");
				driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("Ram4712@gmail.com");
				driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
				
				//fill registration details & click on create account button
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@type='radio']")).click();
				driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Canara@5643");
				
				WebElement day = driver.findElement(By.xpath("//select[@data-qa='days']"));
				Select s=new Select(day);
				s.selectByValue("9");
				
				WebElement month = driver.findElement(By.xpath("//select[@data-qa='months']"));
				Select s1=new Select(month);
				s1.selectByVisibleText("September");
				
				WebElement year = driver.findElement(By.xpath("//select[@data-qa='years']"));
				Select s2=new Select(year);
				s2.selectByValue("1996");
				
				driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
				driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
				
				driver.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys("Ram");
				driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("Patil");
				driver.findElement(By.xpath("//input[@data-qa='company']")).sendKeys("Byjus");
				driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("bkc chowk");
				driver.findElement(By.xpath("//input[@data-qa='address2']")).sendKeys("old delhi road");
				
				WebElement country = driver.findElement(By.xpath("//select[@data-qa='country']"));
				Select ss=new Select(country);
				ss.selectByValue("India");
				
				driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys("Maharashtra");
				driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys("Latur");
				driver.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys("413512");
				driver.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys("8889695214");
				driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
	}
	
	@Test(priority = 2)
	public void VerifyAccountCreated() throws InterruptedException
	{
			String AccountCreated=driver.getTitle();
			assertEquals(AccountCreated, "Automation Exercise - Account Created", "ACCOUNT CREATED! Not Visible");
			//click on continue button
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
			Thread.sleep(5000);
	}
	
	@Test(priority = 3)
	public void verifyloginasusernameVisible() throws InterruptedException
	{
				//verify login as username vivible
				boolean loginasUN = driver.findElement(By.xpath("//a[text()=' Logged in as ']/b[text()='Ram4712']")).isDisplayed();
				assertTrue(loginasUN, "Logged in as UserName Not Visible");
		
				//Add products to cart
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]")).click();
				
				//click continue chopping
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
				
				//click on Cart Button
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//li/a)[3]")).click();
		
	}
	
	@Test(priority = 4)
	public void VerifyCartPageisDisplayed() throws InterruptedException
	{
		String cartpage=driver.getTitle();
		assertEquals(cartpage, "Automation Exercise - Checkout", "Cart Page Not Displayed");
		
		Thread.sleep(1000);
		//click on proceed to checkout
		driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
	}
	
	@Test(priority = 5)
	public void VerifyDeliveryAddressSameasRegistration() throws InterruptedException
	{
		String RegAdd = "bkc chowk old delhi road Latur Maharashtra India";
		String DelAdd = "bkc chowk old delhi road Latur Maharashtra India";
		
		if(RegAdd.equals(DelAdd))
		{
			System.out.println("Delivery Address is same as Registration Address");
		}
		else
		{
			System.out.println("Both Address are Different");
		}
		Thread.sleep(2000);
	}
	
	@Test(priority = 6)
	public void VerifyBillingAddressSameasRegistration() throws InterruptedException
	{
		String RegAdd1 = "bkc chowk old delhi road Latur Maharashtra India";
		String BillAdd = "bkc chowk old delhi road Latur Maharashtra India";
		
		if(RegAdd1.equals(BillAdd))
		{
			System.out.println("Billing Address is same as Registration Address");
		}
		else
		{
			System.out.println("Both Address are Different");
		}
		
		//click on delete account
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//li/a)[5]")).click();
	}
	
	@Test(priority = 7)
	public void VerifyAccountisDeleted() throws InterruptedException
	{
		boolean result1 = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")).isDisplayed();
		assertTrue(result1, "ACCOUNT DELETED! Not Visible");
		
		Thread.sleep(1000);
		//click on continue button
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
	}
	
	@AfterClass
	public void BrowserClose()
	{
		driver.close();
	}

}
