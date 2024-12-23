package CURAHealthCare.BookAppt;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import pageobjects.LoginPage;

public class Login extends BaseTest {
	
	String userName="John Doe";
	String password="ThisIsNotAPassword";
	String errorMessage="Login failed! Please ensure the username and password are valid.";
	
	
	@Test(description="verify login functionality  with valid username and password")
	public void loginOne() {
		String bookingPageText="Make Appointment";
		loginpage.curaLogin(userName, password );
		Assert.assertEquals(loginpage.bookPageText(), bookingPageText);
				}	
	
	@Test(description="verify login functionality  with invalid username and valid password")
	public void loginThree() {
		String userName="John voe";
		loginpage.curaLogin(userName, password );
		Assert.assertEquals(loginpage.loginErrorText(), errorMessage);
	}
	
	@Test(description="verify login functionality  with valid username and invalid password")
	public void loginFour() {
		String password="APassword";
		loginpage.curaLogin(userName, password );
		Assert.assertEquals(loginpage.loginErrorText(), errorMessage);
		}
	
	@Test(description="verify login functionality  with null username and null password")
	public void loginFive() {
		String userName="";
		String password="";
		loginpage.curaLogin(userName, password );
		Assert.assertEquals(loginpage.loginErrorText(), errorMessage);
	}
	
	@Test(description="verify login functionality  with lowercase username and lowercase password")
	public void loginSix() {
		String userName="john deo";
		String password="thisisnotapassword";
		loginpage.curaLogin(userName, password );
		Assert.assertEquals(loginpage.loginErrorText(), errorMessage);
	}
	
//	@Test(dataProvider="loginData")
//	public void loginDataProvider( String userName, String password ) {
//		loginpage.curaLogin(userName, password );
//		Assert.assertEquals(loginpage.loginErrorText(), errorMessage);
//	}
	
//	@DataProvider
//	public Object[][] loginData() {
//		Object[][]  data = new Object[4][2];
//	
//		data [0][0]="John voe";
//		data [0][1]="ThisIsNotAPassword";
//		
//		data[1][0]="John Doe";
//    	data[1][1]="ThisIsNotPassword";
//    	
//    	data[2][0]="";
//    	data[2][1]="";
//    	
//    	data [3][0]="john doe";
//    	data[3][1]="thisisnotapassword";
//    	
//    	return data;
//		
//	}
	
}
