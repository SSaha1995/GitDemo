package resources;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.io.FileHandler;

public class Base 
{
	public WebDriver driver;
	public Properties prop;
	public WebDriver initialiseDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String bsName = System.getProperty("browser");
		//String bsName = prop.getProperty("browser");
		System.out.println(bsName);
		if(bsName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(bsName.contains("headless"))
			{
				options.addArguments("headless");
			}
			driver= new ChromeDriver(options);
		}
		else if(bsName.equals("firefox"))
		{
			//Execute in firefox driver
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if(bsName.equals("edge"))
		{
			//Execute in IE Driver
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\msedgedriver.exe");
			driver= new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dstfile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(src, new File(dstfile));
		return dstfile;
	}
}
