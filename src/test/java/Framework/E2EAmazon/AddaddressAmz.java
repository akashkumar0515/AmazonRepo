package Framework.E2EAmazon;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import resources.Baseclass;
import resources.DatadrivenExcel;

public class AddaddressAmz extends Baseclass
{
	
	public static Logger log=LogManager.getLogger(AddaddressAmz.class.getName());
	DatadrivenExcel dd=new DatadrivenExcel();
	
	@BeforeClass
	public void Initilaizedriver() throws IOException
	{
		
		driver=Initilization();
		log.info("Initilize Driver sucessfully");
		driver.get(Url);
		log.info("Url open sucessfully");
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
		ArrayList<String> data=dd.getdata("Signin");
		String username=data.get(1);
		String password=data.get(2);
		
		AmzSigninpage sng=new AmzSigninpage(driver);
		sng.GetEmail().sendKeys(username);
		sng.getcntnbtn().click();
		sng.getpswd().sendKeys(password);
		sng.getsignbtn().click();
		log.info("Signin sucesfully");
	}
	
	@Test(priority = 3)
	public void Profile()
	{
		AmzHomepage hm=new AmzHomepage(driver);
		hm.getAccount();
		hm.Accntclk().click();
		
		AmzAccountpage Acp=new AmzAccountpage(driver);
		Acp.Addrslink().click();
	}
	
	@Test(priority = 4)
	public void Addadress() throws IOException
	{
		ArrayList<String> data1=dd.getdata("Addadress");
		String Name=data1.get(1);
		String Mobile=data1.get(2);
		String pincode=data1.get(3);
		String Flat=data1.get(4);
		String Area=data1.get(5);
		String Landmark=data1.get(6);
		
		
		AmzaddAddresspage addrs=new AmzaddAddresspage(driver);
		addrs.getaddrswin().click();
		addrs.Getname().sendKeys(Name);
		addrs.GetMobile().sendKeys(Mobile);
		addrs.Getpincode().sendKeys(pincode);
		addrs.GetFlatAddrs().sendKeys(Flat);
		addrs.GetArea().sendKeys(Area);
		addrs.GetLandmark().sendKeys(Landmark);
		addrs.Scrooldown();
		addrs.GetAddrstype().click();
		addrs.Submitbtn().click();
		log.info("Add address sucesfully");
	}
	
	@Test(priority =5 )
	public void logout()
	{
		AmzHomepage hm=new AmzHomepage(driver);
		hm.getAccount();
		hm.GetSignout().click();
		log.info("Logout sucesfully");
	}
	
	@AfterClass
	public void closebswr()
	{
		driver.close();
	}
	
	

}
