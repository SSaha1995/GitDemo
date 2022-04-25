package seleniumframework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;


public class HomePage extends Base
{
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	@BeforeMethod 
	public void initialis() throws IOException
	{
		driver =initialiseDriver();
		log.info("Driver is Initialized");
		  driver.get(prop.getProperty("url"));
			log.info("Navigated to desired url");
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String usrname, String pswd) throws IOException, InterruptedException
	{
		  
		  System.out.println(driver.getTitle());

		  //WebElement ele = driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]"));
		  //ele.click();  
		 LandingPage lp = new LandingPage(driver);
		  lp.popUp().click();
			log.info("Pop Up closed");
		  lp.getLogin().click();
			log.info("clicked on Login Button");

		  LoginPage l = new LoginPage(driver);
		  l.getEmail().sendKeys(usrname);
			log.info("Username Entered");

		  l.getPassword().sendKeys(pswd);
			log.info("Password Entered");

		  //Thread.sleep(2000);
		  l.getLogin().click();
			log.info("Log in Button is clicked in log in Page");

	
}
	@AfterMethod
	public void teardown()
	{
		driver.close();
		log.info("Driver is Closed");

	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		//Row Stands for how many differnt data sets test should run
		//column stands for how many values per each test data set
		Object[][] data = new Object[2][2];
		//0th row
		data[0][0]="babu.sujan75@gmail.com";
		data[0][1]="Babu@12345";
		//1st row
		data[1][0]="sujan95saha@gmail.com";
		data[1][1]="123";
		return data;
		
	}
}