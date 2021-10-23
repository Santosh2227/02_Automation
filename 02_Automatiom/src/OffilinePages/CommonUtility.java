package OffilinePages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonUtility {

	static WebDriver driver;
	static WebElement we;
	static List<WebElement> web;
	
	public static WebDriver openBrowser(String brName)
	{
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		driver=new ChromeDriver();
		return driver;
	}

	public static void openUrl(WebDriver driver, String urlToOpen) {

		driver.get(urlToOpen);
	}


	public static void pause(int timetoWait)
	{
		try {
			Thread.sleep(timetoWait);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void  writeTextbox(WebDriver driver, String locType, String locValue, String data)
	{
		getElementasPerLocator(locType, locValue).sendKeys(data);
	}

	public static void ClickTo(WebDriver driver, String locType, String locValue)
	{
		getElementasPerLocator(locType, locValue).click();
	}
	public static String checkTextBox(WebDriver driver, String locType, String locValue)
	{
		String text=getElementasPerLocator(locType, locValue).getText();
		return text;
	}	

	public static boolean checkLogo( String loctype, String locValue)
	{
		if( getElementasPerLocator(loctype, locValue).isDisplayed())
		{
			return true;
		}

		else return false;

	}

	public static String checkLinkText(String loctype, String locValue)
	{
		WebElement text	= getElementasPerLocator(loctype,locValue);
		text.click();
		return text.getText();
	}

	public static WebElement getElementasPerLocator(String locatorName,String locValue)
	{

		switch (locatorName) {
		case "id":
			we=driver.findElement(By.id(locValue));
			break;
		case "xpath":
			we=driver.findElement(By.xpath(locValue));
			break;
		case "class":
			we=driver.findElement(By.className(locValue));
			break;
		case "tagname":
			we=driver.findElement(By.tagName(locValue));
			break;
		default:
			break;
		}
		return we;

	}

	public static List<WebElement> getAllElementasPerLocator(String locatorName,String locValue)
	{

		switch (locatorName) {
		case "id":
			web=driver.findElements(By.id(locValue));
			break;
		case "xpath":
			web=driver.findElements(By.xpath(locValue));
			break;
		case "class":
			web=driver.findElements(By.className(locValue));
			break;
		case "tagname":
			web=driver.findElements(By.tagName(locValue));
			break;
		default:
			break;
		}
		return web;

	}


	@SuppressWarnings("resource")
	public static List<String>getTestdataInList(String filepath, int i,int row)
	{
		List<String>list=null;
		try {
			FileInputStream fis=new FileInputStream(filepath);
			Workbook wb=new XSSFWorkbook(fis);
			Sheet sheet=wb.getSheetAt(i);
			int lastRowNumber=sheet.getLastRowNum();
			int lastColNumber=sheet.getRow(0).getLastCellNum();

			System.out.println("lastRowNumber is :"+lastRowNumber);
			System.out.println("lastColNumber is :"+lastColNumber);
			System.out.println();

			list=new ArrayList<String>();
			Row row1=sheet.getRow(row);
			Cell cell=row1.getCell(1);
			String data=cell.getStringCellValue().trim();
			list.add(data);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

}
