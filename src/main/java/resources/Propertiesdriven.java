package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Propertiesdriven
{

	
	public static String getdriverprop(String property) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Driver.properties");
		prop.load(fis);
		return prop.getProperty(property);
	}
}
