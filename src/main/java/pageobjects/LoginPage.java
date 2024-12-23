package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
		public LoginPage(WebDriver driver) {
			this.driver= driver;
			PageFactory.initElements(driver,this);
		}
		
		
		@FindBy(id="btn-make-appointment")
		WebElement makeappointment;
		
		@FindBy(xpath="//input[@placeholder='Username'][1]")
	    WebElement getusername;
		
		@FindBy(xpath="//input[@placeholder='Password'][1]")
        WebElement getpassword;
	
		@FindBy(id="txt-username")
		WebElement setusername;
		
		@FindBy(id="txt-password")
		WebElement setpassword;
		
		@FindBy(id="btn-login")
		WebElement loginbutton;
		
		@FindBy(css=".lead.text-danger")
		WebElement errorText;
		
		@FindBy(xpath="//div[@class=\"col-sm-12 text-center\"]/h2")
		WebElement bookingPageText;
		
		
		public BookingPage loginInformation() {
		String username=	getusername.getAttribute("value");
		String password= getpassword.getAttribute("value");
		curaLogin(username,password);
		BookingPage bookingpage= new BookingPage(driver);
		return bookingpage;
        }
		
		public void goTo() {
			driver.get("https://katalon-demo-cura.herokuapp.com/");
			makeappointment.click();
		}

		public void curaLogin(String username, String password) {
			setusername.sendKeys(username);
			setpassword.sendKeys(password);
			loginbutton.click();	
		}
		
		public String loginErrorText() {
			String error=errorText.getText();
			return error;
		}
		
		public String bookPageText() {
			String text=bookingPageText.getText();
			return text;
		}
		
		
		
		
}


