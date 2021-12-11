package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	
	//object to click sigin in homepage
	private By sigin=By.cssSelector("a[href*='sign_in']");
	private By text=By.xpath("//div[@class='text-center']/h2 ");
	private By tabcontact=By.xpath("//a[contains(text(),'Contact')]");
private By header=By.cssSelector("div[class*=video-banner] h3");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public LoginPage getLogin() {
		 driver.findElement(sigin).click();
		 LoginPage login=new LoginPage(driver);
		 return login;
		
		
	}
	public WebElement gettext() {
		return driver.findElement(text);
	}
	public WebElement gettabcontact() {
		return driver.findElement(tabcontact);
	}
	public WebElement getheader() {
		return driver.findElement(header);
	}
}
