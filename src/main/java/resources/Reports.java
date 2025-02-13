package resources;

import com.aventstack.extentreports.ExtentReports;

//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class Reports {
	public ExtentReports getExtentReport() {
	String path=System.getProperty("user.dir")+"//reports//index.html";
	ExtentSparkReporter reporter= new ExtentSparkReporter(path);
	reporter.config().setDocumentTitle("CURA Health Care");
	reporter.config().setReportName("Cura HealthCare Automation");
	ExtentReports extent= new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("tester", "jaspreet");
	return extent;
	
	}

}
