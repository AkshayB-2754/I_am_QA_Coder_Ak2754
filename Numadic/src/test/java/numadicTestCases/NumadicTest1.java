package numadicTestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import numadicConfiguration.Configuration;
import numadicPOM.NumadicPOM1;
import numadicUtility.Utility;

public class NumadicTest1 extends Utility
{

	WebDriver driver;
	String TCID;
	NumadicPOM1 numadic;
	@BeforeClass
	public void launchBrowser() throws InterruptedException
	{
		Reporter.log("----->Launch browser<-----",true);
		 driver=new Configuration().ChromeInitialization(); 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		 numadic=new NumadicPOM1(driver);
	}
	@Test(enabled=true, priority=1)
	public void VerifyingHeader() 
	{
		TCID="101";
		Reporter.log("-----> Verify header text (JOIN OUR CREW) <-----",true);
		String actual = numadic.verifyingHeader(driver);
		String expected="JOIN OUR CREW";
		Assert.assertEquals(actual, expected);
	}
	@Test(enabled=true, priority=2)
	public void VerifyingIntership()
	{
		TCID="102";
		Reporter.log("-----> Verify Intership Message <-----",true);
		numadic.jobtype("Internship",driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String actual = numadic.VerifyingIntership(driver);
		String expected="There are no available job positions that match your filters.";
		Assert.assertEquals(actual, expected);
	}
	
	@AfterMethod
	public void screenshot(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			getScreenShot( driver, "TCID");
			Reporter.log("---> Test case "+TCID+" failed Took screenshot <---",true);
		}
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.quit();
	}
	
}
