package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	public WebDriver driver;
	
	
	public ForgotPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	By emailAddress=By.xpath("//input[@id='user_email']");//to enter the email address
	By sendMeInstruction=By.cssSelector("[type='submit']");//to click the send me
	
	public WebElement getemailaddress() {
		 return driver.findElement(emailAddress);
	}

	public WebElement sendMeInstruction() {
		 return driver.findElement(sendMeInstruction);
	}
	
}
