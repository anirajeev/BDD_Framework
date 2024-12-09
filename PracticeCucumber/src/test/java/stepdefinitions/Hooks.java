package stepdefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import cucumberOptions.utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;

//public class Hooks extends utils {
public class Hooks
{
	utils object;
	public Hooks(utils object) 
	{
	this.object= object;	
	}	
	@Before
	public void LaunchBrowser()
	{
		object.driver= new ChromeDriver();
		System.setProperty("webdriver.driver.chrome", "C:\\Users\\nagar\\FrameworkPractice\\driver\\chromedriver.exe");
		
	} 
	
	@After
	public void takeScreentest() throws IOException
	{
		File src=((TakesScreenshot)object.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:/Users/nagar/FrameworkPractice/Scrrenshots/screenshot.jpg"));
}
	@AfterSuite  
	public void after_suite()  
	{  
	     try {
	            object.driver.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
	      
	}  
}