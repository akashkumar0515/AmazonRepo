package Framework.E2EAmazon;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Baseclass;
import resources.ExtentReportAmz;


public class Listners extends Baseclass implements ITestListener
{
	
	
	ExtentTest Test;
	ExtentReports ext=ExtentReportAmz.getReports();
	ThreadLocal<ExtentTest> th=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result)
	{
		//Testcase varivale store the each test case name after every test case started.
		String Testname=result.getMethod().getMethodName();
		//CreateTest method will create a test name in extent repoeter with taht test case name.
		Test=ext.createTest(Testname);
		th.set(Test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		th.get().log(Status.PASS, "Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		th.get().fail(result.getThrowable());
		WebDriver driver=null;
		String testmethodname=result.getMethod().getMethodName();
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		catch (Exception e) 
		{
			
		} 
		try {
			th.get().addScreenCaptureFromPath(GetScreenshot(testmethodname), result.getMethod().getMethodName());
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void onTestSkipped(ITestResult result) 
	{
		Test.log(Status.SKIP, "Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result)
	{
		
	}

	@Override
	public void onStart(ITestContext context)
	{
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		ext.flush();	
	}

}
