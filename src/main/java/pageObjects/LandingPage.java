package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage 
{
	public WebDriver driver;
	private By text   = By.xpath("//button[contains(text(),'NO THANKS')]");
	private By signin = By.linkText("Login");
	private By title  = By.cssSelector("div[class='text-center'] h2");
	private By navBar = By.cssSelector(".nav.navbar-nav.navbar-right");
	private By header=By.cssSelector("div[class*='video-banner'] h3");
	
	public LandingPage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	public WebElement popUp()
	{
		return driver.findElement(text);
	}
	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getNavBar()
	{
		return driver.findElement(navBar);
	}
	public WebElement getHeader()
	{
		return driver.findElement(header);
	}
}
