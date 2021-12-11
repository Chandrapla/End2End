package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
public WebDriver driver;
public Properties prop;
public WebDriver IntializeDriver() throws IOException
{
	 prop=new Properties();
	 //instead of hard coding the path
	 FileInputStream fis=new FileInputStream("E:\\workplace\\End2EndProject\\src\\main\\java\\resources\\data.properties");
	 //System.getProperty("user.dir")
	//FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	prop.load(fis);//to intergrate data file in prop
	//to call browser from maven mvn test while compiling
	String browserName=System.getProperty("browser");
	//String browserName=prop.getProperty("browser");//to grab which browser u given in property file
	System.out.println(browserName);
	if(browserName.contains("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","E:\\chromdriver\\chromedriver.exe");
		//to run the chrome in headless mode
		ChromeOptions options= new ChromeOptions();
		if(browserName.contains("headless"))
		{
		options.addArguments("headless");
		}
		 driver=new ChromeDriver(options);
	}
	else if(browserName.equals("firefox")) 
	{
	
		System.setProperty("webdriver.gecko.driver", "E:\\geckodriver\\geckodriver.exe");
        driver=  new FirefoxDriver();
     }
	else if(browserName.equals("IE")) 
	{
		
	
		System.setProperty("webdriver.ie.driver", "E:\\IEDriverServer\\IEDriverServer.exe");
		 driver= new InternetExplorerDriver(); 
     }
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//to wait for all load limit set to 10sec
	return driver;
	
}
public String getScreenshotPath(String testCaseName,WebDriver driver) throws IOException
{
TakesScreenshot ts=(TakesScreenshot) driver;
File source=ts.getScreenshotAs(OutputType.FILE);
//source is in virtual place but we don't destination pagedestinationPage=System.getProperty("
 //String destinationFilePath=System.getProperty("user.dir")+\\reports\\"+testCaseName+".png";
String destinationFilePath = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
FileUtils.copyFile(source, new File(destinationFilePath));
//return is given to give path to listener
return destinationFilePath;
}
}