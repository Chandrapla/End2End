package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
		//to inspect email and password
		By email=By.xpath("//input[@name='email']");
		By password=By.xpath("//input[@name=' password']");
		By login=By.cssSelector("[value='Log In']");
		By forgotpassword=By.cssSelector("a[href*='password/new']");//css regular expression
		
		//to call email and password creating the method
		public WebElement email() {
			return driver.findElement(email);
			
		}
		
		public WebElement getlogin() {
			return driver.findElement(login);
			
		}
		public WebElement password() {
			return driver.findElement(password);
			
		}
		
		public ForgotPassword forgotpassword() {
		 driver.findElement(password).click();//to click forgotpassword which is nativageted to other page
		 ForgotPassword fp=new ForgotPassword(driver);
		 return fp;
		 
			
		}

	}

	



