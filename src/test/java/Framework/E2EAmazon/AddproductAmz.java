package Framework.E2EAmazon;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import jdk.internal.org.jline.utils.Log;
import resources.Baseclass;
import resources.Propertiesdriven;


public class AddproductAmz extends Baseclass
{
	public static Logger log=LogManager.getLogger(AddaddressAmz.class.getName());

	@BeforeClass
	public void Initilaizedriver() throws IOException
	{
		driver=Initilization();
		log.info("Driver initilization");
		driver.get(Url);
		driver.manage().window().maximize();
		log.info("Browser Maximize sucessfully");
	}
	
	@Test(priority = 1)
	public void homepage()
	{
		AmzHomepage hm=new AmzHomepage(driver);
		hm.getsignin().click();
		log.info("Sigin page open sucessfully");
	}
	
	@Test(priority = 2)
	public void Signin() throws IOException 
	{
		String username=Propertiesdriven.getdriverprop("Username");
		String password=Propertiesdriven.getdriverprop("Username");
		AmzSigninpage sng=new AmzSigninpage(driver);
		sng.GetEmail().sendKeys(username);
		log.info("Username entered sucessfully");
		sng.getcntnbtn().click();
		sng.getpswd().sendKeys(password);
		log.info("password entered sucessfully");
		sng.getsignbtn().click();
		log.info("Logged in sucssfully");
		
	}
	
	@AfterClass
	public void closebswr()
	{
		driver.close();
		log.info("driver close sucessfully");
	}
}
