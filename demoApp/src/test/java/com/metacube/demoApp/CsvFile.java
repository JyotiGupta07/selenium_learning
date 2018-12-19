package com.metacube.demoApp;


import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;



public class CsvFile {
	WebDriver driver;
	//Provide CSV file path. It Is In D: Drive.
	 String CSV_PATH = "D:\\test.xls";
	 
	// Navigate to the site
	@BeforeSuite 
	public void getURL(){
		System.setProperty("webdriver.chrome.driver", "D:/Office/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.seleniumframework.com/Practiceform/");
		//driver.manage().window().maximize();
		}

	 
	@Test
	public void csvDataRead() throws IOException, InterruptedException{
	  
	@SuppressWarnings("resource")
	CSVReader csvread = new CSVReader(new FileReader(CSV_PATH));
	  String [] csvCell;
	  //while loop will be executed till the last line In CSV.
	  while ((csvCell = csvread.readNext()) != null) {   
		 // System.out.println(csvCell[0] +  csvCell[1]);
		  String text1 = csvCell[0];
		  String text2 = csvCell[1];
		  System.out.println(text1);
		  System.out.println(text2);
		 //Input Text in Text Area
			WebElement inputtext = driver.findElement(By.id("vfb-10"));
			inputtext.clear();
			inputtext.sendKeys(text1);
			//System.out.println("Correct place");
			Thread.sleep(3000);
	 
	  	} 
	 }	 
	
	 
}
