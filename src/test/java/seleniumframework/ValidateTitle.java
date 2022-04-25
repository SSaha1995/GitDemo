package seleniumframework;

//import static org.testng.Assert.assertEquals;

import java.io.IOException;
//import org.apache.logging.log4j.*;
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


public class ValidateTitle extends Base
{
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;

	LandingPage lp;

	@BeforeTest
	public void initialis() throws IOException
	{
		driver =initialiseDriver();
		log.info("Driver is Initialized");
		  driver.get(prop.getProperty("url"));
			log.info("Navigated to desired url");

	}
	
	@Test
	public void validateAppTitle() throws IOException, InterruptedException
	{
		  
		System.out.println(driver.getTitle());

		  //WebElement ele = driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]"));
		  //ele.click();  
		  lp = new LandingPage(driver);
		  lp.popUp().click();
			log.info("Pop Up closed");

		  //lp.getLogin().click();
		  String title =lp.getTitle().getText();
		  Assert.assertEquals(title, "FEATURED COURS123ES");
		  System.out.println(title);
			log.info("Successfully Validated text message");

		  
		  
	
}
    @Test
	public void validateHeader() throws IOException
	{
		
		System.out.println("am i going inside it");
		Assert.assertEquals(lp.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		log.info("Driver is closed");

	}
}