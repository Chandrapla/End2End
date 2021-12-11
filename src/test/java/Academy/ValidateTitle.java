package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class ValidateTitle extends Base {
	public WebDriver driver;
	//to demostarte on clubbing
	LandingPage l;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver=IntializeDriver();//to calling the intializedrive from base class and it's return driver so stored in driver
		//instead of hard code url
		//driver.get("http://qaclickacademy.com");
		log.info("driver is intialized");
		driver.get(prop.getProperty("url"));
		log.info("hitting the ur");
	}

@Test
public void basePageNavigation() throws IOException {
	
	/*
	 * two way to invoke class
	 * 1.by using inheritance
	 * 2.creating an object of the particular class and invoke the method of it
	 */
	 l= new LandingPage(driver);//for giving life to driver in landingpage passing "driver"
	//compare the the text in browser matchs the actual text required(ie;assertion)
	log.info("validate the text in browser matchs the actual text successful ");
	Assert.assertEquals(l.gettext().getText(), "FEATURED COURSES");
	//System.out.println(l.gettext().getText());
	//giving knowing the false statement it will displayed (ie to have screenshot pn failure)
	Assert.assertFalse(l.gettabcontact().isDisplayed());
	//System.out.println(l.gettabcontact().isDisplayed());
	
	
	
	
}
@AfterTest
public void forClosing() {
	driver.close();
	
}
@Test
public void validation() {
	Assert.assertEquals(l.getheader().getText(),"AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
	
}

	
	 
}
