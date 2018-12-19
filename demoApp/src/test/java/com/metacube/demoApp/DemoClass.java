package com.metacube.demoApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class DemoClass {

	WebDriver driver;
	@Test
	public void firstTestCase()
	{
		System.setProperty("webdriver.chrome.driver", "D:/Office/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Into firstTestCase");
		driver.get("http://www.google.com");
		
	}
	@AfterTest
	public void shutDown(){
		driver.close();
	}
}
