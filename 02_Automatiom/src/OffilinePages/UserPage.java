package OffilinePages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserPage {


	WebDriver driver;
	String Url="file:///C:/SELENIUM/Offline%20Website/Offline%20Website/index.html";

	@BeforeClass
	public void setup()
	{
		driver =	CommonUtility.openBrowser("chrome");
		CommonUtility.openUrl(driver, Url);
		CommonUtility.writeTextbox(driver, "id", "email", "kiran@gmail.com");
		CommonUtility.writeTextbox(driver, "id", "password", "123456");
		CommonUtility.ClickTo(driver, "xpath", "//button");
		CommonUtility.ClickTo(driver, "xpath","//span[text()='Users']");
	}

	@Test
	public void checkTitle()
	{
		System.out.println(driver.getTitle()); 
	}

	@Test
	public void getTableheader()
	{
		List<WebElement> tableheader=CommonUtility.getAllElementasPerLocator("xpath", "//tr[1]");
		List<String> expected=Arrays.asList("#","Username","Email","Mobile","Course","Gender","State","Action");
		for(WebElement header:tableheader)
		{
			String list=header.getText();
			if(list.equals(expected))
			System.out.println(list);
		}
}
	
	@Test
	public void checkUserAccordingToGender()
	{
		List<WebElement> username=CommonUtility.getAllElementasPerLocator("xpath","//td[2]");
		List<WebElement> gender=CommonUtility.getAllElementasPerLocator("xpath","//td[6]");
		if(gender.contains("Male")) {
			System.out.println(username);
		}
	}
	
	 @AfterTest
	 public void teardown()
	 {
		 driver.close();
	 }
}