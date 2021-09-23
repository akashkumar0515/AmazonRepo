package Framework.E2EAmazon;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmzaddAddresspage 
{
	public WebDriver driver;
	
	private By addressclick=By.xpath("//h2[text()='Add address']");
	private By name=By.id("address-ui-widgets-enterAddressFullName");
	private By Mobile=By.id("address-ui-widgets-enterAddressPhoneNumber");
	private By Pincode=By.id("address-ui-widgets-enterAddressPostalCode");
	private By Flat=By.id("address-ui-widgets-enterAddressLine1");
	private By Area=By.id("address-ui-widgets-enterAddressLine2");
	private By Landmark=By.id("address-ui-widgets-landmark");
	private By Addrstype=By.xpath("//span[text()=' Select an Address Type ']");
	private By Submit=By.className("a-button-input");
	
	
	
	public AmzaddAddresspage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getaddrswin()
	{
		return driver.findElement(addressclick);
	}
	
	public WebElement Getname()
	{
		return driver.findElement(name);
	}
	
	public WebElement GetMobile()
	{
		return driver.findElement(Mobile);
	}
	
	public WebElement Getpincode()
	{
		return driver.findElement(Pincode);
	}
	
	public WebElement GetFlatAddrs()
	{
		return driver.findElement(Flat);
	}
	
	public WebElement GetArea()
	{
		return driver.findElement(Area);
	}
	
	public WebElement GetLandmark()
	{
		return driver.findElement(Landmark);
	}
	
	public WebElement GetAddrstype()
	{
		driver.findElement(Addrstype).click();
		WebElement addtype=driver.findElement(By.xpath("//a[@id='dropdown1_1']"));
		return addtype;
	}
	
	public WebElement Submitbtn()
	{
		return driver.findElement(Submit);
	}
	
	public JavascriptExecutor Scrooldown()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		return js;
	}

}
