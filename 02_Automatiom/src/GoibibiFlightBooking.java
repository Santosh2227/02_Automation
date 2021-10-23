
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GoibibiFlightBooking {



	WebDriver driver;
	@Test
	public void setup() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:/chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();

		Select seatingclass = new Select (driver.findElement(By.id("gi_class")));
		//List <WebElement> elementCount = seatingclass.getOptions();
		//System.out.println(elementCount.size());
		List<WebElement> dropDwonList = new ArrayList<WebElement>();
		dropDwonList = seatingclass.getOptions();

		for(WebElement temp:dropDwonList)
		{

			seatingclass.selectByValue("B");
		}


		for (int i = 0; i < dropDwonList.size(); i++)
		{
			new Select(driver.findElement(By.id("gi_class"))).selectByIndex(i);
		}

		seatingclass.selectByVisibleText ("Premium Economy");
		System.out.println("Premium Economy selected");
		//showMessageDialog(null, "Check Now!");
		//Thread.sleep(3000);


		seatingclass.selectByIndex(2);
		System.out.println("First Class selected");
		//	showMessageDialog(null, "Check Now!");
		Thread.sleep(3000);

		seatingclass.selectByValue("B");
		System.out.println("Business Class selected");
		//	showMessageDialog(null, "Check Now!");
		Thread.sleep(3000);


	}


	/*
		driver.findElement(By.className("lsPop__cta")).click();
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();

		driver.findElement(By.id("gosuggest_inputSrc")).sendKeys("Dublin (DUB)");
		driver.findElement(By.xpath("//span[normalize-space()='Dublin']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("react-autosuggest-1")));

		driver.findElement(By.id("gosuggest_inputSrc")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("gosuggest_inputSrc")).sendKeys(Keys.DOWN);
	 */
}


