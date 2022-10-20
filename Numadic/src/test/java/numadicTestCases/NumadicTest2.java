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
import numadicPOM.NumadicPOM2;
import numadicUtility.Utility;

public class NumadicTest2 extends Utility
{

	WebDriver driver;
	String TCID;
	NumadicPOM2 numadic;
	@BeforeClass
	public void launchBrowser() throws InterruptedException
	{
		Reporter.log("-----> Launch browser <-----",true);
		 driver=new Configuration().ChromeInitialization(); 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		 numadic=new NumadicPOM2(driver);
	}
	
	
	@Test(enabled= true, priority=1)
	public void VerifyingFullTimeQA() throws InterruptedException
	{
		TCID="103";
		Reporter.log("-----> Verifying FullTime QA <-----",true);
		numadic.jobtype("Full time",driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		numadic.VerifyingQAEngineer(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String actual = numadic.VerifyingURL(driver);
		String expected = "https://numadic.com/careers/qa-engineer.php";
		Assert.assertEquals(actual, expected);
	} 
	
	@Test(enabled= true, priority=2)
	public void ApplyHereButtonActions() throws InterruptedException 
	{
		TCID="104";
		Reporter.log("-----> Verifying and performing ApplyHere Button QA <-----",true);
		Thread.sleep(3000);
		numadic.ApplyHereNow(driver);
	}
	@Test(enabled= true, priority=3)
	public void VerifyingRedirectBack()
	{
		TCID="105";
		Reporter.log("---> Verifying redirect back and performing ApplyHere Button QA <---",true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String actual = numadic.VerifyingRedirectBack(driver);
		String expected="https://numadic.com/careers/#careersFormContainer";
		Assert.assertEquals(actual,expected);
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
		driver.quit();
	}
}
