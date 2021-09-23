package Framework.E2EAmazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmzSigninpage 
{
	private By Email=By.xpath("//input[@type='email']");
	private By continuebtn=By.xpath("//input[@id='continue']");
	private By pswd=By.id("ap_password");
	private By signinbtn=By.id("signInSubmit");
	
	public WebDriver driver;
	
	public AmzSigninpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement GetEmail()
	{
		return driver.findElement(Email);
	}
	
	public WebElement getcntnbtn()
	{
	return driver.findElement(continuebtn);
	}
	
	public WebElement getpswd()
	{
		return driver.findElement(pswd);
	}
	
	public WebElement getsignbtn()
	{
		return driver.findElement(signinbtn);
	}

}
