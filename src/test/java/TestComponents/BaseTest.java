package TestComponents;

import java.io.File;



import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.LoginPage;

public class BaseTest {
	
public	 WebDriver driver; 
public LoginPage loginpage;

	 
	public WebDriver initialize() throws IOException {
		
	String browserName = getGlobalProperties("browser");
	
	//For Chrome
	if (browserName.contains("chrome")) {	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	} 
	
	// for  Firefox
	else if (browserName.equalsIgnoreCase("firefox")) {
		System.setProperty("webDriver.gecko.driver", getGlobalProperties("firefoxPath"));
        driver= new FirefoxDriver();
	} 
	
	//For Edge
			else if (browserName.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver",getGlobalProperties("egdePath"));
				driver = new EdgeDriver();
			}     
	
	driver.manage().window().maximize();
	return driver;
}
	//Fetching information from global properties file
	public String getGlobalProperties(String property) {
		Properties prop= new Properties();
		String projectDir = System.getProperty("user.dir"); 
	    String filePath = projectDir + "\\src\\main\\java\\resources\\global.properties";
	    try (FileInputStream inputStream = new FileInputStream(filePath)) {
	        prop.load(inputStream);
	    }
	    catch(Exception e) {
	    	   System.out.println("An error occurred: " + e.getMessage());
	    }
	 return prop.getProperty(property);
	    }
	 
//initiate driver and launch website 
	@BeforeMethod
	public void launchWebsite() throws IOException {
	driver=	initialize();
		 loginpage= new LoginPage(driver);
		loginpage.goTo();
	}
	
    //helper method to take screenShot
	public String  getScreenShot(String testCaseName, WebDriver driver) throws IOException {
   TakesScreenshot ts= (TakesScreenshot)driver;
  File source=	ts.getScreenshotAs(OutputType.FILE);
  File file= new File(System.getProperty("user.dir")+"//reports//"+ testCaseName+ ".png");
  FileUtils.copyFile(source, file);	
  return System.getProperty("user.dir")+"//reports//"+ testCaseName+ ".png"; }
	
	
	@AfterMethod
	public void closeBowser() {
		driver.close();
			}
}











