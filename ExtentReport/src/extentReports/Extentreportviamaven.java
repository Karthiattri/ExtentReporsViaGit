package extentReports;

import java.io.File;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
@SuppressWarnings("deprecation")
public class Extentreportviamaven {
	WebDriver driver;
	ExtentReports extentReport;
	
	ExtentHtmlReporter htmlReport;
	ExtentTest testcase;
	@Test
	public void OpenGoogle()throws IOException
	{
		testcase=extentReport.createTest("Verify Google Title");
		testcase.log(Status.INFO, "Navigating to google");
		driver.get("http://www.google.co.in");
		String title=driver.getTitle();
		testcase.log(Status.INFO, "Actual to title: "+title);
		testcase.log(Status.INFO, "Expected title:  "+ "Google");
		testcase.log(Status.INFO, "Verification of Actual and Expected title");
		if(title.equals("Google"))
		{
			testcase.log(Status.PASS,"Actual title and Expected title are equl");
		}else
		{
			testcase.log(Status.FAIL,"Actual title and Expected title Not are equl");
			TakesScreenshot screenshot=(TakesScreenshot) driver;
			File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
			File desinationFile=new File("google.png");
			FileHandler.copy(sourceFile, desinationFile);
			testcase.addScreenCaptureFromPath("google.png");
		}
	}
	@Test
	public void OpenBing()throws IOException
	{
		testcase=extentReport.createTest("Verify Bing Title");
		testcase.log(Status.INFO, "Navigating to Bing");

		driver.get("http://www.bing.com");
		String title=driver.getTitle();
		testcase.log(Status.INFO, "Actual to title: "+title);
		testcase.log(Status.INFO, "Expected title:  "+ "bing");
		testcase.log(Status.INFO, "Verification of Actual and Expected title");
		if(title.equals("bing"))
		{
			testcase.log(Status.PASS,"Actual title and Expected title are equl");
		}else
		{
			testcase.log(Status.FAIL,"Actual title and Expected title Not are equl");
			TakesScreenshot screenshot=(TakesScreenshot) driver;
			File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
			File desinationFile=new File("bing.png");
			FileHandler.copy(sourceFile, desinationFile);
			testcase.addScreenCaptureFromPath("bing.png");
		}
	}
	@Test
	public void OpenWikipedia()throws IOException
	{
		testcase=extentReport.createTest("Verify WiKipedia Title");
		testcase.log(Status.INFO, "Navigating to wiKipedia");

		driver.get("http://www.WiKipedia.org");
		String title=driver.getTitle();
		testcase.log(Status.INFO, "Actual to title: "+title);
		testcase.log(Status.INFO, "Expected title:  "+ "WiKipedia");
		testcase.log(Status.INFO, "Verification of Actual and Expected title");
		if(title.equals("WiKipedia"))
		{
			testcase.log(Status.PASS,"Actual title and Expected title are equl");
		}else
		{
			testcase.log(Status.FAIL,"Actual title and Expected title Not are equl");
			TakesScreenshot screenshot=(TakesScreenshot) driver;
			File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
			File desinationFile=new File("wiki.png");
			FileHandler.copy(sourceFile, desinationFile);
			testcase.addScreenCaptureFromPath("wiki.png");
		}
	}
	
	@BeforeSuite
	public void OpenBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Nandhini\\Desktop\\java and selinm jar\\gecko\\geckodriver.exe");
		driver = new FirefoxDriver();
		extentReport=new ExtentReports();
		htmlReport=new ExtentHtmlReporter("ExtentReport.html");
		extentReport.attachReporter(htmlReport);	
	}
	@AfterSuite	
	public void CloseBrowser()
	{
		driver.quit();
		extentReport.flush();


	}
}

