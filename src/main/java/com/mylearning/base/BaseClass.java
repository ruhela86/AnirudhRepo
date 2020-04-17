package com.mylearning.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;



import com.mylearning.utility.WebEventListener;
import com.mylearning.utility.Xls_Reader;

public class BaseClass {
	
	public static WebDriver driver;
	public static String DriverRootPath = System.getProperty("user.dir");
	public static Properties property;
	public static String browserValue;
	
	public EventFiringWebDriver e_driver;
	public WebEventListener eventListener;
	public Xls_Reader Excel;
	
	
	
	public BaseClass()  {
	property = new Properties();
	FileInputStream ip = null;
	try {
		ip = new FileInputStream(DriverRootPath + "\\PropertyFile\\config.properties");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		property.load(ip);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	Excel= new Xls_Reader(DriverRootPath+"\\Resurces\\Devil.xlsx");
	


	
	}
	
	
	/*
	 * @BeforeTest public void ConfigureLog4j() { String Log4jPath =DriverRootPath +
	 * "\\Resurces\\log4j.properties"; Prope.configure(Log4jPath);
	 * 
	 * 
	 * 
	 * }
	 */
	 
	public WebDriver BrowserInit(String browserValue, String URL) throws IOException  {
	
		
		if (browserValue.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", DriverRootPath+"//Drivers//FirefoxDriver//geckodriver.exe");
			driver = new FirefoxDriver();
			
			
		}else if(browserValue.equalsIgnoreCase("Chrome")){
			System.out.println(DriverRootPath);
			System.setProperty("webdriver.chrome.driver", DriverRootPath+"//Drivers//ChromeDriver//chromedriver.exe");
			driver= new ChromeDriver();
				
		}else {
			System.out.println("no driver exist");
		}
		
		  e_driver = new EventFiringWebDriver(driver); 
		  eventListener = new  WebEventListener(); 
		  e_driver.register(eventListener); 
		  driver = e_driver;
		 
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL);
		
		return driver;
	}
	

}
	

