package Academy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPassword;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class HomePage extends Base { 
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void intialize() throws IOException {
		
		driver=IntializeDriver();//to calling the intializedrive from base class and it's return driver so stored in driver
		//instead of hard code url
		//driver.get("http://qaclickacademy.com");
		
	}

@Test(dataProvider="getData")
public void basePageNavigation(String username,String password) throws IOException {
	
	driver.get(prop.getProperty("url"));
	/*
	 * two way to invoke class
	 * 1.by using inheritance
	 * 2.creating an object of the particular class and invoke the method of it
	 */
	LandingPage l= new LandingPage(driver);//for giving life to driver in landingpage passing "driver"
	//l.sigin().click();//to click sigin in homepage
	/*WebDriverWait wait = new WebDriverWait(driver, 5);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav[@class='pull-right']/ul/li[4]/a/span")));
	*/
	LoginPage login = l.getLogin();//to click sigin in homepage
	//for login page
	
	login.email().sendKeys(username);//to enter chandrapalani in email field
	login.password().sendKeys(password);//to enter password
	//System.out.println("passed");
	//log.info("passed the test ");
	//to click login
	login.getlogin().click();
	//to click forgot page
	ForgotPassword otherpage = login.forgotpassword();
	
	otherpage.getemailaddress().sendKeys("xyz");
	otherpage.sendMeInstruction().click();
	
	
	
	
}

@DataProvider
public Object[][] getData() {
	//row stands for how many different data types should run(ie;allowed,restricted)
	//coloumn stands for how many value for each test (ie;how many data need to pass in sendkeys
	//object[1][1] means row is total 2 (0,1) and cloumn is total 2 (0,1)
	Object[][] data=new Object[2][2];
	//0th row ie;for allowed
	data[0][0]="allowed@gmail.com";
	data[0][1]="1234";

	//1st row ie;for restricted
	data[1][0]="restricted@gmial.com";
	data[1][1]="4567";
	
	
	return data;
	
}

@AfterTest
public void forclosing() {
	driver.close();
}

	
	
	 
}
