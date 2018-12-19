package com.metacube.demoApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class MenuItem {
	
	WebDriver driver;
	@Test
	public void gmailLoginPage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:/Office/drivers/oldchromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.gmail.com/");
		//driver.manage().window().maximize();
		//Login into gmail
		  WebElement id = driver.findElement(By.xpath("//*[@class= 'Xb9hP']//*[@type ='email']"));
          id.sendKeys("jyoti.gupta@metacube.com");
          
          WebElement next = driver.findElement(By.xpath("//*[@class='CwaK9']//*[text()='Next']"));
          next.click();
          
          Thread.sleep(2000);
          WebElement password = driver.findElement(By.xpath("//*[@class = 'Xb9hP']//*[@type = 'password']"));
          password.sendKeys("jyotigupta#123");
          
          WebElement next1 = driver.findElement(By.xpath("//*[@class='CwaK9']//*[text()='Next']"));
          next1.click();
          Thread.sleep(5000);
          
          WebElement compose = driver.findElement(By.xpath("//div[text()='COMPOSE']"));
          compose.click();
          Thread.sleep(5000);
          
          WebElement subject = driver.findElement(By.name("subjectbox"));
          subject.sendKeys("Test Mail");
		
	}
	
	
	
	

	/*@Test
	public void testEqual(){
		int x=10;
		int y=20;
	
		if(x==y){
			System.out.println("Values are equal");
		}
		else{
			System.out.println("Not equal");
		}	
	}
	
	@Test
	public void greaterNumber(){
		int x=10;
		int y= 20;
		
		if(x>y)
		{
		System.out.println("x is greater than y" + x);	
		}
		else
		{
		System.out.println("y is grater than x" + y);	
		}
	}
		
	@Test
	public void palindrome()
	{
		String value= "MADAM";
		String rvsvalue ="";
		
	for(int i=value.length()-1;i>=0;i--){
		rvsvalue = rvsvalue + value.charAt(i); 
	}	
		
	if(rvsvalue.equalsIgnoreCase(value)){
	//assertEquals("abcba",value);
		System.out.println("String is Palindrome" + rvsvalue);
		}
	else{
		System.out.println("Not Palindrome");
	}
	}*/

	

}



