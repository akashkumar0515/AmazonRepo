package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportAmz 
{
	static ExtentReports ext;
	public static ExtentReports getReports()
	{
		//create a path in project for extent report.
		String path=System.getProperty("user.dir") +"\\reports\\Executionreports.html";
		//create object of extentsparker reporter class and pass the path.
		ExtentSparkReporter report=new ExtentSparkReporter(path);
		report.config().setReportName("Amazon address Report");
		report.config().setDocumentTitle("Execution report");
	
		
	
		//Create object of Extent reports class.
		ext=new ExtentReports();
		ext.attachReporter(report);
		ext.setSystemInfo("Tester", "Akash kumar");
		
		return ext;
		
		
	}

}
