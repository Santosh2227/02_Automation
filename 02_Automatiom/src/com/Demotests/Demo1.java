package com.Demotests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(com.listeners.listenerDemo.class)
public class Demo1 {

	public Logger log=Logger.getLogger(Demo1.class);
  public   static	WebDriver driver;
		@BeforeClass
	public void setup() 
	{
		System.setProperty("webdriver.chrome.driver","C:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("file:///C:/SELENIUM/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");	
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}
	@Test(priority = 1)
	public void logotest01()
	{
		Boolean flag=driver.findElement(By.xpath("//img")).isDisplayed();
		Assert.assertTrue(true, "JBK logo is displayed!!");
	}
	@Test(priority = 2)
	public void loginJBKtest02()
	{
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | User");
	}
	@Test(priority = 3)
	public void openSelenium_pdf_test03()
	{
		driver.findElement(By.xpath("//a[@href='../pdf/selenium-testing-syllabus-jbk.pdf']")).click();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	@Test(priority = 4)
	public void openPHP_pdf_test04()
	{
		driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[4]/div/a")).click();
	}
	@Test(priority = 5)
	public void openPython_pdf_test05()
	{
		driver.findElement(By.xpath("//a[@href='../pdf/python-syllabus.pdf']")).click();
	}
	@Test(priority = 6)
	public void openJ2EE_pdf_test06()
	{
		driver.findElement(By.xpath("//a[@href='../pdf/java-j2ee-syllabus-jbk.pdf']")).click();
	}
	@Test(priority = 7)
	public void getHeaderTitle_test07()
	{
		String header=driver.findElement(By.xpath("//span[@class='logo-lg']")).getText();
		Assert.assertEquals(header, "Java By Kiran");
	}
	
	@Test(priority = 8)
	public void verifyText_test10()
	{
		String copyright =	driver.findElement(By.xpath("//strong[1]")).getText();
		Assert.assertEquals(copyright, "Copyright © 2005-2019 JavaByKiran.");
	}

	@Test(priority = 9)
	public void gettableData_test11()
	{
		driver.findElement(By.xpath("//a[@href='users.html']")).click();
		String tabledata=driver.findElement(By.xpath("//table[@class='table table-hover']")).getText();
		System.out.println(tabledata);
	}
	
	@Test(priority = 10)
	public void addusertest_test13()
	{
		driver.findElement(By.xpath("//a[@href='users.html']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary btn-sm pull-right']")).click();
		driver.findElement(By.id("username")).sendKeys("asdfgcf");
		driver.findElement(By.id("mobile")).sendKeys("123456");
		driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
		driver.findElement(By.id("course")).sendKeys("selenium");
		driver.findElement(By.id("Female")).click();
		Select oselect =new Select(driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[6]/div/select")));
		oselect.selectByIndex(1);
		driver.findElement(By.id("password")).sendKeys("1234");
		driver.findElement(By.id("submit")).click();
		Alert alert=driver.switchTo().alert();
		String text=alert.getText();
		alert.accept();
		Assert.assertEquals(text, "User Added Successfully. You can not see added user.");
			
	}
	@Test(priority =11 )
	public void courseName_test14()
	{
		ArrayList<String> actlist=new ArrayList<String>();
		ArrayList<String> explist=new ArrayList<String>();
		explist.add("Selenium");
		explist.add("Java / J2EE");
		explist.add("Python");
		explist.add("Php");
		List<WebElement>courselist=driver.findElements(By.xpath("//h3"));
		for(WebElement list:courselist)
		{
			String courses=list.getText();
			actlist.add(courses);
		}                                       //	lst.stream().map(WebElement::getText).forEach(lst1::add);
		System.out.println(actlist);
		Assert.assertEquals(actlist, explist);

	}
	@AfterTest
	public void teardowntest()
	{
		driver.close();
	}

	
}
