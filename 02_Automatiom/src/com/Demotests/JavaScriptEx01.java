package com.Demotests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptEx01 {


	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver","C:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("file:///C:/SELENIUM/Offline%20Website/Offline%20Website/index.html");

		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		  js.executeScript("document.getElementById('email').value='Kiran@gmail.com';");
		  js.executeScript("document.getElementById('password').value='123456';");
		  js.executeScript("document.getElementByxpath('//button').click();");
		 Thread.sleep(2000);
		 
		 //("https://www.browserstack.com/users/sign_in");
	
		/*
		 * driver.get("https://www.browserstack.com/users/sign_in"); 
		 * js.executeScript("document.getElementById('user_email_login').value='rbc@xyz.com';");
		 * js.executeScript("document.getElementById('user_password').value='password';"
		 * ); js.executeScript("document.getElementById('user_submit').click();");
		 * js.executeScript("alert('enter correct login credentials to continue');"); Th
		 */
		 
	}

}
