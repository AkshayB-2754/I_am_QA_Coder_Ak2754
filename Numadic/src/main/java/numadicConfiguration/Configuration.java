package numadicConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Configuration 
{

	static WebDriver driver;
	public static String cwdPath="webdriver.chrome.driver";
	public static String cdPath="C:\\Users\\admin\\eclipse-workspace\\OpenMRS\\Drivers\\chromedriver.exe";
	public static String url="https://numadic.com/careers/";
	public static String gwdPath="webdriver.gecko.driver";
	public static String gdPath="C:\\Users\\admin\\eclipse-workspace\\Numadic\\Drivers\\geckodriver.exe";
	public static String ssPath="C:\\Users\\admin\\eclipse-workspace\\Numadic\\target\\ScreenShots\\";
	
	public WebDriver ChromeInitialization() throws InterruptedException //method for launching browser
	{
		ChromeOptions options=new ChromeOptions(); 
		options.addArguments("--disable-notifications"); 
		System.setProperty(cwdPath,cdPath);
		 driver=new ChromeDriver(options);
		 driver.get(url);
		 driver.manage().window().maximize();
		 Thread.sleep(5000);
		 return driver; 
	}
}
