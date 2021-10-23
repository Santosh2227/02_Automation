

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookFlightsNagpurToPune {

	static WebDriver driver =null;

	public static void waitForElement(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void moveAndClick(WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).click(element).build().perform();
	}


	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {


		String URL = "https://www.goibibo.com/";
		String MonthToBeSelected = "Octomber 2021";
		String DAY = "30";
		System.setProperty("webdriver.chrome.driver","C:/chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.xpath("//span[@id='roundTrip']")).click();

		String mainwindow =	driver.getWindowHandle();
		System.out.println(mainwindow);
		Set<String> otherwindow=driver.getWindowHandles();

		if(!otherwindow.equals(mainwindow))
			driver.close();

		//driver.findElement(By.className("login__tab gotrible")).click();
		driver.findElement(By.className("logSprite icClose")).click();

		WebElement from =	driver.findElement(By.id("gosuggest_inputSrc"));
		from.sendKeys("Nagpur");
		WebElement destiny =	driver.findElement(By.id("gosuggest_inputDest"));

		waitForElement(from);
		moveAndClick(from);
	}		
}

//span[@class='PaxWidgetstyles__ContentActionIconWrapperSpan-sc-gv3w6r-8 dxKRvV'][2]











































