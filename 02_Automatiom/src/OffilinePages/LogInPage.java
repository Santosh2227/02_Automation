package OffilinePages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogInPage {


	WebDriver driver;
	String Url="file:///C:/SELENIUM/Offline%20Website/Offline%20Website/index.html";

	@BeforeClass
	public void logInSite()
	{
		driver =	CommonUtility.openBrowser("chrome");
		CommonUtility.openUrl(driver, Url);
	}

	@Test
	public void enterValidCredentials()
	{
		CommonUtility.writeTextbox(driver, "id", "email", "kiran@gmail.com");
		CommonUtility.writeTextbox(driver, "id", "password", "123456");
		CommonUtility.ClickTo(driver, "xpath", "//button");
	}

	@Test
	public void checkLogoImage()
	{
		CommonUtility.checkLogo("xpath", "//img");
	}

	@Test
	public void matchText()
	{
		String text = CommonUtility.checkLinkText("xpath", "//a[@class='text-center']");

		Assert.assertEquals(text, "Register a new membership");
	}



}

