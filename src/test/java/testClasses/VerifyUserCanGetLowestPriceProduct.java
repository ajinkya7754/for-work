package testClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import UtilClasses.Util1;
import baseClasses.Base1;
import pomClasses.HomePage;

public class VerifyUserCanGetLowestPriceProduct {
	
WebDriver driver;
	
	HomePage hp;
	
	
	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browser) {
	
		
		driver = Base1.getDriver(browser);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		hp = new HomePage(driver);
	}
	
	@Test()
	public void VerifyUserGetLowestPriceProduct() {
		hp.searchProduct();	
		
		for(int i=1; i<=5; i++) {
			
			if(i != 1) {
				hp.switchPage(i);
			}
			
			Assert.assertNotEquals(hp.getLowsetPrice(), "");
		}
		
		
		
	}
	
	
	@AfterMethod
	public void afterMethod (){
		
	}
			
	@AfterClass
	public void afterClass() {
		Base1.unloadDriver();
	}

}
