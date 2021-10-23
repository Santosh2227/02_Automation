package com.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Demotests.Demo1;



public class listenerDemo implements ITestListener  {

	public Logger log=Logger.getLogger(listenerDemo.class);

	public void onTestStart(ITestResult result) {
		log.info("Test Case Starts With Name :"+result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		log.info("Test Case Passed With Name :"+result.getName());

	}

	public void onTestFailure(ITestResult result) {
		SimpleDateFormat sdf = new SimpleDateFormat("  dd-MM-yyyy-hh-mm-ss");
		TakesScreenshot ts=	(TakesScreenshot)Demo1.driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir")+"/screenshots/"+result.getName()+sdf.format(new Date())+".jpg");
		try {
			FileUtils.copyFile(source, destination);
			System.out.println(" screenshots captured");
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("Test Case Failured With Name :"+result.getName());
	}
	public void onTestSkipped(ITestResult result) {
		log.info("Test Case Skipped With Name :"+result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


	}

	public void onStart(ITestContext context) {
		log.info("Test Suite Is Ready To Start The execution");

	}

	public void onFinish(ITestContext context) {
		System.out.println("Test Suite Is finished To Start The execution");
	}

}
