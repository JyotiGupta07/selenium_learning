package com.metacube.demoApp;



import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GmailLink {
	
	WebDriver driver;
	@BeforeClass
	public void contactUsPage(){
		System.setProperty("webdriver.chrome.driver", "D:/Office/drivers/oldchromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.metacube.com/contact.php");
		//driver.manage().window().maximize();
	}
	
	@Test
	public void GetURL() throws InterruptedException{
		//Handle Parent Window
		String parentPageID = driver.getWindowHandle();
		//Click on Mail-Us link
		WebElement link = driver.findElement(By.id("email-link"));
		link.click();
		
		//Handle windows
		Set<String> handles = driver.getWindowHandles();  
	    for (String Windowhandle : handles) 
	    {
	     if (!Windowhandle.equals(parentPageID)) 
	     {
	            driver.switchTo().window(Windowhandle);
	      //login into gmail account
	            
	           // driver.findElement(By.id("identifierId")).sendKeys("test");
	           WebElement id = driver.findElement(By.xpath("//*[@class= 'Xb9hP']//*[@type ='email']"));
	           id.sendKeys("jyoti.gupta@metacube.com");
	           
	           WebElement next = driver.findElement(By.xpath("//*[@class='CwaK9']//*[text()='Next']"));
	           next.click();
	           
	           Thread.sleep(2000);
	           WebElement password = driver.findElement(By.xpath("//*[@class = 'Xb9hP']//*[@type = 'password']"));
	           password.sendKeys("jyotigupta#123");
	           
	           WebElement next1 = driver.findElement(By.xpath("//*[@class='CwaK9']//*[text()='Next']"));
	           next1.click();
	           
	           Thread.sleep(2000);
	           //Switch to mail page
	           driver.switchTo().frame(driver.findElement(By.id("js_frame")));
	           System.out.println("Test");
	           Thread.sleep(2000);
	           //WebElement subject = driver.findElement(By.xpath("//input[@name = 'subjectbox']"));
	           //WebElement subject = driver.findElement(By.xpath(".//*contains[@name,'subjectbox']"));
	           //WebElement subject = driver.findElement(By.xpath("//*[@id = ':oq']//*[@class = 'aoT']"));
	           //WebElement subject = driver.findElement(By.xpath("//input[@id = ':oq' OR @name ='subjectbox']"));
	           //WebElement subject = driver.findElement(By.id(":oq"));
	           // WebElement subject = driver.findElement(By.xpath("//input[@id = ':oq']"));
	           
	           //WebElement subject = driver.findElement(By.xpath("//*[@class = 'Am Al editable LW-avf']"));
	           WebElement subject = driver.findElement(By.name("subjectbox"));
	           subject.sendKeys("Test Mail");
	           
	           
	           Thread.sleep(5000);
	           //System.out.println("Test1");
	            
	           /*WebElement accountbutton = driver.findElement(By.xpath("[@title('Google Account: Jyoti Gupta   (jyoti.gupta@metacube.com)')"));
	           accountbutton.click();
	           Thread.sleep(5000);
	           System.out.println("test2");
	            
	           WebElement signoutbutton = driver.findElement(By.tagName("Sign out"));
	           signoutbutton.click();*/
	            //break;
	            //driver.close();
	           
	     }
	    }
	    
	  // driver.switchTo().window(parentPageID);
	  // Thread.sleep(2000);
	    
	}
	
	@AfterTest
	public void shutdown()
	{
		driver.close();
	}

}
