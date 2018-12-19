package com.metacube.demoApp;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class NewPracticeSite extends GenericMethod {
	
	
	//@BeforeClass
	public static void readProperty(){
		
	}
	
	
	@Test(priority =1)// Test Text-area, by clear existing value and fill new value
	public void testTextArea() throws Exception{
		//value initialization for text-area
		String inputText ="Dummy text for Text-area";
		String labelId = "item-vfb-10";
		String textHeading = "Textarea\nThis is a text area\nThis is a text area";
		String textboxId = "vfb-10";
		//Call method to get Label ID and heading of the text-box
		labelCheck(labelId, textHeading);
		//Call method to get text-area id and input value in text-area
		textBox(By.id(textboxId),inputText);
		Thread.sleep(5000);
		
	}
	
	@Test(priority = 2)// Test Text-box, by clear existing value and fill new value
	public void testTextBox() throws InterruptedException{
		//value initialization for text-box
		String labelId = "item-vfb-9";
		String textHeading = "Text\nThis is a text box";
		String textboxId = "vfb-9";
		String inputText = "Dummy text for Text-box";	
		//Call method to get Label ID and heading of the text-box
		labelCheck(labelId, textHeading);
		//Call method to get text-box id and input value in text-box
		textBox(By.id(textboxId),inputText);
		Thread.sleep(2000);
	
	}
	
	@Test(priority = 3)// Test Check-box
	public void checkCheckbox() throws InterruptedException{
		//value initialization for check-box
		String labelId = "item-vfb-6";
		String textHeading = "Checkbox\nOption 1\nOption 2\nOption 3";
		String checkboxId = "vfb-6-0";
		//Call method to get Label ID and heading of the text-box
		labelCheck(labelId, textHeading);
		//Call method to get check-box id and checked
		checkBox(By.id(checkboxId));
		Thread.sleep(5000);
		
	}
	
	
	@Test(priority = 4)//Test Radio Button Section
	public void checkRadioButton() throws InterruptedException{
		//value initialization for radio-button
		String labelId = "item-vfb-7";
		String textHeading = "Radio\nOption 1\nOption 2\nOption 3";
		String radioButtonId = "vfb-7-1";
		//Call method to get Label ID and heading of the text-box
		labelCheck(labelId, textHeading);
		//Call method to get radio-button id and select
		radioButton(By.id(radioButtonId));
		Thread.sleep(5000);
		captureScreenShot("firstscreenshot","screenshots");
		
	}
	
	
	@Test//Call method to open new Browser window after click on New Browser Window 
	public void newBrowserWindow() throws InterruptedException {
		String buttonId = "button1";
		handleNewWindow(By.id(buttonId));
		Thread.sleep(10000);
		captureScreenShot("second","screenshots");
		
	}
	
	

}
