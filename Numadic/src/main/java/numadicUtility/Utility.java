package numadicUtility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import numadicConfiguration.Configuration;

public class Utility
{

	public  static void getScreenShot(WebDriver driver,String TCID) throws IOException
	{
		Date d=new Date();
		String str=d.toString();
		str=str.replace(" ", "_");
		str=str.replace(":", "_");
		File Source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Destination=new File(Configuration.ssPath+TCID+"_"+str+"_.jpg");
		FileHandler.copy(Source, Destination);
	}
	
	public static String ValidatingErrorMsg(WebElement element)
	{
		String actual=element.getText();
		return actual;
	}
	
	public static String ValidatingDifferentTabs(WebElement element, WebElement element1, String name,String tabname) throws InterruptedException
	{
		System.out.println(tabname+" Visibility is "+element.isDisplayed());
		System.out.println(tabname+" Activity is "+element.isEnabled());
		String actual = element1.getText();
		Thread.sleep(500);
		element.sendKeys(name);
		if(tabname.equalsIgnoreCase("Date of birth"))
		{
			element.sendKeys(Keys.ENTER);
		}
		return actual;	
	}
	public static String ValidatingDropDown(WebElement element,WebElement elementlable, String dropdownName,String text)
	{
		System.out.println(dropdownName+" Visibility is "+elementlable.isDisplayed());
		System.out.println(dropdownName+" Activity is "+elementlable.isEnabled());
		String actual = elementlable.getText();
		Select s=new Select(element);
		s.selectByVisibleText(text);
		return actual;
	}
	
	public static List<String> ValidatingDropDownContain(WebElement element) 
	{		
		Select s=new Select(element);
		List<WebElement> ListOfDropdownValue=s.getOptions();
		List<String>actualValue=new ArrayList<String>();
		for(WebElement sp:ListOfDropdownValue)
		{
			actualValue.add(sp.getText());
		}
		return actualValue;
	}
}
