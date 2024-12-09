package stepdefinitions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumberOptions.utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//public class testStepsOfferPage extends utils{
	public class testStepsOfferPage {
	public String Result;
	public List search;
	public List<String> searchResultsList;
	utils object;

	public testStepsOfferPage(utils object)
	{
		this.object= object;
	}
	//WebDriverobject.driver;
	@Given("Launch Google chrome")
	public void launch_google_chrome() {
	    
	    System.setProperty("webobject.driverchrome.driver","C:\\Users\\nagar\\eclipse-workspace\\driver\\chromeobject.driverexe");
		 object.driver= new ChromeDriver();
	   object.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   object.driver.manage().window().maximize();
	    //throw new io.cucumber.java.PendingException();
	}
	@Given("Navigate to greenkart offers page")
	public void navigate_to_greenkart_offers_page() {
		object.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	   // throw new io.cucumber.java.PendingException();
	}
	@When("User click on the Veg\\/fruit name column")
	public void user_click_on_the_veg_fruit_name_column() {
		object.driver.findElement(By.xpath("//span[text()='Veg/fruit name']")).click();
	   // throw new io.cucumber.java.PendingException();
	
	}
	
	@When ("^User Enter (.+)$")
	public void user_enter(String name) {
		object.driver.findElement(By.id("search-field")).sendKeys(name);
	}
	
	@Then("List should be sorted")
	public void list_should_be_sorted() {
		List <WebElement> originalElements=object.driver.findElements(By.xpath("//tr/td[1]"));
		List <String> OriginalList=originalElements.stream().map(s->s.getText()).collect(Collectors.toList());
		List <String> SortedList=OriginalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(OriginalList.equals(SortedList));	
	   // throw new io.cucumber.java.PendingException();
	} 
	
	@Then("^Respective search result should be listed (.+)$")
	public void respective_search_result_should_be_listed(String name) {
		List <String> price;
		do 
		{
		List <WebElement> Elements=object.driver.findElements(By.xpath("//tr/td[1]"));
		price= Elements.stream().filter(s->s.getText().contains(name)).map(s->getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(a->System.out.println(a));
		
		if(price.size()<1)
		{
			object.driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		}
		
		
		}while(price.size()<1);
	}
		public static String getPriceVeggie(WebElement s)
		{
			String priceValue= s.findElement(By.xpath("following-sibling::td")).getText();
			return priceValue;
		}
	@And("Close Browser")
		public void close_browser()
		{
			object.driver.close();
		}
	@Given("Navigate to greenkart search page")
	public void navigate_to_greenkart_search_page() {
	   object.driver.get("https://rahulshettyacademy.com/seleniumPractise/");
	}

	@When("^User search with shortname of vegetable (.+) and extract the search result$")
	public List<String> user_search_with_shortname_of_vegetable_veg_and_extract_the_search_result(String veg) throws InterruptedException {
	   object.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(veg);
	  //WaitUntilPageLoaded("//h4");
	    Thread.sleep(3000);
	    String Result=object.driver.findElement(By.xpath("//h4[@class='product-name']")).getText().split("-")[0].trim();
	    System.out.println(Result +"Extract");
	    List<WebElement> searchResults=object.driver.findElements(By.xpath("//h4[@class='product-name']"));
	    searchResultsList= searchResults.stream().map(s->s.getText().split("-")[0].trim()).collect(Collectors.toList());
	    System.out.println(searchResultsList);
		return searchResultsList;
	}

	@Then("^User search with same shortname of vegetable (.+) in Top Deals page and Result should match$")
	public void user_search_with_same_shortname_of_vegetable_veg_in_top_deals_page_and_result_should_match(String veg) throws InterruptedException {
		navigate_to_greenkart_offers_page();
		object.driver.findElement(By.id("search-field")).sendKeys("Tom");
		Thread.sleep(2000);
		List <WebElement> searchElements =object.driver.findElements(By.xpath("//tr/td[1]"));
		List <String> search= searchElements.stream().map(s->s.getText()).collect(Collectors.toList());
		System.out.println(search+"Deals");
		//String returnString=user_search_with_shortname_of_vegetable_veg_and_extract_the_search_result(search); 
		//Boolean ResultB = ((String) search).equalsIgnoreCase(searchResultsList);
		Thread.sleep(2000);
		Assert.assertEquals(searchResultsList,search);
		
		
	}
	
		
	}
	
	

