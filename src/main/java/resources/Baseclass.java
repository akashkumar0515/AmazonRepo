package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Baseclass 
{
	public String Url;
	public Properties prop;
	public static WebDriver driver;
	public WebDriver Initilization() throws IOException
	{
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Driver.properties");
		prop.load(fis);
		
		//This will take browser type input from properties file.
		String Drivername=prop.getProperty("browser");
		//This will take browser type input from system(maven and if set parametrization with browser type in jenkins also)
		//String Drivername=System.getProperty("browser");
		Url=prop.getProperty("url");
		//Url=Propertiesdriven.getdriverprop("url");
		
		
		if(Drivername.contains("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
			ChromeOptions option =new ChromeOptions();
			if(Drivername.contains("headless"))
			{
				option.addArguments("headless");
			}
			driver=new ChromeDriver();
			
		}
		else if(Drivername.contains("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\geckodriver.exe");
			driver=new FirefoxDriver();
			
			
		}
		else if(Drivername.contains("IE"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\Selenium\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		return driver;
	}
	
	public String GetScreenshot(String Testcasename) throws IOException
	{
		
		File Src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String Destination=System.getProperty("user.dir")+"\\reports\\"+Testcasename+".png";
		FileUtils.copyFile(Src,new File(Destination));
		
		return Destination;
		
	}

}
