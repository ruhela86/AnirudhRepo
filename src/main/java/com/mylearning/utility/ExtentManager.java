package com.mylearning.utility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	
	public static ExtentReports Createreport() {
		String Filenamme = getReportName();
		String FolderDirectry  = System.getProperty("user.dir")+"\\ExtentReport\\";
		String path = FolderDirectry +Filenamme;
		//htmlReporter = new ExtentHtmlReporter("test-output/myExtentReport.html");
		htmlReporter = new ExtentHtmlReporter(path);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Results");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.setSystemInfo("org", "Self Learning");
		extent.setSystemInfo("Creater", "Anirudh Ruhela");
		extent.attachReporter(htmlReporter);
		
				return extent;
	}
	
	public static String getReportName() {
		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));
		
		String reportname ="AutomationReport_"+dtf.format(now)+".html";
		return reportname;
				
	}


}
