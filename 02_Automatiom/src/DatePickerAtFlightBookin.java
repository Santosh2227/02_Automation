

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatePickerAtFlightBookin {

	WebDriver driver;
	String URL = "https://www.goibibo.com/";
	String MonthToBeSelected = "September 2021";
	String DAY = "30";

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void datePicker() throws InterruptedException, IOException {
		// passing URL
		driver.get(URL);
		// Clicking on Departure Date Picker Box
		driver.findElement(By.xpath("//input[@type='text' and @placeholder='Departure']")).click();
		// Logic for Expected Date Picker
	screenshot();
		while (true) 
		{
			String monthOnPage = driver.findElement(By.xpath("//div[@class='DayPicker-Caption' and @role='heading']")).getText();

			if (monthOnPage.equals(MonthToBeSelected)) 
			{
				break;
			} else
			{
				driver.findElement(
						By.xpath("//span[@role='button' and @class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			}

		}

		// Clicking over the DAY variable date
		driver.findElement(By.xpath("//div[@class='DayPicker-Week']/div[@class='DayPicker-Day']/div[text()=" + DAY + "]")).click();
		
	}
	public void screenshot() throws IOException
	{
		TakesScreenshot scrShot =((TakesScreenshot)driver);

		//Call getScreenshotAs method to create image file

		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		//Move image file to new destination

		File DestFile=new File("E:Screenshot/Automation");

		//Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);
		System.out.println(" Screenshot is Taken : ");

	}

	@AfterMethod
	public void teardown() 
	{
		driver.close();
	}

}

