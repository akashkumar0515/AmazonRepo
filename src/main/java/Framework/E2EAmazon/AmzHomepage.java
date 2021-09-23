package Framework.E2EAmazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AmzHomepage 
{
	public WebDriver driver;
	
	 //Actions a=new Actions(driver);
	//WebElement mouseover=driver.findElement(By.id("nav-link-accountList"));
	//a.moveToElement(mouseover).build().perform();
	
	private By Signin=By.id("nav-link-accountList");
	private By Urccount=By.id("nav-link-accountList");
	private By Account=By.xpath("//span[text()='Your Account']");
	private By Signout=By.xpath("//span[text()='Sign Out']");
	
	public AmzHomepage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public WebElement getsignin()
	{
		return driver.findElement(Signin);
	}
	
	public WebElement getAccount()
	{
		Actions a=new Actions(driver);
		WebElement mouseover=driver.findElement(Urccount);
		a.moveToElement(mouseover).build().perform();
		return mouseover;
	}
	
	public WebElement Accntclk()
	{
		return driver.findElement(Account);
	}
	
	public WebElement GetSignout()
	{
		return driver.findElement(Signout);
	}
}
