package numadicPOM;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NumadicPOM1 
{

@FindBy(xpath="//div[@class='page-header']/h1")private WebElement Header;
@FindBy(xpath="//select[@id='job_type']")private WebElement JobType;
@FindBy(xpath="//table[@id='job-posts-table']")private WebElement IntershipVerify;

public NumadicPOM1(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public String verifyingHeader(WebDriver driver)
{
	String actual = Header.getText();
	return actual;
}

public void jobtype(String job,WebDriver driver)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true)",JobType);
	Select s=new Select(JobType);
	s.selectByVisibleText(job);
}

public String VerifyingIntership(WebDriver driver)
{
	String actual = IntershipVerify.getText();
	return actual;
}




}
