package com.mylearning.utility;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.mylearning.base.BaseClass;

public class CustomListner extends BaseClass implements ITestListener {
	
	private static ExtentReports extent =ExtentManager.Createreport();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTest test = extent.createTest(result.getTestClass().getName()+" :: "
														+ result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String LogText = "<b>Test Method "+ result.getMethod().getMethodName() +" Successful</b>";
		Markup m = MarkupHelper.createLabel(LogText, ExtentColor.GREEN);
		extentTest.get().log(Status.PASS, m);
		
		
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String spath = null;
		String ExceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		extentTest.get().fail("Exception occured, click to see details"+ ExceptionMessage.replaceAll("," , "<br>") );
		try {
			 spath = Util.getScreenshot(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			extentTest.get().fail("<b><font color=red>"+"Screenshot of Failure"+"</font></b>", 
					MediaEntityBuilder.createScreenCaptureFromPath(spath).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String logText = "<b>test Method" + result.getMethod().getMethodName() +"failed</b>";
				Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
				extentTest.get().fail(m);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String LogText = "<b>Test Method "+ result.getMethod().getMethodName() +" Skipped</b>";
		Markup m = MarkupHelper.createLabel(LogText, ExtentColor.BLUE);
		extentTest.get().log(Status.SKIP, m);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
	if (extent != null)	
		extent.flush();
		}

}
