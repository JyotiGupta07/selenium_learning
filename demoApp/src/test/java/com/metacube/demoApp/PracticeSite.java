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
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;




public class PracticeSite {
	
	WebDriver driver;
	
	@BeforeSuite
	public void getURL(){
		System.setProperty("webdriver.chrome.driver", "D:/Office/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.seleniumframework.com/Practiceform/");
		//driver.manage().window().maximize();
	}

	
	
	@Test// Test Text-area, by clear existing value and fill new value
	public void testTextArea(){
		String labelId = "item-vfb-10";
		String textHeading = "Textarea\nThis is a text area\nThis is a text area";
		String textboxId = "vfb-10";
		genericURLFunction(labelId,textHeading);
		genericInputValueFunction(textboxId);
	}
	
	
	@Test// Test Text-box, by clear existing value and fill new value
	public void testTextBox(){
		String labelId = "item-vfb-9";
		String textHeading = "Text\nThis is a text box";
		String textboxId = "vfb-9";
		genericURLFunction(labelId,textHeading);
		genericInputValueFunction(textboxId);	
	}
	
	
	@Test//Test Check-box section
	public void checkbox(){
		String labelId = "item-vfb-6";
		String textHeading = "Checkbox\nOption 1\nOption 2\nOption 3";
		genericURLFunction(labelId,textHeading);
		
		WebElement chkId = driver.findElement(By.id("vfb-6-0"));
		chkId.click();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	}
	
	
	@Test//Test Radio Button Section
	public void radiobutton(){
		String labelId = "item-vfb-7";
		String textHeading = "Radio\nOption 1\nOption 2\nOption 3";
		genericURLFunction(labelId,textHeading);
		
		WebElement radioId = driver.findElement(By.id("vfb-7-1"));
		radioId.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	
	@Test//Test URL Section
	public void urlSection() throws Exception, IOException{
		String labelId = "item-vfb-11";
		String textHeading = "URL";
		String textboxId = "vfb-11";
		// Funtion to check url and heading of the section
		genericURLFunction(labelId,textHeading);
		
		// Applying function to check validation and print validation message
		genericInputValueFunction(textboxId);
		
		// Input correct value in URL section 
		WebElement textbox = driver.findElement(By.id(textboxId));
		// Tab to read Validation message
		textbox.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		String actual = driver.findElement(By.xpath("//*[@class = 'vfb-error']")).getText();
		String expected = "Please enter a valid URL.";
		Assert.assertEquals(actual, expected);
		//System.out.println(actual);
		textbox.clear();
		textbox.sendKeys("http://www.metacube.com");
		//Take screenshot of current page
		
		/* One way for dynamic screenshots
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("D:\\screenshots\\"+ System.currentTimeMillis()+".png"));*/
		
		
		// Second way for dynamic screenshots
		//DateFormat dateFormat = new SimpleDateFormat("");
		saveScreenshot("firstscreen");
				
	}
	
	
	//Take Screenshot method
	public void saveScreenshot(String name) {
		
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		String formattedDate = dateFormat.format(date);
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("D:\\screenshots\\"+formattedDate+" "+name+".png"));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	} 
	
	//Method for New Window
	@Test
	public void newWindow() throws InterruptedException{
		//Handle Parent Window
		String parentPageID = driver.getWindowHandle();
		//Click on Mail-Us link
		WebElement button = driver.findElement(By.id("button1"));
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

	
	// Method for Drop-Down
		//@Test
		public void dropdownValue(){
			String labelId ="item-vfb-12";
			String textHeading = "Select\nOption 1\nOption 2\nOption 3";
			genericURLFunction(labelId,textHeading);
			
			//Select make = new Select(By.id(labelId));
		}
		
	
			
	
	//Generic Function to check URL and Heading
	public void genericURLFunction(String labelId, String text){
		
		String url = "http://www.seleniumframework.com/Practiceform/";
		assertTrue((driver.getCurrentUrl()).equals(url), "Page is missing");
				
			if(driver.getCurrentUrl().equals(url)){		
					WebElement labelHeading = driver.findElement(By.id(labelId));
					String labelText = labelHeading.getText();
					//System.out.println("FindText");
					assertEquals(labelText, text, "Text mismatch");
				}
			
		}	
						
	//Generic Function to fill value in Text-box and Text-area
		public void genericInputValueFunction(String textboxId){
			WebElement textbox = driver.findElement(By.id(textboxId));
			textbox.clear();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			textbox.sendKeys("This is a Text-box");
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		}
		

	@AfterTest()
	public void shutdown(){
		driver.close();
	}
	
}




/*Test//Method for Drag and Drop
public void DragAndDropTest() throws InterruptedException{
	//WebElement drag= driver.findElement(By.id("draga"));
	//WebElement drag = driver.findElement(By.xpath("//div[@class = 'wpb_wrapper']//button[@id ='draga']"));
	WebElement drag = driver.findElement(By.id("draga"));
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	//WebElement drop = driver.findElement(By.xpath("//div[@class = 'wpb_wrapper']//button[@id ='dragb']"));
	WebElement drop = driver.findElement(By.id("dragb"));
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	//WebElement drop = driver.findElement(By.id("dragb"));
	//Configure the action
	Actions builder = new Actions(driver);
	//Action dragAndDrop = builder.clickAndHold(drag).moveToElement(drop).release(drop).build();
	Action dragAndDrop = builder.clickAndHold(drag).moveToElement(drop).keyDown(Keys.CONTROL).release(drop).build();
	dragAndDrop.perform();
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	if(dragAndDrop.equals(drop))
	{
	//System.out.println("Dragging");
	
	//System.out.println("Dropping");
	assertEquals("Drag To!",drop.getText());
	}
	
	System.out.println("NA");
	Thread.sleep(10000);	
	
}
*/
/*// Generic function to check Text-area/Text-box Heading and Input operation
public void genericHeadingFunction(String labelId, String text,String textboxId){

String url = "http://www.seleniumframework.com/Practiceform/";
assertTrue(driver.getCurrentUrl().equals(url), "Page is missing");

if(driver.getCurrentUrl().equals(url)){

WebElement labelHeading = driver.findElement(By.id(labelId));
String text1 = labelHeading.getText();
assertEquals(text1, text, "Textmismatch");
}

WebElement textbox = driver.findElement(By.id(textboxId));
textbox.clear();
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
textbox.sendKeys("This is a Text-box");
driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
}*/


/*String url = "http://www.seleniumframework.com/Practiceform/";
@Test
public void testTextArea() throws InterruptedException{
//Find correct area, match with heading
	String text1 = "Textarea\nThis is a text area\nThis is a text area";
	
	assertTrue(driver.getCurrentUrl().equals(url), "Page is missing");
	
	if(driver.getCurrentUrl().equals(url)){
	
		WebElement textarea = driver.findElement(By.id("item-vfb-10"));
		String text = textarea.getText();
		assertEquals(text, text1, "Textmismatch");
		System.out.println("Find Text");
	}
	
//Input Text in Text Area
	WebElement inputtext = driver.findElement(By.id("vfb-10"));
	inputtext.clear();
	inputtext.sendKeys("This is a Text area for testing.");
	System.out.println("Correct place");
	Thread.sleep(3000);
	
} */
