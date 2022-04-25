package seleniumframework;

//import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
//import pageObjects.LoginPage;
import resources.Base;


public class ValidateNavigationBar extends Base
{
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;

	@BeforeTest
	public void initialis() throws IOException
	{
		driver =initialiseDriver();
		log.info("Driver is Initialized");

		  driver.get(prop.getProperty("url"));
			log.info("Navigated to desired url");

	}

	@Test
	public void basePageNavigation() throws IOException, InterruptedException
	{
		  
		  System.out.println(driver.getTitle());

		  //WebElement ele = driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]"));
		  //ele.click();  
		 LandingPage lp = new LandingPage(driver);
		  lp.popUp().click();
			log.info("Pop Up closed");

		  //lp.getLogin().click();
		  Assert.assertTrue(lp.getNavBar().isDisplayed());
			log.info("Navigation Bar is Displayed");

	
}
	@AfterTest
	public void teardown()
	{
		driver.close();
		log.info("Driver is closed");

	}
}