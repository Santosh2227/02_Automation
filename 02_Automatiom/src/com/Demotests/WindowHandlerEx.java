package com.Demotests;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WindowHandlerEx {

	WebDriver driver;
	@BeforeClass
	public void setup() 
	{
		System.setProperty("webdriver.chrome.driver","C:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

	}

	
	public void mainWindowhandler() throws InterruptedException
	{
		driver.get("file:///C:/SELENIUM/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");	
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String main	=driver.getWindowHandle();

		System.out.println(" Id or handle of main window: "+main);

		List<WebElement> links  = driver.findElements(By.partialLinkText("More info"));
		for(WebElement link:links)
		{
			link.click();
		}
		driver.findElement(By.linkText("JavaByKiran")).click();
		Thread.sleep(3000);
		Set<String> windows =	driver.getWindowHandles();//5
		for(String win:windows)
		{
			if(!win.equals(main))
			{
				driver.switchTo().window(win);
				Thread.sleep(3000);
				System.out.println(" Id or handle of child window: " +driver.getWindowHandle());
				System.out.println(driver.getCurrentUrl());
				driver.close();
			}
		}

	}

	@Test
	public void redBusLogin() throws Exception {
		Thread.sleep(10000);
		driver.get("https://www.redbus.in/");
		Thread.sleep(10000);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Thread.sleep(10000);
		driver.findElement(By.id("signin-block")).click();
		driver.findElement(By.id("signInLink")).click();
		Thread.sleep(10000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='modalFrame']")));
		driver.findElement(By.id("mobileNoInp")).sendKeys("123456");
		driver.findElement(By.id("newFbId")).click();// div[@class='modalFrame']
	}
}







