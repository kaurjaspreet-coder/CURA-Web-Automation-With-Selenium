package CURAHealthCare.BookAppt;

import java.io.IOException;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import pageobjects.BookingPage;
import pageobjects.ConfirmationPage;
import pageobjects.LoginPage;

public class apptBooking  extends BaseTest{
	@Test
	public void bookingTest() throws InterruptedException{
		String facilityName= "Hongkong CURA Healthcare Center";
		String readmissionYes="Yes";
		String date="14/November/2024";
		String comments="Reports will be sent to the clinic";	
	BookingPage bookingpage= loginpage.loginInformation();
	bookingpage.facility(facilityName);
	bookingpage.readmission(readmissionYes);
	bookingpage.datePicker(date);
	bookingpage.addComments(comments);
    ConfirmationPage confirmationpage=	bookingpage.bookAppointmentButton();
	
	// confirming text 
Assert.assertEquals(facilityName, confirmationpage.confirmingFacility());
Assert.assertEquals(readmissionYes, confirmationpage.confirmingReadmission());	
Assert.assertEquals(date, confirmationpage.confirmingVisitingDate());
Assert.assertEquals(comments, confirmationpage.confirmingComment());
	
 //checking history
	driver.findElement(By.cssSelector(".btn.btn-dark.btn-lg.toggle")).click();
	driver.findElement(By.linkText("History")).click();
	driver.findElement(By.cssSelector(".btn.btn-dark.btn-lg.toggle")).click();
	driver.findElement(By.linkText("Logout")).click();
	}	
	}

	



