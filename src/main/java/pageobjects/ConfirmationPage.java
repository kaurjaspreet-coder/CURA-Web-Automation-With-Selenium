package pageobjects;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(tagName="h2")
	WebElement message;
	
	@FindBy (id="facility")
	WebElement checkingFaciity;
	
	@FindBy(id="hospital_readmission")
	WebElement checkingHospitalReadmission;
	
	@FindBy(id="program")
	WebElement checkingProgram;
	
	@FindBy(id="visit_date")
	WebElement checkingVisitDate;
	
	@FindBy(id="comment")
	WebElement checkingComment;
	
	@FindBy(css=".btn.btn-default")
	WebElement button;
	
	public String confirmingMessage() {
		String  messageConfirmation=message.getText();
		return messageConfirmation;
	}
	public String confirmingFacility() {
		String facilityConfirmation=checkingFaciity.getText();
		return facilityConfirmation;
	}
	public String confirmingReadmission() {
		String readmissionConfirmation=checkingHospitalReadmission.getText();
		return readmissionConfirmation;
	}
	public String confirmingProgram() {
		String programConfirmation= checkingProgram.getText();
		return programConfirmation;
	}
	public String confirmingVisitingDate() {
	String date=checkingVisitDate.getText();
	String formatDate=reverseFormatDate(date);
	return formatDate;
	}
	
	public String confirmingComment() {
		String comment=checkingComment.getText();
		return comment;
		}
	
	public void confirmationBurron() {
		button.click();
	}
	
	public static String reverseFormatDate(String date) {
        try {
            // Parse the input date in the format "dd/MM/yyyy"
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date parsedDate = inputFormat.parse(date);

            // Format the parsed date to the desired format "dd/MMMM/yyyy" (full month name)
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MMMM/yyyy");
            return outputFormat.format(parsedDate);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Handle the exception as needed
        }
    }
}
