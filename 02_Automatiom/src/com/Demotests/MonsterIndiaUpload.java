package com.Demotests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MonsterIndiaUpload {

	WebDriver driver;
	@Test
	public void FileUpload() throws InterruptedException, AWTException
	{
		System.setProperty("webdriver.chrome.driver","C:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		StringSelection ss = new StringSelection("C:\\Users\\ABC\\Desktop\\TestRunner.java");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	
		driver.get("http://my.monsterindia.com/create_account.html");
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, 350)");
		Thread.sleep(5000);
		
		driver.findElement(By.id("wordresume")).click();
		System.out.println(" Browse button click ");
		
		Robot robot = new Robot();
		Thread.sleep(3000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		
	}
	
}









