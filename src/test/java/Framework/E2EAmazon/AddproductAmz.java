package Framework.E2EAmazon;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import resources.Baseclass;
import resources.Propertiesdriven;


public class AddproductAmz extends Baseclass
{
	

	@BeforeClass
	public void Initilaizedriver() throws IOException
	{
		driver=Initilization();
		driver.get(Url);
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void homepage()
	{
		AmzHomepage hm=new AmzHomepage(driver);
		hm.getsignin().click();
	}
	
	@Test(priority = 2)
	public void Signin() throws IOException 
	{
		String username=Propertiesdriven.getdriverprop("Username");
		String password=Propertiesdriven.getdriverprop("Username");
		AmzSigninpage sng=new AmzSigninpage(driver);
		sng.GetEmail().sendKeys(username);
		sng.getcntnbtn().click();
		sng.getpswd().sendKeys(password);
		sng.getsignbtn().click();
		
	}
	
	@AfterClass
	public void closebswr()
	{
		driver.close();
	}
}
