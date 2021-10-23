package com.Demotests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MoneyControlWebsite {

	WebDriver driver;
	@BeforeClass
	public void setup() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:/chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.moneycontrol.com/markets/indian-indices/");
		Thread.sleep(10000);
	}
	@Test
	public void ajaxHandlingTest()
	{

		Float e1= Float.parseFloat(driver.findElement(By.xpath("//tr[1]//td[3]")).getText());
		Float e2= Float.parseFloat(driver.findElement(By.xpath("//tr[2]//td[3]")).getText());
		Float e3= Float.parseFloat(driver.findElement(By.xpath("//tr[3]//td[3]")).getText());
		Float e4= Float.parseFloat(driver.findElement(By.xpath("//tr[4]//td[3]")).getText());
		Float e5= Float.parseFloat(driver.findElement(By.xpath("//tr[5]//td[3]")).getText());

		System.out.println(e1+" "+e2+" "+e3+" "+e4+" "+e5);

		Float[]elements= {e1,e2, e3, e4, e5};
		Float max= elements[0];
		Float min= elements[0];

		for(int i=0; i<elements.length; i++)
		{
			if(max < elements[i]);
			{
				max = elements[i];
			}
			if(min > elements[i])
			{
				min = elements[i];
			}
			System.out.println(elements[i]);
		}

	}
	
	@Test
	public void TextFromTable() {
		//*[@id="indicesTable"]/thead/tr/th[1]/div
	List<WebElement> text =driver.findElements(By.xpath(""));
	
	}

}
