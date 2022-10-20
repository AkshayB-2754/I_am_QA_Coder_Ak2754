package numadicPOM;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NumadicPOM2 
{

@FindBy(xpath="//select[@id='job_type']")private WebElement JobType;
@FindBy(xpath="//a[contains(text(),'QA Engineer')]")private WebElement QAEngineer;
@FindBy(xpath="(//div[@class='container']/descendant::a)[11]")private WebElement ApplyHereNowButton;
@FindBy(xpath="(//button[@class='btn btn-red-outline scroll-form'])[10]")private WebElement QAapplyButton;
@FindBy(xpath="//a[@href='/careers#careersFormContainer']")private WebElement ApplyHereNowButton2;
@FindBy(xpath="//div[contains(text(),'Head Office')]")private WebElement HeadOffice;


public NumadicPOM2(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}


public void jobtype(String job,WebDriver driver)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true)",JobType);
	Select s=new Select(JobType);
	s.selectByVisibleText(job);
}



public void VerifyingQAEngineer(WebDriver driver) throws InterruptedException
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	js.executeScript("arguments[0].scrollIntoView(true)", QAEngineer); 
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	
	js.executeScript("arguments[0].click();", QAEngineer);
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	
}

public String VerifyingURL(WebDriver driver)
{
	String actual = driver.getCurrentUrl();
	return actual;
}

public void ApplyHereNow(WebDriver driver)
{
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	js.executeScript("arguments[0].scrollIntoView(true)", ApplyHereNowButton); 
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));


	boolean applyhereDisplayed = ApplyHereNowButton.isDisplayed();
	boolean applyhereEnabled = ApplyHereNowButton.isEnabled();
	System.out.println(applyhereDisplayed);
	System.out.println(applyhereEnabled);
	

	js.executeScript("arguments[0].click();", ApplyHereNowButton);
		
}



public String VerifyingRedirectBack (WebDriver driver) 

{
	String actual = driver.getCurrentUrl();
	return actual;
	
}


}
