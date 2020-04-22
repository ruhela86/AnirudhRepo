package com.mylearning.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mylearning.PageFactory.HomePage;
import com.mylearning.PageFactory.Login;
import com.mylearning.base.BaseClass;



public class LoginTest extends BaseClass{
	
	Login log;
	HomePage Home;
	boolean flag=true;

	
	public LoginTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	

	@BeforeMethod
	public void beforemethod() throws IOException {
	String Br =property.getProperty("browser");
		driver =BrowserInit(Br, property.getProperty("URL"));
		log= new Login();	
		
	}
	
	
	@Test
	public void ValidateLogo() {
		Assert.assertTrue(log.LogoVerify());
		
		
	}
	
	@Test(enabled = true)
	public void ValicadteWelcomeMsg() {
		Assert.assertTrue(log.MessgeVerify());
	
	}
	

	
	
	@Test(enabled = true)
	public void validatelogin() throws IOException {
	Home =log.login( Excel.getCellData("Sheet1", "userid", 2),  Excel.getCellData("Sheet1", "password", 2));
	Assert.assertEquals(log.VerifyHomePage(),"CRMPRO" );
		
		
	}
	
	@Test(enabled = true)
	public void checkbranch1() {
		System.out.println("cadding code to branch 1");
	}
	
	
	
	@Test(enabled = true)
	public void testfail() {
		Assert.assertEquals(true, false);
	}
	
	
	@AfterMethod
	public void aftermethod() {
		System.out.println("after method");
		/* ITestResult result----parameter
		 * if (ITestResult.FAILURE==result.getStatus()){
		 * FacebookUtility.screenshoot(driver); }else
		 * if(ITestResult.SKIP==result.getStatus()){
		 * System.out.println("test is skipped"); }
		 */
		
		driver.quit();
	}
}
