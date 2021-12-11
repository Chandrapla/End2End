package resources;
import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
 static ExtentReports extent;
	
	public static ExtentReports getReportObject() 
	{
		
		String path =System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		 extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rahul Shetty");
		return extent;
		
	}
	@Test

	public void initialDemo()

	{
	
	System.setProperty("webdriver.chrome.driver","E:\\chromdriver\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();	
	driver.get("https://rahulshettyacademy.com/");
	System.out.println(driver.getTitle());
	driver.close();


	}
}
