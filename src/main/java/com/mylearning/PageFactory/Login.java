package com.mylearning.PageFactory;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mylearning.base.BaseClass;

public class Login extends BaseClass {
	
	

	public Login() throws IOException {
		//super();
		// TODO Auto-generated constructor stub
		//this.driver = driver;
			PageFactory.initElements(driver, this);
		
		
	}
	
	
	///Page Factory
	
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement username;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement Passowrd;
	
	@FindBy(xpath="//input[@class='btn btn-small']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement SignUpLink;
	
	@FindBy(xpath="//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement CRMLogo;
	
	@FindBy(xpath="//h1[contains(text(),'Power up your sales, customer service, and marketi')]")
	WebElement WelcomeMsg;	
	
	@FindBy(xpath="//td[@class='logo_text']")
			WebElement CRMtext;;
	
	public boolean LogoVerify() {
		return CRMLogo.isDisplayed();
	}
	
    public boolean MessgeVerify() {
    	return WelcomeMsg.isDisplayed();
    }
    
  
   
    	
    
    
    public HomePage login(String uid, String pwd) {
    	username.sendKeys(uid);
    	Passowrd.sendKeys(pwd);
    	LoginBtn.click();
    	return new HomePage(); 	
    	
    }
public String VerifyHomePage() {
		
		return driver.getTitle();
	}
}
