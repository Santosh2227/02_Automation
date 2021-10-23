package OffilinePages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DashPage {


	WebDriver driver;
	String Url="file:///C:/SELENIUM/Offline%20Website/Offline%20Website/index.html";

	WebElement links;
	WebElement python;;
	WebElement sel;
	WebElement j2ee ;
	WebElement php ;


	@BeforeClass
	public void logInSite()
	{
		driver =	CommonUtility.openBrowser("chrome");
		CommonUtility.openUrl(driver, Url);
		CommonUtility.writeTextbox(driver, "id", "email", "kiran@gmail.com");
		CommonUtility.writeTextbox(driver, "id", "password", "123456");
		CommonUtility.ClickTo(driver, "xpath", "//button");

	}

	@Test
	public void checkTitle() {
		String title=driver.getTitle();
		System.out.println(title);
	}
	@Test
	public void checkText()
	{
		String text1=CommonUtility.checkTextBox(driver, "xpath", "//a[text()='JavaByKiran']");
		String text2=CommonUtility.checkTextBox(driver, "xpath", "//b[text()='Design for Selenium Automation Test']");
		String text3=CommonUtility.checkTextBox(driver, "xpath", "//small[text()='Courses Offered']");
		String text4=CommonUtility.checkTextBox(driver, "xpath", "//strong[text()='Copyright © 2005-2019 ']");
		System.out.println(text1);
		System.out.println(text2);
		System.out.println(text3);
		System.out.println(text4);
	}
	@Test
	public void checkCourses()
	{
		List<WebElement>actCourses=driver.findElements(By.xpath("//h3"));
		for(WebElement course:actCourses)
		{
			String courses=course.getText();
			System.out.println(courses); 
		}	
	}

	@Test
	public void expectedCheckList()
	{
		sel =CommonUtility.getElementasPerLocator("xpath","//h3[text()='Selenium']");
		python=CommonUtility.getElementasPerLocator("xpath", "//h3[text()='Python']");
		j2ee=CommonUtility.getElementasPerLocator("xpath","//h3[text()='Java / J2EE']");
		php=CommonUtility.getElementasPerLocator("xpth", "//h3[text()='Php']");

		if(sel.isDisplayed())
			System.out.println(sel.getText()+" "+sel.getSize()+" "+sel.getLocation());
		if(j2ee.isDisplayed())
			System.out.println(j2ee.getText()+" "+j2ee.getSize()+" "+j2ee.getLocation());
		if(python.isDisplayed())
			System.out.println(python.getText()+" "+python.getSize()+" "+python.getLocation());
		if(php.isDisplayed())
			System.out.println(php.getText()+" "+php.getSize()+" "+php.getLocation());

	}
	@Test
	public void openSelenium_pdf_test03()
	{
		links=CommonUtility.getElementasPerLocator("xpath", "//a[@class='small-box-footer'][1]");
		sel =CommonUtility.getElementasPerLocator("xpath","//h3[text()='Selenium']");
		if(links.equals(sel))
			sel.click();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	@Test
	public void openPHP_pdf_test04()
	{
		links=CommonUtility.getElementasPerLocator("xpath", "//a[@class='small-box-footer'][1]");
		php=CommonUtility.getElementasPerLocator("xpth", "//h3[text()='Php']");
		if(links.equals(php))
			php.click();

	}
	@Test
	public void openPython_pdf_test05()
	{
		links=CommonUtility.getElementasPerLocator("xpath", "//a[@class='small-box-footer'][1]");
		python=CommonUtility.getElementasPerLocator("xpath", "//h3[text()='Python']");
		if(links.equals(python))
			python.click();		
	}
	@Test
	public void openJ2EE_pdf_test06()
	{
		links=CommonUtility.getElementasPerLocator("xpath", "//a[@class='small-box-footer'][1]");
		j2ee=CommonUtility.getElementasPerLocator("xpath","//h3[text()='Java / J2EE']");
		System.out.println(links);
		if(links.equals(j2ee))
			j2ee.click();
	}
	@Test
	public void getHeaderTitle_test07()
	{
		WebElement header=CommonUtility.getElementasPerLocator("xpath","//span[@class='logo-lg']");
		Assert.assertEquals(header.getText(), "Java By Kiran");
	}




	@AfterTest
	public void tearDown()
	{
		driver.close();
		System.out.println(" Test Run ");
	}



}
/*
WebElement sel=CommonUtility.findelement("xpath", "//a[@href='../pdf/selenium-testing-syllabus-jbk.pdf']");
WebElement	php=CommonUtility.findelement("xpath", "//a[@href='#' and @class='small-box-footer']");
//driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[4]/div/a")).click();
python	=CommonUtility.findelement("xpath", "//a[@href='../pdf/python-syllabus.pdf']");
driver.findElement(By.xpath("//a[@href='../pdf/java-j2ee-syllabus-jbk.pdf']")).click();
driver.findElement(By.xpath("//a[@href='../pdf/python-syllabus.pdf']")).click();
//	List<String> courses=CommonUtility.getTestdataInList(System.getProperty("user.dir")+"/dashBoard.xlsx", 0,1);
 */