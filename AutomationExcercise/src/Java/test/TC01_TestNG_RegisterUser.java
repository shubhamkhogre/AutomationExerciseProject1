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

public class TC01_TestNG_RegisterUser 
{
	WebDriver driver;
	
	@BeforeClass
	public void openbrowserSetup()
	{	//launch browser
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
	}
	
	@Test(priority = 2)
	public void signupText() throws InterruptedException
	{
		//click on ' Signup / Login' button
		driver.findElement(By.xpath("//a[contains(text(),' Signup / Login')]")).click();
		//verify 'New User Signup!' Visible
		boolean signUpText = driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed();
		assertTrue(signUpText, "New User Signup! Not Visible");
		Thread.sleep(2000);
		
		//enter name & email address
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("ramsurvase");
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("ramsurchamp22a@gmail.com");
		//click on signup button
		driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
	}
	
	@Test(priority = 3)
	public void verifyaccountInfoVisible() throws InterruptedException
	{
		//verify acc info visible
		boolean accinfoText = driver.findElement(By.xpath("(//h2[@class='title text-center']/b)[1]")).isDisplayed();
		assertTrue(accinfoText, "ENTER ACCOUNT INFORMATION Not Visible");
		Thread.sleep(2000);
		
		//Fill details: Title, Name, Email, Password, Date of birth
		driver.findElement(By.xpath("//input[@type='radio']")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("ramsurvase");
		
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
		
		driver.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys("ram");
		driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("survase");
		driver.findElement(By.xpath("//input[@data-qa='company']")).sendKeys("Byjus");
		driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("abc chowk");
		driver.findElement(By.xpath("//input[@data-qa='address2']")).sendKeys("old ausa road");
		
		WebElement country = driver.findElement(By.xpath("//select[@data-qa='country']"));
		Select ss=new Select(country);
		ss.selectByValue("India");
		
		driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys("Maharashtra");
		driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys("Latur");
		driver.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys("413512");
		driver.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys("8888695214");
		driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();	
	}
	
	@Test(priority = 4)
	public void verifyacccreatedtextVisible() throws InterruptedException
	{
		//Verify that 'ACCOUNT CREATED!' is visible
		boolean acccreatedtext = driver.findElement(By.xpath("//b[text()='Account Created!']")).isDisplayed();
		assertTrue(acccreatedtext, "ACCOUNT CREATED! Not Visible");
		
		//click on contibue button
		driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 5)
	public void verifyloginasusernameVisible()
	{
		//verify login as username vivible
		boolean loginasUN = driver.findElement(By.xpath("//a[text()=' Logged in as ']/b[text()='ramsurvase']")).isDisplayed();
		assertTrue(loginasUN, "Logged in as UserName Not Visible");
		
		//click on delete account
		driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();
		
	}
	
	@Test(priority = 6)
	public void verifyaccountDeleted()
	{
		//verify acc deleted
		boolean accdeleted = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")).isDisplayed();
		assertTrue(accdeleted, "Account Deleted Not Vissible");
		
		//click on continue button
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		//close the browser
		driver.close();
	}
	
	
}
