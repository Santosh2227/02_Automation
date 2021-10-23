package com.Demotests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RobotClassDemo {

	WebDriver driver=null;
	Robot robot=null;
	Actions action=null;
	@BeforeClass
	public void setup() throws AWTException 
	{
		action = new Actions(driver);
		robot=new Robot();

		System.setProperty("webdriver.chrome.driver","C:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	//@Test
	public void copyLogoautomation() throws InterruptedException 
	{
		driver.get("file:///C:/SELENIUM/Offline%20Website/Offline%20Website/index.html");
		action = new Actions(driver);
		action.contextClick(driver.findElement(By.tagName("img"))).perform();
		Thread.sleep(5000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(3000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(10000);
	}
	@Test
	public void testUpload() throws InterruptedException, AWTException
	{
		driver.get("http://javabykiran.com/playground");
		driver.findElement(By.linkText("File Upload")).click();

		WebElement	element=driver.findElement(By.xpath("//input[@id='file']"));
		action.contextClick(element).perform();
		Thread.sleep(5000);
		System.out.println(driver.getTitle());

		StringSelection ss = new StringSelection("E:\\Screenshot\\AutoIT.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Thread.sleep(5000);

		robot.delay(250); 
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);

		Thread.sleep(3000);
		//		driver.findElement(By.xpath("//button[@id='submitbutton']")).click();

	}
	
	
}














