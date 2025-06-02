package steps;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class HomePage extends BaseClass{
	
	@Given("I navigate to the demoqa homepage URL {string}")
	public void i_navigate_to_the_demoqa_homepage_url(String URL) {
		WebDriverManager.chromedriver().setup();
		dv = new ChromeDriver();
		dv.manage().window().maximize();
		dv.get(URL);
		dv.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
	}
	
	@SuppressWarnings("deprecation")
	@Then("the page title should be {string}")
	public void the_page_title_should_be(String ExpPageTitle) {
		String ActualTitle = dv.getTitle();
		System.out.println("ActualTitle: "+ ActualTitle);
		System.out.println("ExpPageTitle: "+ ExpPageTitle);		
		Assert.assertEquals(ExpPageTitle, ActualTitle);
	   
	}

	@Then("the URL should contain {string}")
	public void the_url_should_contain(String string) {
	    
	}

	@Then("I should see the {string} card")
	public void i_should_see_the_card(String string) {
	   
	}
	
	@Then("Close the Browser")
	public void close_the_browser() {
	    dv.quit();
	}

}
