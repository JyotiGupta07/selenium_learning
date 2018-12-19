package com.metacube.demoApp;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class HomePage {
	WebDriver driver;
	@Test
	public void firstPage(){
		System.setProperty("webdriver.chrome.driver", "D:/Office/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.metacube.com");
		//driver.manage().window().maximize();
	}
	 
	
	@Test
	public void testFirstPageText(){
		String labelFinder = "//td[text()='Innovation Landscape']";
		String sectionURL = "http://www.metacube.com/landscape.php";
		String innovationLandscapeText = "INNOVATION\nLANDSCAPE\nWe’re into great ideas, great technology and great products.";
		String messageFinder = "//div[@id= 'landscape-image-banner']";
		checkFooterLinks(labelFinder,sectionURL,messageFinder,innovationLandscapeText);
	}
	
	@Test
	public void testSecPageText(){
		String labelFinder = "//td[text()='Innovation Engine']";
		String sectionURL = "http://www.metacube.com/engine.php";
		String innovationEngineText = "INNOVATION\nENGINE\nWe are all about our people.";
		String messageFinder = "//div[@id= 'engine-image-banner']";
		checkFooterLinks(labelFinder,sectionURL,messageFinder,innovationEngineText);
	}
	
	
	@Test
	public void testThirdPageText(){	
		String sectionURL = "http://www.metacube.com/process.php";
		String innovationProcessText = "INNOVATION\nPROCESS\nIt is about the recipe and the ingredients.";
		String messageFinder = "//div[@id= 'process-image-banner']";
		String labelFinder = "//td[text()='Innovation Process']";
		checkFooterLinks(labelFinder,sectionURL,messageFinder,innovationProcessText);
	}
	
	
	
	// Generic method to automate footer section
	public void checkFooterLinks(String labelLink,String url,String finder,String text){
		WebElement link = driver.findElement(By.xpath(labelLink));
		link.click();
		assertTrue(driver.getCurrentUrl().equals(url), "Page is missing");
		if(driver.getCurrentUrl().equals(url))
		{
		WebElement message = driver.findElement(By.xpath(finder));
		String messageText = message.getText();
		assertEquals(messageText,text,"Textmismatch");
		}
		driver.navigate().back();
	
	}
	
	
	@AfterTest
	public void shutdown(){
		driver.close();
	}
	
}





/* Another Method to automate
 //@Test//(dependsOnMethods = "firstPage", description = "This tests footer section - Landscape link.")
	public void testFirstPageText(){
	driver.findElement(By.xpath("//td[text()='Innovation Landscape']")).click();
	String landscapeUrl = "http://www.metacube.com/landscape.php";
	assertTrue(driver.getCurrentUrl().equals(landscapeUrl), "landscape page missing.");
	if(driver.getCurrentUrl().equals(landscapeUrl))
	{
		
	String innovationLandscape = "INNOVATION\nLANDSCAPE\nWe’re into great ideas, great technology and great products.";
	WebElement message =  driver.findElement(By.xpath("//div[@id='landscape-image-banner']"));
	String messageText = message.getText(); 
	assertEquals(messageText, innovationLandscape, "Text didn't match");
	 
	}
	driver.navigate().back();
}	*/
