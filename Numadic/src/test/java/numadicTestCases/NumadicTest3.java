package numadicTestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import numadicConfiguration.Configuration;
import numadicPOM.NumadicPOM3;
import numadicUtility.Utility;

public class NumadicTest3 extends Utility
{
	WebDriver driver;
	String TCID;
	NumadicPOM3 numadic;
	SoftAssert soft;
	@BeforeClass
	public void launchBrowser() throws InterruptedException
	{
		Reporter.log("----->Launch browser<-----",true);
		 driver=new Configuration().ChromeInitialization(); 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		 numadic=new NumadicPOM3(driver);
	}
	@Test(enabled=true, priority=1)
	public void ClickingOnQaApplyButton()
	{
		TCID="106";
		Reporter.log("----->Clicking on Apply button For QA Engineer<-----",true);
		numadic.ClickOnQA(driver);
		
	}
	@Test(enabled=true, priority=2)
	public void ValidatingErrorMsgForPersonalDetails() throws InterruptedException
	{
		Thread.sleep(5000);
		TCID="107";
		soft=new SoftAssert();
		numadic.ClickNextButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Reporter.log("----->Validating first name error message<-----",true);
		String actual = numadic.FirstNameErrorMsg(driver);
		String expected="Enter your first name"; //validating First name error msg
		soft.assertEquals(actual, expected);
		
		Reporter.log("----->Validating last name error message<-----",true);
		String actual1 = numadic.LastNameErrorMsg();
		String expected1="Enter your last name"; //validating Last name error msg
		soft.assertEquals(actual1, expected1);
		
		Reporter.log("----->Validating  email error message<-----",true);
		String actual2 = numadic.EmailErrorMsg();
		String expected21="Enter an email"; //validating email error msg
		String expected22="This value should be a valid email.";
		soft.assertEquals(actual2, expected21);
		soft.assertEquals(actual2, expected22);

		Reporter.log("----->Validating phone number error message<-----",true);
		String actual3 = numadic.PhoneNoErrorMsg();
		String expected3="Enter your mobile number"; //validating phone no. error msg
		String expected31="Enter a valid mobile number";
		soft.assertEquals(actual3,expected31);
		soft.assertEquals(actual3, expected3);
		
		Reporter.log("----->Validating Date of birth error message<-----",true);
		String actual4 = numadic.DateOfBirthErrorMsg();
		String expected4="Enter your date of birth"; //validating date of birth error msg
		soft.assertEquals(actual4, expected4);
		
	}

	@Test(enabled=true, priority=3)
	public void ValidatingPersonalDetailsFirstName() throws InterruptedException
	{
		Thread.sleep(5000);
		TCID="108";
		Reporter.log("----->Validating first name<-----",true);
		
		String actual1 = numadic.ValidatingFirstName("Akshay");
		String expected1 = "First name";  //validating label
		Assert.assertEquals(actual1, expected1);
	}
	@Test(enabled=true, priority=4)
	public void ValidatingPersonalDetailsLastName() throws InterruptedException
	{
		TCID="109";
		Reporter.log("----->Validating Lats name<-----",true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		String actual1 = numadic.ValidatingLastName("Bhangire");
		String expected1 = "Last name";		//validating label
		Assert.assertEquals(actual1, expected1);
		
	}
	@Test(enabled=true, priority=5)
	public void ValidatingPersonalDetailsEmail() throws InterruptedException
	{
		TCID="110";
		Reporter.log("----->Validating Email<-----",true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		String actual1 = numadic.ValidatingEmail("akshay@gmail.com");
		String expected1 = "Email";		//validating label
		Assert.assertEquals(actual1, expected1);
		
	}
	@Test(enabled=true, priority=6)
	public void ValidatingPersonalDetailsMobileNumber() throws InterruptedException
	{
		TCID="111";
		Reporter.log("----->Validating mobile nmber<-----",true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		String actual1 = numadic.ValidatingPhoneNumber("9579072073");
		String expected1 = "Mobile";		//validating label
		Assert.assertEquals(actual1, expected1);
		
	}
	@Test(enabled=true, priority=7)
	public void ValidatingPersonalDetailsCurrentCity() throws InterruptedException
	{
		TCID="112";
		Reporter.log("----->Validating current city<-----",true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		String actual1 = numadic.ValidatingCurrentCity("Pune");
		String expected1 = "Current city";		//validating label
		Assert.assertEquals(actual1, expected1);
		
	}
	@Test(enabled=true, priority=8)
	public void ValidatingPersonalDetailsHometown() throws InterruptedException
	{
		TCID="113";
		Reporter.log("----->Validating Hometown<-----",true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		String actual1 = numadic.ValidatingHomeTown("Pune");
		String expected1 = "Hometown";		//validating label
		Assert.assertEquals(actual1, expected1);
		
	}
	
	@Test(enabled=true, priority=9)
	public void ValidatingSportsDropDown() throws InterruptedException
	{
		TCID="114";
		Reporter.log("----->Validating Sports drop down<-----",true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		List<String> actual= numadic.ValidatingSportsDropDown();
		List<String> expected= Arrays.asList("-- Select one --","Cricket","Football","Basketball","Kabbadi","Pokemon GO","Counter Strike");
		Assert.assertEquals(actual, expected, "Error occures while validating Sports drop down elements");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String actual1 = numadic.ValidatingSportsDropDown("Kabbadi");
		String expected1 = "Sports you watch and/or play?";		//validating label
		Assert.assertEquals(actual1, expected1);
	}
	@Test(enabled=true, priority=10)
	public void ValidatingPetsDown() throws InterruptedException
	{
		TCID="115";
		Reporter.log("----->Validating Pets drop down<-----",true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		List<String> actual= numadic.ValidatingPetsDropDown();
		List<String> expected= Arrays.asList("-- Select one --","Dogs","Cats","Pokemon");
		Assert.assertEquals(actual, expected, "Error occures while validating Pets drop down elements");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String actual1 = numadic.ValidatingPetsDropDown("Dogs");
		String expected1 = "Dogs or Cats?";		//validating label
		Assert.assertEquals(actual1, expected1);
	}
	@Test(enabled=true, priority=12)
	public void ValidatingDateOfBirth() throws InterruptedException
	{
		TCID="116";
		Reporter.log("----->Validating Date of birth tab<-----",true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String actual= numadic.ValidatingDateOfBirth("24/05/1990");
		String expected="Date of birth";
		Assert.assertEquals(actual, expected);
	}
	
	@AfterMethod
	public void screenshot(ITestResult result) throws IOException
	{   
		if(ITestResult.FAILURE==result.getStatus())
		{
			getScreenShot( driver, TCID);
			Reporter.log("---> Test case "+TCID+" failed Took screenshot <---",true);
		}
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException  
	{	
		Thread.sleep(3000);
		driver.quit();
	}
}
