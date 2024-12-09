package cucumberOptions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utils {
	//public static WebDriver driver;
	public WebDriver driver;
	public static void main(String[] args) {
		
	}

	public void WaitUntilPresenceOfElement(String element)
	{
	WebDriverWait obj = new WebDriverWait(driver, Duration.ofSeconds(5));
	obj.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
	}
	
	public void WaitUntilPageLoaded(String element)
	{
	WebDriverWait obj = new WebDriverWait(driver, Duration.ofSeconds(5));
	obj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
	}
}
