package com.metacube.demoApp;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class FooterLinks{

	WebDriver driver;
	@Test
	public void MainPage(){
		
	System.setProperty("webdriver.chrome.driver", "D:/Office/drivers/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://www.metacube.com");
	
	}
	
	@Test
	public void ideaLinkTest(){
	
		String labelText = "//td[text()= 'Ideas']";
		String labelUrl = "http://www.metacube.com/blog.php";
		String textFinder = "//div[@id= 'blog-text-banner']";
		String ideaPageText = "Our Ideas";
		checkOtherFooterLinks(labelText,labelUrl,textFinder,ideaPageText);
	}
	
	@Test
	public void careerLinkTest(){
	
		String labelText = "//td[text()= 'Careers']";
		String labelUrl = "http://www.metacube.com/careers.php";
		String textFinder = "//div[@id= 'careers-text-banner']";
		String ideaPageText = "Careers\nWe are constantly on the lookout for the best talent. View the latest opportunities at Metacube for fresh graduates and experienced professionals alike.";
		checkOtherFooterLinks(labelText,labelUrl,textFinder,ideaPageText);
	}
	
	
	@Test
	public void newsLinkTest(){
	
		String labelText = "//td[text()= 'News']";
		String labelUrl = "http://www.metacube.com/news.php";
		String textFinder = "//div[@id= 'news-text-banner']";
		String ideaPageText = "News and Events\nStay updated on the latest happenings at Metacube. Watch this space for news, announcements and upcoming events.";
		checkOtherFooterLinks(labelText,labelUrl,textFinder,ideaPageText);
	}
	
	
	
	@Test
	public void aboutLinkTest(){
	
		String labelText = "//td[text()= 'About']";
		String labelUrl = "http://www.metacube.com/about.php";
		String textFinder = "//div[contains(@class, 'text')]/h3";
		String ideaPageText = "What we do";
		checkOtherFooterLinks(labelText,labelUrl,textFinder,ideaPageText);
	}
	
	
	@Test
	public void contactLinkTest(){
	
		String labelText = "//td[text()= 'Contact']";
		String labelUrl = "http://www.metacube.com/contact.php";
		String textFinder = "//h3[text() = 'Contact Us']";
		String ideaPageText = "Contact Us";
		checkOtherFooterLinks(labelText,labelUrl,textFinder,ideaPageText);
	}
	
	
	//Generic method to automate
	public void checkOtherFooterLinks(String linkText,String url,String finder,String pageText){
		WebElement labelLink = driver.findElement(By.xpath(linkText));
		labelLink.click();
		assertTrue(driver.getCurrentUrl().equals(url), "Page is missing");
		
		if(driver.getCurrentUrl().equals(url)){
			WebElement text = driver.findElement(By.xpath(finder));
			String ideaPageText =  text.getText();
			assertEquals(ideaPageText,pageText,"Text mismatch");
			}
		driver.navigate().back();
		}
		
		
		@AfterTest
		public void shutdown(){
			driver.close();
		}
		
		
		
	}

		
