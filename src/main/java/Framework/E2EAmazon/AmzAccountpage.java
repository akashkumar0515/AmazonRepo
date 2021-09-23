package Framework.E2EAmazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmzAccountpage 
{
	
	private By Address=By.xpath("//span[text()='Edit addresses for orders and gifts']");
	
	WebDriver driver;
	
	public AmzAccountpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement Addrslink()
	{
		return driver.findElement(Address);
	}

}
