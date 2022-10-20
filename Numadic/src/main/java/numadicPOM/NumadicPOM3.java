package numadicPOM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import numadicUtility.Utility;

public class NumadicPOM3 extends Utility
{

@FindBy(xpath="(//button[@class='btn btn-red-outline scroll-form'])[12]")public WebElement QAEngi;
@FindBy(xpath="//a[contains(text(),'QA Engineer')]")public WebElement QAEngineer;
@FindBy(xpath="//input[@id='firstName']")public WebElement FirstName;
@FindBy(xpath="//label[@id='name_label']")public WebElement FirstNameLable;
@FindBy(xpath="//ul[@id='parsley-id-5']/li")public WebElement FNerror;
@FindBy(xpath="//input[@id='lastName']")public WebElement LastName;
@FindBy(xpath="//label[@class='required-field']/following-sibling::input[@id='lastName']/preceding-sibling::label")public WebElement LastNameLable;
@FindBy(xpath="//ul[@id='parsley-id-7']/li")public WebElement LNerror;
@FindBy(xpath="//div//input[@id='email']")public WebElement Email;
@FindBy(xpath="//label[@id='email_label']")public WebElement EmailLable;
@FindBy(xpath="//ul[@id='parsley-id-9']/li")public WebElement EmailError;
@FindBy(xpath="//input[@id='phone']")public WebElement Phone;
@FindBy(xpath="//label[@id='phone_label']")public WebElement PhoneLable;
@FindBy(xpath="//ul[@id='parsley-id-11']/li")public WebElement PhoneError;
@FindBy(xpath="//select[@id='sports']")public WebElement Sports;
@FindBy(xpath="//label[@id='sports_label']")public WebElement SportLable;
@FindBy(xpath="//select[@id='pets']")public WebElement Pets;
@FindBy(xpath="//label[@id='pets_label']")public WebElement PetsLable;
@FindBy(xpath="//input[@id='current_city']")public WebElement CurrentCity;
@FindBy(xpath="//div[@class='form-group']/label[contains(text(),'Current city')]")public WebElement CurrentCityLable;
@FindBy(xpath="//input[@id='hometown']")public WebElement HomeTown;
@FindBy(xpath="//div[@class='form-group']/label[contains(text(),'Hom')]")public WebElement HomeTownLable;
@FindBy(xpath="//input[@id='dob']")public WebElement DateOfBirth;
@FindBy(xpath="//div[@class='form-group']/label[contains(text(),'Date')]")public WebElement DateOfBirthLable;
@FindBy(xpath="//ul[@id='parsley-id-21']/li")public WebElement DOBError;
@FindBy(xpath="//input[@id='careers_form_btn_step1']")public static WebElement NextButton;
//@FindBy(xpath="(//th[@class='datepicker-switch'])[1]")public  WebElement Date;


public NumadicPOM3(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public void ClickOnQA(WebDriver driver)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true)",QAEngineer);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	Actions a=new Actions(driver);
	a.moveToElement(QAEngi).perform();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	a.click(QAEngi).perform();
}

public void ClickNextButton()
{
	NextButton.click();
}

public String FirstNameErrorMsg(WebDriver driver) throws InterruptedException
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
    js.executeScript("window.scrollBy(5000,0)");
    Thread.sleep(3000);
	
    String actual = ValidatingErrorMsg(FNerror);
    System.out.println(actual);
	return actual;
}
public String LastNameErrorMsg()
{
	return ValidatingErrorMsg(LNerror);
}
public String EmailErrorMsg()
{
	return ValidatingErrorMsg(EmailError);
}
public String PhoneNoErrorMsg()
{
	return ValidatingErrorMsg(PhoneError);
}
public String DateOfBirthErrorMsg()
{
	return ValidatingErrorMsg(DOBError);
}
public String ValidatingFirstName(String name) throws InterruptedException
{
	
	return ValidatingDifferentTabs(FirstName, FirstNameLable, name,"First name tab");	
}
public String ValidatingLastName(String name) throws InterruptedException
{
	
	return ValidatingDifferentTabs(LastName, LastNameLable, name,"Last name tab");	
}
public String ValidatingEmail(String name) throws InterruptedException
{
		return ValidatingDifferentTabs(Email, EmailLable, name,"Email tab");	
}
public String ValidatingPhoneNumber(String name) throws InterruptedException
{
		return ValidatingDifferentTabs(Phone, PhoneLable, name,"Mobile tab");	
}
public String ValidatingCurrentCity(String name) throws InterruptedException
{
		return ValidatingDifferentTabs(CurrentCity, CurrentCityLable, name,"Current city");	
}
public String ValidatingHomeTown(String name) throws InterruptedException
{
		return ValidatingDifferentTabs(HomeTown, HomeTownLable, name,"Hometown");	
}
public String ValidatingSportsDropDown(String text) throws InterruptedException //Validating for lable.
{
		return ValidatingDropDown(Sports,SportLable,"Sport",text);	
}
public String ValidatingDateOfBirth(String name) throws InterruptedException
{
		return ValidatingDifferentTabs(DateOfBirth, DateOfBirthLable, name,"Date Of Birth");	
}

public List<String> ValidatingSportsDropDown() throws InterruptedException
{
	Thread.sleep(3000);
	return ValidatingDropDownContain(Sports);
	
}
public String ValidatingPetsDropDown(String text) throws InterruptedException //Validating for lable.
{
		return ValidatingDropDown(Pets,PetsLable,"Pets",text);	
}


public List<String> ValidatingPetsDropDown() throws InterruptedException //Validating for drop down contain.
{
	Thread.sleep(3000);
	return ValidatingDropDownContain(Pets);
}


}


