package pageobjects;

import java.text.SimpleDateFormat;
import  java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;



public class BookingPage {
	WebDriver driver;
  private String dayToSelect;
  private String monthToSelect;
  private String yearToSelect; 
	
	public BookingPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	//selecting the facility
	@FindBy(id="combo_facility")
	WebElement facility;

    public void facility(String facilityName) {
	Select facilityList= new Select(facility);
	facilityList.selectByVisibleText(facilityName);
  }
	
    // selecting hospital readmission
	@FindBy(id="chk_hospotal_readmission")
	WebElement readmission;
	
	public void readmission(String response) {
		if (response.equals("Yes")) {
			readmission.click();
		}
	}
	
	// selecting health care program
	@FindBy (id="radio_program_medicaid")
	WebElement healthProgram;
	
	public void healthProgram()
	{
		healthProgram.click();
	}
	
	// selecting the date
	@FindBy(css=".glyphicon.glyphicon-calendar")
   WebElement calendarIcon;
	
	@FindBy(className="datepicker-switch")
	WebElement diplayedMonthAndYear;
	
	@FindBy(id="txt_visit_date")
	WebElement dateText;
	
	@FindBy(className="next")
	WebElement nextButton;
	
	@FindBy(className="prev")
	WebElement previousButton;
	
	@FindBy(xpath="//table[@class='table-condensed']//td")
	List<WebElement> allDates;
	
	@FindBy(xpath="//div[@class='datepicker-months']/table/tbody/tr/td/span")
	List<WebElement> allMonths;

	
	public String datePicker(String dateToSelect) throws InterruptedException {
		
		//splitting the date to be selected
		String[] splitDate=dateToSelect.split("/");
	     dayToSelect= splitDate[0];
		 monthToSelect=splitDate[1];
		 yearToSelect=splitDate[2];
	    calendarIcon.click();
	  
	    //splitting the displayed date on calendar
       String diplayedMonthAndYearText=diplayedMonthAndYear.getText();
	   String displayedMonth= diplayedMonthAndYearText.split(" ")[0].trim();
	   String displayedYear= diplayedMonthAndYearText.split(" ")[1].trim();
	
	// if it is future date click on next button
	while(!(displayedMonth.equalsIgnoreCase(monthToSelect)&& displayedYear .equals(yearToSelect)))
		{
		if (Integer.parseInt(displayedYear)<Integer.parseInt(yearToSelect)) {
		    nextButton.click();
		}
		// if it is past date click on previous button
	 else if(Integer.parseInt(displayedYear)>Integer.parseInt(yearToSelect))
		{
			previousButton.click();
		}
		
		//if it is current year
	 else {
		 diplayedMonthAndYear.click();
		 List<WebElement> months=allMonths;
	 	for (int i=0; i<months.size();i++) {
        String  firstThreeCharOfMonth= monthToSelect.substring(0, 3);
	 	if(	months.get(i).getText().equalsIgnoreCase(firstThreeCharOfMonth)) {
	 		months.get(i).click();
	 		break;
	 	}
	 }
	 }
		diplayedMonthAndYearText=diplayedMonthAndYear.getText();
		  displayedMonth= diplayedMonthAndYearText.split(" ")[0].trim();
		  displayedYear= diplayedMonthAndYearText.split(" ")[1].trim();
				}
	
	List<WebElement> dates=allDates;
	for (int i=0; i<dates.size();i++) {
	if(	dates.get(i).getText().equals(dayToSelect)) {
		dates.get(i).click();
		break;
	}
	}
		String fullDate=  dateText.getText();
        return fullDate;
	}
	
	@FindBy(id="txt_comment")
	WebElement comment;
	
	public void addComments(String comments) {
	comment.sendKeys(comments);
	}
	
	@FindBy(id="btn-book-appointment")
	WebElement bookAppointment;
 
	public ConfirmationPage bookAppointmentButton() {
		bookAppointment.click();
		ConfirmationPage confirmationpage= new ConfirmationPage(driver);
		return confirmationpage;
	}
}
