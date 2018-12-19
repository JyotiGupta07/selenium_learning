package com.metacube.demoApp;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;


public class GenericMethod {
	WebDriver driver;
	String url = "http://www.seleniumframework.com/Practiceform/";
	String driverpath = "D:/Office/drivers/chromedriver.exe";
	
	//Navigate to the site
	@BeforeTest
	public void getURL(){
		//Set system property
		System.setProperty("webdriver.chrome.driver",driverpath);
		// Open Chrome
		driver = new ChromeDriver();
		//Pass the URL
		driver.get(url);
		//driver.manage().window().maximize();
	}

	
	//Generic Function to check URL and Label
	public void labelCheck(String labelId, String text){
		String message = "Current URL doesn't matches application URL. Please check.";
		assertTrue((driver.getCurrentUrl()).equals(url), message);
				
		if(driver.getCurrentUrl().equals(url)){		
			//Get Label Heading text
			WebElement labelHeading = driver.findElement(By.id(labelId));
			String labelText = labelHeading.getText();
			//Match between actual text and expected text
			assertEquals(labelText, text, "Labels didn't match. Expected: "+labelText+"but found "+text);
		}
	}	
	
	
	//Generic Function to fill value in Text-box and Text-area
	public void textBox(By obj, String inputText){
		// Find text-box id
		WebElement textbox = driver.findElement(obj);
		//Clear existing value in Text-box
		textbox.clear();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		// Input new value in Text-box
		textbox.sendKeys(inputText);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	
	//Method to open New Window		
	public void handleNewWindow(By obj) throws InterruptedException{
		//Handle Parent Window
		String parentPageID = driver.getWindowHandle();
		//Get click-able button id
		WebElement button = driver.findElement(obj);
		//Click on button
		button.click();
		//Handle windows
		Set<String> handles = driver.getWindowHandles();  
	    for (String Windowhandle : handles) 
	    {
	     if (!Windowhandle.equals(parentPageID)) 
	     {
	            driver.switchTo().window(Windowhandle);
	            Thread.sleep(5000);
	            driver.close();
	     }
	    }
		    driver.switchTo().window(parentPageID);
	}
		
	
	//Test Radio Button Section
		public void radioButton(By obj){
			//Get radio-button id
			WebElement radioId = driver.findElement(obj);
			use select
			//Select radio-button
			radioId.click();
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		}
	
	
	//Test Check-box section
	public void checkBox(By obj){
		//Get check-box ID
		WebElement chkId = driver.findElement(obj);
		// Checked on check-box
		chkId.click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
		
	
	//Take Screenshot method
		public void captureScreenShot(String name,String folderName) {
			
			DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
			Date date = new Date();
			String formattedDate = dateFormat.format(date);
			String screenshotPath = "D:\\"+folderName+"\\"+formattedDate+" "+name+".png";
			//Take screenshot and store as a file format
	        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
			//copy screenshots to desired location using copyFile method
				FileUtils.copyFile(srcFile, new File(screenshotPath));
			} catch (IOException e) {
			
				e.printStackTrace();
			
			}
			
		} 
		
		
		
	// Close browser
	@AfterSuite
	public void shutdown(){
		driver.close();
	}
	

}
